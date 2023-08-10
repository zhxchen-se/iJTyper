import os
import re
import sys
import csv
import json
import time
import torch 
import subprocess
import torch.nn.functional as F
from tqdm import tqdm
from database import DB
from transformers import RobertaTokenizer, RobertaForMaskedLM
sys.path.append(os.path.abspath(os.path.join(os.getcwd(), "..")))
sys.path.append(os.path.abspath(os.path.join(os.getcwd(), "../Baseline")))
from Baseline import run_baseline
import Baseline.Prompt_tune.ASE_prompt_tuning.PromptInference.Practicality.predDictData_line as DL
current_file_path = os.path.abspath(__file__)
current_directory = os.path.dirname(current_file_path)
filePath = os.path.abspath(os.path.join(current_directory,"..","Baseline","Prompt_tune","ASE_prompt_tuning","PromptInference","Practicality","SO_codeSnippet"))
class Pred_with_Prompt_Augmented(DL.Itera_Pred):
    def __init__(self,codeSnippet_Name,model_name,rule_node_pred_dict):
        self.codeSnippet_Name = codeSnippet_Name
        self.rule_node_pred_dict = rule_node_pred_dict
        # 将某些文件置空
        DL.boolean(os.path.join(filePath, self.codeSnippet_Name, 'errorInfo'))
        DL.boolean(os.path.join(filePath, self.codeSnippet_Name, 'FQN_pred'))
        DL.boolean(os.path.join(filePath, self.codeSnippet_Name,'Prompt_data'))

        self.Topk = 3  # 为每个 simple name 的 API 推荐 两个候选的
        self.Count_Number = 8 # 向下走几步

        # self.errorType = ['错误: 找不到符号']
        self.errorType = ['error: cannot find symbol']
        self.tokenizer = RobertaTokenizer.from_pretrained(model_name)
        self.model = RobertaForMaskedLM.from_pretrained(model_name)

        self.device = torch.device("cpu")
        self.model.to(self.device) 

        self.file_read()

    def augment_codestr(self,code_str):
        for node in self.rule_node_pred_dict:
            pattern = r"\b(?<!\.)" + re.escape(node) + r"\b" #匹配到的API元素前面不能有.
            code_str = re.sub(pattern, self.rule_node_pred_dict[node], code_str)
        return code_str

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

        #对 node_pred进行过滤
        error_symbol_list = []
        for codeError in self.codeErrorInfo:  
            error_symbol = codeError['error_symbol']
            error_symbol_list.append(error_symbol)
        
        list_copy = error_symbol_list.copy()
        error_symbol_list = []
        for item in list_copy:
            if len(item.split()) >= 3:
                error_symbol_list.append(item.split()[2])
            if len(item.split()) == 1:
                error_symbol_list.append(item)
                
        error_symbol_list = list(set(error_symbol_list))
        # error_symbol_list = list(set([item.split()[2] for item in error_symbol_list]))
        # print(f"debug109:error_symbol_list = {error_symbol_list}")
        # print(f'debug110:self.rule_node_pred_dict = {self.rule_node_pred_dict}')
        self.rule_node_pred_dict = {key: value for key, value in self.rule_node_pred_dict.items() if key in error_symbol_list}
        # print(f'debug112:self.rule_node_pred_dict = {self.rule_node_pred_dict}')


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

                        code_str = self.augment_codestr(code_str)

                        self.codeInfo.append({"maskCode": maskCode, "Glob_context": code_str})
                        break

                    elif code_i <2 and code_i<len(self.code_Split)-2:  # 前面两行没有, 后面两行有
                        Context_code.append(self.code_Split[:code_i])
                        Context_code.append([code.replace(error_code,maskCode,1)])
                        Context_code.append(self.code_Split[code_i+1:code_i+3])
                        code_list_  = [inner for code in Context_code for inner in code]
                        code_str = ' '.join(code_list_)

                        code_str = self.augment_codestr(code_str)


                        self.codeInfo.append({"maskCode": maskCode, "Glob_context": code_str})
                        break

                    elif code_i >=2 and code_i>=len(self.code_Split)-2:  # 前面两行有，后面两行 没有
                        Context_code.append(self.code_Split[code_i-2:code_i])
                        Context_code.append([code.replace(error_code,maskCode,1)])
                        Context_code.append(self.code_Split[code_i+1:])

                        code_list_  = [inner for code in Context_code for inner in code]
                        code_str = ' '.join(code_list_)

                        code_str = self.augment_codestr(code_str)

                        self.codeInfo.append({"maskCode": maskCode, "Glob_context": code_str})
                        break
                    elif len(self.code_Split) <=3:  #
                        code_str = ' '.join(self.code_Split)
                        code_c = code_str.replace(error_code,maskCode,1)

                        code_c = self.augment_codestr(code_c)

                        self.codeInfo.append({"maskCode": maskCode, "Glob_context": code_c})
                        break

        with open(os.path.join(filePath,self.codeSnippet_Name,'Prompt_data',os.path.basename(code_file_path)),'w',encoding='utf-8') as f:
            json.dump(self.codeInfo,f,indent=2)   
            print(f"Prompt data has been saved to {os.path.join(filePath,self.codeSnippet_Name,'Prompt_data',os.path.basename(code_file_path))}")     


def DL_predict_with_Rule_info(file_name,dataset,lib,topK,rule_node_pred_dict):
    '''
    returns dl_ans and dl_truth
    {'node':['fqn1','fqn2','...']}
    '''
    tmp_dir = os.getcwd() #~/ours
    os.chdir(os.path.abspath(os.path.join(tmp_dir,"..","Baseline"))) #~/Baseline

    model_name = 'modelTuned_30'
    Model_path = os.path.abspath(os.path.join("./Prompt_tune/ASE_prompt_tuning/PromptTuning/", "Model", model_name))
    print('model_name:',model_name,' pred_way: type.method() --> <mask>.type.method()')

    # copy code from dataset
    DL.boolean(f'./Prompt_tune/ASE_prompt_tuning/PromptInference/Practicality/SO_codeSnippet/{lib}/original_java')
    source_folder = os.path.abspath(f'../Datasets/{dataset}/{lib}')
    target_folder = os.path.abspath(f'./Prompt_tune/ASE_prompt_tuning/PromptInference/Practicality/SO_codeSnippet/{lib}/original_java')
    source_file_path = os.path.join(source_folder, file_name)
    target_file_path = os.path.join(target_folder, file_name)
    p = subprocess.Popen(['cp', source_file_path, target_file_path])
    if p.poll() is None:
        p.wait()

    # major steps
    os.chdir("./Prompt_tune/ASE_prompt_tuning/PromptInference/Practicality/")
    DL.ground_truth(lib)
    DL.getCodeSnippet(lib)
    Pred_with_Prompt_Augmented(lib,Model_path,rule_node_pred_dict)
    DL.Metric(lib)

    # get final results
    os.chdir(os.path.abspath(os.path.join(tmp_dir,"..","Baseline"))) #~/Baseline
    record_entries = run_baseline.extract_results_from_DL(file_name,lib,topK)
    node_pred_dict = {}
    node_truth_dict = {}
    for entry in record_entries:
        node = entry[0]
        pred = entry[1]
        node_pred_dict[node] = pred

        truth = entry[2]
        node_truth_dict[node] = truth

    # print(f"node_pred_dict = {node_pred_dict}")
    # print(f"node_truth_dict = {node_truth_dict}")
    os.chdir(tmp_dir)
    return node_pred_dict,node_truth_dict


if __name__ == '__main__':
    print('hello')
   