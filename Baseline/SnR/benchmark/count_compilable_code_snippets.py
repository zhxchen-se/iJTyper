#!/bin/env python3
# Expected to be launched in compilable_code_snippets
import argparse
import csv
import os
import re
import subprocess

error_line_re = re.compile(r'[0-9]+ error')
ignored_errors = ['error: package R does not exist', 'error: package gen does not exist']


def prep_compile():
    pass


def compile_file(file_path):
    jar_path = os.environ['snr_library_external']
    cmd = f'javac -cp "{os.path.join(jar_path, "*")}" {os.path.basename(file_path)}'
    # cmd = 'pwd'
    print(cmd)
    proc = subprocess.run(
        cmd,
        cwd=os.path.dirname(file_path),
        check=False,
        shell=True,
        stdout=subprocess.PIPE,
        stderr=subprocess.PIPE)
    # proc = subprocess.run(
    #     cmd,
    #     cwd=os.path.dirname(file_path),
    #     check=False,
    #     shell=True)
    ignored_error_count = 0
    reported_error_count = 0
    for line in proc.stderr.decode('utf8').split('\n'):
        print(line)
        is_ignored = False
        for ignored_error in ignored_errors:
            if line.endswith(ignored_error):
                is_ignored = True
                break
        if is_ignored:
            ignored_error_count += 1
        elif error_line_re.match(line):
            reported_error_count = int(line.split()[0].strip())
    print('IgErrors: ' + str(ignored_error_count))
    print('ReErrors: ' + str(reported_error_count))
    print('Success compile: ' + str(reported_error_count - ignored_error_count == 0))
    return (reported_error_count - ignored_error_count) == 0


def get_stats(snippet_dir, output_csv_path):
    assert os.path.isdir(snippet_dir)
    prep_compile()
    results = []

    for file_name in sorted(os.listdir(snippet_dir)):
        if not os.path.isfile(os.path.join(snippet_dir, file_name)) or not file_name.endswith('.java'):
            continue
        file_path = os.path.join(snippet_dir, file_name)
        compile_res = compile_file(file_path)
        results.append([file_name, compile_res])

    with open(output_csv_path, 'w') as csv_file:
        writer = csv.writer(csv_file)
        writer.writerows(results)


def main():
    parser = argparse.ArgumentParser(
        description="Gather stats from the run")
    parser.add_argument("--input-dir", "-i", type=str, metavar="path", required=True, help="Input logs")
    parser.add_argument("--output-csv", "-o", type=str, metavar="path", required=True, help="Output")
    parsed = parser.parse_args()
    get_stats(parsed.input_dir, parsed.output_csv)


if __name__ == "__main__":
    main()
