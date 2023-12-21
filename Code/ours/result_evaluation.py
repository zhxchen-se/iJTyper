import os
import re
import csv
import pandas as pd
current_file_path = os.path.abspath(__file__)
current_directory = os.path.dirname(current_file_path)
class Result:
    def __init__(self, dl_node_pred_dict=None, dl_node_truth_dict=None, rule_node_pred_dict=None, rule_node_truth_dict=None,snippet_file_name=None,lib=None):
        self.dl_node_pred_dict = dl_node_pred_dict.copy() if dl_node_pred_dict else {}
        self.dl_node_truth_dict = dl_node_truth_dict.copy() if dl_node_truth_dict else {} 
        self.rule_node_pred_dict = rule_node_pred_dict.copy() if rule_node_pred_dict else {}
        self.rule_node_truth_dict = rule_node_truth_dict.copy() if rule_node_truth_dict else {}

        self.dl_checked = 0
        self.dl_correct = 0
        self.rule_checked = 0
        self.rule_correct = 0

        self.total_node_pred_dict = {}
        self.total_node_truth_dict = {}

        self.total_checked = 0
        self.total_correct= 0

        self.snippet_file_name = snippet_file_name
        self.lib = lib
        self.csv_result = [(snippet_file_name,""),("Node","Statistical_pred","Statistical_truth","Statistical_correct","Constraint_pred","Constraint_truth","Constraint_correct","iJTyper_correct")]




    
    def combine_ans(self,last_result):
        '''
        both ans and truth use the last deterministic result as the total result
        returns a Result object
        '''
        #dl_truth and rule_truth may have '-'
        #if rule_pred exist, rule_truth may not exist;if rule_truth exists, rule_pred must also exist
        self.dl_checked = 0
        self.dl_correct = 0
        self.rule_checked = 0
        self.rule_correct = 0
        self.total_checked = 0
        self.total_correct= 0

        self.simplify_dl_pred_dict() 
        # print(f'debug48:dl_node_pred_dict = {self.dl_node_pred_dict}')
        for key in self.dl_node_pred_dict:
            node = key

            if (node in self.rule_node_pred_dict) or (node in last_result.rule_node_pred_dict) or (node in last_result.rule_node_truth_dict): 
                #utilize last_result
                self.derive_info_from_last(node,last_result)

                #get current results
                dl_pred = self.dl_node_pred_dict[node]
                dl_truth = "-"
                if node in self.dl_node_truth_dict:
                    dl_truth = self.dl_node_truth_dict[node]
    
                rule_pred = "-"
                rule_truth = "-"
                if node in self.rule_node_pred_dict:
                    rule_pred = self.rule_node_pred_dict[node]
                if node in self.rule_node_truth_dict:
                    rule_truth = self.rule_node_truth_dict[node]
                
                # if dl_truth == "-" and rule_truth == "-":
                #     continue

                #update checked number
                if dl_pred != "-":
                    self.dl_checked += 1
                    self.total_checked += 1
                if rule_pred != "-":
                    self.rule_checked += 1
                
                #get final answer and respective correct number
                dl_record_correct,rule_record_correct,total_record_correct,total_pred,total_truth = self.judge_correct(dl_pred,dl_truth,rule_pred,rule_truth)
                # print(f'debug81:node = {node}, total_pred = {total_pred}')
                self.rule_correct += rule_record_correct
                self.dl_correct += dl_record_correct
                self.total_correct += total_record_correct
                self.total_node_pred_dict[node] = total_pred
                self.total_node_truth_dict[node] = total_truth

                # print(f'debug88:total_node_pred_dict = {self.total_node_pred_dict}')
                #save result
                result = (node,dl_pred,dl_truth,dl_record_correct,rule_pred,rule_truth,rule_record_correct,total_record_correct) #add one column:total correct
                self.csv_result.append(result)


            else:   # split node name
                flag = False        # token is found in rule
                split_list = self.split_token(node)
                for token in split_list:
                    if (token in self.rule_node_pred_dict) or (token in last_result.rule_node_pred_dict) or (token in last_result.rule_node_truth_dict):
                        flag = True
                        #utilize last_result
                        self.derive_info_from_last(token,last_result)

                        #get current results
                        dl_pred = self.dl_node_pred_dict[node] #attention! node not token here 
                        dl_truth = "-"
                        if node in self.dl_node_truth_dict:
                            dl_truth = self.dl_node_truth_dict[node]
                        
                        rule_pred = "-"
                        rule_truth = "-"
                        if token in self.rule_node_pred_dict:
                            rule_pred = self.rule_node_pred_dict[token]
                        if token in self.rule_node_truth_dict:
                            rule_truth = self.rule_node_truth_dict[token]
                        
                        # if dl_truth == "-" and rule_truth == "-":
                        #     continue
                        
                        #update checked number
                        if dl_pred != "-":
                            self.dl_checked += 1
                            self.total_checked += 1
                        if rule_pred != "-":
                            self.rule_checked += 1
                        
                        #get final answer and respective correct number
                        dl_record_correct,rule_record_correct,total_record_correct,total_pred,total_truth = self.judge_correct(dl_pred,dl_truth,rule_pred,rule_truth)
                        # print(f'debug126:node = {node}, total_pred = {total_pred}')

                        self.rule_correct += rule_record_correct
                        self.dl_correct += dl_record_correct
                        self.total_correct += total_record_correct
                        self.total_node_pred_dict[node] = total_pred
                        self.total_node_truth_dict[node] = total_truth
                        #save result
                        result = (token,dl_pred,dl_truth,dl_record_correct,rule_pred,rule_truth,rule_record_correct,total_record_correct) #add one column:total correct
                        self.csv_result.append(result)

                if flag == False:   # token is not found in rule
                    self.dl_checked += 1
                    self.total_checked += 1

                    rule_pred = "-"
                    rule_truth = "-"
                    rule_record_correct = 0

                    dl_pred = self.dl_node_pred_dict[node]
                    dl_truth = self.dl_node_truth_dict[node]

                    dl_record_correct = 1 if dl_pred == dl_truth else 0
                    total_record_correct = dl_record_correct

                    total_pred = dl_pred
                    total_truth = dl_truth
                    self.dl_correct += dl_record_correct
                    self.total_correct += dl_record_correct
                    self.total_node_pred_dict[node] = total_pred
                    self.total_node_truth_dict[node] = total_truth
                    #save result
                    result = (node,dl_pred,dl_truth,dl_record_correct,rule_pred,rule_truth,rule_record_correct,total_record_correct) #add one column:total correct
                    self.csv_result.append(result)

        dl_precision = round(self.dl_correct/self.total_checked,4) if self.total_checked>0 else 0
        rule_recall = round(self.rule_correct/self.total_checked,4) if self.total_checked>0 else 0
        rule_precision = round(self.rule_correct/self.rule_checked,4) if self.rule_checked>0 else 0
        total_precision = round(self.total_correct/self.total_checked,4) if self.total_checked>0 else 0

        pred_line = (f"statistical_correct:{self.dl_correct}",f"statistical_accuracy:{dl_precision}","",f"constraint_correct:{self.rule_correct}",f"constraint_checked:{self.rule_checked}",f"constraint_accuracy:{rule_precision}",f"constraint_recall:{rule_recall}")
        total_line = (f"checked:{self.total_checked}",f"iJTyper correct:{self.total_correct}",f"iJTyper recall:{total_precision}")
        self.csv_result = self.csv_result +[pred_line,total_line]
        
        return self.total_node_pred_dict,self.total_node_truth_dict

    def simplify_dl_pred_dict(self): #reduce the number of candidates from 3 to 1
        #TODO should be combined with database
        for key,value in self.dl_node_pred_dict.items():
            self.dl_node_pred_dict[key] = value[0]




    def split_token(self,ori_token):
        token_list = []
        if ori_token.find("new ")!=-1:
            token_list.append(ori_token.lstrip('new ').rstrip('()'))
        if ori_token.find(".")!=-1:
            token_list = token_list+ori_token.split('.')
        # print("[info] token list:",token_list)
        return token_list

    def judge_correct(self,dl_pred,dl_truth,rule_pred,rule_truth):
        '''
        returns dl_record_correct,rule_record_correct,total_record_correct,total_pred,total_truth
        '''
        dl_record_correct = 0
        rule_record_correct = 0
        total_record_correct = 0
        total_pred = "-"
        total_truth = "-"
        if rule_truth != "-": #if rule_truth exists
            dl_record_correct = 1 if rule_truth.startswith(dl_pred) else 0 
            rule_record_correct = 1 if rule_truth == rule_pred else 0
            total_record_correct += rule_record_correct # use rule answer 
            total_pred = rule_pred
            total_truth = rule_truth
        else: #if rule_truth doesn't exist
            total_truth = dl_truth
            if rule_pred != '-': #if rule_pred exists, use rule answer
                if rule_pred.replace('$','.').startswith(dl_truth):
                    rule_record_correct = 1
                else: 
                    rule_record_correct = 0
                total_record_correct += rule_record_correct
                total_pred = rule_pred
                dl_record_correct = 1 if dl_pred == dl_truth else 0 
            else:               #if rule_pred doesn't exist, use dl answer
                rule_record_correct = 0
                dl_record_correct = 1 if dl_pred == dl_truth else 0
                total_record_correct += dl_record_correct
                total_pred = dl_pred
        
        return dl_record_correct,rule_record_correct,total_record_correct,total_pred,total_truth
        
        


    def derive_info_from_last(self,node,last_result):
        dl_pred = "-"
        dl_truth = "-"
        
        if node in self.dl_node_pred_dict:
            # print(f'debug210:node={node}')
            # print(f'debug211:self.dl_node_pred_dict = {self.dl_node_pred_dict}')
            dl_pred = self.dl_node_pred_dict[node]
        if node in self.dl_node_truth_dict:
            dl_truth = self.dl_node_truth_dict[node]
        
        rule_pred = "-"
        rule_truth = "-"
        if node in self.rule_node_pred_dict:
            rule_pred = self.rule_node_pred_dict[node]
        if node in self.rule_node_truth_dict:
            rule_truth = self.rule_node_truth_dict[node]
        

        #find deterministic result from last_result
        if dl_pred == "-":
            if node in last_result.dl_node_pred_dict:
                self.dl_node_pred_dict[node] = last_result.dl_node_pred_dict[node]

        if dl_truth == "-":
            if node in last_result.dl_node_truth_dict:
                self.dl_node_truth_dict[node] = last_result.dl_node_truth_dict[node]
        
        if rule_pred == "-":
            if node in last_result.rule_node_pred_dict:
                self.rule_node_pred_dict[node] = last_result.rule_node_pred_dict[node]
        
        if rule_truth == "-":
            if node in last_result.rule_node_truth_dict:
                # print(f"debug248: node = {node}")
                self.rule_node_truth_dict[node] = last_result.rule_node_truth_dict[node]


    def show_csv(self,iter_round=None): #use csv to print result
        folder = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","csv_file",self.lib))
        if not os.path.exists(folder):
            os.makedirs(folder)
        if iter_round:
            csv_path = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","csv_file",self.lib,f"{self.snippet_file_name}_iter{iter_round}.csv"))
        else:
            csv_path = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","csv_file",self.lib,f"{self.snippet_file_name}.csv"))
        csv_path = csv_path.replace('.java',"")
        with open(csv_path, 'w', newline='', encoding='utf-8') as csvfile:
            csvwriter = csv.writer(csvfile)
            for row in self.csv_result:
                csvwriter.writerow(row)
        print(f"csv file has been saved to {csv_path}")
        return csv_path
        

