#!/usr/bin/env python3

import argparse
import os

__location__ = os.path.realpath(
    os.path.join(os.getcwd(), os.path.dirname(__file__)))

def read_all_code_snippets():
    pass

def collect_so_answerId():
    pass

def main():
    parser = argparse.ArgumentParser(
            description = "Process csnippex")
    parser.add_argument("--csnippex-location", "-c", action="store_true", help="Location of csnippex with README.txt", requred=True)
    parsed = parser.parse_args()
    if not os.path.isdir(parsed.csnippex_location):
        print("Expected csnippex-location to be a path")
    if not os.path.isdir(os.path.join(parsed.csnippex_location, "compilable_code_snippets", "")):
        # s = f.read()
        # j = json.loads(s)
        # f = open("cs0.json", encoding="cp1252")
        # first_element = j[0]
        # >>> first_unit[0]
        # {'packageDeclaration': 'package test;\n', 'imports': ['import java.util.Set;', 'import java.io.IOException;', 'import java.util.HashSet;'], 'body': '\n /* Code snippet extracted from http://stackoverflow.com/a/18322219 by CSNIPPEX (http://sccpu2.cse.ust.hk/csnippex/)\n stackoverflow code is available for use under the terms of the MIT License */\n\n\n\n\npublic class Sandbox {\n\n    public static void main(String[] args) throws IOException {\n        Set<Integer> userNumbers = new HashSet<>();\n        userNumbers.add(1);\n        userNumbers.add(2);\n        userNumbers.add(3);\n        userNumbers.add(4);\n        userNumbers.add(5);\n        userNumbers.add(6);\n\n        Set<Integer> lotteryNumbers = new HashSet<>();\n        lotteryNumbers.add(1);\n        lotteryNumbers.add(2);\n        lotteryNumbers.add(3);\n        lotteryNumbers.add(4);\n        lotteryNumbers.add(5);\n        lotteryNumbers.add(6);\n        lotteryNumbers.add(7);\n\n        if (lotteryNumbers.containsAll(userNumbers)) {\n            System.out.println("We have a winner!");\n        } else {\n            System.out.println("Sorry, you\'re a loser");\n        }\n    }\n\n\n}\n', 'className': 'Sandbox', 'main': ''}
        # >>> j[1]["units"][0]
        # {'packageDeclaration': 'package test;\n', 'imports': ['import java.awt.*;', 'import java.awt.color.*;'], 'body': '\n /* Code snippet extracted from http://stackoverflow.com/a/18245592 by CSNIPPEX (http://sccpu2.cse.ust.hk/csnippex/)\n stackoverflow code is available for use under the terms of the MIT License */\n\n\n public class Answer18245592{\npublic static void main(String[] args) throws Exception{\n }\n}\n', 'className': 'Answer18245592', 'main': ''}
        # >>> j[2]["units"][0]
        # {'packageDeclaration': 'package test;\n', 'imports': [], 'body': '\n /* Code snippet extracted from http://stackoverflow.com/a/2031816 by CSNIPPEX (http://sccpu2.cse.ust.hk/csnippex/)\n stackoverflow code is available for use under the terms of the MIT License */\n\n\n public class Answer2031816_2{\npublic static void main(String[] args) throws Exception{\n String s = "string1, string2, string3";\nSystem.out.println(s.replaceAll("string1|2", "blah"));\n}\n}\n', 'className': 'Answer2031816_2', 'main': ''}


if __name__ == "__main__":
    main()
