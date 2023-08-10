#!/usr/bin/env python3

import argparse
import csv
import os
import sys
from typing import Dict, List

from java_import_util import remove_import_file, match_import, filter_ignored_imports

__location__ = os.path.realpath(
    os.path.join(os.getcwd(), os.path.dirname(__file__)))


def read_std_csv(input_file: str) -> Dict[str, List[str]]:
    snippet_stats: Dict[str, List[str]] = dict()
    with open(input_file, newline='') as input_csv_file:
        input_reader = csv.reader(input_csv_file, delimiter=',')
        for row in input_reader:
            snippet_name, fql = row
            if snippet_name not in snippet_stats:
                snippet_stats[snippet_name] = list()
            snippet_stats[snippet_name].append(fql)
    return snippet_stats


def process(input_file: str, snippets: List[str]):
    result_imports = read_std_csv(input_file)
    stats: Dict[str, List[str]] = dict()
    total_imports = 0
    correct_imports = 0
    for snippet_file in snippets:
        snippet_name = os.path.basename(snippet_file)
        snippet_code, expected_imports = remove_import_file(snippet_file)
        filtered_expected_imports = filter_ignored_imports(expected_imports)
        matched_imports = []
        if snippet_name in result_imports:
            matched_imports = filter_ignored_imports(match_import(result_imports[snippet_name], filtered_expected_imports))
        stats[snippet_name] = [str(len(matched_imports)), str(len(filtered_expected_imports))]
        total_imports += len(filtered_expected_imports)
        correct_imports += len(matched_imports)
    output_writer = csv.writer(sys.stdout, delimiter=',')
    for bench_name in stats.keys():
        output_writer.writerow([bench_name, *stats[bench_name]])
    output_writer.writerow(['total: ', correct_imports, total_imports])


def main():
    parser = argparse.ArgumentParser(
        description="Print stat from csv")
    parser.add_argument("--input-csv", "-i", type=str, metavar="path", required=True, help="Input")
    parser.add_argument("--snippets", "-s", nargs='+', type=str, metavar="path", required=True, help="Snippet location")
    parsed = parser.parse_args()
    if not os.path.isfile(parsed.input_csv):
        print(f"{parsed.input_csv} is not a file", file=sys.stderr)
        return
    for file in parsed.snippets:
        if not os.path.isfile(file):
            print(f"{file} is not a file", file=sys.stderr)
            return
    process(parsed.input_csv, parsed.snippets)


if __name__ == "__main__":
    main()
