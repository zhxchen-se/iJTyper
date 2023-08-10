#!/usr/bin/env bash

set -o pipefail
set -o nounset
set -o errexit
set -o xtrace

#expect
# StatType path with patch

#do
# get golden file

readonly BINARY_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

if [ $# -gt 0 ]; then
  echo "Running with arguments: $0 $@"
else
  echo "Expect arguments $0 StatType_dir"
  exit 1
fi
readonly StatType_SOURCE=$1

readonly WORK_DIR="${BINARY_DIR}/benchmark_stattype_work_dir"
rm -rf "${WORK_DIR}"
mkdir -p "${WORK_DIR}"

cp -r "${StatType_SOURCE}" "${WORK_DIR}"

pushd "${WORK_DIR}"
mkdir "output"
pushd "TypeResolutionParser"
mkdir -p ./T:/type-resolution/
mvn compile
mvn -q exec:java \
    -Dexec.mainClass="dictionary.ExtractEntitySignature" \
    -Dexec.args="${BINARY_DIR}/../../src/test/resources/jars/so" > "../output/create_dict_temp_output"
mvn -q exec:java \
    -Dexec.mainClass="baker.TestSequenceGenerator" \
    -Dexec.args="${BINARY_DIR}/../../src/test/resources/snippets/so ./T:/type-resolution ${BINARY_DIR}/../../src/test/resources/jars/so ../output/generatedbakersequence-android android" > "../output/baker_temp_output_android"
mvn -q exec:java \
    -Dexec.mainClass="baker.TestSequenceGenerator" \
    -Dexec.args="${BINARY_DIR}/../../src/test/resources/snippets/so ./T:/type-resolution ${BINARY_DIR}/../../src/test/resources/jars/so ../output/generatedbakersequence-gwt gwt" > "../output/baker_temp_output_gwt"
mvn -q exec:java \
    -Dexec.mainClass="baker.TestSequenceGenerator" \
    -Dexec.args="${BINARY_DIR}/../../src/test/resources/snippets/so ./T:/type-resolution ${BINARY_DIR}/../../src/test/resources/jars/so ../output/generatedbakersequence-hibernate hibernate" > "../output/baker_temp_output_hibernate"
mvn -q exec:java \
    -Dexec.mainClass="baker.TestSequenceGenerator" \
    -Dexec.args="${BINARY_DIR}/../../src/test/resources/snippets/so ./T:/type-resolution ${BINARY_DIR}/../../src/test/resources/jars/so ../output/generatedbakersequence-joda joda" > "../output/baker_temp_output_joda"
mvn -q exec:java \
    -Dexec.mainClass="baker.TestSequenceGenerator" \
    -Dexec.args="${BINARY_DIR}/../../src/test/resources/snippets/so ./T:/type-resolution ${BINARY_DIR}/../../src/test/resources/jars/so ../output/generatedbakersequence-xtream xstream" > "../output/baker_temp_output_xstream"
mvn -q exec:java \
    -Dexec.mainClass="baker.TestSequenceGenerator" \
    -Dexec.args="${BINARY_DIR}/../../src/test/resources/snippets/jdk ./T:/type-resolution ${BINARY_DIR}/../../src/test/resources/jars/so ../output/generatedbakersequence-java java" > "../output/baker_temp_output_java"
# This code did something. But was not what we wanted.
#expect
# StatType path with patched tests/misc/TestTypeResolution.java to take in java source and jar
#   and compiled so there's a target/test-classes dir present.
#   idk how to do it with command line with this pom and not standard maven directory structure.
#   Had to get intellij to do it for me

#diff --git a/tests/misc/TestTypeResolution.java b/tests/misc/TestTypeResolution.java
#index 51c4fdd..5442b80 100644
#--- a/tests/misc/TestTypeResolution.java
#+++ b/tests/misc/TestTypeResolution.java
#@@ -17,8 +17,8 @@ public class TestTypeResolution {
#
#        public static void main(String[] args) {
#                HashSet<String> sourcePaths = new HashSet<>(), jarPaths = new HashSet<>();
#-               getSourcePaths(new File("D:/Projects/TypeResolution_Oracle/src/androidExamples/Android39.java"), sourcePaths, ".java");
#-               getSourcePaths(new File("D:/Projects/TypeResolution_Oracle/lib"), jarPaths, ".jar");
#+               getSourcePaths(new File(args[0]), sourcePaths, ".java");
#+               getSourcePaths(new File(args[1]), jarPaths, ".jar");
#                @SuppressWarnings("rawtypes")
#                Map options = JavaCore.getOptions();
#                options.put(JavaCore.COMPILER_COMPLIANCE, JavaCore.VERSION_1_8);
#for f in ${BINARY_DIR}/../../src/test/resources/snippets/so/*.java; do
#  mvn -q exec:java \
#      -Dexec.classpathScope="test" \
#      -Dexec.mainClass="misc.TestTypeResolution" \
#      -Dexec.args="${f} ${BINARY_DIR}/../../src/test/resources/jars/so" > "../output/temp_output"
#  sed -e "s/^/$(basename ${f}),/" "../output/temp_output" >> "../standard.csv"
#done
###### End comment
popd

