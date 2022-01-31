
# Introduction
The Twitter CRUD application allows the user to post , view, and delete tweets. Along with this HttpClient and OAuth (V1.0 )credentials will help to create transmission with the Twitter REST API. This transmission will  receive tweet requests.
 Using the Twitter application's Commands , user will be able to apply CRUD operations such as, posting , deleting or querying a tweet. The Application is deployed on a Docker container or can be executed by the command line. The package management handled by the Maven and third-party Java libraries.

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

Set up the environment variables used for authorization with twitter

Application uses four environment to authorization with twitter; consumerKey, consumerSecret, accessToken, tokenSecret
To package app using Maven:

Run the command ```mvn clean package -Dmaven.test.skip=true```

To package app using Docker:

 -Pull docker image:
        ```  docker pull gzarslan/twitter```
          
           
 -Example Usage to run Docker container :

 -Post tweets

 ```docker run --rm \ -e consumerKey=CONSUMER_KEY \ -e consumerSecret=CONSUMER_SECRET \ -e accessToken=ACCESS_TOKEN \ -e tokenSecret=ACCESS_TOKEN_SECRET \ $ gzarslan\twitter  post "tweet_text" latitude:longitude```

 -Show tweets
 ```docker run --rm \ -e consumerKey=CONSUMER_KEY \ -e consumerSecret=CONSUMER_SECRET \ -e accessToken=ACCESS_TOKEN \ -e tokenSecret=ACCESS_TOKEN_SECRET \ $ gzarslan\twitter  show tweet_id [field1, field2]```

 -Delete tweets
 ```docker run --rm \ -e consumerKey=CONSUMER_KEY \ -e consumerSecret=CONSUMER_SECRET \ -e accessToken=ACCESS_TOKEN \ -e tokenSecret=ACCESS_TOKEN_SECRET \ gzarslan\twitter  delete [tweetId1,tweetId2,..]```

# Implementation


Java Twitter CRUD Application
The application implemented by using MVC design. it represents multiple layers that are Controller ,Service ,DAO(Data Access Object) layer.

##APP - MAIN




##Controller

The TwitterController object controls if the all required arguments have been passed to the program and then calls the service layer.

##Service

The service layer will handle the business logic of the application.  The process will be done by checking the length of the tweets are correct , also it will verify that the longitude and latitude are correct. It will call the DAO layer afterwards.

##DAO

The Data Access Objects will extract the necessary data, and communicates with the data source.The Dao object will create the Rest-API that will check the required functionality per the correct format required by the Twitter. It calls the HTTP methods using the Helper object of Twitter.

##MODELS

Data model of the Tweet object contains subtypes of data fields are used by Twitter's API to store information. It mainly uses  Twitter's Data Dictionary v1.1  concept:  https://developer.twitter.com/en/docs/twitter-api/v1/data-dictionary/object-model/tweet

The Models in the Twitter API:

Tweet object contains Tweet object, contains Entities, Coordinates objects.

Entities object contains Entities object, contains hashtags and user_mentions objects

Hashtags contain Hashtags object

UserMentions contains user_mentions object

Coordinates contain coordinates object

##SPRING
The framework of Spring was utilised to manage dependencies by using Maven. Classes were annotated with @Component, @controller, @service and @repository  that flags to indicate the Beans to the Inversion of Control container. Lastly, once Spring injects the dependencies , application can run with SpringBoot.


# Test
JUnit version 4 was used for integration testing of the various application layers.Instead of executing actual Twitter API calls, which required genuine Twitter keys, the Mockito Framework was utilised to test unit testing using mock objects.

# Deployment

Application Dockerized by using Docker image. Creating docker file allows us to carry openjdk:8-alpine configurations that will deploy java code which packaged by maven  into docker image.


# Improvement

1-Add more method to pull tweets between given dates.
2-Cam improve to part that will allow us to comment under our tweet.
3.Implement more functionality to post such as picture.



