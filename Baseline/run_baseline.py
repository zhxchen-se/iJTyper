import os
import re
import sys
import time
import json
import glob
import shutil
import subprocess
import Prompt_tune.ASE_prompt_tuning.PromptInference.Practicality.predDictData_line as DL
from collections import OrderedDict
sys.path.append(os.path.abspath(os.path.join(os.getcwd(), "..")))
sys.path.append(os.path.abspath(os.path.join(os.getcwd(), "../ours")))
from ours.database import DB
from ours.rule import extract_typeinfo_from_log,handle_unsupported_exception,add_text_to_file
def copy_file(source_path,target_path):
    p = subprocess.Popen(['cp', source_path, target_path])
    if p.poll() is None:
        p.wait() #synchronize

def clear_folder(file_path):
    if not os.path.exists(file_path):
        print('Creat folder....')
        os.makedirs(file_path)
    else:
        shutil.rmtree(file_path)
        os.makedirs(file_path)

def copy_all_codes_from_Dataset_to_ASE(dataset):
    lib_list = ['gwt','android','hibernate','jdk','joda_time','xstream'] 
    for lib in lib_list:
        source_path = os.path.abspath(os.path.join(os.getcwd(),"../","Datasets",dataset,lib))
        target_path = os.path.abspath(os.path.join(os.getcwd(),"Prompt_tune","ASE_prompt_tuning",
                            "PromptInference","Practicality","SO_codeSnippet",lib,"original_java"))
        print(f"Copying files from {source_path} to {target_path} ...")
        clear_folder(target_path)
        file_list = glob.glob(os.path.join(source_path, "*"))  #get all files
        for file in file_list:
            copy_file(file, target_path)

def copy_all_codes_from_Dataset_to_SnR(dataset):
    lib_list = ['gwt','android','hibernate','jdk','joda_time','xstream'] 
    for lib in lib_list:
        source_path = os.path.abspath(os.path.join(os.getcwd(),"../","Datasets",dataset,lib))
        target_path = os.path.abspath(os.path.join(os.getcwd(),"SnR","src","test","resources","snippets","so",lib))
        print(f"Copying files from {source_path} to {target_path} ...")
        clear_folder(target_path)
        file_list = glob.glob(os.path.join(source_path, "*"))  #get all files
        for file in file_list:
            copy_file(file, target_path)   


def extract_results_from_DL(snippet_name,lib_name,topK):
    '''
    work_dir:~/Baseline/
    work_dir should be changed before the function is called
    '''
    tmp_dir = os.getcwd()
    prac_dir = os.path.join(tmp_dir,"Prompt_tune","ASE_prompt_tuning","PromptInference","Practicality")
    os.chdir(prac_dir)

    # 从JSON文件读取数据
    pre_file_str = f"./SO_codeSnippet/{lib_name}/FQN_pred/{snippet_name}_pred.json"
    compare_file_str = f"./SO_codeSnippet/{lib_name}/Compare/{snippet_name}_compare.txt"
    with open(pre_file_str) as pre_file:
        pre_data = json.load(pre_file,object_pairs_hook=OrderedDict)
    with open(compare_file_str) as compare_file:
        compare_data = json.load(compare_file, object_pairs_hook=OrderedDict)

    # print(f"debug62:pre_data = {pre_data}")

    token_pattern = r"(new )?<MASK>\.(([^ .\";()<>,]|\(\))*)" # r"(new )?<MASK>\.([^ .\";)]*\)?)"
    exacted_records = []
    nodes = set()
    
    # 遍历每个对象并提取"fqnToken"的数据
    for i in range(len(pre_data)):
        pre_record = pre_data[i]
        compare_record = compare_data[i]
        pre_fqn = pre_record['fqnToken']
        # print(f"debug73:pre_fqn = {pre_fqn}")
        ase_truth = compare_record['FQN_true']
        truth_len = len(ase_truth)
        FQNCode = pre_record['FQNCode']
        token_matches = re.finditer(token_pattern, FQNCode)
        tokens = "unknown"
        complete_database = DB(isComplete=True)
        if token_matches:
            tokens = token_matches
            count = 0
            for token in tokens:
                token_name = token.group(0).replace("<MASK>.","")
                # print(f"debug84:token_name = {token_name}")
                if token_name.find(")")!=-1 and token_name.find("(")==-1:
                    token_name = token_name.rstrip(')')
                if token_name.find("(")!=-1 and token_name.find(")")==-1:
                    token_name = token_name.rstrip('(')
                if (token_name not in nodes) and (token_name != ''): #Repeated token_name only use the first prediction
                    # token_pre = pre_fqn[count][0]
                    # print(f"debug83:count = {count}")
                    token_pre = []

                    # for i in range(0,topK):# without knowledgebase check
                    #     token_pre.append(pre_fqn[count][i])

                    for i in range(0,len(pre_fqn[count])):
                        if complete_database.check_if_entry_exists_in_four_tables(pre_fqn[count][i]): # knowledgebase check
                            token_pre.append(pre_fqn[count][i])
                        if len(token_pre) >= topK:
                            break
                    if len(token_pre) < topK: 
                        for i in range(0,len(pre_fqn[count])):
                            if pre_fqn[count][i] not in token_pre:
                                token_pre.append(pre_fqn[count][i])
                            if len(token_pre) >= topK:
                                break 
                        



                    token_truth = "-"
                    if count<truth_len:
                        token_truth = ase_truth[count]
                    token_correct = 1 if token_pre==token_truth else 0
                    exacted_record=(token_name,token_pre,token_truth,token_correct)
                    exacted_records.append(exacted_record)
                    nodes.add(token_name)
                count += 1

    os.chdir(tmp_dir)
    return exacted_records

