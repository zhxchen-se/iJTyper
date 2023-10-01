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

readonly WORK_DIR="${BINARY_DIR}/golden_coster_work_dir"
rm -rf "${WORK_DIR}"
mkdir -p "${WORK_DIR}"

cp -r "${COSTER_SOURCE}" "${WORK_DIR}"

pushd "${WORK_DIR}"
mkdir "output"
pushd "output"
touch "so.csv"
popd
pushd "COSTER"
mvn clean
rm -f COSTER.jar
mvn assembly:single
#mv target/COSTER-jar-with-dependencies.jar ./COSTER.jar
mvn package
mv target/COSTER.jar ./COSTER.jar
java -cp COSTER.jar:target/COSTER-jar-with-dependencies.jar org.usask.srlab.coster.COSTER -f eval -e extrinsic \
    -r "${BINARY_DIR}/../../src/test/resources/snippets/so/" \
    -j "${BINARY_DIR}/../../src/test/resources/jars/so/" \
    -d "${WORK_DIR}/output/" \
    -t 1 -m model/ -c cosine -n levenshtein | tee ../output/coster_log.txt
popd
#../coster_csv_to_standard_csv.py -i "output/so.csv" > "standard.csv"
#../standard_csv_to_stats.py -i "standard.csv" -s ${BINARY_DIR}/../../src/test/resources/snippets/so/*

