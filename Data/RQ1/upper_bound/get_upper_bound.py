import os
import csv
from collections import defaultdict
if __name__ == '__main__':
    datasets = ['StatType-SO','Short-SO']
    for dataset in datasets:
        folder_path = os.path.abspath(os.path.join(os.getcwd(),f'topk=3+{dataset}','MiddleResults','csv_file'))
        libs = ["android","gwt","hibernate","joda_time","jdk","xstream"]
        
        dataset_checked = 0
        dataset_correct = 0
        for lib in libs:
            lib_checked = 0
            lib_correct = 0
            csv_path = os.path.abspath(os.path.join(folder_path,lib))
            file_names = os.listdir(csv_path)
            filtered_files = [filename for filename in file_names if ('iter' not in filename) and (filename != f'{lib}.csv')]
            # print(filtered_files)

            for file_name in filtered_files:
                node_truth_dict = {}
                file_path = os.path.abspath(os.path.join(csv_path,file_name))
                # print(file_path)
                with open(file_path, 'r') as f:
                    reader = csv.reader(f)
                    next(reader) 
                    reader = csv.DictReader(f) 
                    for row in reader:
                        # print(f'row={row}')
                        if row['Node'].startswith("dl_correct"):
                            break
                        if row['Rule_truth'] != '-':
                            node_truth_dict[row['Node']] = row['Rule_truth'] 
                        else:
                            node_truth_dict[row['Node']] = row['DL_truth']
                # print(f'node_truth_dict={node_truth_dict}')
                iter_files = [filename for filename in file_names if filename.startswith(f"{os.path.basename(file_path).split('.')[0]}_iter")]
                iter_files.append(os.path.basename(file_path))
                # print(f'iter_files = {iter_files}')

                # collect answers
                result = defaultdict(set) # results from all the iteration rounds, both two types of methods
                for iter_file in iter_files:
                    iter_file_path = os.path.abspath(os.path.join(csv_path,iter_file))
                    with open(iter_file_path) as csvfile:
                        reader = csv.reader(csvfile)
                        next(reader) 
                        reader = csv.DictReader(csvfile) 
                        for row in reader:
                            if row['Node'].startswith("dl_correct"):
                                break
                            node = row['Node']
                            result[node].add(row['DL_pred'])
                            if row['Rule_pred'] != '-':
                                result[node].add(row['Rule_pred'])
                # print(f'result={result}')
                # calculate correct API numbers
                with open(file_path, 'r') as f:
                    reader = csv.reader(f)
                    next(reader) 
                    reader = csv.DictReader(f) 
                    for row in reader:
                        if row['Node'].startswith("dl_correct"):
                            break
                        lib_checked += 1
                        node = row['Node']
                        if node_truth_dict[node] in result[node]:
                            lib_correct += 1
                # lib_checked += len(node_truth_dict)
                # for node in node_truth_dict.keys():
                #     if node_truth_dict[node] in result[node]:
                #         lib_correct += 1

            print(f'{dataset},{lib},{lib_correct/lib_checked}')
            dataset_checked += lib_checked
            dataset_correct += lib_correct
        print(f'{dataset},{dataset_correct/dataset_checked}')
