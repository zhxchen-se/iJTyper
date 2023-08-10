#!/usr/bin/env bash

set -o pipefail
set -o nounset
set -o errexit
set -o xtrace

#expect
# COSTER path with model in COSTER/model dir. Expected to be named COSTER

#do
# benchmarks

readonly BINARY_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

if [ $# -gt 0 ]; then
  echo "Running with arguments: $0 $@"
else
  echo "Expect arguments $0 COSTER_dir"
  exit 1
fi
readonly COSTER_SOURCE=$1

readonly WORK_DIR="${BINARY_DIR}/benchmark_coster_work_dir"
rm -rf "${WORK_DIR}"
mkdir -p "${WORK_DIR}"

cp -r "${COSTER_SOURCE}" "${WORK_DIR}"

pushd "${WORK_DIR}"
mkdir "output"
pushd "output"
touch "so.csv"
popd
pushd "COSTER"
mvn package
cp -f target/COSTER-jar-with-dependencies.jar ./
java -jar COSTER-jar-with-dependencies.jar -f eval -e extrinsic \
    -r "${BINARY_DIR}/../../src/test/resources/snippets/so/" \
    -j "${BINARY_DIR}/../../src/test/resources/jars/so/" \
    -d "${WORK_DIR}/output/" \
    -t 1 -m model/ -c cosine -n levenshtein
popd
#../coster_csv_to_standard_csv.py -i "output/so.csv" > "standard.csv"
#../standard_csv_to_stats.py -i "standard.csv" -s ${BINARY_DIR}/../../src/test/resources/snippets/so/*
java -cp ${BINARY_DIR}/../../target/snr-server-0.0.1-SNAPSHOT.jar:${BINARY_DIR}/../../lib/*:${BINARY_DIR}/../../target/lib/* org.javelus.snr.toy.CheckCOSTERImport "${BINARY_DIR}/../../src/test/resources/snippets/so/" "${BINARY_DIR}/../../src/test/resources/jars/so/" "${WORK_DIR}/output/import_summary.csv" "${WORK_DIR}/fixed/"
${BINARY_DIR}/../count_compilable_code_snippets.py -i "${WORK_DIR}/fixed" -o "${WORK_DIR}/output/compile_result.csv"

