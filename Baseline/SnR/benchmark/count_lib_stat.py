#!/usr/bin/env python3
import argparse
import csv
import json
import os
from typing import Dict, List

status = ["unsolved", "extra", "missing", "diff", "correct"]


def count_libs(lib_stats: Dict[str, List[str]], golden: Dict[str, Dict[str, List[str]]], ignore_jdk: bool):
    stat = dict()
    for name, libs in lib_stats.items():
        if name not in golden:
            print("No golden stat for " + name)
            continue
        golden_libs = set(golden[name]['Best completed libs'])
        actual_libs = set(map(lambda a: str(a).split(':')[1], libs))
        if ignore_jdk:
            golden_libs = set(filter(lambda a: a != 'jdk', golden_libs))
        # print("+ " + str(list(actual_libs - golden_libs)))
        # print("- " + str(list(golden_libs - actual_libs)))
        snippet_status = status[2]
        plus = len(actual_libs - golden_libs)
        minus = len(golden_libs - actual_libs)
        if plus == 0 and minus == 0:
            snippet_status = status[4]
        elif len(actual_libs) == 0:
            snippet_status = status[0]
        elif plus > 0 and minus == 0:
            snippet_status = status[1]
        elif plus == 0 and minus > 0:
            snippet_status = status[2]
        else:
            snippet_status = status[3]
        stat[name] = [snippet_status, plus, minus]
    return stat


def main():
    parser = argparse.ArgumentParser(
        description="Gather stats from the run")
    parser.add_argument("--input-csv", "-i", type=str, metavar="path", required=True, help="Input snippets")
    parser.add_argument("--input-golden", "-g", type=str, metavar="path", required=True, help="Input golden")
    parser.add_argument("--output", "-o", type=str, metavar="path", required=True, help="Output stat")
    parser.add_argument("--ignore-jdk", "-j", action="store_true", required=False, help="Ignore JDK")
    parsed = parser.parse_args()
    assert os.path.isfile(parsed.input_csv)
    assert os.path.isfile(parsed.input_golden)
    lib_stats: Dict[str, List[str]] = dict()
    with open(parsed.input_csv) as csv_fp:
        csv_reader = csv.reader(csv_fp)
        for row in csv_reader:
            lib_stats[row[0]] = row[1:]
    with open(parsed.input_golden) as json_fp:
        golden = json.load(json_fp)
        stats = count_libs(lib_stats, golden, parsed.ignore_jdk)
        with open(parsed.output, 'w') as csv_f:
            writer = csv.writer(csv_f)
            for name, stat in sorted(stats.items(), key=lambda kv: kv[0]):
                writer.writerow([name, *stat])


if __name__ == "__main__":
    main()
