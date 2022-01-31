
# Introduction
The Project design of the application to search matching strings within the files by using grep commands. The grep commands will be able to read and write the files in the file directory. Searching the patterns that are done by regular expressions write the results to an output file in the root directory.

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


# Implementation


Java Grep Application


# Pseudocode

- `process` method pseudocode.




         matchedLines = []
        
         for file in listFilesRecursively(rootDir)
      
                for line in readLines(file)
                
                 if containsPattern(line)
                 
                         matchedLines.add(line)
                         
                            writeToFile(matchedLines)




# Test

To test the application, There is an instance file that includes lines of text (Shakespeare.txt). The application reads the lines by using the java grep method called readLines. Along with this, The instance output file used to write out results into the output file includes matched lines by using application methods.


# Deployment

Application Dockerized by using Docker image. Creating a Docker file allows us to carry openjdk:8-alpine configurations that will copy from the JAR file and create entry point configurations.


# Improvement

1-Use Java Stream APIs in the implementation rather than using java collections for more efficient memory management.

2-Use more and proper lambda implementation.

3-Flexible search methods can implement such as searching and replacing patterns.


