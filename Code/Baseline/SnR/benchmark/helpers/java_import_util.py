import locale
import os
from typing import List, Tuple, Union, re


def remove_import(lines: List[str]) -> Tuple[str, List[str]]:
    new_str = ''
    imports: List[str] = []
    for line in lines:
        if line.strip().startswith("import ") \
                and ' ' not in line.strip()[6:].strip() \
                and line.strip()[6:].endswith(';'):
            imports.append(line.strip()[6:-1].strip())
            continue
        else:
            new_str = new_str + line
    return new_str.strip(), imports


def remove_import_file(file: str, encoding=locale.getpreferredencoding()) -> Tuple[str, List[str]]:
    if not os.path.isfile(file):
        return '', []
    try:
        with open(file, encoding=encoding) as f:
            return remove_import(f.readlines())
    except UnicodeDecodeError:
        return remove_import_file(file, encoding="ISO-8859-15")


IGNORED_IMPORT: List[Union[str, re.Pattern]] = [
    'gen.R',
]


def ignored_import(item) -> bool:
    for ignore in IGNORED_IMPORT:
        match: bool = True
        if isinstance(ignore, re.Pattern):
            if ignore.fullmatch(str(item).strip()) is None:
                match = False
        else:
            if str(item).strip() != str(ignore).strip():
                match = False
        if match:
            return True
    return False


def filter_ignored_imports(imports: List[str]) -> List[str]:
    return list(filter(lambda a: not ignored_import(a), imports))


def match_import(actual_imports: List[str], expected_imports: List[str]) -> List[str]:
    intersection = list()
    for imported_path in actual_imports:
        if imported_path in expected_imports:
            intersection.append(imported_path)
    return intersection
