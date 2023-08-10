#!/usr/bin/env python3
import argparse
import csv
import json
import os
from typing import Dict, List


def count_golden_libs(golden_stats: Dict[str, List[str]], golden: Dict[str, Dict[str, List[str]]]):
    for name, mapping in golden.items():
        libs = mapping['Best completed libs']
        golden_stats[name] = [str(len(libs))]


def main():
    parser = argparse.ArgumentParser(
        description="Gather lib stats from golden")
    parser.add_argument("--input-golden", "-g", type=str, metavar="path", required=True, help="Input golden")
    parser.add_argument("--output", "-o", type=str, metavar="path", required=True, help="Output stat")
    parsed = parser.parse_args()
    assert os.path.isfile(parsed.input_golden)
    golden_stats: Dict[str, List[str]] = dict()
    with open(parsed.input_golden) as json_fp:
        golden = json.load(json_fp)
        count_golden_libs(golden_stats, golden)
        with open(parsed.output, 'w') as csv_f:
            writer = csv.writer(csv_f)
            for name, stat in sorted(golden_stats.items(), key=lambda kv: kv[0]):
                writer.writerow([name, *stat])


if __name__ == "__main__":
    main()
