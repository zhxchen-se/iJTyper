#-*- coding: utf-8 -*-
import re


# 这里将 variable 转成对应的 label, i.e., variable.method() --> type.method() 只转这一种
def code_Parse(java_code,path_json,):

    # path_json is json AST 文件路径
    # java_code is FQN_file 的文件路径

    with open(java_code,'r',encoding='utf-8') as f:  # 要处理的.java 文件。 将 code 以分号进行切割 保存在 code_list 当中
        code_content = f.read()
        code = re.sub('''"(.*?)"''',"String",code_content)
        code_list = code.split(";\n")
        codeF_list = [' '.join(code.split())+';' for code in code_list ]

    varType_list = json_deal(path_json)  # 用于存储 Localvariable 和 Field --> []
    varType_list = list(set(varType_list))  # 去除命名相同的变量名

    # 通过variable 对 code 进行切片。
    list_dict = []  # 用于存储 dict: {Code_statement:[]}

    # 计算 func_list当中一共有多少行 代码
    if len(codeF_list) <=5:
        code_dict1 = {'var_name': str, 'code_statement': []}
        code_dict1['var_name'] = None
        code_dict1['code_statement'] = " ".join(codeF_list)
        list_dict.append(code_dict1['code_statement'])
        return list_dict# 如果代码行数小于5行 则不处理

        # 将 variable 区分成两部分
    basic_variable = []  # int,string 类型的变量
    class_variable = []  # type 为 FQN 的类型变量
    for var in varType_list:
        var_label = var[1]
        if var_label.count('.') >= 2 and \
                var_label != 'java.lang.String' and var_label != "java.lang.Object" and var_label != 'java.lang.Integer' \
                and '[]' not in var_label:
            class_variable.append(var)
        else:
            basic_variable.append(var)

    added_index = []
    for var in class_variable:
        code_dict = {'var_name': str, 'code_statement': []}
        code_statement = []
        var_name = var[0]
        var_label = var[1]
        for func_index in range(len(codeF_list)):
            # ① listvar var = new varList(); ② var.add(); ③ var = new list();  注意: '^'+var 是用于匹配 var 顶格写的表达式
            if re.search('[^A-Za-z0-9]'+var_name+'[^A-Za-z0-9]',codeF_list[func_index]) or \
                    re.search('^'+var_name+'\.',codeF_list[func_index]) or re.search('^'+var_name+'[^A-Za-z0-9]',codeF_list[func_index]):
                added_index.append(func_index)

                if var_label.count('.') >= 2 and var_label != 'java.lang.String' and var_label != "java.lang.Object" and '[]' not in var_label:
                    code_state_sub = re.sub('^' + var_name + '\.', ' ' + var_label + '.', codeF_list[func_index])
                    code_statement.append(re.sub('[^A-Za-z0-9]' + var_name + '\.', ' ' + var_label + '.', code_state_sub))
                else:
                    code_statement.append(codeF_list[func_index])
        if len(code_statement)==0: continue
        code_dict['var_name'] = var_name
        code_dict['code_statement'] = ' '.join(code_statement)
        list_dict.append(code_dict['code_statement'])

    for var in basic_variable:
        code_statement = []
        var_name = var[0]
        for func_index in range(len(codeF_list)):
            if func_index in added_index: continue
            # ① listvar var = new varList(); ② var.add(); ③ var = new list();  注意: '^'+var 是用于匹配 var 顶格写的表达式
            if re.search('[^A-Za-z0-9]' + var_name + '[^A-Za-z0-9]', codeF_list[func_index]) or \
                    re.search('^' + var_name + '\.', codeF_list[func_index]) or re.search('^' + var_name + '[^A-Za-z0-9]', codeF_list[func_index]):
                code_statement.append(codeF_list[func_index])
                # added_index.append(func_index)
        if len(code_statement) == 0: continue
        list_dict.append(' '.join(code_statement))

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




