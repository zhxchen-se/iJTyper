#!/usr/bin/env bash

readonly BINARY_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"


pushd "${BINARY_DIR}"

for I in 1 2 3 4 5
do
pushd "../"
make benchmark
if [[ $? -ne 0 ]] ; then
    exit 1
fi
popd
ZIP_NAME="benchmark-snapshot-$(printf '%(%y-%m-%d)T').zip"
./package_benchmark_results.bash
mv "${ZIP_NAME}" "${ZIP_NAME}-${I}"
done

popd
