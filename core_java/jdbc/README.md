# Introduction


The java database connection application enables a connection between a Java program and a relational database management system (RDBMS).It uses DAO and Repository architectural patterns, as well as certain advanced JDBC principles.

- Technologies used in this Application ;

  - JAVA

  - Docker( To run app within container)

  - Maven (build automation tool for JAVA)

  - Git / Github

  - IntelliJ IDEA

  - PSQL

  - DBeaver(ER Diagram)

# Implementaiton
## ER Diagram


![image](https://i.imgur.com/xqxU016.png)

## Design Patterns

The DAO(Data Access Object) is pattern that separates low level API operations from Business/Applications operations.
.The domain model of the application to be fully independent of the database.Therefore, designing a simple DAO class will keep these components neatly isolated from one another.
On the other hand, Repository design patterns deals with data and hides requests.However, at a higher level, closer to an app's stored procedures. Database access Object can be used by a repository to retrieve data from a database and create a domain object. It can also use a DAO to prepare data from a domain object and transfer it to a storage system for persistence.


# Test
The application tested using Docker container and Postgres SQL database.The docker container runs the postgres database that is includes all the tables which is used in the application(customer,salesperson,products etc.).Along with this all the tables created by the sql scripts that involves in the project directory.
All the application data used to test application methods and DAO manipulations.
