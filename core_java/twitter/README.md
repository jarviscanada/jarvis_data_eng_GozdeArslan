
# Introduction

The CRUD application for Twitter allows users to create, read, and remove tweets. Along with this, HttpClient and OAuth (V1.0)credentials will aid in the creation of Twitter REST API communication. Requests for tweets will be sent to this communication.  The user will be able to do CRUD activities such as posting, deleting, and querying a tweet using the Twitter application's Commands. The application can be run from the command line or via a Docker container. Maven and third-party Java libraries are in charge of package management.

- Technologies used in this project ;

    - JAVA (stream APIs,Collections)

    - Junit - Mockito

    - SpringBoot

    - Docker(To run app within container)

    - Jackson -JSON

    - Maven (build automation tool for JAVA)

    - Git / Github

    - IntelliJ IDEA



# Quick Start

Set up the environment variables used for authorization with Twitter

The application uses four environments to authorization with Twitter; consumerKey, consumerSecret, accessToken, tokenSecret
To package app using Maven:

Run the command ```mvn clean package -Dmaven.test.skip=true```

To package app using Docker:

-Pull docker image:
```  docker pull gzarslan/twitter```


-Example Usage to run Docker container :

   ##### Post tweets

```docker run --rm \ -e consumerKey=CONSUMER_KEY \ -e consumerSecret=CONSUMER_SECRET \ -e accessToken=ACCESS_TOKEN \ -e tokenSecret=ACCESS_TOKEN_SECRET \ $ gzarslan\twitter  post "tweet_text" latitude:longitude```

  ##### Show tweets

```docker run --rm \ -e consumerKey=CONSUMER_KEY \ -e consumerSecret=CONSUMER_SECRET \ -e accessToken=ACCESS_TOKEN \ -e tokenSecret=ACCESS_TOKEN_SECRET \ $ gzarslan\twitter  show tweet_id [field1, field2]```

  ##### Delete tweets

```docker run --rm \ -e consumerKey=CONSUMER_KEY \ -e consumerSecret=CONSUMER_SECRET \ -e accessToken=ACCESS_TOKEN \ -e tokenSecret=ACCESS_TOKEN_SECRET \ gzarslan\twitter  delete [tweetId1,tweetId2,..]```

# Implementation


Java Twitter CRUD Application
The application is implemented by using the MVC design. It represents multiple layers that are Controller, Service, Helper, and DAO(Data Access Object) layer.


## Design

### UML diagram

![Uml](https://i.imgur.com/F4O9OgZ.png)

### APP - MAIN

### Controller

#### TwitterController

The TwitterController object controls if all required arguments have been passed and parsed properly (CLI args) to the program and then calls the service layer.


## Service

#### TwitterService

The service layer will handle the business logic of the application.  The process will be done by checking the length of the tweets are correct, also it will verify that the longitude and latitude are correct. It will call the DAO layer afterward.

## DAO

#### TwitterDAO

The Data Access Objects will extract the necessary data and communicate with the data source (implemented with POJOs). The Dao object will create the Rest-API that will check the required functionality per the correct format required by Twitter. It calls the HTTP methods using the Helper object of Twitter. Along with this, the Dao object does not handle business logic.

## Models
The Tweet object's data model has subtypes of data fields that Twitter's API uses to store information. It primarily utilizes the Data Dictionary v1.1 concept via Twitter: https://developer.twitter.com/en/docs/twitter-api/v1/data-dictionary/object-model/tweet

The Models in the Twitter API:

Tweet object model contains  ;

- Tweet

- Contains

- Entities

- Coordinates

- Hashtag

- User mention

Entities object contains Entities object, contains hashtags and user_mentions objects

Hashtags contain Hashtags object

UserMentions contains user_mentions object

Coordinates contain coordinates object

#### Object model sample
 ```
 {
  "created_at" : "Fri Jun 26 17:32:16 +0000 2020",
  "id" : 1276568976764686343,
  "id_str" : "1276568976764686343",
  "text" : "test post",
  "entities" : {
    "hashtags" : [ ],
    "user_mentions" : [ ]
  },
  "coordinates" : {
    "coordinates" : [ 40.0, 23.0 ],
    "type" : "Point"
  },
  "retweet_count" : 0,
  "favourite_count" : 0,
  "favourited" : false,
  "retweeted" : false
}
```

## SPRING

Maven had been used to manage dependencies using the Spring framework. @Component, @controller, @service, and @repository were used as annotations to signal the Beans to the Inversion of Control container. Ultimately, once Spring has injected the dependencies, SpringBoot can be used to execute the application.


## Test

#### Integration Test

JUnit was used for integration testing of the various application layers such as DAO, Service, Controller for the Twitter class implementations.

#### Unit Test
 Instead of using original Twitter keys to execute actual Twitter API calls, the Mockito Framework was used to validate unit testing using mock objects.

## Deployment

Application Dockerized by using Docker image. Creating a docker file allows us to carry openjdk:8-alpine configurations that will deploy java code packaged by maven into a docker image.  Verified image pushed to the docker hub.


## Improvement

1-Add more methods to pull tweets between given dates.
2-Cam improve to the part that will allow us to comment under our tweet.
3. Implement more functionality to post such as a picture.



