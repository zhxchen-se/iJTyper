import json

import torch
import numpy as np
from transformers import RobertaTokenizer, RobertaForMaskedLM
import torch.nn.functional as F
import subprocess
import os
import pandas as pd
import re
from tqdm import tqdm
import shutil
import glob
import sys
from sklearn.metrics import precision_recall_fscore_support
current_file_path = os.path.abspath(__file__)
current_directory = os.path.dirname(current_file_path)
# prompt_infer_path = os.path.abspath(os.path.join(os.getcwd(),"./.."))
# prompt_tuning_path = os.path.abspath(os.path.join(os.getcwd(), "../..","PromptTuning"))
prompt_infer_path = os.path.abspath(os.path.join(current_directory,"./.."))
prompt_tuning_path = os.path.abspath(os.path.join(current_directory, "../..","PromptTuning"))

filePath = os.path.join(prompt_infer_path, "Practicality", "SO_codeSnippet")
# filePath = '../datasets/soTestFile_2/'
java_key_words = ['public','private','Public','Private','final','final','new','New','void','Void','Static','static','protected','Protected','extends']


class Itera_Pred():
    def __init__(self,codeSnippet_Name,model_name):
        self.codeSnippet_Name = codeSnippet_Name
        # 将某些文件置空
        boolean(os.path.join(filePath, self.codeSnippet_Name, 'errorInfo'))
        boolean(os.path.join(filePath, self.codeSnippet_Name, 'FQN_pred'))
        boolean(os.path.join(filePath, self.codeSnippet_Name,'Prompt_data'))

        self.Topk = 20  # 为每个 simple name 的 API 推荐 两个候选的
        self.Count_Number = 8 # 向下走几步

        # self.errorType = ['错误: 找不到符号']
        self.errorType = ['error: cannot find symbol']
        self.tokenizer = RobertaTokenizer.from_pretrained(model_name)
        self.model = RobertaForMaskedLM.from_pretrained(model_name)

        # self.device = torch.device("cpu")
        self.device = torch.device("cuda")
        self.model.to(self.device) 

        self.file_read()

    def file_read(self):  # 读取 codeSnippet的文件夹,
        codeSnippet_path = os.path.join(filePath,self.codeSnippet_Name,'codeSnippet')
        json_path = os.path.join(filePath,self.codeSnippet_Name,'json_File')

        code_files = [file for file in glob.glob(codeSnippet_path+'/*')]
        AST_files = [file for file in glob.glob(json_path+'/*')]

        # json_fileName = [file.split('\\')[-1].replace('.json', '.java') for file in AST_files]
        json_fileName = [file.split('/')[-1].replace('.json', '.java') for file in AST_files]
        for code_file in code_files:
            print('file_name: ',os.path.basename(code_file))
            # code_file = os.path.join(filePath, self.codeSnippet_Name, 'codeSnippet', 'hb3.java')

            if code_file.endswith('.java'):  # 因为有些 codeSnippet 会通过编译 生成 .class 文件
                baseFile_name = os.path.basename(code_file)
                file_index = json_fileName.index(baseFile_name)
                # AST_files_path = AST_files[file_index]
                self.Start(code_file)


    def Start(self,code_file_path):
        self.code_file_path = code_file_path
        self.excute_cmd(self.code_file_path)  # 输入 code snippet 通过终端收集 报错信息 输出：errorInfo_path
        with open(self.errorInfo_path,'r',encoding='utf-8') as f:
            content = f.read()
            if len(list(content)) == 0:return  # 如果code snippet 没有报错信息 则退出

        # prompt：glob_context + <mask><mask><mask>.applet var = new ...
        self.predictData_Gen(self.code_file_path)  # 输入：code snippet和对应的报错信息 输出 self.codeErrorInfo 和  self.codeInfo. maskCode/ errorType/ contextCode

        self.out_sequence = []  # 存储当前的序列 和当前序列的得分
        self.numberMaskSearch()  # 输入: self.condeInfo 进行预测, 输出 self.out_sequence()

        self.file_writer()  # 输入: self.out_sequence 和 self.codeErrorInfo

    def excute_cmd(self,file_path):
        # 'C:\\Users\\YuanZQ\\Desktop\\testFile_so\\Class_1.java'
        # cmd = 'javac ' + file_path
        cmd = ['javac',file_path]
        obj = subprocess.run(cmd,
                             stdin=subprocess.PIPE,
                             stdout=subprocess.PIPE,
                             stderr=subprocess.PIPE,
                             universal_newlines=True)
        # print(obj.stderr)  # 输出异常信息
        # print(obj.stdout)
        file_name = os.path.basename(file_path)+'_stderr.txt'
        self.errorInfo_path = os.path.join(filePath,self.codeSnippet_Name,'errorInfo',file_name)
        with open(self.errorInfo_path,'w',encoding='utf-8') as f:
            f.write(obj.stderr)

    def deal_AST(self,AST_files_path):
        Variable_list = []
        with open(AST_files_path, 'r', encoding='utf-8') as f:
            cont = f.read()
            cont = ' '.join(cont.split())
            type_define = ['LocalVariable', 'Field', 'Parameter', "CatchVariable"]
            for type in type_define:
                type_info = '''"type": "''' + type + '''"'''
                Variable_all = re.findall(type_info, cont)
                for i in range(len(Variable_all)):
                    Variable_info = re.search(type_info, cont)
                    if Variable_info == None: break

                    before_index = Variable_info.start()
                    end_index = Variable_info.end()

                    # 向前遍历 得到 variable name
                    var_name = []
                    Tag = False
                    while True:
                        before_index = before_index - 1
                        if Tag:
                            if cont[before_index] == '''"''':
                                var_name.reverse()
                                Variable_list.append(''.join(var_name))
                                break
                            var_name.append(cont[before_index])
                        if cont[before_index] == '''"''':
                            Tag = True
                    cont = cont[end_index:]
        return Variable_list


    def predictData_Gen(self,code_file_path):
        contextLen = 4 # 取出前后4行代码，作为被 <mask> 那行代码的 context code

        #首先,逐行将code snippet 进行切割
        with open(code_file_path,'r',encoding='utf-8') as f:  # 要处理的.java 文件。 将 code 以分号进行切割 保存在 code_list 当中
            code = f.read()
            code = re.sub('''"(.*?)"''',"String",code)
            code_list = code.split(";\n")
            self.code_Split = [' '.join(code.split())+';' for code in code_list ]


        # 接着对程序的报错信息进行处理
        codeErrorInfo_temp1 = []  # 存储程序种报错的信息
        with open(self.errorInfo_path,'r',encoding='utf-8') as f:  # 将 code error 信息 存储 到 codeErrorInfo 当中
            Tag,count = True,0
            Temp_list = []
            fileName = os.path.basename(code_file_path)  # 获取 .java 文件的名称
            for line in f.readlines():
                # if fileName+':' in line and '错误:' in line and Tag:
                if fileName+':' in line and 'error:' in line and Tag:
                    Temp_list.append(line)
                    Tag = False
                    continue
                # if fileName in line or '个错误' in line and Tag == False:
                if fileName in line or 'errors' in line and Tag == False:
                    if fileName +':' not in line:
                        codeErrorInfo_temp1.append(Temp_list.copy())
                        break
                    codeErrorInfo_temp1.append(Temp_list.copy())
                    Temp_list.clear()
                    Temp_list.append(line)
                    continue
                if Tag == False:
                    Temp_list.append(line)
                    continue

        codeErrorInfo_temp2 = []  # 对 codeErrorInfo 进一步处理
        for codeError in codeErrorInfo_temp1:
            codeError_dict = {'errorLine': int, 'errorType': str, 'errorCode': [], 'errorToken_loca': int,'error_symbol':str}
            line_number = re.findall(":\d+:", codeError[0])[0]  # 得到 :line:
            line_temp = [i for i in line_number if str.isdigit(i)]
            codeError_dict['errorLine'] = int(''.join(line_temp))  # 得到 报错的 line
            # codeError_dict['errorType'] = re.search('错误: .*',codeError[0]).group() # 得到报错的 type
            codeError_dict['errorType'] = re.search('error: .*',codeError[0]).group() # 得到报错的 type
            codeError_dict['errorCode'] = codeError[1]
            codeError_dict['errorToken_loca'] = codeError[2].index('^')
            if len(codeError)>3: codeError_dict['error_symbol'] = codeError[3]
            else: codeError_dict['error_symbol'] = 'NULL'
            codeErrorInfo_temp2.append(codeError_dict)
        self.codeErrorInfo = sorted(codeErrorInfo_temp2,key= lambda x:(x['errorLine'],x['errorToken_loca']))

        # 遍历报错信息，从code-snippet中找打对应的 global context
        self.codeInfo = []
        for codeError in self.codeErrorInfo:  # codeErrorInfo 存储的是收集的的错误信息
            error_type = codeError['errorType']  # e.g., 错误: 找不到符号 目前只针对这种错误
            error_code = " ".join(codeError['errorCode'].split())
            error_code = re.sub('''"(.*?)"''', "String", error_code)
            # if error_type not in self.errorType or '方法' in codeError['error_symbol'] or "变量 super" in codeError['error_symbol'] : continue
            if error_type not in self.errorType or 'method' in codeError['error_symbol'] or "variable super" in codeError['error_symbol']: continue
            symbolIndex = codeError['errorToken_loca']
            maskCode = codeError['errorCode'][:symbolIndex] + '<mask><mask><mask>.' + codeError['errorCode'][symbolIndex:]   # 先添加三个 <mask>,因为最短需要三个<mask>
            maskCode = " ".join(maskCode.split())
            maskCode = re.sub('''"(.*?)"''', "String", maskCode)

            # 找到 error_code 的global context code
            Context_code,Tag = [],True
            for code_i in range(len(self.code_Split)):
                code = " ".join(self.code_Split[code_i].split())
                if error_code in code:
                    if code_i >=2 and code_i<len(self.code_Split)-2:  # 前面两行和后面两行都有
                        Context_code.append(self.code_Split[code_i-2:code_i])
                        Context_code.append([code.replace(error_code,maskCode,1)])
                        Context_code.append(self.code_Split[code_i+1:code_i+3])

                        code_list_  = [inner for code in Context_code for inner in code]
                        code_str = ' '.join(code_list_)
                        self.codeInfo.append({"maskCode": maskCode, "Glob_context": code_str})
                        break

                    elif code_i <2 and code_i<len(self.code_Split)-2:  # 前面两行没有, 后面两行有
                        Context_code.append(self.code_Split[:code_i])
                        Context_code.append([code.replace(error_code,maskCode,1)])
                        Context_code.append(self.code_Split[code_i+1:code_i+3])
                        code_list_  = [inner for code in Context_code for inner in code]
                        code_str = ' '.join(code_list_)
                        self.codeInfo.append({"maskCode": maskCode, "Glob_context": code_str})
                        break

                    elif code_i >=2 and code_i>=len(self.code_Split)-2:  # 前面两行有，后面两行 没有
                        Context_code.append(self.code_Split[code_i-2:code_i])
                        Context_code.append([code.replace(error_code,maskCode,1)])
                        Context_code.append(self.code_Split[code_i+1:])

                        code_list_  = [inner for code in Context_code for inner in code]
                        code_str = ' '.join(code_list_)
                        self.codeInfo.append({"maskCode": maskCode, "Glob_context": code_str})
                        break
                    elif len(self.code_Split) <=3:  #
                        code_str = ' '.join(self.code_Split)
                        code_c = code_str.replace(error_code,maskCode,1)
                        self.codeInfo.append({"maskCode": maskCode, "Glob_context": code_c})
                        break

        with open(os.path.join(filePath,self.codeSnippet_Name,'Prompt_data',os.path.basename(code_file_path)),'w',encoding='utf-8') as f:
            json.dump(self.codeInfo,f,indent=2)


    def numberMaskSearch(self):
        for i in range(len(self.codeInfo)):
            dataDict = {'maskCode':[],'predCode':[]}
            # if self.errorType not in self.codeInfo[i].errorType: continue  # 目前只针对 这种错误类型
            prompt = self.codeInfo[i]['Glob_context']
            dataDict['maskCode'] = prompt
            token_list = self.tokenizer.encode(prompt, add_special_tokens=True)
            # code_tokens = [token for token in code_tokens_temp if token not in stop_words]
            token_tensor = torch.tensor([token_list])

            scoreList = []  # 这个list当中只会存储两个元素，当前的分数，和 上一次预测所得到的分数
            Count = 0 #
            while True:
                scores, indexs = self.model_Pred(token_tensor)  # 模型的输出
                # 将 预测所得到的 TypeId 转成 字符
                pred_token_list_temp = self.tokenizer.convert_ids_to_tokens(indexs)  # token_list--['token1','token2','token3'...]
                pred_token_list = []
                for token in pred_token_list_temp:
                    token_temp = token.replace('Ġ','')
                    if token_temp not in java_key_words:  # 去除预测结果当中的 java-key-words, e.g., final
                        pred_token_list.append(token_temp)
                pred_token_str = ''.join(pred_token_list)

                scoreList.append((sum(scores.tolist()) / len(scores.tolist()),pred_token_str))  # --> [(average-score,tokens),...] 存储 top-k个
                # scoreList:[(top-1),(top-2),..]
                if len(scoreList)>self.Topk:  # 保证在进行比较之前,scoreList 当中包含self.TopK+1 个 value
                    scoreList_Topk = sorted(scoreList,reverse=True)[:self.Topk]
                    scoreList_temp = scoreList[:self.Topk]
                    if scoreList_temp == scoreList_Topk:  # 如果 scoreList 当中 topK的序列没有发生变化，则加 1
                        Count = Count + 1
                    else:
                        Count = 0
                    scoreList.sort(reverse=True)  # 将 scoreList: max_value---> min_value

                if Count >=self.Count_Number:  #  scoreList 当中连续 x 次 value 一致 则退出预测

                    pred_type_list = [] # 首先去重 --- 这样写是为了保证 top 的顺序
                    for fqn in scoreList:
                        if fqn[1] not in pred_type_list:
                            pred_type_list.append(fqn[1])

                    output_type_list = []
                    # Tag = True
                    for pred_type in pred_type_list:  #  将 ‘java..util..' 这种类似的预测删除
                        Tag = True
                        dot_index = [alpha_i for alpha_i in range(len(list(pred_type))) if pred_type[alpha_i] == '.' ]
                        for dot in dot_index:
                            if dot+1 in dot_index:
                                Tag = False
                        if Tag:
                            output_type_list.append(pred_type)


                    # total_pred_fqn_List 进行筛选 首先去重 --- 这样写是为了保证 top 的顺序
                    # pred_type_list = []
                    # for fqn in scoreList:
                    #     if fqn[1]+'.' not in pred_type_list:
                    #         pred_type_list.append(fqn[1]+'.')
                    #
                    # output_type_list = []  # 所预测的fqn 就一个正确的fqn_list. 例如将''java..text.format'' 这种的预测序列删除
                    # for pred_type in pred_type_list:
                    #     for api_type in self.apiType_list:
                    #         if pred_type in api_type:
                    #             output_type_list.append('.'.join(pred_type.split('.')[:-1]))
                    #             break
                    #
                    if len(output_type_list) == 0: # 可能一个猜对的都没有
                        type_list = scoreList[:self.Topk]
                        output_type_list = [type[1] for type in type_list]

                    dataDict['predCode'] = output_type_list[:self.Topk]  # 取前面 前 topK个value
                    self.out_sequence.append(dataDict)
                    break

                insertID_list = [self.tokenizer.mask_token_id]*(len(self.maskIndex_list)+1)  # 添加 <mask> ID
                insertID_tensor = torch.tensor([insertID_list])
                beforPart = token_tensor[:,0:self.maskIndex_list[0]]
                afterPart = token_tensor[:,self.maskIndex_list[-1]+1:]
                self.new_token_tensor = torch.cat([beforPart,insertID_tensor,afterPart],dim=1)  # 完成了 对新的输入的拼接
                token_tensor = self.new_token_tensor

    # 将预测结果 写入文件夹：FQN_pred
    def file_writer(self):
        predToken_list = [] # 将预测的package name 取出来: [(),(),(),...]
        for codeValue in self.out_sequence:
            temp = []
            for value in codeValue['predCode']:
                temp.append(value.replace('Ġ',''))
            predToken_list.append(tuple(temp))

        # codeError_list = [errorValue for errorValue in self.codeErrorInfo if errorValue['errorType'] in self.errorType and '方法' not in errorValue['error_symbol']
        #                   and "变量 super" not in errorValue['error_symbol']]
        codeError_list = [errorValue for errorValue in self.codeErrorInfo if errorValue['errorType'] in self.errorType and 'method' not in errorValue['error_symbol']
                            and "variable super" not in errorValue['error_symbol']]
        assert len(predToken_list) == len(codeError_list),'len(predToken) != len(codeError)'

        errorCode_list = []  # 将同一行代码的不同报错位置放在一起
        start,endIndex = 0,0
        for var_i in range(len(codeError_list)):  # 输出为 errorCode_List
            errorDict = {'errorLine':int,'errorCode': str, 'errorToken_loca': []}  #errorLine:报错的代码行号, errorCode-报错那一行代码
            errorDict['errorLine']  = codeError_list[var_i]['errorLine']
            errorDict['errorCode'] = codeError_list[var_i]['errorCode']  # 获取报错的代码行
            errorDict['errorToken_loca'].append(codeError_list[var_i]['errorToken_loca'])  # 精准到某一给code token出错
            if var_i not in range(start,endIndex):
                temp_j =var_i + 1
                while temp_j<len(codeError_list) \
                        and errorDict['errorLine'] == codeError_list[temp_j]['errorLine']:
                    errorDict['errorToken_loca'].append(codeError_list[temp_j]['errorToken_loca'])
                    temp_j = temp_j + 1
                endIndex = temp_j
                errorCode_list.append(errorDict)

        token_i,pred_Token,index_i = 0,0,0
        fixCode_list = []  # 将 package name + simple name 组成FQN
        for value_code in errorCode_list:
            codeDict2 = {'originalCode':str,'FQNCode':str,'fqnToken':[]}
            value_code_temp= value_code['errorCode'].replace('}', '').replace('{', '')
            codeDict2['originalCode'] = ' '.join(value_code_temp.split())

            start = 0
            codeIter_list = list(value_code['errorCode'])  # 将 str 切成 list
            code_temp_List=[]  # List list = new List(); --> java.util.List list = new java.util.List();
            for int_loca in range(len(value_code['errorToken_loca'])):  # value_code['errorToken_loca'] 是 ^ 号的位置。
                simpleName = []
                for i in range(value_code['errorToken_loca'][int_loca], len(codeIter_list)):
                    if codeIter_list[i].isalpha() is False: break
                    simpleName.append(codeIter_list[i])  # 得到出错API的 simpleName

                codeDict2['fqnToken'].append(tuple(token + '.' + ''.join(simpleName) for token in predToken_list[token_i]))
                # codeDict2['fqnToken'].append(predToken_list[token_i] +'.'+ ''.join(simpleName))
                fixedCode = value_code['errorCode'][start:value_code['errorToken_loca'][int_loca]] + '<MASK>'+ '.'
                token_i = token_i+1
                start = value_code['errorToken_loca'][int_loca]
                code_temp_List.append(fixedCode)
                if int_loca == len(value_code['errorToken_loca'])-1:
                    code_temp_List.append(value_code['errorCode'][value_code['errorToken_loca'][int_loca]:])

            codeDict2['FQNCode'] = ''.join(code_temp_List)
            codeDict2['FQNCode'] = codeDict2['FQNCode'].replace('}', '').replace('{', '')
            codeDict2['FQNCode'] = ' '.join(codeDict2['FQNCode'].split())
            fixCode_list.append(codeDict2)

        # print(f"debug379:fixCode_list = {fixCode_list}")
        # 将数据写存入为 json
        file_path = os.path.join(filePath,self.codeSnippet_Name,'FQN_pred',os.path.basename(self.code_file_path)+'_pred.json')
        with open(file_path,'w',encoding='utf-8') as f:
            json.dump(fixCode_list,f,indent=2)

    def model_Pred(self,token_tensor):
        self.maskIndex_list = [np.argwhere(token_tensor.numpy()[0] == self.tokenizer.mask_token_id)][0].transpose()[0,:].tolist() # x == y, x 和 y的维度要相等
        
        token_tensor = token_tensor.to(self.device) #cuda

        output = self.model(token_tensor)[0]
        cur_pred = output[:,self.maskIndex_list,:]
        scores,indexs = torch.topk(cur_pred,k=1)  # 返回 top-beamSize 的 values
        score,index = scores.view(-1).detach(),indexs.view(-1).detach()
        return score,index

