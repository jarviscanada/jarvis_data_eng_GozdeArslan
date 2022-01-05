
Introduction

Discuss the design of each app. What does the app do? What technologies have you used? (e.g. core java, libraries, lambda, IDE, docker, etc..)
The Project design of application to search matching strings within the files by using grep commands.The grep commands will be able to read and write the files
in the file directory.Searching the patterns that is done by regular expressions write the results to an output file in the root directory.

- Technologies used in this project ;

    - JAVA (Basics, stream APIs,Collections and Regex)

    - Docker( To run app within container)

    - Maven (build automation tool for JAVA)

    - Git / Github 

    - IntelliJ IDEA     



# Quick Start
How to use your apps?

Application uses three command line arguments ; [regex] [rootDirectory] [outfile] 

Run Application with Docker

- Make sure Docker Container running.

``` docker run --rm \ -v `pwd`/data:/data -v `pwd`/log:/log \ ${docker_user}/grep [regex] [rootDirectory] [outfile] ```

Application Run with JAR file 

``` java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp [regex] [rootDirectory] [outfile] ```

Example run :

```java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp \ .*Romeo.*Juliet.* ./data ./out/grep.txt```

Application Run with additional JVM options

``` java -Xms5m -Xmx5m \-cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp [regex] [rootDirectory] [outfile] ```


#Implemenation
Java Grep Application 

## Pseudocode

`process` method pseudocode.

 matchedLines = [] 
for file in listFilesRecursively(rootDir)
for line in readLines(file)
if containsPattern(line)
matchedLines.add(line)
writeToFile(matchedLines) ```



## Performance Issue
(30-60 words)
Discuss the memory issue and how would you fix it

# Test
How did you test your application manually? (e.g. prepare sample data, run some test cases manually, compare result)

To test application ,There is an instance file that is includes lines of text (Shakespeare.txt).The application reads the lines by using java grep method called readLines. Along with this ,The instance output file used to write out results in to Output file includes matched lines by using application methods.


# Deployment
How you dockerize your app for easier distribution?

Application Dockerized by using Docker image. Creting docker file allows us to carry openjdk:8-alpine configurations that will copy from JAR file and creates entry point configurations.


# Improvement
1-
2-



