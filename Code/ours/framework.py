import os
import re
import sys
import csv
import time
import shutil
import torch 
import signal
import argparse
import traceback
from contextlib import contextmanager
import subprocess
from tqdm import tqdm
from knowledge_base import DB,reset_database
from result_evaluation import Result
from constraint_based import *
from statistically_based import *
sys.path.append(os.path.abspath(os.path.join(os.getcwd(), "..")))
sys.path.append(os.path.abspath(os.path.join(os.getcwd(), "../Baseline")))
from Baseline import run_baseline

def Set_GPU(gpu_index):
    if torch.cuda.is_available():
        print("CUDA is available!")
        torch.cuda.set_device(gpu_index)
        device = torch.cuda.current_device()
        print("using gpu:", device)
    else:
        print("CUDA is not available.")


def write_time_info(snippet_file_name,lib,all_queryapipool_time,all_insert_results_time,all_benchmark_time,all_binding_time,rule_time,dl_time,snippet_time,all_combine_time,kb_reduction_time):
    time_folder = os.path.abspath(os.path.join(os.getcwd(),'MiddleResults','time_info',lib))
    if not os.path.exists(time_folder):
        os.makedirs(time_folder)
    csv_time_path = os.path.abspath(os.path.join(time_folder,f"{lib}_time_info.csv"))
    # print(f'debug35:csv_time_path = {csv_time_path}')

    time_info = [snippet_file_name, all_queryapipool_time, all_insert_results_time, kb_reduction_time,all_benchmark_time, all_binding_time,rule_time,dl_time, all_combine_time,snippet_time]
    if not os.path.exists(csv_time_path):
        with open(csv_time_path, 'w', newline='') as csvfile:
            csv_writer = csv.writer(csvfile)
            csv_writer.writerow(['Snippet File', 'Query API Pool Time', 'Insert Results Time', 'kb_reduction_time','Benchmark Time', 'Binding Time', 'Rule_time','DL_time','ans_combine_time','Snippet Time'])

    with open(csv_time_path, 'a', newline='') as csvfile:
        csv_writer = csv.writer(csvfile)
        csv_writer.writerow(time_info)

    