def extract_info_from_lib_csv(dataset,lib): # evaluate csv_file/{lib}/{snippet_name}.csv
    tmp_dir = os.getcwd()
    os.chdir(current_directory)

    dataset_directory = os.path.abspath(os.path.join(os.getcwd(),"..","Datasets",dataset,lib))
    file_names = os.listdir(dataset_directory) 

    lib_csv_folder_path = os.path.abspath(os.path.join(tmp_dir,'MiddleResults',"csv_file",lib))
    csv_file_names = os.listdir(lib_csv_folder_path) 
    # some files may meet with some error so that will not appear
    # print(f"debug281:file_names = {file_names}")
    # print(f"debug282:csv_file_names = {csv_file_names}")
    checked = 0
    rule_checked = 0
    dl_correct = 0
    rule_correct = 0
    total_correct = 0
    pattern_dl_correct = r"dl_correct:(\d+)"
    pattern_rule_correct = r"rule_correct:(\d+)"
    pattern_rule_checked = r"rule_checked:(\d+)"
    pattern_checked = r"^checked:(\d+)"
    pattern_total_correct = r"total correct:(\d+)"

    for file_name in file_names:
        # print(f'debug305:file_name = {file_name}')

        csv_file = file_name.replace('.java','.csv')
        if csv_file in csv_file_names: # if exists
            csv_file_path = os.path.abspath(os.path.join(tmp_dir,'MiddleResults',"csv_file",lib,csv_file))
            with open(csv_file_path, 'r', newline='', encoding='utf-8') as csvfile:
                lines = csvfile.readlines()
                for line in lines:
                    match_dl_correct = re.search(pattern_dl_correct, line)
                    match_rule_correct = re.search(pattern_rule_correct, line)
                    match_rule_checked = re.search(pattern_rule_checked, line)
                    match_checked = re.search(pattern_checked, line)
                    match_total_correct = re.search(pattern_total_correct, line)
                    if match_dl_correct:
                        dl_correct +=  int(match_dl_correct.group(1))
                    if match_rule_correct:
                        rule_correct += int(match_rule_correct.group(1))
                    if match_rule_checked:
                        rule_checked += int(match_rule_checked.group(1))
                    if match_checked:
                        checked += int(match_checked.group(1))
                    if match_total_correct:
                        total_correct += int(match_total_correct.group(1))
    
    dl_recall = round(dl_correct/checked,4)
    rule_precision = round(rule_correct/rule_checked,4)
    rule_recall = round(rule_correct/checked,4)
    total_recall = round(total_correct/checked,4)

    save_lib_csv_folder = os.path.abspath(os.path.join(tmp_dir,'MiddleResults',"lib_csv_summary")) 
    if not os.path.exists(save_lib_csv_folder):
        os.makedirs(save_lib_csv_folder)

    save_lib_csv_path = os.path.abspath(os.path.join(save_lib_csv_folder,f'{lib}_summary.csv'))


    with open(save_lib_csv_path, 'w', newline='', encoding='utf-8') as summary_csv:
        csv_writer = csv.writer(summary_csv)
        csv_writer.writerow(['checked','dl_correct','rule_checked','rule_correct',  'total_correct','dl_recall','rule_accuracy','rule_recall','total_recall'])
        csv_writer.writerow([checked, dl_correct,rule_checked,rule_correct, total_correct,dl_recall,rule_precision,rule_recall,total_recall])

    print(f"lib summarize csv has been saved to {save_lib_csv_path}")

    os.chdir(tmp_dir)


