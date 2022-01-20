package ca.jrvs.apps.twitter.dao.helper;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.net.URI;



class TwitterHttpHelperTest {


@Test
     public void httpGet() throws Exception{


    String consumerKey =System.getenv("consumerKey");
    String consumerSecret =System.getenv("consumerSecret");
    String accessToken =System.getenv("accessToken");
    String tokenSecret =System.getenv("tokenSecret");
    HttpHelper httpHelper=new TwitterHttpHelper(consumerKey,consumerSecret,accessToken,tokenSecret);
    HttpResponse response =httpHelper.httpGet(new URI("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=Gzdea90857396"));
    System.out.println(EntityUtils.toString(response.getEntity()));

}

}