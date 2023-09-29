import csv
from scipy.stats import wilcoxon



def check_total_recall():
    MLM = []
    SnR = []
    ChatGPT = []
    iJTyper = [] 

    datasets = ['Short-SO','StatType-SO']
    for dataset in datasets:
        with open(f'{dataset}.csv', 'r') as f:
            reader = csv.reader(f)
            next(reader)
            for row in reader:
                MLM.append(float(row[0]))
                SnR.append(float(row[1]))
                ChatGPT.append(float(row[2])) 
                iJTyper.append(float(row[3]))

        # 执行Wilcoxon秩和检验
        methods = [MLM,SnR,ChatGPT]
        method_names = ['MLM','SnR','ChatGPT']
        for i in range(0,len(methods)):

            statistic, p_value = wilcoxon(methods[i], iJTyper)

            # print(f"i={i}, {dataset}, {method_names[i]}, iJTyper Wilcoxon Statistic:", statistic)
            print(f"i={i}, {dataset}, {method_names[i]}, iJTyper P-value:", p_value)

def check_snr_and_rule_precision():
    SnR = []
    iJTyper_constraint = []
    datasets = ['Short-SO','StatType-SO']
    for dataset in datasets:
        with open(f'{dataset}_rule_precision.csv', 'r') as f:
            reader = csv.reader(f)
            next(reader)
            for row in reader:
                SnR.append(float(row[0]))
                iJTyper_constraint.append(float(row[1]))
        # 执行Wilcoxon秩和检验
        statistic, p_value = wilcoxon(SnR, iJTyper_constraint)
        # print(f"i={i}, {dataset}, {method_names[i]}, iJTyper Wilcoxon Statistic:", statistic)
        print(f"{dataset}, SnR_precision, iJTyper_constraint_precision P-value:", p_value)
           
# check_snr_and_rule_precision()


def check_mlm_and_statistical_precision():
    MLM = []
    iJTyper_statistical = []
    datasets = ['Short-SO','StatType-SO']
    for dataset in datasets:
        with open(f'{dataset}_MLM_precision.csv', 'r') as f:
            reader = csv.reader(f)
            next(reader)
            for row in reader:
                MLM.append(float(row[0]))
                iJTyper_statistical.append(float(row[1]))
        # 执行Wilcoxon秩和检验
        statistic, p_value = wilcoxon(MLM, iJTyper_statistical)
        # print(f"i={i}, {dataset}, {method_names[i]}, iJTyper Wilcoxon Statistic:", statistic)
        print(f"{dataset}, MLM_precision, iJTyper_statistical_precision P-value:", p_value)
           
check_snr_and_rule_precision()
check_mlm_and_statistical_precision()