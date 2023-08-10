#-*- coding: utf-8 -*-
import shutil
import json
import os
import glob
import random
import re
from tqdm import tqdm
import ast
random.seed(1)

root_file_path = os.path.abspath(os.path.join(os.getcwd(), "../.."))
current_path  = os.getcwd()
file_percent = 10
TAG = False
selected_file_list = []
stop_fqn = ['java.lang.String','java.lang.Object','java.lang.Override','java.lang.Class']

def code_Parse_FQN(java_code_path):

    with open(java_code_path,'r',encoding='utf-8') as f:  # 要处理的.java 文件。 将 code 以分号进行切割 保存在 code_list 当中
        code_content = f.read()
        code = re.sub('''"(.*?)"''',"String",code_content)
        code_list = code.split(";\n")
        codeStatement_list = [' '.join(code.split())+';' for code in code_list ]

    # 3 lines 一划分
    output_list = []  # 通过context 将 code 进行划分
    skip_line = 0
    for code_i in range(len(codeStatement_list)):
        if code_i < skip_line: continue
        if codeStatement_list[code_i].count('.')<2:
            skip_line = skip_line+2
            continue
        if code_i + 5 > len(codeStatement_list):
            splited_code = ' '.join(codeStatement_list[code_i:])
            output_list.append(splited_code)
            break
        splited_code = codeStatement_list[code_i: code_i+5]
        output_list.append(' '.join(splited_code))
        skip_line = skip_line + 2
    return output_list

if __name__ =="__main__":
    pass