def Extract_binding_logs(log_file):
    '''
    returns Rule_ans and Rule_truth
    {'node':['fqn']}
    if a node has no rule_truth, it will not be added to node_truth_dict
    '''
    node_pred_dict = {}
    node_truth_dict = {}

    #define patterns
    pattern = r"For node: (.+?) expected fqn: (.+?) with type: .+? got: (.+)"
    # pattern_notfind = r"Did not find solution for node: (.+) with type"
    # pattern_notmatch = r"Cannot find matching typeVariable for: (.+)"
    pattern_find_ans_but_no_truth = r"No match for actual type \w+: (.*) with type: .* got: (.*)"

    with open(log_file, "r") as file:
        for line in file:
            for line in file:
                match = re.search(pattern, line)
                match_find_ans_but_no_truth = re.search(pattern_find_ans_but_no_truth,line)
                if match:
                    node = match.group(1)
                    truth = re.sub("<.*>","",match.group(2)) # match.group(2)
                    got = match.group(3).replace('$','.') 
                    if(node != 'void' and truth!='void' and node.startswith('@') == False and node not in node_pred_dict): #remove duplicates
                        node_pred_dict[node] = got
                        node_truth_dict[node] = truth

                if match_find_ans_but_no_truth:
                    node = match_find_ans_but_no_truth.group(1)
                    got = match_find_ans_but_no_truth.group(2)
                    if(node != 'void' and got!='void' and node.startswith('@') == False and node not in node_pred_dict):
                        node_pred_dict[node] = got
                        node_truth_dict[node] = "-"
    
    return node_pred_dict,node_truth_dict 
        

def DL_predict_one_snippet(file_name,dataset,lib,topK): 
    '''
    returns dl_ans and dl_truth
    {'node':['fqn1','fqn2','...']}
    '''
    tmp_dir = os.getcwd()
    current_file_path = os.path.abspath(__file__)
    current_directory = os.path.dirname(current_file_path)
    os.chdir(current_directory)

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
    DL.Itera_Pred(lib,Model_path)
    DL.Metric(lib)

    os.chdir(current_directory)
    record_entries = extract_results_from_DL(file_name,lib,topK)
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

def pure_rule_execute_make_benchmark(file_name,lib):
    '''
    work_dir:~/Baseline/SnR
    returns log output path (in Middle results)
    '''
    output_folder = os.path.abspath(os.path.join(os.getcwd(),"../","../","ours","MiddleResults","benchmark_log",lib))
    # run_baseline.clear_folder(output_folder)
    output_path = os.path.join(output_folder,file_name)
    output_path = output_path.replace('.java','_pure_rule_stdout.txt')
    with open(os.devnull, 'w') as devnull: 
        print('Executing make benchmark...')
        # p = subprocess.Popen(['make', 'benchmark'], stdout=devnull, stderr=devnull)
        # if p.poll() is None:
        #     p.wait()

        max_retries = 3  # Maximum number of retries
        timeout_seconds = 60  # Timeout in seconds
        for attempt in range(max_retries + 1):
            print(f'Attempt {attempt + 1} of make benchmark...')
            with open(output_path, 'w') as outputfile:
                p = subprocess.Popen(['make', 'benchmark'], stdout=devnull,stderr=devnull)
            start_time = time.time()
            while p.poll() is None:
                if time.time() - start_time > timeout_seconds:
                    print(f"Process timed out after {timeout_seconds} seconds. Retrying...")
                    p.terminate() 
                    break 

            if p.poll() is not None and p.poll() == 0:
                print("Make benchmark completed successfully.")
                break 
        
            if attempt == max_retries:
                print("Maximum number of retries reached. Exiting.")
                raise TimeoutError("Fail to execute make benchmark:time out and reached maximum retries.")  # Throw a custom timeout error
                break

        # get log_dir
        log_dir = os.path.abspath(os.path.join(os.getcwd(),"benchmark","snippet_log"))
        for root, dirs, files in os.walk(log_dir):
            for name in files:
                if name.startswith(f"{file_name}.stdout"):
                    log_path = os.path.join(root, name)
        p = subprocess.Popen(['cp', log_path, output_path])
        if p.poll() is None:
            p.wait() 
    print(f'make benchmark log output_path = {output_path}')
    return output_path



