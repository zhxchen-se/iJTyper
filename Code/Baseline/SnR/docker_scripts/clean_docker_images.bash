#!/usr/bin/env bash

set -o pipefail
set -o nounset
set -o errexit
#set -o xtrace

readonly SOURCE_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd ${SOURCE_DIR}/../

docker image prune
