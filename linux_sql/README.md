# Linux Cluster Monitoring Agent


## Introduction
The Linux cluster Monitoring agent project contains solutions and aids in the creation of infrastructure for the Jarvis Linux Cluster Administration(LCA) team in regards to server host monitoring. This infrastructure assists the team in examining host statistics and data usage. The monitoring agent servers will run on centOS 7 and will save host data (hardware specifications and resource use data) into the (RDBMS)Postgres Database every minute. The LCA team will be able to help servers in need by having records of each node and node monitoring systems.



- Technologies used in this project ;

     - Bash Scripts 
 
     - Docker
 
     - PostgresSQL Database 
 
     - Git / Github
 
    -  IntelliJ IDEA 


## Quick Start

- Start Docker if the server is not running 

```sudo systemctl status docker || sudo systemctl start docker```

- Start a psql instance using psql_docker.sh

```./psql_docker.sh create db_username db_password```

- Start/stop Postgres Container

```./psql_docker.sh start ```

```./psql_docker.sh stop ``` 

- Create tables using ddl.sql

``` psql -h localhost -U postgres -d host_agent -f sql/ddl.sql ```

- Insert hardware specs data into the DB

 ```./host_info.sh psql_host psql_port db_name psql_user psql_password ```
 
- Insert hardware usage data into the DB

```./host_usage.sh psql_host psql_port db_name psql_user psql_password ```

- Crontab setup

  Edit crontab file 
  
    ``` crontab -e ```
    
  Add this line in the file
  
  ``` * * * * * bash /<file Path>/host_usage.sh localhost 5432 host_agent postgres postgrepasword > /tmp/host_usage.log ```

## Architecture and Design

  Diagram below illustrates architecture of project. 

  ![image](https://user-images.githubusercontent.com/71332538/144785085-455e1873-5b24-4776-b698-a28eadac1400.png)


## Script Description

### psql_docker.sh

Utilises docker to set up a psql instance.It creates,starts,stops a docker container to operate the Postgres database.


```./psql_docker.sh create db_username db_password```

### host_info.sh

Collects hardware specification data.Unlike host_usage.h ,this script will only be run once and first because of constant parameters of hardware.

``` ./scripts/host_info.sh psql_host psql_port db_name psql_user psql_password ``

### host_usage.sh

Gathers usage information of running server and insert into host_usage table.Unlike host_info.sh ,this script needs to be executed every minuteby using Crontab.

```./host_usage.sh psql_host psql_port db_name psql_user psql_password ```

### ddl.sql

Contains create table statement to create host_info and host_usage if the tables are not exist.

### queries.sql

Includes queries to print some information to manage future improvements

### crontab

Contains special bash lines that allows to run host_usage.h script every minute.

 ``` * * * * * bash /<file Path>/host_usage.sh localhost 5432 host_agent postgres postgrepasword > /tmp/host_usage.log ```


### Deployment

The project deployed on Github from the JRD (jarvis Remote Desktop).Database managed by using Postgres Docker. Host agent timed controlled by the Crontab.

## Improvements

- Error Handling : Current script does not navigate when there is an error data extracting process.

- More SQL statements can be added to analyze some speifications.