def Rule_predict_one_snippet(file_name,dataset,lib): #Predicting for a single code segment, note that some nodes may only in  pred_dict, not in truth_dict
    '''
    returns Rule_ans and Rule_truth
    {'node':['fqn']}
    '''
    tmp_dir = os.getcwd()
    current_file_path = os.path.abspath(__file__)
    current_directory = os.path.dirname(current_file_path)
    os.chdir(current_directory)

    # copy code from dataset
    DL.boolean(f'./SnR/src/test/resources/snippets/so')
    source_folder = os.path.abspath(f'../Datasets/{dataset}/{lib}')
    target_folder = os.path.abspath(f'./SnR/src/test/resources/snippets/so')
    source_file_path = os.path.join(source_folder, file_name)
    target_file_path = os.path.join(target_folder, file_name)
    p = subprocess.Popen(['cp', source_file_path, target_file_path])
    if p.poll() is None:
        p.wait()

    # save binding results
    print('Executing make binding...')
    DL.boolean('./logs/bind_lib_logs')
    os.chdir('./SnR')
    output_path = os.path.abspath(f"../logs/bind_lib_logs/{file_name}")
    output_path = output_path.replace('.java','.txt')


    # execute make binding
    max_retries = 3  # Maximum number of retries
    timeout_seconds = 60  # Timeout in seconds
    binding_start_time = time.time()
    for attempt in range(max_retries + 1):
        print(f'Attempt {attempt + 1}...')
        with open(output_path, 'w') as outputfile:
            p = subprocess.Popen(['make', 'runcomparebindinganalysisandeclipsejdt'], stdout=outputfile)
        start_time = time.time()
        while p.poll() is None:
            if time.time() - start_time > timeout_seconds:
                print(f"Process timed out after {timeout_seconds} seconds. Retrying...")
                p.terminate() 
                break 

        if p.poll() is not None and p.poll() == 0:
            print("Make binding completed successfully.")
            break 
    
        if attempt == max_retries:
            print("Maximum number of retries reached. Exiting.")
            raise TimeoutError("Fail to execute make runcomparebindinganalysisandeclipsejdt:time out and reached maximum retries.")  # Throw a custom timeout error
            break
    binding_time = time.time()-binding_start_time
    print(f'Bind log has been saved to {output_path}')

    # TODO execute make benchmark
    benchmark_start_time = time.time()
    benchmark_log_path = pure_rule_execute_make_benchmark(file_name,lib)
    extra_types = extract_typeinfo_from_log(benchmark_log_path)
    benchmark_time = time.time() - benchmark_start_time
    #extract log
    os.chdir('../') #~/Baseline
    node_pred_dict,node_truth_dict = Extract_binding_logs(output_path)
    

    # TODO save unresolve type ref and unsupported_exception error info
    _,match_str = handle_unsupported_exception(output_path)
    os.chdir(os.path.abspath(os.path.join(os.getcwd(),'..','ours')))
    extra_info_folder = os.path.abspath(os.path.join(os.getcwd(),'MiddleResults','pure_rule_extra_info',lib))
    if not os.path.exists(extra_info_folder):
        os.makedirs(extra_info_folder)
    # unresolve type ref
    unresolved_info_path = os.path.abspath(os.path.join(extra_info_folder,'pure_rule_unresolved_typeref_info.txt'))
    add_text_to_file(unresolved_info_path,f"filename:{file_name}    extra_types:{extra_types}\n")
    # unsupported_exception
    exception_info_path = os.path.abspath(os.path.join(extra_info_folder,'pure_rule_UnsupportedOperationException_info.txt'))
    add_text_to_file(exception_info_path,f"filename:{file_name}    java.lang.UnsupportedOperationException:{match_str}\n")


    os.chdir(tmp_dir)
    return node_pred_dict,node_truth_dict,benchmark_time,binding_time


if __name__ == '__main__':
    pass
    # node_pred_dict,node_truth_dict = DL_predict_one_snippet('JodaTime40.java','StatType-SO','joda_time',3)
    # # print(Rule_predict_one_snippet('JodaTime02.java','StatType-SO','joda_time'))
    # start_time = time.time()
    # ret = extract_results_from_DL('JodaTime40.java','joda_time',3)
    # print(ret)
    # end_time = time.time()
    # print(f'耗时：{end_time-start_time}')