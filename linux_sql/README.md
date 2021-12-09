# Linux Cluster Monitoring Agent


## Introduction
The Linux cluster Monitoring agent project contains solutions in the creation of infrastructure for the Jarvis Linux Cluster Administration(LCA) team in regards to server host monitoring. This infrastructure assists the team in examining host statistics and data usage. The monitoring agent servers will run on centOS 7 and will save host data (hardware specifications and resource use data) into the (RDBMS) Postgres Database every minute(Crontab). The LCA (Jarvis Linux Cluster Administration) team will be able to help servers in need by having records of each node and node monitoring systems.


- Technologies used in this project ;

    - Bash Scripts

    - Docker

    - PostgresSQL Database

    - Git / Github

    - IntelliJ IDEA


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

## Implementation

The project is implemented by using the technologies mentioned above(Docker, Postgres, IDE, Bash scripts, git). It will be using Jarvis Remote Desktop to run our project. The Bash scripts will create a Docker container instance that will also pull the Postgres database. Along with this, the docker will be created a project data volume that will allow us to persist data from the container. To persist data we will be querying the hardware information by using bash scripts. SQL scripts will create tables to hold values that are queried by the bash scripts. After storing data,  it will be extracting information from the database that will help the LCA team for analysis.

## Architecture and Design

Diagram below illustrates architecture of project.

![image](https://user-images.githubusercontent.com/71332538/144785085-455e1873-5b24-4776-b698-a28eadac1400.png)


## Script Description


### psql_docker.sh

Utilises docker to set up a psql instance.It creates,starts,stops a docker container to operate the Postgres database.

#### Usage

```./psql_docker.sh create db_username db_password```

### host_info.sh

Collects hardware specification data.Unlike host_usage.h ,this script will only be run once and first because of constant parameters of hardware.

#### Usage

``` ./scripts/host_info.sh psql_host psql_port db_name psql_user psql_password ```

### host_usage.sh

Gathers usage information of running server and insert into host_usage table.Unlike host_info.sh ,this script needs to be executed every minuteby using Crontab.

#### Usage

```./host_usage.sh psql_host psql_port db_name psql_user psql_password ```

### ddl.sql

Contains create table statement to create host_info and host_usage if the tables are not exist.

#### Usage

``` ``` psql -h localhost -U postgres -d host_agent -f sql/ddl.sql ```

### queries.sql

Includes queries to print some information to manage future improvements


### crontab

Contains special bash lines that allows to run host_usage.h script every minute.

#### Usage

``` * * * * * bash /<file Path>/host_usage.sh localhost 5432 host_agent postgres postgrepasword > /tmp/host_usage.log ```

## Database Modeling

The host_agent database in our container comprises two tables: host info and host usage. If these tables do not exist, they will be created. The hardware specifications (id, hostname,CPU number, etc.) will be stored in the host info table. The primary key will be "id," and fields will not be allowed to have null values. In addition, the host usage table contains hardware usage data (host id, CPU idle, memory-free, etc.) that cannot have null values. Because the Relational database modeling structure is used, the foreign and primary key will be host id.The tables below illustrate data fields in each table.


Host information table shows hardware specifications data;

![image](https://user-images.githubusercontent.com/71332538/145319985-23748dbf-e6e3-41c7-b3d8-86ab3a50aad5.png)

   

 Host Usage table shows resource usage data;

![image](https://user-images.githubusercontent.com/71332538/145320009-8ab119f9-fb67-464f-9672-9db222126e90.png)

   


## Testing

The application runs on a single machine rather than a Linux cluster. Along with this, if the connection and firewalls are configured appropriately, It will also work in a clustering stage. Bash scripts tested on the Jarvis Remote Desktop were run on CentOS 7. They were successfully sended the information (hardware specifications and resource use data) into the Database.

## Deployment

The project source code deployed on Github from the JRD (Jarvis Remote Desktop).Database managed by using Postgres Docker. Host agent timed controlled by the Crontab.

## Improvements

- Error Handling : Current script does not navigate when there is an error data extracting process.

- More SQL statements can be added to analyze some parameters or specifications.


