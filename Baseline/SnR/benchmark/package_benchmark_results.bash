#!/usr/bin/env bash

ZIP_NAME="benchmark-snapshot-$(printf '%(%y-%m-%d)T').zip"
echo "Writing ${ZIP_NAME}"

grep "Exception" ./snippet_log/*.stderr.* > ./exceptionerror.txt

zip -r "${ZIP_NAME}" StatType-Completion-output-json snippet_log fixed \
                     error_distribution.csv exceptionerror.txt bench_stat.csv problem_distribution.csv \
                     individual_stat.csv individual_lib_stat.csv individual_lib_stat_count.csv \
                     compile_result.csv
