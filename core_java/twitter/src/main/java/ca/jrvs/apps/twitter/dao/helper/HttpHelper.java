package ca.jrvs.apps.twitter.dao.helper;



import org.apache.http.HttpResponse;

import java.net.URI;

public interface HttpHelper {
    //void TwitterHttpHelper(String consumerKey,String consumerSecret,String accessToken, String tokenSecret);

    HttpResponse httpPost(URI uri);

    HttpResponse httpGet(URI uri);
}
