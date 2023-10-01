#-*- coding: utf-8 -*-
import os
import re


# 这里将 variable 转成对应的 label, i.e., variable.method() --> type.method() 只转这一种
def code_Parse(java_code,path_json):
    # path_json is json file
    # java_code is FQN code file
    with open(java_code,'r',encoding='utf-8') as f:  # 要处理的.java 文件。 将 code 以分号进行切割 保存在 code_list 当中
        code_content = f.read()
        code = re.sub('''"(.*?)"''',"String",code_content)
        code_list = code.split(";\n")
        codeFunction_list = [' '.join(code.split())+';' for code in code_list ]

    varType_list = json_deal(path_json)  # 用于存储 Localvariable 和 Field --> []
    # self.varType_list = list(set(self.varType_list))

    # 对代码进行切片操作
    list_dict = []  # 用于存储 dict: {Code_statement:[]}

    # 计算 func_list当中一共有多少行 代码
    if len(codeFunction_list) <=2:
        code_dict1 = {'var_name': str, 'code_statement': []}
        code_dict1['var_name'] = None
        code_dict1['code_statement'] = " ".join(codeFunction_list)
        list_dict.append(code_dict1['code_statement'])
        return list_dict # 如果代码行数小于5行 则不处理

    # 将 variable 区分成两部分
    basic_variable = []  # int,string 类型的变量
    class_variable = [] # type 为 FQN 的类型变量
    for var in varType_list:
        var_label = var[1]
        if var_label.count('.') >= 2 and var_label != 'java.lang.String' and var_label != "java.lang.Object" and var_label != 'java.lang.Integer' \
                and '[]' not in var_label:
            class_variable.append(var)
        else: basic_variable.append(var)

    added_funcIndex = []  # ’var' 得到 var.method() and local context
    for class_var in class_variable:
        code_dict = {'var_name': str, 'code_statement': []}
        var_name = class_var[0]
        var_label = class_var[1].replace('$','.')
        var_label_simple_name = '.'.join(var_label.split('.')[:-1])
        code_statement = []
        varStatement_index = 0
        TAG,code_value = True,None
        for func_index in range(len(codeFunction_list)):
            # 旨在找到第一次出现 当前 variable的code statement, 分别对应 List var = xx ②‘Var= xx' 以及这个var 所对应simple name在这个code statement
            if (re.search('[^A-Za-z0-9]'+var_label_simple_name+'[^A-Za-z0-9]',codeFunction_list[func_index]) or
                    re.search('^'+var_label_simple_name+'[^A-Za-z0-9]',codeFunction_list[func_index])) and \
                    (re.search('[^A-Za-z0-9]'+var_name+'[^A-Za-z0-9]',codeFunction_list[func_index]) or
                    re.search('^'+var_name+'[^A-Za-z0-9]',codeFunction_list[func_index])):
                code_statement.append(codeFunction_list[func_index])
                added_funcIndex.append(func_index)
                varStatement_index = func_index
                code_value = codeFunction_list[func_index]
                continue

             # 得到 这个 var的使用, var.add() 或者 class.var (var 是一个filed)
            if re.search('^'+var_name+'\.',codeFunction_list[func_index]) or re.search('[^A-Za-z0-9]'+var_name+'\.',codeFunction_list[func_index]) or \
                    re.search('\.' + var_name + '[^A-Za-z0-9]', codeFunction_list[func_index],re.I) and TAG is False:
                code_statement.append(codeFunction_list[func_index])
                added_funcIndex.append(func_index)

        # 得到 first_index, 的前后一行 构成 context
        before_index = varStatement_index - 1 # 前一行
        after_index = varStatement_index + 1  # 后一行
        if before_index > 0 and codeFunction_list[before_index] not in code_statement and code_value != None:
            code_statement.insert(code_statement.index(code_value),codeFunction_list[before_index])

        if after_index < len(codeFunction_list) and codeFunction_list[after_index] not in code_statement and code_value != None:
            code_statement.insert(code_statement.index(code_value)+1,codeFunction_list[after_index])

        for code_state in code_statement:
            code_state_sub = re.sub('^' + var_name + '\.', ' ' + var_label + '.', code_state)
            code_dict['code_statement'].append(re.sub('[^A-Za-z0-9]' + var_name + '\.', ' ' + var_label + '.', code_state_sub))
        code_dict['var_name'] = var_name
        list_dict.append(" ".join(code_dict['code_statement']))

    for basic_var in basic_variable:  # 仅仅选取前后一行，作为Local context
        code_dict = {'var_name': str, 'code_statement': []}
        var_name = basic_var[0]
        code_statement = []
        for func_index in range(len(codeFunction_list)):
            if func_index in added_funcIndex: continue

            # 旨在找到第一次出现 当前 variable的code statement, 分别对应 List var = xx ②‘Var= xx'
            if re.search('[^A-Za-z0-9]' + var_name + '[^A-Za-z0-9]', codeFunction_list[func_index]) or \
                re.search('^' + var_name + '[^A-Za-z0-9]', codeFunction_list[func_index]):
                code_statement.append(codeFunction_list[func_index])
                # added_funcIndex.append(func_index)
                varStatement_index = func_index
                code_statement_value = codeFunction_list[func_index]

                # 得到 first_index, 的前后一行 构成 context
                before_index = varStatement_index - 1  # 前一行
                after_index = varStatement_index + 1  # 后一行
                if before_index > 0 and codeFunction_list[before_index] not in code_statement:
                    code_statement.insert(code_statement.index(code_statement_value), codeFunction_list[before_index])

                if after_index < len(codeFunction_list) and codeFunction_list[after_index] not in code_statement:
                    code_statement.insert(code_statement.index(code_statement_value)+1, codeFunction_list[after_index])

        code_dict['code_statement'] = ' '.join(code_statement)

        code_dict['var_name'] = var_name
        list_dict.append(code_dict['code_statement'])

    # 对于 未选择出来的 func
    for func_index in range(len(codeFunction_list)):
        code_dict = {'var_name': 'var', 'code_statement': []}
        code_statement = [codeFunction_list[func_index]]
        code_statement_value = codeFunction_list[func_index]

        if func_index in added_funcIndex: continue
        # 得到 first_index, 的前后一行 构成 context
        before_index = func_index - 1  # 前一行
        after_index = func_index + 1  # 后一行
        if before_index > 0:
            code_statement.insert(code_statement.index(code_statement_value), codeFunction_list[before_index])

        if after_index < len(codeFunction_list):
            code_statement.insert(code_statement.index(code_statement_value)+1, codeFunction_list[after_index])

        code_dict['code_statement'] = ' '.join(code_statement)
        list_dict.append(code_dict['code_statement'])

    return list_dict


# get variable and variable type from json file
def json_deal(AST_files_path):
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
                            # Variable_list.append(''.join(var_name))
                            break
                        var_name.append(cont[before_index])
                    if cont[before_index] == '''"''':
                        Tag = True

                # 向后遍历得到 variable 的 label
                var_label = []
                cont = cont[end_index:]
                Variable_label = re.search(''', "children": \[ { \"label\":''', cont)
                end_index_label = Variable_label.end()
                Tag_label = False
                while True:
                    end_index_label = end_index_label + 1
                    if Tag_label:
                        if cont[end_index_label] == '''"''':
                            # Variable_list.append(''.join(var_name))
                            break
                        var_label.append(cont[end_index_label])
                    if cont[end_index_label] == '''"''':
                        Tag_label = True
                Variable_list.append((''.join(var_name), ''.join(var_label)))
    # print(Variable_list)
    return Variable_list

if __name__ =="__main__":
    pass