def create_table():
    all_lib_number = [0,0,0,0,0]
    table = [["Lib", "DL Recall(Accuracy)", "Rule Accuracy", "Rule Recall", "Total Recall"]]
    csv_directory = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","lib_csv_summary"))
    file_names = sorted(os.listdir(csv_directory))
    for file_name in file_names:
        csv_file_path = os.path.abspath(os.path.join(csv_directory,file_name))
        with open(csv_file_path, "r") as file:
            csv_reader = csv.reader(file)
            next(csv_reader)
            second_row = next(csv_reader)
            row = [file_name.replace('_summary.csv','')]
            for i in range(0,5):
                all_lib_number[i] += int(second_row[i])
            for i in range(5,9):
                row.append(second_row[i])
            table.append(row)

    return table,all_lib_number
  

def get_total_summary():
    tmp_dir = os.getcwd()
    os.chdir(current_directory)
    
    table,all_lib_number = create_table()

    sava_csv_path = os.path.abspath(os.path.join(tmp_dir,"MiddleResults","summary.csv"))
    with open(sava_csv_path, 'w', newline='') as csv_file:
        writer = csv.writer(csv_file)
        writer.writerows(table)

    # calculate average
    df = pd.read_csv(sava_csv_path)
    # print(f"debug379:df['DL Recall(precision)']={df['DL Recall(precision)']}")
    ase_mean = df['DL Recall(Accuracy)'].mean()
    precision_snr_mean = df['Rule Accuracy'].mean()  
    recall_snr_mean = df['Rule Recall'].mean()
    total_recall_mean = df['Total Recall'].mean()
    means_df = pd.DataFrame({'Lib':['Average'],
                            'DL Recall(Accuracy)': [ase_mean],
                            'Rule Accuracy': [precision_snr_mean],
                            'Rule Recall': [recall_snr_mean],
                            'Total Recall': [total_recall_mean]})
    combined_df = pd.concat([df, means_df]) 

    # calculate total
    total_dl_recall = round(all_lib_number[1]/all_lib_number[0],4)
    total_rule_precision = round(all_lib_number[3]/all_lib_number[2],4)
    total_rule_recall = round(all_lib_number[3]/all_lib_number[0],4)
    total_recall = round(all_lib_number[4]/all_lib_number[0],4)
    total_df = pd.DataFrame({'Lib':['Total'],
                            'DL Recall(Accuracy)': [total_dl_recall],
                            'Rule Accuracy': [total_rule_precision],
                            'Rule Recall': [total_rule_recall],
                            'Total Recall': [total_recall]})
    combined_df = pd.concat([combined_df, total_df]) 
    combined_df.to_csv(sava_csv_path, index=False)
    print(f"Final summary has been saved to {sava_csv_path}")    

    os.chdir(tmp_dir)