class error_data():
    def __init__(self,maskCode,errorType,contextCode):
        self.maskCode = maskCode  # 报错的 code statement
        self.errorType = errorType  # 报错类型
        self.contextCode = contextCode  # 该语句的 context code  暂且定位 local context


class Metric():
    def  __init__(self,codeSnippet_Name):
        self.codeSnippet_Name = codeSnippet_Name

        # 将某些文件置空
        boolean(os.path.join(filePath, self.codeSnippet_Name, 'Compare'))
        self.file_read()

        self.scorePrint()

    def file_read(self):
        FQN_pred_path = os.path.join(filePath, self.codeSnippet_Name, 'FQN_pred')
        # FQN_Truth_path = os.path.join(filePath, self.codeSnippet_Name, 'FQN_truth')
        FQN_Truth_path = os.path.join(filePath, self.codeSnippet_Name, 'FQN')

        FQN_Pred_files = [file for file in glob.glob(FQN_pred_path + '/*')]
        FQN_Truth_files = [file for file in glob.glob(FQN_Truth_path+'/*')]
        for file_pred_path in FQN_Pred_files:
            baseName = os.path.basename(file_pred_path).split('_pred')[0]  # Class_1.java_pred.json--> Class_1.java
            file_truth_path = [file_truth for file_truth in FQN_Truth_files if baseName == os.path.basename(file_truth)][0]
            if len(file_truth_path)==0:continue
            # file_pred_path = os.path.join(filePath,'xstream','FQN_pred','xstream_class_28.java_pred.json')
            # file_truth_path = os.path.join(filePath, 'xstream', 'FQN_Truth','xstream_class_28.java')
            with open(file_pred_path,'r',encoding='utf-8') as f:
                pred_content = json.load(f)
                pred_list = [pred for pred in pred_content if type(pred) == dict]
            with open(file_truth_path,'r',encoding='utf-8') as f:
                true_content_list = f.read().split(';\n')
                true_list = [' '.join(code.split()) + ';' for code in true_content_list]
                self.file_deal(pred_list,true_list,baseName)

    def file_deal(self,pred_list, true_list,fileName):
        groundTrue_list = true_list.copy()
        output_list = []
        start = 0
        for pred in pred_list:  # 预测所得到的那个列表
            pred_dict = {'codeStatement': str, 'FQN_Pred': [], 'FQN_true': []}
            pred_dict['codeStatement'] = pred['originalCode']

            for predFqn in pred['fqnToken']:
                simpleName = predFqn[0].split('.')[-1]  # java.util.Map --> Map
                pred_dict['FQN_Pred'].append(predFqn)

                for true_i in range(start,len(groundTrue_list)):
                    reSearch = re.search('\.'+simpleName+'[^A-Za-z]',groundTrue_list[true_i])
                    if reSearch:
                        fqn_true_temp = [] # 将 simpleName 所对应的FQN 全部取出来
                        for var_j in range(reSearch.start(),-1,-1): # 从后往前 遍历
                            if groundTrue_list[true_i][var_j].isalpha() or groundTrue_list[true_i][var_j] == '.' or groundTrue_list[true_i][var_j].isdigit():
                                fqn_true_temp.append(groundTrue_list[true_i][var_j])
                            else: break
                        fqn_true_temp.reverse()
                        pred_dict['FQN_true'].append(''.join(fqn_true_temp)+simpleName)

                        # 进行截断：java.applet.Applet var = new java.applet.Applet() --> var = new java.applet.Applet()
                        groundTrue_list[true_i] = groundTrue_list[true_i][reSearch.end():]
                        break
                    else:
                        start = true_i
                        # groundTrue_list.remove(groundTrue_list[true_i])

            output_list.append(pred_dict)


        with open(os.path.join(filePath,self.codeSnippet_Name,'Compare',fileName+'_compare.txt'),'w',encoding='utf-8') as f:
            json.dump(output_list,f,indent=2)

    def scorePrint(self):
        compareFile = os.path.join(filePath,self.codeSnippet_Name,'Compare')
        compareFile_path = [file for file in glob.glob(compareFile+'/*')]
        Total_FQN = 0

        metric_dict = {'precision_li': [], 'recall_li': [], 'f1_li': []}
        for file in compareFile_path:
            with open(file,'r',encoding='utf-8') as f:
                fileContent = json.load(f)
                temp_pred = []
                temp_label = []
                for content in fileContent:
                    temp_label.extend(content['FQN_true'])  # 真实值[fqn1,fqn2,..]
                    temp_pred.extend(content['FQN_Pred'])  # 预测值 [(fqn1',fqn1''),(fqn2',fqn2''),..]
            if len(temp_pred) == len(temp_label) and len(temp_label)>0 and len(temp_pred)>0:
                recommendations_made = len(temp_pred) * len(temp_pred[0])  # len(temp_pred[0]) == topK
                recommendations_requested = len(temp_pred)  # test data 当中有多少个API
                relevant = 0
                for var_i in range(len(temp_label)):
                    if temp_label[var_i] in temp_pred[var_i]:  #  对于某一个 API 而言，如果其对应的真实FQN在 推荐的topK当中
                        relevant = relevant + 1
                # precision = round(relevant/recommendations_made,4)  # 保留四位小数点
                recall = round(relevant/recommendations_requested,4)
                # f1 = round((2*precision*recall)/(precision+recall),4)
                # metric_dict['precision_li'].append(precision),\
                metric_dict['recall_li'].append(recall)
                # metric_dict['f1_li'].append(f1)
                print(f'file_name:', os.path.basename(file),
                      f'Total_FQN:{len(temp_label)}',
                      f'Unique.{len(set(temp_label))}',
                      f'recall:{recall:.4f}')
                Total_FQN = Total_FQN+len(temp_label)

        # Mean_score = {k: sum(v) / len(v) for k, v in metric_dict.items()}
        Mean_recall_score = sum(metric_dict['recall_li'])/len(metric_dict['recall_li']) 
        print(f'Average_F1-Score:',f'recall:{Mean_recall_score:.4f}',f'Total_FQN:{Total_FQN}')


