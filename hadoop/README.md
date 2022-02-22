Table of contents
* [Introduction](#Introduction)


# Introduction

The Hadoop project is an ongoing python data analytics project. The objective of this project is to improve Core Hadoop components such as HDFS, MapReduce, and YARN, which process large amounts of data provided by an analytics team. This Hadoop project will assist us in evaluating the Hadoop ecosystem and how it interacts with a distributed system for data storage and processing. Apache Hive and Zeppelin Notebook were used to handle the business problem. The Google Cloud Platform's data proc function enables the Hadoop cluster to use several machines to manage the 21 million dataset workload, which utilizes one master node and two worker nodes in the cluster and uses hive. Hive will allow using the cluster to do HQL statements.

  - Technologies used in this project ;

    - Apache Hadoop
  
    - Google Cloud Platform
  
    - Hive, YARN
  
    - Zeppelin

    - Git / Github





# Hadoop Cluster

Hadoop cluster created on the Google Cloud Platform that contains 1 master node and 2 worker nodes.


![image](https://i.imgur.com/N79j3I6.jpg)



- In this project,  a Hadoop cluster is set it up  on the Google Cloud Platform with 1 master node and 2 worker nodes. The hardware specifications ;

 - 1 master node , 2 worker nodes 
 - 2 vCPUs
 - 13GB RAM
 - 100GB of disk size.

 
- Big Data Tools 

     - MapReduce: MapReduce is a Hadoop programming pattern for processing large amounts of data stored in the Hadoop File System (HDFS). It is a vital feature of the Hadoop framework's operation. By splitting gigabytes into manageable bits and processing them in parallel on Hadoop compute nodes, MapReduce will make similar processing easier.
Also, it merges data from different servers and returns a compacted output to the application.

   - Hadoop Distributed File System (HDFS): HDFS is a distributed file system that runs on compute nodes and can handle massive data collections. It is used to scale a Hadoop cluster from a few nodes to hundreds of nodes. HDFS is one of Apache Hadoop's primary components, along with MapReduce and YARN.

   - Yet Another Resource Negotiator (YARN): It is cluster coordinating components of Hadoop that allows streaming, interactive, and graph processing of data stored in HDFS to be processed. YARN's Master/slave architecture, which involves Resource management and multiple Node managers, is mainly composed of Java virtual machines. The Resource Manager keeps track of the cluster's consumption while Node Managers gather usage data from its member nodes and report it to the Resource Manager. 

   - Hive: Apache Hive is an open-source data warehouse software designed for OLAP that enables schema in a database and processed data into HDFS. Hive provides us with SQL-type language for querying called HiveQL or HQL. Along with this, It is designed to convert HQL to MapReduce to make processes much easier by reducing the functions. Because Hive manages the metadata and does not store any data files.
   
   - Zeppelin: A  multi-purpose interactive UI that allows users to execute queries and display the result in a web-based notebook.




# Hive Project

![image](https://i.imgur.com/sLCYwEW.jpg)

# Improvements
- Adding more  and different nodes specifications to increase performance for hadoop cluster.
- Using Apache spark instead of Apache Tez to decrease runtime of the queries.

