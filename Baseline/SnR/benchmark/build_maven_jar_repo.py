#!/usr/bin/env python3

import argparse
import atexit
import json
import math
import os
import shutil
import signal
import subprocess
import sys
import time
import uuid
from typing import Dict, List

__location__ = os.path.realpath(
    os.path.join(os.getcwd(), os.path.dirname(__file__)))

BUILD_STATE_LOCATION = os.path.join(__location__, "build_state_save.json")
RETRY_MAX = 3
DELAY_403_NS = 2 * int(3.6e12)  # 3.6e12 is 1h in ns
#SLEEP_AFTER_N_PACKAGE = 100
#SLEEP_AFTER_N_PACKAGE_NS = int(0.25 * int(3.6e12))
SLEEP_AFTER_N_PACKAGE = 10000
SLEEP_AFTER_N_PACKAGE_NS = 1

class ExecutionResults:
    def __init__(self, jar_file: str, exit_code: int, stdout: str, stderr: str):
        self.jar_file = jar_file
        self.exit_code = exit_code
        self.stdout = stdout
        self.stderr = stderr

    def __str__(self):
        return str(self.__dict__)


class BuildState:
    def __init__(self, build_mode: str, finished_jar: List[ExecutionResults], failed_jar: List[ExecutionResults], last_403_time: int,
                 queue_jar: List[str], args: str):
        assert build_mode == 'maven' or build_mode == 'jar'
        self.build_mode = build_mode
        self.finished_jar: List[ExecutionResults] = finished_jar
        self.failed_jar: List[ExecutionResults] = failed_jar
        self.last_403_time: int = last_403_time
        self.queue_jar: List[str] = queue_jar
        self.args = args

    def __str__(self):
        return str(self.__dict__)


def build_state_to_json(build_state: BuildState) -> str:
    return json.dumps(build_state, indent=2, default=lambda a: a.__dict__)


global_build_state = BuildState('maven', [], [], 0, [], "")
retry_counter = 0
package_count_since_sleep = 0
snr_database_url = "jdbc:mysql:127.0.0.1:3306/snr"
snr_database_username = "snr"
snr_database_password = "SnR123456*"


def read_state():
    global global_build_state
    if not os.path.isfile(BUILD_STATE_LOCATION):
        print("Expected state in: " + BUILD_STATE_LOCATION)
        exit(2)
    f = open(BUILD_STATE_LOCATION, 'r')
    s = f.read()
    j = json.loads(s)
    finished_jar = []
    for json_finished_jar in j['finished_jar']:
        finished_jar.append(ExecutionResults(json_finished_jar['jar_file'],
                                             json_finished_jar['exit_code'],
                                             json_finished_jar['stdout'],
                                             json_finished_jar['stderr']))
    failed_jar = []
    for json_failed_jar in j['failed_jar']:
        failed_jar.append(ExecutionResults(json_failed_jar['jar_file'],
                                           json_failed_jar['exit_code'],
                                           json_failed_jar['stdout'],
                                           json_failed_jar['stderr']))
    global_build_state = BuildState(j['build_mode'], finished_jar, failed_jar, j['last_403_time'], j['queue_jar'], j['args'])
    f.close()


def write_state():
    if os.path.exists(BUILD_STATE_LOCATION):
        shutil.move(BUILD_STATE_LOCATION, BUILD_STATE_LOCATION + '.backup')
    f = open(BUILD_STATE_LOCATION, 'w')
    f.write(build_state_to_json(global_build_state))
    f.close()


def print_build_state():
    j = build_state_to_json(global_build_state)
    if len(j) > 10000:
        print("Shortened summary")
        print('Finished: ' + str(len(global_build_state.finished_jar)))
        print('Failed: ' + str(len(global_build_state.failed_jar)))
        print('Last 403 time: ' + time.strftime('%m-%d %H:%M', time.localtime(global_build_state.last_403_time / int(1e9))) + '(' + str(global_build_state.last_403_time) + ')')
        print('Queued: ' + str(len(global_build_state.queue_jar)))
        print('Args: ' + str(global_build_state.args))
    else:
        print(j)


def print_build_state_signal_handler(signal_num, stack_frame):
    print_build_state()
    sys.stdout.flush()


def process_result_log(results: ExecutionResults):
    logs_dir = os.path.join(__location__, 'logs')
    if not os.path.exists(logs_dir):
        os.makedirs(logs_dir, exist_ok=True)
    random_uuid = str(uuid.uuid4().hex)
    logs_stdout = os.path.join(logs_dir, os.path.basename(results.jar_file) + '.stdout.' + random_uuid + '.txt')
    logs_stderr = os.path.join(logs_dir, os.path.basename(results.jar_file) + '.stderr.' + random_uuid + '.txt')
    print('Writing logs(stdout): ' + logs_stdout)
    print('Writing logs(stderr): ' + logs_stderr)
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


def process_args(args: str) -> str:
    total:List[str] = []
    for seg in args.split(' '):
        total.append("-D" + seg.strip().replace('_', '.').lower())
    return ' '.join(total)


