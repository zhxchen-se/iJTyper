#!/usr/bin/env python3
import argparse
import json
import locale
import os
import subprocess
from typing import List, Dict, Tuple

from helpers.java_import_util import remove_import_file

__location__ = os.path.realpath(
    os.path.join(os.getcwd(), os.path.dirname(__file__)))

# Generate the initial lib golden file to be modified.

def find_largest(libs_count: Dict[str, int], is_android: bool) -> str:
    assert len(libs_count) > 0
    largest_lib: Tuple[str, int] = list(libs_count.items())[0]
    for lib, count in libs_count.items():
        if count > largest_lib[1]:
            largest_lib = (lib, count)
        if count == largest_lib[1] and ('android' in largest_lib[0] or 'jdk' in largest_lib[0]) and ('android' in lib or 'jdk' in lib):
            if is_android and 'android' in lib:
                largest_lib = (lib, count)
            if not is_android and 'android' in largest_lib[0]:
                largest_lib = (lib, count)
    return largest_lib[0]


def get_libs_count(imports: Dict[str, List[str]], used_libs: List[str]) -> Tuple[Dict[str, int], List[str]]:
    libs_count = dict()
    import_list = list()
    for imp, libs in imports.items():
        resolved = False
        for used_lib in used_libs:
            if used_lib in libs:
                resolved = True
        if resolved:
            continue
        if len(libs) > 0:
            import_list.append(imp)
        for lib in libs:
            if lib not in libs_count:
                libs_count[lib] = 0
            libs_count[lib] = libs_count[lib] + 1
    return libs_count, import_list


def get_minimal_libs(stat: Dict[str, Dict[str, List[str]]]):
    for name, imports in stat.items():
        used_libs = list()
        libs_count, import_list = get_libs_count(imports, used_libs)
        # print("Processing: " + name + " imports " + str(import_list))
        while len(import_list) > 0:
            if len(libs_count) == 0:
                print("Cannot find " + str(import_list) + " in " + name + " info " + str(imports))
                used_libs.append("missed " + str(import_list))
                break
            is_android: bool = "android" in name.lower()
            # print("Find largest with counts " + str(libs_count))
            largest = find_largest(libs_count, is_android)
            used_libs.append(largest)
            # print("Added " + largest)
            libs_count, import_list = get_libs_count(imports, used_libs)
        stat[name]['Best completed libs'] = used_libs


def get_libs(dir: str) -> Dict[str, Dict[str, List[str]]]:
    assert os.path.isdir(dir)
    stat: Dict[str, Dict[str, List[str]]] = dict()
    for file_name in os.listdir(dir):
        if not os.path.isfile(os.path.join(dir, file_name)) or not file_name.endswith('.java'):
            continue
        file_path = os.path.join(dir, file_name)
        stat[file_name] = dict()
        input_code, imports = remove_import_file(file_path)
        for imp in imports:
            cmd = 'mysql --user="' + os.getenv('snr_database_username') + '" --password="' + os.getenv('snr_database_password') + '" --database="' + os.getenv('snr_database_name') + '" ' \
                  '--execute="' \
                  'SELECT snr.mvn_artifact.artifactid ' \
                  'FROM snr.mvn_class ' \
                  'JOIN snr.mvn_artifact ON snr.mvn_class.artifact_id = snr.mvn_artifact.id ' \
                  'WHERE snr.mvn_class.name = \'' + str(imp).replace('.', '/') + '\' OR \'' + '$'.join(str(imp).replace('.', '/').rsplit('/', 1)) + '\';"'

            print('Running cmd: ' + cmd)
            proc = subprocess.run(
                cmd,
                check=False,
                shell=True,
                stdout=subprocess.PIPE,
                stderr=subprocess.PIPE)
            output = list(map(lambda a: str(a)[:].strip(), proc.stdout.decode(locale.getpreferredencoding()).split()[1:]))
            # print(proc.stdout.decode(locale.getpreferredencoding()))
            print(imp + ' is in ' + str(output))
            stat[file_name][imp] = output

    return stat


def main():
    parser = argparse.ArgumentParser(
        description="Gather stats from the run")
    parser.add_argument("--input-dir", "-i", type=str, metavar="path", required=True, help="Input snippets")
    parser.add_argument("--output-json", "-o", type=str, metavar="path", required=True, help="Output golden")
    parsed = parser.parse_args()
    stat = get_libs(parsed.input_dir)
    get_minimal_libs(stat)
    with open(parsed.output_json, 'w') as output_f:
        json.dump(stat, output_f, indent=4, sort_keys=True)


if __name__ == "__main__":
    main()