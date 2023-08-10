## How to run (for snr developers)

### Compile
```shell script
mvn package
```

### Build database

#### Sql 
Run `sql/create.sql`

#### Add java runtime jar
```shell script
# Build Project
# Run JarRepoBuilder (assuming ${JAVA_HOME} is set to location of openjdk8)
java -cp target/${snr-server.jar}:target/lib/*:lib/* org.javelus.snr.mrb.JarRepoBuilder "${JAVA_HOME}/lib/rt.jar" "openjdk:jdk:1.8.0"
```
##### example:  
```shell script
java -Dsnr.database.url="jdbc:mysql://127.0.0.1:3306/snr?&serverTimezone=UTC" -Dsnr.database.username="snr" -Dsnr.database.password="SnR123456*" -cp ./target/snr-server-0.0.1-SNAPSHOT.jar:./lib/*:./target/lib/* org.javelus.snr.mrb.JarRepoBuilder "/usr/lib/jvm/jre-1.8.0/lib/rt.jar" "openjdk:jdk:1.8.0"
```

#### Add CSNIPPEX dataset
Get the dataset from `http://sccpu2.cse.ust.hk/csnippex/index.html`
```shell script
wget http://sccpu2.cse.ust.hk/csnippex/files/CsnippexDataSetAnalysis.zip
```
Unzip the dataset  
Run MavenJarRepoBuilder
```shell script
java -cp target/${snr-server.jar}:target/lib/*:lib/* org.javelus.snr.mrb.MavenJarRepoBuilder "${CsnippexDataSetAnalysis_unziped_folder}/CsnippexDataSetAnalysis/libs"
```
MavenJarRepoBuilder expects jar files with `META-INF/maven/**/pom.xml` with `version`, `artifactId`, and `groupId`.  
  
##### example:  
```shell script
java -Dsnr.database.url="jdbc:mysql://127.0.0.1:3306/snr?&serverTimezone=UTC" -Dsnr.database.username="snr" -Dsnr.database.password="SnR123456*" -cp target/snr-server-0.0.1-SNAPSHOT.jar:target/lib/*:lib/* org.javelus.snr.mrb.MavenJarRepoBuilder "../csnippex/CsnippexDataSetAnalysis/libs" 
```

#### Add maven jars
```shell script
java -cp target/${snr-server.jar}:target/lib/*:lib/* org.javelus.snr.mrb.MavenRepoBuilder "<groupId>:<artifactId>[:<extension>[:<classifier>]]:<version>"
```
com.gemstone.gemfire:gemfire:jar:7.0.2 need manual intervention to be grabbed from https://repo.spring.io/plugins-release/

Actually lets just grab all the jars from https://repo.spring.io/plugins-release/ maybe do a rerun on https://repo1.maven.org/maven2/ for the failed stuff.
##### example:  
```shell script
java -Dsnr.database.url="jdbc:mysql://127.0.0.1:3306/snr?&serverTimezone=UTC" -Dsnr.database.username="snr" -Dsnr.database.password="SnR123456*" -cp target/snr-server-0.0.1-SNAPSHOT.jar:target/lib/*:lib/* org.javelus.snr.mrb.MavenRepoBuilder "com.gemstone.gemfire:gemfire:jar:7.0.2" 
```


### Start spring-boot server with somewhat default database config
```shell script
mvn spring-boot:run "-Dspring-boot.run.jvmArguments=-Dsnr.database.url=\"jdbc:mysql://127.0.0.1:3306/snr?&serverTimezone=UTC\" -Dsnr.database.username=\"snr\" -Dsnr.database.password=\"SnR123456*\""
```


## Running COSTER
git clone https://github.com/khaledkucse/COSTER
Download Data from http://bit.ly/costerData
Download model from http://bit.ly/costerModel
Obtain data from COSTER author
