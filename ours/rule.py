import os
import re
import sys
import time
import torch 
import subprocess
from database import DB
sys.path.append(os.path.abspath(os.path.join(os.getcwd(), "..")))
sys.path.append(os.path.abspath(os.path.join(os.getcwd(), "../Baseline")))
from Baseline import run_baseline

def get_api_pool(dl_node_pred_dict):
    api_pool = ['java.lang','java.io']
    for value in dl_node_pred_dict.values():
        api_pool.extend(value)
    api_pool = list(set(api_pool))
    return api_pool

def extract_typeinfo_from_log(log_path):
    types = []
    with open(log_path) as f:
        for line in f:
            match = re.search(r"Unable to resolve TypeRef: L(.+);", line)
            if match:
                #如果是泛型，那么只取泛型前面的部分
                match_str = match.group(1)
                match_str = match_str.split('<')[0]
                types.append(match_str)
    return list(set(types))

def execute_make_benchmark(file_name,lib):
    '''
    work_dir:~/Baseline/SnR
    returns log output path (in Middle results)
    '''
    output_folder = os.path.abspath(os.path.join(os.getcwd(),"../","../","ours","MiddleResults","benchmark_log",lib))
    # run_baseline.clear_folder(output_folder)
    output_path = os.path.join(output_folder,file_name)
    output_path = output_path.replace('.java','_stdout.txt')
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

def execute_make_binding(file_name,lib):
    '''
    work_dir:~/Baseline/SnR
    returns log output path (in Middle results)
    '''
    output_folder = os.path.abspath(os.path.join(os.getcwd(),"../","../","ours","MiddleResults","bind_log",lib))
    # run_baseline.clear_folder(output_folder)
    output_path = os.path.join(output_folder,file_name)
    output_path = output_path.replace('.java','.txt')
    # with open(output_path, 'w') as outputfile:
    #     print('Executing make binding...')
    #     p = subprocess.Popen(['make', 'runcomparebindinganalysisandeclipsejdt'], stdout=outputfile)
    # if p.poll() is None:
    #     p.wait()

    print('Executing make binding...')
    max_retries = 3  # Maximum number of retries
    timeout_seconds = 60  # Timeout in seconds
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

    print(f'bind log output_path = {output_path}')
    return output_path

def handle_unsupported_exception(bind_log_path):
    print('Processing java.lang.UnsupportedOperationException...')
    extra_field = []
    match_str = ''
    with open(bind_log_path) as f:
        for line in f:
            match = re.search(r"java.lang.UnsupportedOperationException: (.+) could not be a valid type name or a variable name.", line)
            if match:
                match_str = match.group(1)
                extra_field.append(match_str)
                #如果有点,将其子token也放进去
                if '.' in match_str:
                    match_str_list = match_str.split('.')
                    for token in match_str_list:
                        extra_field.append(token)
    extra_field = list(set(extra_field))
    print(f'extra_field = {extra_field}, len(extra_field) = {len(extra_field)}')
    return extra_field,match_str
    

def add_text_to_file(file_path,text):
    try:
        with open(file_path, 'a') as file:
            file.write(text + '\n') 
    except Exception as e:
        print(f"add text to {file_path} error:", str(e))

def Rule_predict_with_DL_info(file_name,dataset,lib,dl_node_pred_dict,log_feed_back_flag): #DL -> Rule
    '''
    returns Rule_ans and Rule_truth
    {'node':['fqn']}
    '''
    tmp_dir = os.getcwd()
    current_file_path = os.path.abspath(__file__)
    current_directory = os.path.dirname(current_file_path)
    current_directory = os.path.abspath(os.path.join(current_directory,"../","Baseline"))
    os.chdir(current_directory)

    # 1.copy code from dataset
    run_baseline.DL.boolean(f'./SnR/src/test/resources/snippets/so')
    source_folder = os.path.abspath(f'../Datasets/{dataset}/{lib}')
    target_folder = os.path.abspath(f'./SnR/src/test/resources/snippets/so')
    source_file_path = os.path.join(source_folder, file_name)
    target_file_path = os.path.join(target_folder, file_name)
    p = subprocess.Popen(['cp', source_file_path, target_file_path])
    if p.poll() is None:
        p.wait()

    # 2.get api_pool 
    # print(f"debug111:dl_node_pred_dict = {dl_node_pred_dict}")
    api_pool = get_api_pool(dl_node_pred_dict)
    # print(f'debug113:api_pool = {api_pool}')

    # 3.query entries from complete database
    complete_database = DB(isComplete=True)
    results = complete_database.query_apipool(api_pool)

    # 4.insert entries to empty database
    simplified_database = DB(isComplete=False)
    simplified_database.clear_four_tables()
    simplified_database.copy_results_to_four_tables(results)
    
    os.chdir("./SnR")
    match_str = ''
    # 5.execute make benchmark, get feedback log 
    if log_feed_back_flag:
        benchmark_log_path = execute_make_benchmark(file_name,lib)
        extra_info_folder = os.path.abspath(os.path.join(tmp_dir,'MiddleResults','extra_info',lib))
        if not os.path.exists(extra_info_folder):
            os.makedirs(extra_info_folder)
        # 6.repeat until no more unresolved type
        for i in range(0,10):
            # 6.1 extract unresolved type info from log
            extra_types = extract_typeinfo_from_log(benchmark_log_path)
            print(f'extra_types={extra_types},len(extra_types)={len(extra_types)}')
            # save unresolve type ref
            unresolved_info_path = os.path.abspath(os.path.join(extra_info_folder,'unresolved_typeref_info.txt'))
            add_text_to_file(unresolved_info_path,f"filename:{file_name} log_feed_back_flag:{log_feed_back_flag}   extra_types:{extra_types}\n")
            
            if len(extra_types) == 0:
                break
            api_pool += extra_types
            api_pool = list(set(api_pool))

            # 6.2 rebuild database
            results = complete_database.query_apipool(api_pool)
            simplified_database.clear_four_tables()
            simplified_database.copy_results_to_four_tables(results)

            # 6.3 reexecute make benchmark
            benchmark_log_path = execute_make_benchmark(file_name,lib)
            
    # 7.execute make binding 
    bind_log_path = execute_make_binding(file_name,lib)

    if log_feed_back_flag:
        extra_field,match_str = handle_unsupported_exception(bind_log_path)
        # 8. add and rerun
        if(len(extra_field)):
            # rebuild knowledgebase
            api_pool += extra_field
            results = complete_database.query_apipool(api_pool)
            simplified_database.clear_four_tables()
            simplified_database.copy_results_to_four_tables(results)
            # rerun
            bind_log_path = execute_make_binding(file_name,lib)

    node_pred_dict,node_truth_dict = run_baseline.Extract_binding_logs(bind_log_path)

    complete_database.close()
    simplified_database.close()

    # 9. TODO save unsupported_exception error info
    if log_feed_back_flag:
        os.chdir(tmp_dir)
        exception_info_path = os.path.abspath(os.path.join(extra_info_folder,'UnsupportedOperationException_info.txt'))
        add_text_to_file(exception_info_path,f"filename:{file_name}  log_feed_back_flag:{log_feed_back_flag}  java.lang.UnsupportedOperationException:{match_str}\n")

    os.chdir(tmp_dir)

    return node_pred_dict,node_truth_dict