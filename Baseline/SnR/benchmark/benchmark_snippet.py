#!/usr/bin/env python3

import argparse
import atexit
import json
import locale
import os
import shutil
import signal
import subprocess
import sys
import time
import uuid
from os import path
from typing import List, Union, Tuple

from helpers.java_import_util import remove_import_file, remove_import, match_import

__location__ = os.path.realpath(
    os.path.join(os.getcwd(), os.path.dirname(__file__)))

STATE_LOCATION = os.path.join(__location__, "benchmark_snippet_save.json")
RETRY_MAX = 0
log_dir_path = 'snippet_log'


# DELAY_403_NS = 2 * int(3.6e12)  # 3.6e12 is 1h in ns
# SLEEP_AFTER_N_PACKAGE = 100
# SLEEP_AFTER_N_PACKAGE_NS = int(0.25 * int(3.6e12))


class ExecutionResults:
    def __init__(self, java_file: str, output_file: str, exit_code: int, stdout: str, stderr: str, run_time: int, total_imports: List[str], correct_imports: List[str]):
        self.java_file = java_file
        self.output_file = output_file
        self.exit_code = exit_code
        self.stdout = stdout
        self.stderr = stderr
        self.run_time = run_time
        self.total_imports = total_imports
        self.correct_imports = correct_imports

    def __str__(self):
        return str(self.__dict__)


class State:
    def __init__(self, finished_snippet: List[ExecutionResults], failed_snippet: List[ExecutionResults],
                 queue_snippet: List[str], output_dir: Union[None, str], skip_private: bool):
        self.finished_snippet: List[ExecutionResults] = finished_snippet
        self.failed_snippet: List[ExecutionResults] = failed_snippet
        self.queue_snippet: List[str] = queue_snippet
        self.output_dir: Union[None, str] = output_dir
        self.skip_private: bool = skip_private

    def __str__(self):
        return str(self.__dict__)


def state_to_json(state: State) -> str:
    return json.dumps(state, indent=2, default=lambda a: a.__dict__)


global_state = State([], [], [], None, False)
retry_counter = 0
snr_database_url = "jdbc:mysql:127.0.0.1:3306/snr"
snr_database_username = "snr"
snr_database_password = "SnR123456*"
snr_library_external = "./"


def read_state():
    global global_state
    if not os.path.isfile(STATE_LOCATION):
        print("Expected state in: " + STATE_LOCATION)
        exit(2)
    f = open(STATE_LOCATION, 'r')
    s = f.read()
    j = json.loads(s)
    finished_snippet = []
    for json_finished_snippet in j['finished_snippet']:
        finished_snippet.append(ExecutionResults(json_finished_snippet['java_file'],
                                                 json_finished_snippet['output_file'],
                                                 json_finished_snippet['exit_code'],
                                                 json_finished_snippet['stdout'],
                                                 json_finished_snippet['stderr'],
                                                 json_finished_snippet['run_time'],
                                                 json_finished_snippet['total_imports'],
                                                 json_finished_snippet['correct_import']))
    failed_snippet = []
    for json_failed_snippet in j['failed_snippet']:
        failed_snippet.append(ExecutionResults(json_failed_snippet['java_file'],
                                               json_failed_snippet['output_file'],
                                               json_failed_snippet['exit_code'],
                                               json_failed_snippet['stdout'],
                                               json_failed_snippet['stderr'],
                                               json_failed_snippet['run_time'],
                                               json_failed_snippet['total_imports'],
                                               json_failed_snippet['correct_import']))
    global_state = State(finished_snippet, failed_snippet, j['queue_snippet'], j['output_dir'], j['skip_private'])
    f.close()


def write_state():
    if os.path.exists(STATE_LOCATION):
        shutil.move(STATE_LOCATION, STATE_LOCATION + '.backup')
    f = open(STATE_LOCATION, 'w')
    f.write(state_to_json(global_state))
    f.close()


