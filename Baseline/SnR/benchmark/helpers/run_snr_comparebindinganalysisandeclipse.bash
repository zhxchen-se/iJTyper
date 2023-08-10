#!/usr/bin/env bash

set -o pipefail
set -o nounset
set -o errexit
set -o xtrace

#expect
# Env to be set

#do
# benchmarks

readonly BINARY_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

cd "${BINARY_DIR}/../../"
readonly WORK_DIR="${BINARY_DIR}/benchmark_snr_work_dir"
rm -rf "${WORK_DIR}"
mkdir -p "${WORK_DIR}"
java ${java_d_options} -cp ./target/snr-server-0.0.1-SNAPSHOT.jar:lib/*:target/lib/* org.javelus.snr.toy.CompareBindingAnalysisAndEclipse "${snr_snippets_folder}" "${snr_library_external}" "${WORK_DIR}/output_all.txt" true
