#!/usr/bin/env python3

import argparse
import csv
import json
import math
import os
import re
import shutil
from typing import Dict, List, Any

from helpers.java_import_util import filter_ignored_imports

__location__ = os.path.realpath(
    os.path.join(os.getcwd(), os.path.dirname(__file__)))

IGNORED_PROBLEM: List[Dict[str, str]] = [
    {
        'problemSeverity': 'ERROR',
        'message': 'R cannot be resolved to a variable'
    },
    {
        'problemSeverity': 'ERROR',
        'message': re.compile('SANITY CHECK: Invalid opcode -88 at pc [0-9]+ for stackmap table attribute for method [\w()]+')
    },
]

ERR_ID_TO_PROBLEM = {}

for key, val in json.load(open(os.path.join(__location__, 'iproblems_ids.json'))).items():
    ERR_ID_TO_PROBLEM[val] = key


def ignored_problem(problem) -> bool:
    for ignore in IGNORED_PROBLEM:
        match: bool = True
        for key, val in ignore.items():
            if key not in problem:
                match = False
                break
            if isinstance(val, re.Pattern):
                if val.fullmatch(str(problem[key]).strip()) is None:
                    match = False
                    break
            else:
                if str(problem[key]).strip() != str(val).strip():
                    match = False
                    break
        if match:
            return True
    return False


def ns_to_str(ns: int) -> str:
    minuets = math.floor(ns / 6e10)
    ns = ns - minuets * 6e10
    seconds = math.floor(ns / 1e9)
    ns = ns - seconds * 1e9
    return f"{minuets}m {seconds}s"


import_groups = ['android.', 'java.', 'org.joda.time.', '.gwt.', 'org.hibernate.', 'com.thoughtworks.xstream.']


def group_imports_by_lib(imports: List[str]) -> Dict[str, List[str]]:
    grouped_imports = dict()
    for group in import_groups:
        grouped_imports[group] = []
    for imp in imports:
        for group in import_groups:
            if group in imp:
                grouped_imports[group].append(imp)
                break
    return grouped_imports


def map_len(dict_list: Dict[str, List[Any]]) -> Dict[str, int]:
    mapped_dict = dict()
    for name, item in dict_list.items():
        mapped_dict[name] = len(item)
    return mapped_dict


def group_to_list(group_dict: Dict[str, Any]) -> List[Any]:
    ret = list()
    for group in import_groups:
        ret.append(group_dict[group])
    return ret




def collect_stats_for_file(file: str, bench_name: str, stats) -> Dict[str, int]:
    with open(file) as json_file:
        log_benchmark = os.path.join(file + ".benchmark_log.json")
        if not os.path.exists(log_benchmark):
            raise Exception("Expected companion benchmark log " + log_benchmark)
        benchmark_file = open(log_benchmark)
        benchmark = json.load(benchmark_file)
        total_imports = group_imports_by_lib(filter_ignored_imports(benchmark['total_imports']))
        correct_imports = group_imports_by_lib(filter_ignored_imports(benchmark['correct_imports']))
        stats['total_imports'] += sum(group_to_list(map_len(total_imports)))
        stats['correct_imports'] += sum(group_to_list(map_len(correct_imports)))
        data = json.load(json_file)
        stats['total_benchmarks'] = stats['total_benchmarks'] + 1
        stats["individual_stat"][bench_name] = [ns_to_str(benchmark['run_time']), *group_to_list(map_len(correct_imports)), *group_to_list(map_len(total_imports))]
        stats['individual_lib_stat'][bench_name] = data['usedLibraries']
        failed = False
        serv_N = 0
        serv_E = 0
        serv_W = 0
        serv_I = 0
        serv_O = 0
        serv_IGN = 0
        for problem in data['problems']:
            severity = problem['problemSeverity']
            if ignored_problem(problem):
                severity = "IGNORED"
            if severity is None or severity == "ERROR":
                failed = True
            if problem['problemId'] not in stats['problem_distribution']:
                stats['problem_distribution'][problem['problemId']] = 0
            stats['problem_distribution'][problem['problemId']] = stats['problem_distribution'][problem['problemId']] + 1
            if severity is None:
                serv_N = serv_N + 1
                if problem['problemId'] not in stats['error_distribution']:
                    stats['error_distribution'][problem['problemId']] = 0
                stats['error_distribution'][problem['problemId']] = stats['error_distribution'][problem['problemId']] + 1
            elif severity == "ERROR":
                serv_E = serv_E + 1
                if problem['problemId'] not in stats['error_distribution']:
                    stats['error_distribution'][problem['problemId']] = 0
                stats['error_distribution'][problem['problemId']] = stats['error_distribution'][problem['problemId']] + 1
            elif severity == "WARNING":
                serv_W = serv_W + 1
            elif severity == "INFO":
                serv_I = serv_I + 1
            elif severity == "OTHER":
                serv_O = serv_O + 1
            elif severity == "IGNORED":
                serv_IGN = serv_IGN + 1
            if severity is None or severity == "ERROR":
                stats["individual_stat"][bench_name].append(ERR_ID_TO_PROBLEM[problem['problemId']])
        if failed:
            stats["failed_benchmarks"].append(bench_name)
        # TODO analyze imports and match
        stats["bench_stat"][bench_name] = [serv_N, serv_E, serv_W, serv_I, serv_O, serv_IGN, not failed]