def print_state():
    j = state_to_json(global_state)
    if len(j) > 10000:
        print("Shortened summary")
        print('Finished: ' + str(len(global_state.finished_snippet)))
        print('Failed: ' + str(len(global_state.failed_snippet)))
        print('Queued: ' + str(len(global_state.queue_snippet)))
        print('Output Dir: ' + str(global_state.output_dir))
        print('Skip private: ' + str(global_state.skip_private))
    else:
        print(j)


def print_state_signal_handler(signal_num, stack_frame):
    print_state()
    sys.stdout.flush()


def process_result_log(results: ExecutionResults) -> None:
    logs_dir = os.path.join(__location__, log_dir_path)
    if not os.path.exists(logs_dir):
        os.makedirs(logs_dir, exist_ok=True)
    random_uuid = str(uuid.uuid4().hex)
    logs_stdout = os.path.join(logs_dir, os.path.basename(results.java_file) + '.stdout.' + random_uuid + '.txt')
    logs_stderr = os.path.join(logs_dir, os.path.basename(results.java_file) + '.stderr.' + random_uuid + '.txt')
    logs_benchmark = os.path.join(results.output_file + '.benchmark_log.json')
    print('Writing logs(stdout): ' + logs_stdout)
    print('Writing logs(stderr): ' + logs_stderr)
    print('Writing benchmark logs: ' + logs_benchmark)
    if os.path.exists(logs_stdout) or os.path.exists(logs_stderr):
        process_result_log(results)
        return
    f_stdout = open(logs_stdout, 'w')
    f_stdout.write(results.stdout)
    f_stdout.close()
    f_stderr = open(logs_stderr, 'w')
    f_stderr.write(results.stderr)
    f_stderr.close()
    results.stdout = logs_stdout
    results.stderr = logs_stderr
    f_bench = open(logs_benchmark, 'w')
    json.dump(results, f_bench, indent=2, default=lambda a: a.__dict__)


def run_snr():
    global retry_counter
    """ Build maven jar repo. Retries on 403 after preset timeout. Record other failures as failed. """
    while len(global_state.queue_snippet) > 0:
        snippet_file = global_state.queue_snippet[-1]
        pipe = subprocess.PIPE
        output_file = "/dev/null"
        if global_state.output_dir is None:
            output_file = "/dev/null"
        else:
            output_file = path.join(global_state.output_dir, path.basename(snippet_file) + ".json")
        cmd = 'java -Dsnr.database.url="' + snr_database_url + '" ' + \
              '-Dsnr.database.username="' + snr_database_username + '" ' + \
              '-Dsnr.database.password="' + snr_database_password + '" ' + \
              '-Dsnr.library.external="' + snr_library_external + '" ' + \
              '-Dsnr.library.private.skip=' + str(global_state.skip_private) + ' ' + \
              '-cp ' + \
              os.path.join(__location__, '..', 'target', 'snr-server-0.0.1-SNAPSHOT.jar') + ':' + \
              os.path.join(__location__, '..', 'target', 'lib', '*') + ':' + \
              os.path.join(__location__, '..', 'lib', '*') + ' ' + \
              'org.javelus.snr.compile.SnRBuilder ' + \
              ' --output-file ' + output_file
              # ' --input-file ' + snippet_file + \

        print('Running cmd: ' + cmd)
        input_code, imports = remove_import_file(snippet_file)
        input_code_encoded = input_code.encode(locale.getpreferredencoding())
        start_execution_time = time.time_ns()
        proc = subprocess.run(
            cmd,
            check=False,
            shell=True,
            stdout=pipe,
            stderr=pipe,
            input=input_code_encoded)
        stop_execution_time = time.time_ns()
        number_of_imports = imports
        correct_imports = []

        if os.path.exists(output_file):
            with open(output_file) as o_file:
                json_output = json.load(o_file)
                if "updatedContent" in json_output and json_output["updatedContent"] is not None:
                    updated_code, updated_imports = remove_import(str(json_output["updatedContent"]).split('\n'))
                    correct_imports = match_import(updated_imports, imports)
        results: ExecutionResults = ExecutionResults(snippet_file,
                                                     output_file,
                                                     proc.returncode,
                                                     proc.stdout.decode(locale.getpreferredencoding()),
                                                     proc.stderr.decode(locale.getpreferredencoding()),
                                                     stop_execution_time - start_execution_time,
                                                     number_of_imports,
                                                     correct_imports)
        if results.exit_code == 0:
            retry_counter = 0
            process_result_log(results)
            global_state.finished_snippet.append(results)
            global_state.queue_snippet.pop(-1)
            print('Processed: ' + snippet_file)
        else:
            errs = results.stderr.split('\n')
            last_errs = errs[-min(20, len(errs)):]
            for err in last_errs:
                if err.startswith('Caused by:') and err.index('403') != -1:
                    global_state.last_403_time = time.time_ns()
                    if retry_counter < RETRY_MAX:
                        retry_counter = retry_counter + 1
                        print('Retrying 403:' + snippet_file)
                        continue
            retry_counter = 0
            process_result_log(results)
            global_state.failed_snippet.append(results)
            global_state.queue_snippet.pop(-1)
            print('Failed to process: ' + snippet_file)