# 如果文件夹存在先清空文件夹，再创一个。
def boolean(file_path):
    if not os.path.exists(file_path):
        print('Creat folder....')
        os.makedirs(file_path)
    else:
        shutil.rmtree(file_path)
        os.makedirs(file_path)

def ground_truth(lib_name):
    # jar_package = os.path.join(prompt_tuning_path,"Spoon_FQN_3.jar")
    jar_package = os.path.join(prompt_tuning_path,"Spoon_FQN.jar")
    lib_path = os.path.join(prompt_infer_path,"Practicality","SO_codeSnippet",lib_name)  # lib_name 为需要解析的 library.  Note: "codeSnippet" must be contained in the path
    print(lib_path)
    # cmd = "java -jar "+jar_package+" "+lib_path
    cmd = ['java','-jar',jar_package,lib_path]
    subprocess.run(cmd)
    

def getCodeSnippet(lib_name):  # remove important statement in the original_java
    original_java_path = os.path.join(prompt_infer_path,"Practicality","SO_codeSnippet",lib_name,"original_java")  # input java path
    codeSnippet_path = os.path.join(prompt_infer_path,"Practicality","SO_codeSnippet",lib_name,"codeSnippet")  # output java path
    boolean(codeSnippet_path)  # make dir

    java_files = [file for file in glob.glob(original_java_path + '/*')]

    for file in java_files:
        out_cont = []
        with open(file,'r',encoding='utf-8') as f:
            for line in f.readlines():
                if "import " in line or "package " in line: continue
                else: out_cont.append(line)

        with open(os.path.join(codeSnippet_path,os.path.basename(file)),'w',encoding="utf-8") as f:
            f.write("".join(out_cont))


def main_func():
    import sys
    # f = open('model_35_line_2.log', 'a')
    # sys.stdout = f
    # sys.stderr = f

    codeSnippet_Name = ['android','gwt','hibernate','jdk','joda_time','xstream']  # here is the code snippet name
    model_names = ['modelTuned_30']
    for model_name in model_names:  # get the model that used to predict
        Modle_path = os.path.join(prompt_tuning_path, "Model", model_name)
        print('model_name:',model_name,' pred_way: type.method() --> <mask>.type.method()')

        for file in codeSnippet_Name:
            ground_truth(file)  # get the ground truth by the FQN annotation ground_truth
            getCodeSnippet(file)  # remove import statement

            Itera_Pred(file, Modle_path)  # start predict
            Metric(file)  # 指标计算

if __name__ =="__main__":
    # this .py file: type.method() --> <mask>.type.method(), another .py file: type.method() --> <mask>.method()
    main_func()








