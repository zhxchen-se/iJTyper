#!/usr/bin/env bash


mysql snr -u snr "-p${snr_database_password}" < ../sql/create.sql
java -Dsnr.database.url="${snr_database_url}" -Dsnr.database.username="${snr_database_username}" -Dsnr.database.password="${snr_database_password}" -Dsnr.library.private.skip="${snr_library_private_skip}" -Dsnr.library.class.protected.skip="${snr_library_class_protected_skip}" -cp ../target/snr-server-0.0.1-SNAPSHOT.jar:../lib/*:../target/lib/* org.javelus.snr.mrb.JarRepoBuilder "${JAVA_RT_JAR_PATH}" "openjdk:jdk:1.8.0"
./build_maven_jar_repo.py -j -ja snr.library.private.skip=${snr_library_private_skip} snr.library.class.protected.skip=${snr_library_class_protected_skip} -l "${snr_library_external}"