def main():
    global global_state, snr_database_url, snr_database_username, snr_database_password, snr_library_external

    parser = argparse.ArgumentParser(
        description="Build Maven sql database")
    parser.add_argument("--output-dir", "-o", type=str, metavar="path", help="Output folder for reduced result",
                        required=False)
    parser.add_argument("--snippets", "-s", nargs='+', type=str, metavar="path", help="Location of snippet files",
                        required=False)
    parser.add_argument("--list-failures", "-lf", action='store_true', help="Printout failed ",
                        required=False)
    parser.add_argument("--queue-failures", "-qf", action='store_true', help="Writes to state a queue of failed ",
                        required=False)
    parser.add_argument("--skip-private", "-sp", action='store_true', help="Skip private",
                        required=False)
    parsed = parser.parse_args()
    if parsed.list_failures:
        read_state()
        snippet_files = []
        for failure in global_state.failed_snippet:
            snippet_files.append(failure.java_file)
        print(' '.join(snippet_files))
        return
    if parsed.queue_failures:
        read_state()
        snippet_files = []
        for failure in global_state.failed_snippet:
            snippet_files.append(failure.java_file)
        if len(snippet_files) == 0:
            print("No failures found. States are not written")
            return
        global_state = State([], [], snippet_files, parsed.output_dir, global_state.skip_private)
        write_state()
        return
    if os.environ.get('snr_database_url') is None:
        print("Expect env: snr_database_url")
        exit(1)
    snr_database_url = os.environ.get('snr_database_url')
    if os.environ.get('snr_database_username') is None:
        print("Expect env: snr_database_username")
        exit(1)
    snr_database_username = os.environ.get('snr_database_username')
    if os.environ.get('snr_database_password') is None:
        print("Expect env: snr_database_password")
        exit(1)
    snr_database_password = os.environ.get('snr_database_password')
    if os.environ.get('snr_library_external') is None:
        print("Expect env: snr_library_external")
        exit(1)
    snr_library_external = os.environ.get('snr_library_external')
    if parsed.snippets:
        snippets = []
        for file in parsed.snippets:
            if not os.path.isfile(file):
                print("Expect file, got: " + file)
                exit(1)
            snippets.append(os.path.abspath(file))
        global_state = State([], [], snippets, parsed.output_dir, parsed.skip_private)
    else:
        print("No files defined. Resuming previous state")
        read_state()
        print_state()
        print("Loaded previous state")
    # Run main logic
    atexit.register(write_state)
    atexit.register(print_state)
    signal.signal(signal.SIGALRM, print_state_signal_handler)
    run_snr()
    print("Finished successfully")


if __name__ == "__main__":
    main()