def build_maven_jar_repo():
    global retry_counter, package_count_since_sleep
    """ Build maven jar repo. Retries on 403 after preset timeout. Record other failures as failed. """
    while len(global_build_state.queue_jar) > 0:
        maven_jar = global_build_state.queue_jar[-1]
        pipe = subprocess.PIPE
        cmd = None
        if global_build_state.build_mode == 'maven':
            cmd = 'java -Dsnr.database.url="' + snr_database_url + '" ' + \
                  '-Dsnr.database.username="' + snr_database_username + '" ' + \
                  '-Dsnr.database.password="' + snr_database_password + '" ' + \
                  process_args(str(global_build_state.args)) + ' ' + \
                  '-cp ' + os.path.join(__location__, '..', 'target', 'snr-server-0.0.1-SNAPSHOT.jar') + ':' + os.path.join(__location__, '..', 'target', 'lib', '*') + ':' + os.path.join(__location__, '..', 'lib', '*') + ' ' + \
                  'org.javelus.snr.mrb.MavenJarRepoBuilder ' + \
                  maven_jar
        elif global_build_state.build_mode == 'jar':
            cmd = 'java -Dsnr.database.url="' + snr_database_url + '" ' + \
                  '-Dsnr.database.username="' + snr_database_username + '" ' + \
                  '-Dsnr.database.password="' + snr_database_password + '" ' + \
                  process_args(str(global_build_state.args)) + ' ' + \
                  '-cp ' + os.path.join(__location__, '..', 'target', 'snr-server-0.0.1-SNAPSHOT.jar') + ':' + os.path.join(__location__, '..', 'target', 'lib', '*') + ':' + os.path.join(__location__, '..', 'lib', '*') + ' ' + \
                  'org.javelus.snr.mrb.JarRepoBuilder ' + \
                  maven_jar + ' '

        print('Running cmd: ' + cmd)
        if package_count_since_sleep >= SLEEP_AFTER_N_PACKAGE:
            write_state()
            print('Sleeping after ' + str(SLEEP_AFTER_N_PACKAGE) + ' package starting: ' + time.strftime('%m-%d %H:%M', time.localtime(time.time_ns() / int(1e9))))
            time.sleep(math.ceil(SLEEP_AFTER_N_PACKAGE_NS / int(1e9)))
            package_count_since_sleep = 0
        if time.time_ns() - global_build_state.last_403_time < DELAY_403_NS:
            print('Sleeping due to recent 403 at: ' + time.strftime('%m-%d %H:%M', time.localtime(global_build_state.last_403_time / int(1e9))))
            time.sleep(math.ceil(DELAY_403_NS / int(1e9)))
        package_count_since_sleep = package_count_since_sleep + 1
        proc = subprocess.run(
            cmd,
            check=False,
            shell=True,
            stdout=pipe,
            stderr=pipe)
        results: ExecutionResults = ExecutionResults(maven_jar, proc.returncode, str(proc.stdout), str(proc.stderr))
        if results.exit_code == 0:
            retry_counter = 0
            process_result_log(results)
            global_build_state.finished_jar.append(results)
            global_build_state.queue_jar.pop(-1)
            print('Processed: ' + maven_jar)
        else:
            errs = results.stderr.split('\n')
            last_errs = errs[-min(20, len(errs)):]
            for err in last_errs:
                if err.startswith('Caused by:') and err.index('403') != -1:
                    global_build_state.last_403_time = time.time_ns()
                    if retry_counter < RETRY_MAX:
                        retry_counter = retry_counter + 1
                        print('Retrying 403:' + maven_jar)
                        continue
            retry_counter = 0
            process_result_log(results)
            global_build_state.failed_jar.append(results)
            global_build_state.queue_jar.pop(-1)
            print('Failed to process: ' + maven_jar)


def main():
    global global_build_state, snr_database_url, snr_database_username, snr_database_password

    parser = argparse.ArgumentParser(
        description="Build Maven sql database")
    parser.add_argument("--libs", "-l", nargs='+', type=str, metavar="path", help="Location of maven jars",
                        required=False)
    parser.add_argument("--list-failures", "-lf", action='store_true', help="Printout failed ",
                        required=False)
    parser.add_argument("--queue-failures", "-qf", action='store_true', help="Writes to state a queue of failed ",
                        required=False)
    parser.add_argument("--maven", "-m", action='store_true', help="Import as maven",
                        required=False)
    parser.add_argument("--jar", "-j", action='store_true', help="Import as jar",
                        required=False)
    parser.add_argument("--java-args", "-ja", nargs='+', type=str, help="Arguments to program",
                        required=False)
    parsed = parser.parse_args()
    if parsed.list_failures:
        read_state()
        jar_files = []
        for failure in global_build_state.failed_jar:
            jar_files.append(failure.jar_file)
        print(' '.join(jar_files))
        return
    build_mode = 'maven'
    if parsed.jar and parsed.maven:
        raise Exception('Both jar and maven set')
    if parsed.jar:
        build_mode = 'jar'
    elif parsed.maven:
        build_mode = 'maven'
    if parsed.queue_failures:
        read_state()
        jar_files = []
        for failure in global_build_state.failed_jar:
            jar_files.append(failure.jar_file)
        if len(jar_files) == 0:
            print("No failures found. States are not written")
            return
        global_build_state = BuildState(build_mode, [], [], 0, jar_files, global_build_state.args)
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
    if parsed.libs:
        libs = []
        libs_path = parsed.libs
        if len(libs_path) == 1 and os.path.isdir(libs_path[0]):
            base_path = libs_path[0]
            libs_path = []
            for f in os.listdir(base_path):
                libs_path.append(os.path.join(base_path, f))
        for file in libs_path:
            if not os.path.isfile(file):
                print("Expect file, got: " + file)
                exit(1)
            libs.append(os.path.abspath(file))
        global_build_state = BuildState(build_mode, [], [], 0, libs, ' '.join(parsed.java_args))
    else:
        print("No files defined. Resuming previous state")
        read_state()
        print_build_state()
        print("Loaded previous state")
    # Run main logic
    atexit.register(write_state)
    atexit.register(print_build_state)
    signal.signal(signal.SIGALRM, print_build_state_signal_handler)
    build_maven_jar_repo()
    print("Finished successfully")


if __name__ == "__main__":
    main()
