#!/usr/bin/env python3

import argparse
import csv
import os
import sys
from typing import List, Dict

__location__ = os.path.realpath(
    os.path.join(os.getcwd(), os.path.dirname(__file__)))


def convert(input_file: str):
    collected: Dict[str, List[str]] = dict()
    with open(input_file, newline='') as input_csv_file:
        input_reader = csv.reader(input_csv_file, delimiter=',')
        is_first = True
        for row in input_reader:
            if is_first:
                is_first = False
                continue
            bench_path = row[0]
            found_api = row[6]
            bench_name = os.path.basename(bench_path)
            if bench_name not in collected:
                collected[bench_name] = list()
            if found_api not in collected[bench_name]:
                collected[bench_name].append(found_api)
    output_writer = csv.writer(sys.stdout, delimiter=',')
    for bench_name in collected.keys():
        for fql_name in collected[bench_name]:
            output_writer.writerow([bench_name, fql_name])


def main():
    parser = argparse.ArgumentParser(
        description="Convert csv")
    parser.add_argument("--input-csv", "-i", type=str, metavar="path", required=True, help="Input")
    parsed = parser.parse_args()
    if not os.path.isfile(parsed.input_csv):
        print(f"{parsed.input_csv} is not a file", file=sys.stderr)
        return
    convert(parsed.input_csv)


if __name__ == "__main__":
    main()
