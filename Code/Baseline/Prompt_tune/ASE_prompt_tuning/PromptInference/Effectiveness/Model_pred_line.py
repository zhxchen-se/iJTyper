#-*- coding: utf-8 -*-
# 每个文件当中，分别有 6个Model. 测试文件有3个，分别在 D1,D2,D3文件夹
from __future__ import absolute_import
import glob
import os
import json
import random
import re
from transformers import RobertaTokenizer,RobertaForMaskedLM
from tqdm import tqdm
import torch
import numpy as np
from PromptInference.all_way import D1_split_by_oneLine as D1


java_key_words = ['public','private','Public','Private','final','final','new','New','void','Void','Static','static','protected','Protected','extends']
# model_name = os.path.join(root_path,'jdk','model','D3_M2_model')

Topk = 1
root_file_path = os.path.abspath(os.path.join(os.getcwd(), "../..","PromptTuning"))
Tag1 = True  # 是否重新选取预测的文件数据？
Tag2 = False  # 是否从处理好的数据中选取一部分数据用于预测。如果生成的line.json 较大，这个可以设置为True，以便更快的看到预测的数据
output_pred = []

class pred_start():
    # Lib_names is the API in the Libs that need to infer and Percent is the how many data that need to infer
    def __init__(self,Lib_names,percent):
        pred_json = os.path.join('./predData', 'line.json')
        # file_path = os.path.join('./pred_Data','file_list.json')

        if Tag1 == True:
            self.tokenizer = RobertaTokenizer.from_pretrained("microsoft/codebert-base-mlm")
            pred_file = self.file_select(Lib_names,percent)  # get the file path that need to predict
            Pred_data = self.pred_Data_Gen(pred_file)  # get the API that need to infer the correspond FQN.

            with open(pred_json, 'w', encoding='utf-8') as f:
                json.dump(Pred_data,f)

            # with open(file_path, 'w', encoding='utf-8') as f:
            #     json.dump(pred_file,f)

        if Tag2 == True:
            with open(pred_json,'r',encoding='utf-8') as f:
                Pred_data = json.load(f)

            Data_test = []
            for pred in Pred_data:
                lib_name = pred['lib']
                predict_data = pred['pred_out']
                sampled_data = random.sample(predict_data, 1000)
                Data_test.append({'lib':lib_name,'pred_out':sampled_data})
                with open(os.path.join("./predData",'Date_test_1000.json'), 'w', encoding='utf-8') as f:
                    json.dump(Data_test,f,indent=2)

        with open(os.path.join("./predData",'line.json'), 'r', encoding='utf-8') as f:
            Data_test = json.load(f)

        modle_names = ['modelTuned_35']
        for model_name in modle_names:
            # out_dict1 = {'model_name': model_name, 'pred_detail':[]}

            print('######## model_name',model_name)
            # if 'model_line' in model_name: model_path = os.path.join("./Model",model_name)
            # else: model_path = model_name

            model_path = os.path.join(root_file_path,'Model',model_name)

            self.tokenizer = RobertaTokenizer.from_pretrained(model_path)
            self.model = RobertaForMaskedLM.from_pretrained(model_path)
            total_corr = 0

            out_list = []
            for pred in Data_test:
                lib_name = pred['lib']
                print('######## lib_name', lib_name)
                Corr = 0  # 正确的数  TP/(FP+TP)
                count = 0
                predict_data = pred['pred_out']
                # sampled_data = random.sample(predict_data,500)
                for pred_d in tqdm(predict_data, desc='pred'):
                    out_dict2 = {'lib_name': lib_name, 'pred_type': str, 'truth_type': str,"full_FQN":str,'boolean':int,'context':str}
                    count = count + 1
                    prompt = pred_d['context']
                    fqn_true = pred_d['truth_type']
                    pred = self.numberMaskSearch(prompt)

                    # print('*****************************')
                    print('######## pred:',pred)
                    print('######## fqn_true:', fqn_true)
                    # print('*****************************')
                    out_dict2['pred_type'] = pred
                    out_dict2['truth_type'] = fqn_true

                    out_dict2['boolean'] = 0
                    if fqn_true == pred:
                        out_dict2['boolean'] = 1
                        Corr = Corr + 1
                        total_corr = total_corr + 1

                    # save the information
                    out_dict2['pred_type'] = pred
                    out_dict2['truth_type'] = fqn_true
                    out_dict2['context'] = prompt
                    out_dict2['full_FQN'] = pred_d["fqn"]

                    out_list.append(out_dict2)
                print(f'precision:{round(Corr / len(predict_data), 3)}')

            with open(os.path.join('./pre_data1000model-random-token-45.json'),'w',encoding='utf-8') as f:
                json.dump(out_list,f,indent=2)

    def file_select(self,Lib_names,percent):
        lib_names = ['android', 'gwt', 'hibernate', 'jdk', 'joda_time', 'xstream']
        out_file_lib = []
        # CODE_LIST_FILE = []
        for lib_name in Lib_names:
            out_file = []  # two values, ① codeFqn path  ②AST path

            print("**********", lib_name, '**********')
            codeFqn_file = os.path.join(root_file_path, 'Lib_data', lib_name, 'FQN')  # get the FQN path
            path_json = os.path.join(root_file_path, 'Lib_data', lib_name, 'json_File')  # get the AST file path
            path_json_list = [file for file in glob.glob(path_json + '/*')]  # get all the Json files
            codeFqn_file_list = [file for file in glob.glob(codeFqn_file + '/*')]  # get all the FQN files

            # get the files that have been used to fine-tuned Model
            selected_file_lib = os.path.join(root_file_path,'selectedFile','select_lib_10.json')
            with open(selected_file_lib,'r',encoding='utf-8') as f:
                file_cont = json.load(f)
            for s_cont in file_cont:  # "s" is selected
                (s_lib_name, s_fqn_file), = s_cont.items()
                if s_lib_name != lib_name: continue
                s_fqn_file_name = [os.path.basename(s_file) for s_file in s_fqn_file]
                different_file = [file_1 for file_1 in codeFqn_file_list if os.path.basename(file_1) not in s_fqn_file_name]

                select_file_size = int(percent *0.01* len(different_file))  # To make sure the tuning file is different from the test file
                codeFqn_list = random.sample(different_file,select_file_size)
                # CODE_LIST_FILE.append({"file_path":codeFqn_list,"lib_name":lib_name})
                for codeFqn in codeFqn_list:
                    fqn_name = os.path.basename(codeFqn).replace('.java','.json')
                    for json_file in path_json_list:
                        if fqn_name in json_file:
                            out_file.append([codeFqn, json_file])
                            break
                out_file_lib.append({"lib":lib_name,'out_file':out_file})
        return out_file_lib


    def pred_Data_Gen(self,test_file):

        pred_data_out = []
        for files_lib in test_file:
            lib_name = files_lib['lib']
            lib_files = files_lib['out_file']
            pred_data = []
            for test_file_path in tqdm(lib_files):
                try:
                    fqn_path = test_file_path[0]
                    json_file = test_file_path[1]

                    splited_code_list = D1.code_Parse_FQN(fqn_path, json_file)
                    if splited_code_list == 0: continue

                    split_code_set = []
                    [split_code_set.append(split_code) for split_code in splited_code_list if
                     split_code not in split_code_set and split_code != '']

                    for splited_code in split_code_set:
                        tokens = self.tokenizer.tokenize(splited_code)
                        if len(tokens) > 500: continue  # 这批数据先不处理
                        FQN_data, fqn_list = self.fqnFind(splited_code)
                        if len(FQN_data) == 0: continue
                        pred_data.extend(FQN_data)  # [{'context':context,'truth_type':truth_type},..]
                except:
                    print('----------')

            pred_data_out.append({'lib':lib_name,'pred_out':pred_data})

        return pred_data_out


    def fqnFind(self,code):
        # code = "java.lang.String[] ls = f1.list(sun.font.SunFontManager.getInstance().getTrueTypeFilter()); if (ls == null) { return null; } for (int i = 0; i < ls.length; i++) { java.io.File fontFile = new java.io.File(f1, ls[i]);"
        data_list = []
        fqn_list = []
        line = re.sub('''"(.*?)"''',"String",code)
        itera_list = list(line)
        dot_index_temp = [code_i for code_i in range(len(itera_list)) if line[code_i] == '.']
        dot_index = [dot for dot in dot_index_temp if dot+1 not in dot_index_temp]  #去除连续的 '...'
        if len(dot_index)<2: return data_list,fqn_list

        index_list = []
        for dot_i in dot_index:
            left_start = None  # xxx java.lang.object .... left_start 是 j 的下标
            if dot_i in index_list: continue
            index_list.append(dot_i)
            # 先动当前 dot 的 左边开始
            left = dot_i
            left_str = []
            while True:
                if left<0: # 防止左边越界
                    left_str.reverse()
                    break
                Tag = True
                if itera_list[left].isalpha() or itera_list[left] == '.' or \
                        itera_list[left].isdigit() or itera_list[left]=='_':
                    left_str.append(itera_list[left])
                    if itera_list[left] == '.':
                        index_list.append(left)
                    left_start = left
                    left = left-1
                    Tag = False
                if Tag:
                    left_str.reverse()
                    break
            right = dot_i + 1
            right_str = []
            while True:
                if right >= len(itera_list): # 防止右边 越界
                    break
                Tag = True
                if itera_list[right].isalpha() or itera_list[right] == '.' or \
                        itera_list[right].isdigit() or itera_list[right]=='_':
                    right_str.append(itera_list[right])
                    if itera_list[right] == '.':
                        index_list.append(right)
                    right = right + 1
                    Tag = False
                if Tag:
                    if itera_list[right] == "(":
                        right_str.append("()")
                    break

            fqn_str_temp = ''.join(left_str)+''.join(right_str)

            # if fqn_str_temp == '.avajlang.String':
            #     print(code)
            #     exit()
            fqn_forbiden = ['java.lang.String', 'java.lang.Object','java.lang.Override']
            if fqn_str_temp in fqn_forbiden:
                continue
            if fqn_str_temp.count('.')>=2:
                truth_type = ".".join(fqn_str_temp.split('.')[:-1])
                Mask_number = len(self.tokenizer.tokenize(truth_type))
                context = code[0:left_start] + '<mask>'*Mask_number + code[index_list[-1]:]
                data_list.append({'fqn':fqn_str_temp,'truth_type':truth_type,'context':context})
                fqn_list.append(fqn_str_temp)

        return data_list,fqn_list

    def numberMaskSearch(self,prompt):
        token_list = self.tokenizer.encode(prompt, add_special_tokens=True)
        token_tensor = torch.tensor([token_list])

        maskIndex_list = [np.argwhere(token_tensor.numpy()[0] == self.tokenizer.mask_token_id)][0].transpose()[0,:].tolist() # x == y, x 和 y的维度要相等
        output = self.model(token_tensor)[0]
        cur_pred = output[:,maskIndex_list,:]
        scores,indexs = torch.topk(cur_pred,k=1)  # 返回 top-beamSize 的 values
        score,index = scores.view(-1).detach(),indexs.view(-1).detach()

        # 将 预测所得到的 TypeId 转成 字符
        pred_token_list_temp = self.tokenizer.convert_ids_to_tokens(index)  # token_list--['token1','token2','token3'...]
        pred_token_list = [token.replace('Ġ','') for token in pred_token_list_temp]
        pred_token_str = ''.join(pred_token_list)
        return pred_token_str

    def model_Pred(self,token_tensor):
        maskIndex_list = [np.argwhere(token_tensor.numpy()[0] == self.tokenizer.mask_token_id)][0].transpose()[0,:].tolist() # x == y, x 和 y的维度要相等
        output = self.model(token_tensor)[0]
        cur_pred = output[:,maskIndex_list,:]
        scores,indexs = torch.topk(cur_pred,k=1)  # 返回 top-beamSize 的 values
        score,index = scores.view(-1).detach(),indexs.view(-1).detach()
        return score,index,maskIndex_list

if __name__ == '__main__':
    # import sys
    #
    # f = open('pred.log', 'a')
    # sys.stdout = f
    # sys.stderr = f  # redirect std err, if necessary
    Lib_names = ["cloudbees"]
    percent = 60  # Percentage of files used to predict
    pred_start(Lib_names,percent)