def output_fixed_file(file, output_dir):
    with open(file) as json_file:
        data = json.load(json_file)
        with open(os.path.join(output_dir, os.path.basename(file)).replace('.json', ''), 'w') as output_file:
            output_file.write(data['updatedContent'])


def get_stats(dir: str) -> None:
    assert os.path.isdir(dir)
    output_dir = os.path.join(__location__, 'fixed')
    shutil.rmtree(output_dir, ignore_errors=True)
    os.mkdir(output_dir)
    
    stats = dict()
    stats['total_benchmarks']: int = 0
    stats['failed_benchmarks']: List[str] = []
    stats['error_distribution']: Dict[int, int] = dict()
    stats['problem_distribution']: Dict[int, int] = dict()
    stats['bench_stat']: Dict[str, List[int]] = dict()
    stats['individual_stat']: Dict[str, List[str]] = dict()
    stats['total_imports']: int = 0
    stats['correct_imports']: int = 0
    stats['individual_lib_stat']: Dict[str, List[str]] = dict()

    for file_name in os.listdir(dir):
        if not os.path.isfile(os.path.join(dir, file_name)) or not file_name.endswith('.json') or file_name.endswith('.json.benchmark_log.json'):
            continue
        file_path = os.path.join(dir, file_name)
        benchmark_name = file_name[:-5]
        collect_stats_for_file(file_path, benchmark_name, stats)
        output_fixed_file(file_path, output_dir)
    print(stats)
    with open('bench_stat.csv', 'w') as csv_f:
        writer = csv.writer(csv_f)
        for name, stat in sorted(stats['bench_stat'].items(), key=lambda kv: kv[0]):
            writer.writerow([name, *stat])
    with open('error_distribution.csv', 'w') as csv_f:
        writer = csv.writer(csv_f)
        for problemId, count in sorted(stats['error_distribution'].items(), key=lambda kv: kv[0]):
            writer.writerow([problemId, ERR_ID_TO_PROBLEM[problemId], count])
    with open('problem_distribution.csv', 'w') as csv_f:
        writer = csv.writer(csv_f)
        for problemId, count in sorted(stats['problem_distribution'].items(), key=lambda kv: kv[0]):
            writer.writerow([problemId, ERR_ID_TO_PROBLEM[problemId], count])
    with open('individual_stat.csv', 'w') as csv_f:
        writer = csv.writer(csv_f)
        for name, stat in sorted(stats['individual_stat'].items(), key=lambda kv: kv[0]):
            writer.writerow([name, *stat])
    with open('individual_lib_stat.csv', 'w') as csv_f:
        writer = csv.writer(csv_f)
        for name, stat in sorted(stats['individual_lib_stat'].items(), key=lambda kv: kv[0]):
            writer.writerow([name, *stat])
    print("# of compilable: " + str(stats['total_benchmarks'] - len(stats['failed_benchmarks'])) + '/' + str(stats['total_benchmarks']) + " (" + str(int((stats['total_benchmarks'] - len(stats['failed_benchmarks'])) / stats['total_benchmarks'] * 10000) / 100) + "%)")
    if stats['total_imports'] == 0:
        print("No golden imports")
    else:
        print("Correct Imports: " + str(stats['correct_imports']) + '/' + str(stats['total_imports']) + " (" + str(int(stats['correct_imports'] / stats['total_imports'] * 10000) / 100) + "%)")


def main():
    parser = argparse.ArgumentParser(
            description="Gather stats from the run")
    parser.add_argument("--input-dir", "-i", type=str, metavar="path", required=True, help="Input logs")
    parsed = parser.parse_args()
    get_stats(parsed.input_dir)


if __name__ == "__main__":
    main()
