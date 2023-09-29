#!/usr/bin/env bash

set -o pipefail
set -o nounset
set -o errexit
#set -o xtrace

readonly SOURCE_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd ${SOURCE_DIR}/../

docker ps --filter "status=exited" | \
    grep 'snr' | \
    awk '{print $1}' | \
    xargs --no-run-if-empty docker rm