def iterative_execute_one_snippet(snippet_file_name,dataset,lib,topK,build_kb_with_extension=True,StartFromRule=True,log_feed_back_flag=True,Maximum_iter_round=15):
    '''
    returns a Result object and iter_round
    '''
    tmp_dir = os.getcwd()
    last_result = None
    iter_round = 1

    original_snr_node_pred_dict = {}

    snippet_start_time = time.time()
    rule_time = 0
    dl_time = 0
    all_benchmark_time = 0
    all_binding_time = 0
    all_queryapipool_time = 0
    all_insert_results_time = 0
    all_combine_time = 0
    if StartFromRule: # Rule -> DL -> Rule -> DL...
        print("Iterative mode:Rule -> DL -> Rule -> DL...")
        while True:     #repeat until total_dict remain unchanged
            print(f"iter_round = {iter_round}")
            if last_result == None:
                db = DB(isComplete=False)
                db.kill_binding_query_thread()
                db.close()
                reset_database() 
                rule_start_time = time.time()
                rule_node_pred_dict,rule_node_truth_dict,benchmark_time,binding_time = run_baseline.Rule_predict_one_snippet(snippet_file_name,dataset,lib)
                original_snr_node_pred_dict = rule_node_pred_dict.copy()
                rule_time += time.time() - rule_start_time
                all_benchmark_time += benchmark_time
                all_binding_time += binding_time
            else:
                rule_start_time = time.time()
                rule_node_pred_dict,rule_node_truth_dict,queryapipool_time,insert_results_time,benchmark_time,binding_time,kb_reduction_time = Rule_predict_with_DL_info(snippet_file_name,dataset,lib,dl_node_pred_dict,build_kb_with_extension,log_feed_back_flag,original_snr_node_pred_dict)
                rule_time += time.time() - rule_start_time
                all_queryapipool_time += queryapipool_time
                all_insert_results_time += insert_results_time
                all_benchmark_time += benchmark_time
                all_binding_time += binding_time

            dl_start_time = time.time()
            # print(f'debug90:rule_node_pred_dict = {rule_node_pred_dict}')
            dl_node_pred_dict,dl_node_truth_dict = DL_predict_with_Rule_info(snippet_file_name,dataset,lib,topK,rule_node_pred_dict)
            dl_time += time.time()-dl_start_time

            # print(f'debug93:iter{iter_round},dl_node_pred:{dl_node_pred_dict}')
            # print(f'debug94:iter{iter_round},rule_node_pred:{rule_node_pred_dict}')
            result = Result(dl_node_pred_dict,dl_node_truth_dict,rule_node_pred_dict,rule_node_truth_dict,snippet_file_name,lib)
            
            combine_start_time = time.time()
            if last_result:
                result.combine_ans(last_result) 
            else:
                result.combine_ans(Result())
            all_combine_time += time.time()-combine_start_time

            result.show_csv(iter_round)
            
            if last_result: # compare with last result
                last_pred = last_result.total_node_pred_dict
                this_pred = result.total_node_pred_dict
                # print(f'last_pred = {last_pred}')
                # print(f'this_pred = {this_pred}')
                if last_pred == this_pred or iter_round == Maximum_iter_round:
                    last_result = result
                    break

            last_result = result
            iter_round += 1

    else:   # DL -> Rule -> DL -> Rule...
        print("Iterative mode:DL -> Rule -> DL -> Rule...")
        while True:
            print(f"iter_round = {iter_round}")
            if last_result == None:
                dl_start_time = time.time()
                dl_node_pred_dict,dl_node_truth_dict = run_baseline.DL_predict_one_snippet(snippet_file_name,dataset,lib,topK)
                dl_time += time.time()-dl_start_time
            else:
                dl_start_time = time.time()
                dl_node_pred_dict,dl_node_truth_dict = DL_predict_with_Rule_info(snippet_file_name,dataset,lib,topK,rule_node_pred_dict)
                dl_time += time.time()-dl_start_time

            rule_start_time = time.time()
            rule_node_pred_dict,rule_node_truth_dict,queryapipool_time,insert_results_time,benchmark_time,binding_time = Rule_predict_with_DL_info(snippet_file_name,dataset,lib,dl_node_pred_dict,build_kb_with_extension,log_feed_back_flag)
            rule_time += time.time()-rule_start_time
            all_queryapipool_time += queryapipool_time
            all_insert_results_time += insert_results_time
            all_benchmark_time += benchmark_time
            all_binding_time += binding_time

            result = Result(dl_node_pred_dict,dl_node_truth_dict,rule_node_pred_dict,rule_node_truth_dict,snippet_file_name,lib)
            if last_result:
                result.combine_ans(last_result)
            else:
                result.combine_ans(Result())

            result.show_csv(iter_round)

            if last_result: # compare with last result
                last_pred = last_result.total_node_pred_dict
                this_pred = result.total_node_pred_dict
                if last_pred == this_pred or iter_round == Maximum_iter_round:
                    last_result = result
                    break

            last_result = result
            iter_round += 1

    snippet_time = time.time() - snippet_start_time
    os.chdir(tmp_dir)

    write_time_info(snippet_file_name,lib,all_queryapipool_time,all_insert_results_time,all_benchmark_time,all_binding_time,rule_time,dl_time,snippet_time,all_combine_time,kb_reduction_time)

    print(f"{snippet_file_name} has been successfully processed after {iter_round} rounds.")
    return last_result,iter_round

def execute_baseline_only_combine_ans(snippet_file_name,dataset,lib,topK):
    '''
    returns a Result object
    '''
    tmp_dir = os.getcwd()
    rule_node_pred_dict,rule_node_truth_dict,_,_ = run_baseline.Rule_predict_one_snippet(snippet_file_name,dataset,lib)
    dl_node_pred_dict,dl_node_truth_dict = run_baseline.DL_predict_one_snippet(snippet_file_name,dataset,lib,topK,check_knowledge_base=False)

    result = Result(dl_node_pred_dict,dl_node_truth_dict,rule_node_pred_dict,rule_node_truth_dict,snippet_file_name,lib)
    result.combine_ans(Result())
    result.show_csv()

    os.chdir(tmp_dir)
    print(f"{snippet_file_name} has been successfully processed.")
    return result,1

