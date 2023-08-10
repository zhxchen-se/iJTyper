#!/usr/bin/env bash

readonly BINARY_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

export JAVA_RT_JAR_PATH="/usr/lib/jvm/java-1.8.0-openjdk-amd64/jre/lib/rt.jar"

export coster_stat_path="${BINARY_DIR}/helpers/benchmark_coster_work_dir/output/coster_stat.csv"
export stattype_so_lib_gold_path="${BINARY_DIR}/benchmark_lib_golden.json"
export snr_database_name='snr'
export snr_database_url="jdbc:mariadb://127.0.0.1:3306/${snr_database_name}?&serverTimezone=UTC"
export snr_database_username=snr
export snr_database_password='SnR123456*'
export snr_library_external="${BINARY_DIR}/../src/test/resources/jars/"
export snr_library_private_skip='True'
export snr_library_class_protected_skip='True'
export snr_snippets="${BINARY_DIR}/../src/test/resources/snippets/so/*"
export snr_snippets_folder="${BINARY_DIR}/../src/test/resources/snippets/so/"
export snr_souffle_solver_path="${BINARY_DIR}/../souffle/dependency"
java_d_options="-Dsnr.database.url=${snr_database_url} "
java_d_options+="-Dsnr.database.username=${snr_database_username} "
java_d_options+="-Dsnr.database.password=${snr_database_password} "
java_d_options+="-Dsnr.library.external=${snr_library_external} "
java_d_options+="-Dsnr.library.private.skip=${snr_library_private_skip} "
java_d_options+="-Dsnr.library.class.protected.skip=${snr_library_class_protected_skip} "
java_d_options+="-Dsnr.solver=souffle " # options include souffle, brute, baker
java_d_options+="-Dsnr.souffle.solver.path=${snr_souffle_solver_path} "
export java_d_options

bash
