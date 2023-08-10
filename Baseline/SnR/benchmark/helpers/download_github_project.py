#!/usr/bin/env python3
import argparse
import os
import subprocess
import sys
from typing import List

__location__ = os.path.realpath(os.path.join(os.getcwd(), os.path.dirname(__file__)))


def read_names(path: str) -> List[str]:
    names = list()
    with open(path) as f:
        for line in f:
            names.append(line.strip())
    return names


def test_git_url(url: str):
    cmd = ['git', 'ls-remote', '--exit-code', url]
    res = subprocess.run(cmd, stdin=subprocess.DEVNULL, stderr=subprocess.DEVNULL, stdout=subprocess.DEVNULL)
    return res.returncode == 0


def find_git_for_name(name: str) -> str:
    name_parts = name.split('-')
    assert len(name_parts) > 1
    for i in range(0, len(name_parts) - 1):
        url_str = 'https://username:password@github.com/' + '-'.join(name_parts[:i+1]) + '/' + '-'.join(name_parts[i+1:]) + '.git'
        if test_git_url(url_str):
            return url_str
    raise Exception('Cannot find git for name: ' + name)


def clone_repo(to_path: str, url_str: str):
    cmd = ['git', 'clone', '--depth', '1', url_str]
    res = subprocess.run(cmd, stdin=subprocess.DEVNULL, stderr=subprocess.DEVNULL, stdout=subprocess.DEVNULL, cwd=to_path)
    return res.returncode == 0


def main():
    parser = argparse.ArgumentParser(
        description="Print stat from csv")
    parser.add_argument("--input", "-i", type=str, metavar="path", required=True, help="Input")
    parser.add_argument("--outdir", "-o", type=str, metavar="path", required=True, help="Output dir")
    parsed = parser.parse_args()
    if not os.path.isfile(parsed.input):
        print(f"{parsed.input} is not a file", file=sys.stderr)
        return
    if not os.path.isdir(parsed.outdir):
        print(f"{parsed.outdir} is not a dir", file=sys.stderr)
        return
    names = read_names(parsed.input)
    for name in names:
        try:
            url_str = find_git_for_name(name)
            print('Found git ' + name + ' -> ' + url_str)
            if clone_repo(parsed.outdir, url_str):
                print('Cloned ' + name)
            else:
                print('Failed to clone ' + name)
        except Exception as e:
            print('Cannot find git for ' + name)
    # git_urls = list(map(find_git_for_name, names))
    # print('\n'.join(git_urls))


if __name__ == "__main__":
    main()
