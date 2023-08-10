#!/usr/bin/env bash

mkdir -p StatType-Completion-output-json
rm StatType-Completion-output-json/*
rm snippet_log/*

arg=""
if [ "${snr_library_private_skip}" = "True" ]; then
    arg="-sp"
fi

./benchmark_snippet.py ${arg} -o StatType-Completion-output-json/ -s ${snr_snippets}

./analyze_result_json.py -i StatType-Completion-output-json/

./count_compilable_code_snippets.py -i fixed -o compile_result.csv

./count_lib_stat.py -i individual_lib_stat.csv -g ${stattype_so_lib_gold_path} -o individual_lib_stat_count.csv