@contextmanager
def time_limit(seconds):
    def signal_handler(signum, frame):
        raise TimeoutError("Timed out!")
    signal.signal(signal.SIGALRM, signal_handler)
    signal.alarm(seconds)
    try:
        yield
    finally:
        signal.alarm(0)

def clear_lib_folders(lib):
    '''
    work_dir: ~/ours
    '''
    lib_folder_path = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","csv_file",lib))
    run_baseline.clear_folder(lib_folder_path)

    error_log_folder = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","error_log",lib))
    run_baseline.clear_folder(error_log_folder)

    benchmark_log_output_folder = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","benchmark_log",lib))
    run_baseline.clear_folder(benchmark_log_output_folder)

    bind_log_output_folder = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","bind_log",lib))
    run_baseline.clear_folder(bind_log_output_folder)

    extra_info_folder = os.path.abspath(os.path.join(os.getcwd(),'MiddleResults','extra_info',lib))
    run_baseline.clear_folder(extra_info_folder)

    pure_extra_info_folder = os.path.abspath(os.path.join(os.getcwd(),'MiddleResults','pure_rule_extra_info',lib))
    run_baseline.clear_folder(pure_extra_info_folder)

    time_info_folder = os.path.abspath(os.path.join(os.getcwd(),'MiddleResults','time_info',lib))
    run_baseline.clear_folder(time_info_folder)

def run_lib(dataset,lib,topK,build_kb_with_extension=True,StartFromRule=True,log_feed_back_flag=True,Maximum_iter_round=15):
    '''
    work_dir: ~/ours
    '''
    tmp_dir = os.getcwd()
    directory = os.path.abspath(os.path.join(os.getcwd(),"..","Datasets",dataset,lib))
    file_names = os.listdir(directory) 
    all_results = []
    dl_correct = 0
    rule_correct = 0
    rule_checked = 0
    total_checked = 0
    total_correct = 0

    clear_lib_folders(lib)

    # file_names = file_names[:2]
    file_names = sorted(file_names)
    print(f'file_names = {file_names}')

    iter_round_dict = {} # count file_name--iter_round
    for file_name in tqdm(file_names, desc="Processing",leave=True, dynamic_ncols=True):
        try:
            with time_limit(360): # if subprocess timeout, unable to track
                result,iter_round = iterative_execute_one_snippet(file_name,dataset,lib,topK,build_kb_with_extension,StartFromRule,log_feed_back_flag,Maximum_iter_round)
                # result,iter_round= execute_baseline_only_combine_ans(file_name,dataset,lib,topK) 
            result.show_csv() # save file_name.csv
            iter_round_dict[file_name] = iter_round # count iter_round
            all_results.extend(result.csv_result)
            all_results.append((""))
            dl_correct += result.dl_correct
            rule_correct += result.rule_correct
            rule_checked += result.rule_checked
            total_checked += result.total_checked
            total_correct += result.total_correct
        except Exception as e:
            os.chdir(tmp_dir) 
            error_message = f"Error processing file {file_name}: {str(e)}"
            error_log_folder = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","error_log",lib))
            error_log_path = os.path.abspath(os.path.join(error_log_folder,f"{file_name}_err.txt"))
            with open(error_log_path, 'w') as error_log:
                error_log.write(error_message + '\n')
                error_log.write(traceback.format_exc())  # stack info
                error_log.write("\n")
            continue
    
    #add total line
    dl_precision = round(dl_correct/total_checked,4) if total_checked else 0
    rule_precision = round(rule_correct/rule_checked,4) if rule_checked else 0
    rule_recall = round(rule_correct/total_checked,4) if total_checked else 0
    total_precision = round(total_correct/total_checked,4) if total_checked else 0 
    total_row = (f"total checked:{total_checked}",f"rule correct:{rule_correct}",f"rule checked:{rule_checked}",f"dl correct:{dl_correct}",f"total correct:{total_correct}")
    total_metric = (f"dl precision:{dl_precision}",f"rule precision:{rule_precision}",f"rule recall:{rule_recall}",f"total_precision:{total_precision}")
    all_results.append(("total status",""))
    all_results.append(total_row)
    all_results.append(total_metric)
    print(all_results)
    
    # save lib results to csv
    lib_csv_path = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","csv_file",lib,f"{lib}.csv"))
    with open(lib_csv_path, 'w', newline='', encoding='utf-8') as csvfile:
        csvwriter = csv.writer(csvfile)
        for row in all_results:
            csvwriter.writerow(row)
    print(f"lib csv file has been saved to {lib_csv_path}")

    # save iter_round info
    iter_round_gt10 = [key for key, value in iter_round_dict.items() if value >= 10] # separate iter_round > 10
    count_csv_path = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","iter_round_count",f"{lib}_IterCount.csv"))
    with open(count_csv_path, 'w', newline='', encoding='utf-8') as csvfile:
        csvwriter = csv.writer(csvfile)
        csvwriter.writerow(['File', 'Iter_Round'])
        for key, value in iter_round_dict.items():
            csvwriter.writerow([key, value])

        csvwriter.writerow([])  # empty line
        csvwriter.writerow(['iter_round_gt10:'] + iter_round_gt10)
    print(f"lib iter count file has been saved to {count_csv_path}")

    os.chdir(tmp_dir)