def get_lib_iter_rounds(lib):
    tmp_dir = os.getcwd()
    os.chdir(current_directory)
    lib_csv_folder_path = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","csv_file",lib))
    file_names = os.listdir(lib_csv_folder_path)

    file_max_iters = {}

    
    for filename in sorted(file_names):
        if filename.endswith(".csv"):
            parts = filename.split("_iter")
            if len(parts) == 2:
                file_name = parts[0]
                iter_num = int(parts[1].split(".")[0])
                if file_name in file_max_iters:
                    file_max_iters[file_name] = max(file_max_iters[file_name], iter_num)
                else:
                    file_max_iters[file_name] = iter_num


    output_path = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults","iter_round_count",f"{lib}_IterCount.csv"))
    with open(output_path, mode="w", newline="") as csvfile:
        csv_writer = csv.writer(csvfile)
        csv_writer.writerow(["File", "Iter_Round"])
        for file_name, max_iter in file_max_iters.items():
            csv_writer.writerow([file_name, max_iter])

    print(f"Iter_round count file has been saved to {output_path}")

    os.chdir(tmp_dir)



def extract_info_from_lib_csv_specify_iteration_round(dataset,lib,iter_round): # evaluate csv_file/{lib}/{snippet_name}_iter{i}.csv
    tmp_dir = os.getcwd()
    os.chdir(current_directory)

    dataset_directory = os.path.abspath(os.path.join(os.getcwd(),"..","Datasets",dataset,lib))
    file_names = os.listdir(dataset_directory) 

    lib_csv_folder_path = os.path.abspath(os.path.join(tmp_dir,'MiddleResults',"csv_file",lib))
    csv_file_names = os.listdir(lib_csv_folder_path) 
    # some files may meet with some error so that will not appear
    checked = 0
    rule_checked = 0
    dl_correct = 0
    rule_correct = 0
    total_correct = 0
    pattern_dl_correct = r"dl_correct:(\d+)"
    pattern_rule_correct = r"rule_correct:(\d+)"
    pattern_rule_checked = r"rule_checked:(\d+)"
    pattern_checked = r"^checked:(\d+)"
    pattern_total_correct = r"total correct:(\d+)"

    for file_name in file_names:
        csv_file = file_name.replace('.java',f'_iter{iter_round}.csv')
        csv_file_path = None
        if csv_file in csv_file_names: # if exists
            csv_file_path = os.path.abspath(os.path.join(tmp_dir,'MiddleResults',"csv_file",lib,csv_file))
        else: # if not exists: error or lower iteration round exists
            tmp = iter_round - 1
            while tmp:
                csv_file = file_name.replace('.java',f'_iter{tmp}.csv')
                if csv_file in csv_file_names: # if exists
                    csv_file_path = os.path.abspath(os.path.join(tmp_dir,'MiddleResults',"csv_file",lib,csv_file))
                    break
                tmp -= 1

        if csv_file_path:
            # print(f'debug481:csv_file_path = {csv_file_path}')
            with open(csv_file_path, 'r', newline='', encoding='utf-8') as csvfile:
                    lines = csvfile.readlines()
                    for line in lines:
                        match_dl_correct = re.search(pattern_dl_correct, line)
                        match_rule_correct = re.search(pattern_rule_correct, line)
                        match_rule_checked = re.search(pattern_rule_checked, line)
                        match_checked = re.search(pattern_checked, line)
                        match_total_correct = re.search(pattern_total_correct, line)
                        if match_dl_correct:
                            dl_correct +=  int(match_dl_correct.group(1))
                        if match_rule_correct:
                            rule_correct += int(match_rule_correct.group(1))
                        if match_rule_checked:
                            rule_checked += int(match_rule_checked.group(1))
                        if match_checked:
                            checked += int(match_checked.group(1))
                        if match_total_correct:
                            total_correct += int(match_total_correct.group(1))

    dl_recall = round(dl_correct/checked,4)
    rule_precision = round(rule_correct/rule_checked,4)
    rule_recall = round(rule_correct/checked,4)
    total_recall = round(total_correct/checked,4)

    save_lib_csv_folder = os.path.abspath(os.path.join(tmp_dir,'MiddleResults',f"lib_csv_summary_iter{iter_round}")) 
    if not os.path.exists(save_lib_csv_folder):
        os.makedirs(save_lib_csv_folder)

    save_lib_csv_path = os.path.abspath(os.path.join(save_lib_csv_folder,f'{lib}_summary_iter{iter_round}.csv'))


    with open(save_lib_csv_path, 'w', newline='', encoding='utf-8') as summary_csv:
        csv_writer = csv.writer(summary_csv)
        csv_writer.writerow(['checked','dl_correct','rule_checked','rule_correct',  'total_correct','dl_recall','rule_accuracy','rule_recall','total_recall'])
        csv_writer.writerow([checked, dl_correct,rule_checked,rule_correct, total_correct,dl_recall,rule_precision,rule_recall,total_recall])

    print(f"lib summarize csv of iteration {iter_round} has been saved to {save_lib_csv_path}")

    os.chdir(tmp_dir)


