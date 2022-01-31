# Introduction


The java database connection application enables a connection between a Java program and a relational database management system (RDBMS). It uses DAO and Repository architectural patterns, as well as certain advanced JDBC principles.

- Technologies used in this Application ;

  - JAVA

  - Docker( To run app within container)

  - Maven (build automation tool for JAVA)

  - Git / Github

  - IntelliJ IDEA

  - PSQL

  - DBeaver(ER Diagram)

  - IntelliJ IDEA
  
  - PSQL
  
  - DBeaver(ER Diagram)
  

# Implementaiton
## ER Diagram


![image](https://i.imgur.com/xqxU016.png)

## Design Patterns

The DAO(Data Access Object) is a pattern that separates low-level API operations from Business/Applications operations. The domain model of the application is to be fully independent of the database. Therefore, designing a simple DAO class will keep these components neatly isolated from one another. On the other hand, Repository design patterns deal with data and hide requests. However, at a higher level, closer to an app's stored procedures. Database access Object can be used by a repository to retrieve data from a database and create a domain object. It can also use a DAO to prepare data from a domain object and transfer it to a storage system for persistence.


## Test
The application was tested using the Docker container and Postgres SQL database. The docker container runs the Postgres database that includes all the tables which are used in the application(customer, salesperson, products, etc.).Along with this, all the tables are created by the SQL scripts that involves in the project directory.
All the application data was used to test application methods and DAO manipulations.