def add_comment_to_code(java_file_name,total_node_pred_dict):
    java_file_path = os.path.abspath(os.path.join(os.getcwd(),'code_snippet',java_file_name))
    with open(java_file_path, 'r') as java_file:
        java_code = java_file.read()

    comment_lines = []
    for java_class, fqn in total_node_pred_dict.items():
        comment_lines.append(f'\t{java_class}: {fqn}')
    
    comment_block = '\n'.join(comment_lines)
    java_code_with_comments = f'/*\n{comment_block}\n*/\n{java_code}'

    output_path = os.path.abspath(os.path.join(os.getcwd(),'output',java_file_name))

    with open(output_path, 'w') as java_file:
        java_file.write(java_code_with_comments)
    
    print(f'Output code snippet has been saved to {output_path}')


def redirect_stdout_to_log():
    log_path = os.path.abspath(os.path.join(os.getcwd(),'log','output.log'))
    log_stream = open(log_path, "w")
    sys.stdout = log_stream

def redirect_stdout_to_console():
    sys.stdout = sys.__stdout__


def main():
    tmp_dir = os.getcwd()
    parser = argparse.ArgumentParser(description='iJTyper')
    parser.add_argument('--topk', type=int, default=3, help='Top-K value (default: 3)')
    parser.add_argument('--iter', type=int, default=10, help='Maximum iteration rounds for one snippet (default: 10)')
    parser.add_argument('--gpu', type=int, default=0, help='GPU index (default: 0)')
    args = parser.parse_args()

    Set_GPU(args.gpu)
    # # snippet_file_name = 'Class_2.java'  
    # # lib = 'jdk'    
    # # dataset = 'StatType-SO'
    dataset = 'mydataset'
    file_list = os.listdir('./code_snippet/')
    lib = 'mylib'
    
    redirect_stdout_to_log()
    csv_paths = []
    for snippet_file_name in tqdm(file_list, desc="Processing",leave=True, dynamic_ncols=True):
        result,_ = iterative_execute_one_snippet(snippet_file_name,dataset,lib,topK=args.topk,build_kb_with_extension=True,StartFromRule=True,log_feed_back_flag=True,Maximum_iter_round = args.iter)
        csv_paths.append(result.show_csv())
        add_comment_to_code(snippet_file_name,result.total_node_pred_dict)


    redirect_stdout_to_console()
    print(f"Output code snippets have been saved to {os.path.abspath(os.path.join(os.getcwd(),'output'))}")
    # print(result.total_node_pred_dict)
    # print(result.total_node_truth_dict)
    # libs = ["android","gwt","hibernate","joda_time","jdk","xstream"]
    os.chdir(tmp_dir)


    
if __name__ == '__main__':
    main()