def create_table_specify_iteration_round(iter_round):
    all_lib_number = [0,0,0,0,0]
    table = [["Lib", "DL Recall(Accuracy)", "Rule Accuracy", "Rule Recall", "Total Recall"]]
    csv_directory = os.path.abspath(os.path.join(os.getcwd(),"MiddleResults",f"lib_csv_summary_iter{iter_round}"))
    file_names = sorted(os.listdir(csv_directory))
    for file_name in file_names:
        csv_file_path = os.path.abspath(os.path.join(csv_directory,file_name))
        with open(csv_file_path, "r") as file:
            csv_reader = csv.reader(file)
            next(csv_reader)
            second_row = next(csv_reader)
            row = [file_name.replace('_summary.csv','')]
            for i in range(0,5):
                all_lib_number[i] += int(second_row[i])
            for i in range(5,9):
                row.append(second_row[i])
            table.append(row)

    return table,all_lib_number

def get_summary_specify_iteration_round(iter_round):
    tmp_dir = os.getcwd()
    os.chdir(current_directory)

    table,all_lib_number = create_table_specify_iteration_round(iter_round)
    sava_csv_path = os.path.abspath(os.path.join(tmp_dir,"MiddleResults",f"summary_iter{iter_round}.csv"))
    with open(sava_csv_path, 'w', newline='') as csv_file:
        writer = csv.writer(csv_file)
        writer.writerows(table)

    # calculate average
    df = pd.read_csv(sava_csv_path)
    # print(f"debug379:df['DL Recall(precision)']={df['DL Recall(precision)']}")
    ase_mean = df['DL Recall(Accuracy)'].mean()
    precision_snr_mean = df['Rule Accuracy'].mean()  
    recall_snr_mean = df['Rule Recall'].mean()
    total_recall_mean = df['Total Recall'].mean()
    means_df = pd.DataFrame({'Lib':['Average'],
                            'DL Recall(Accuracy)': [ase_mean],
                            'Rule Accuracy': [precision_snr_mean],
                            'Rule Recall': [recall_snr_mean],
                            'Total Recall': [total_recall_mean]})
    combined_df = pd.concat([df, means_df]) 

    # calculate total
    total_dl_recall = round(all_lib_number[1]/all_lib_number[0],4)
    total_rule_precision = round(all_lib_number[3]/all_lib_number[2],4)
    total_rule_recall = round(all_lib_number[3]/all_lib_number[0],4)
    total_recall = round(all_lib_number[4]/all_lib_number[0],4)
    total_df = pd.DataFrame({'Lib':['Total'],
                            'DL Recall(Accuracy)': [total_dl_recall],
                            'Rule Accuracy': [total_rule_precision],
                            'Rule Recall': [total_rule_recall],
                            'Total Recall': [total_recall]})
    combined_df = pd.concat([combined_df, total_df]) 
    combined_df.to_csv(sava_csv_path, index=False)
    print(f"Final summary of iteration {iter_round} has been saved to {sava_csv_path}")    

    os.chdir(tmp_dir)


if __name__ == '__main__':
    # libs = ["android","gwt","hibernate","joda_time","jdk","xstream"]
    libs = ["gwt"]
    # dataset = "Short-SO"
    dataset = "StatType-SO"
    for iter_round in range(1,7):
        # print(f'debug591:{iter_round}')
        for lib in libs:
            extract_info_from_lib_csv(dataset,lib)
            get_lib_iter_rounds(lib)
            # specify iteration round
            # extract_info_from_lib_csv_specify_iteration_round(dataset,lib,iter_round)
        
        get_total_summary()
        # get_summary_specify_iteration_round(iter_round)

    