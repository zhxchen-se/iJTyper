.PHONY: test benchmark databaseclean databasebuildso

package:
	echo package -Dmaven.test.skip=True

test: package
	echo test

benchmark: package
	cd benchmark && echo './run.bash' | ./set_env.bash

benchmarkdumb: package
	cd benchmark && echo 'SNR_DUMB_SOLVER="true" ./run.bash' | ./set_env.bash

databaseclean: package
	cd benchmark && echo 'mysql $${snr_database_name} -u $${snr_database_username} "-p$${snr_database_password}" < ../sql/create.sql' | ./set_env.bash

databasebuildso: package
	cd benchmark && echo './build_sql.bash' | ./set_env.bash

runcollectapielement: package
	java -cp ./target/snr-server-0.0.1-SNAPSHOT.jar:lib/*:target/lib/* org.javelus.snr.toy.CollectAPIElement ./src/test/resources/snippets/so/ ./src/test/resources/jars/so/

runcomparebindinganalysisandeclipse: package
	echo './benchmark/helpers/run_snr_comparebindinganalysisandeclipse.bash' | ./benchmark/set_env.bash
# 	echo 'java $${java_d_options} -cp ./target/snr-server-0.0.1-SNAPSHOT.jar:lib/*:target/lib/* org.javelus.snr.toy.CompareBindingAnalysisAndEclipse ./src/test/resources/snippets/so/ ./src/test/resources/jars/so/' | ./benchmark/set_env.bash

runcomparebindinganalysisandeclipsejdt: package
	echo 'java $${java_d_options} -cp ./target/snr-server-0.0.1-SNAPSHOT.jar:lib/*:target/lib/* org.javelus.snr.toy.CompareBindingAnalysisAndEclipseJDT "$${snr_snippets_folder}" "$${snr_library_external}" true false' | ./benchmark/set_env.bash

runcomparebindinganalysisandeclipsejdtdumb: package
	echo 'java $${java_d_options} -cp ./target/snr-server-0.0.1-SNAPSHOT.jar:lib/*:target/lib/* org.javelus.snr.toy.CompareBindingAnalysisAndEclipseJDT "$${snr_snippets_folder}" "$${snr_library_external}" true true' | ./benchmark/set_env.bash

# ex: make benchmarkcoster COSTER_PATH=../temp_dir/COSTER
# Gets coster raw and coster compilable raw
benchmarkcoster: package
	echo "./benchmark/helpers/benchmark_coster.bash ${COSTER_PATH}" | ./benchmark/set_env.bash

benchmarkcosterlib: package
	echo "./benchmark/helpers/benchmark_coster_lib_stat.bash ${COSTER_PATH}" | ./benchmark/set_env.bash

# Expect benchmarkcoster to be ran so that ${coster_stat_path} exists
runcheckcosterimport: package
	mkdir -p ./benchmark/helpers/benchmark_coster_work_dir/
	echo 'java -cp ./target/snr-server-0.0.1-SNAPSHOT.jar:lib/*:target/lib/* org.javelus.snr.toy.CheckCOSTERImport $${snr_snippets_folder} $${snr_library_external} ./benchmark/helpers/benchmark_coster_work_dir/output/import_summary.csv ./benchmark/helpers/benchmark_coster_work_dir/fixed/' | ./benchmark/set_env.bash
	echo './benchmark/count_compilable_code_snippets.py -i ./benchmark/helpers/benchmark_coster_work_dir/fixed/ -o ./benchmark/helpers/benchmark_coster_work_dir/output/compile_result.csv' | ./benchmark/set_env.bash

# Get coster api info
benchmarkcosterstat: package
	echo 'java -cp ./target/snr-server-0.0.1-SNAPSHOT.jar:lib/*:target/lib/* org.javelus.snr.toy.CalcCOSTERStats $${snr_snippets_folder} $${snr_library_external}' | ./benchmark/set_env.bash

countsolc:
	@echo 'printf "Android," & sloccount $${snr_snippets_folder}/Android*.java 2>&1 | grep "java=" | cut -f1 -d" "' | ./benchmark/set_env.bash
	@echo 'printf "JDK," & sloccount $${snr_snippets_folder}/Class_*.java 2>&1 | grep "java=" | cut -f1 -d" "' | ./benchmark/set_env.bash
	@echo 'printf "GWT," & sloccount $${snr_snippets_folder}/gwt_class_*.java 2>&1 | grep "java=" | cut -f1 -d" "' | ./benchmark/set_env.bash
	@echo 'printf "Hibernate," & sloccount $${snr_snippets_folder}/hibernate_class_*.java 2>&1 | grep "java=" | cut -f1 -d" "' | ./benchmark/set_env.bash
	@echo 'printf "JodaTime," & sloccount $${snr_snippets_folder}/JodaTime*.java 2>&1 | grep "java=" | cut -f1 -d" "' | ./benchmark/set_env.bash
	@echo 'printf "XStream," & sloccount $${snr_snippets_folder}/xstream_class_*.java 2>&1 | grep "java=" | cut -f1 -d" "' | ./benchmark/set_env.bash

countsolcfile:
	sloccount --wide --details $${snr_snippets_folder}/*

genbenchmarklibgolden:
	echo 'benchmark/gen_benchmark_lib_golden.py -i $${snr_snippets_folder} -o $${stattype_so_lib_gold_path}' | ./benchmark/set_env.bash

starttestserver:
	echo 'echo spring-boot:run -Dspring-boot.run.jvmArguments="$${java_d_options}"' | ./benchmark/set_env.bash
