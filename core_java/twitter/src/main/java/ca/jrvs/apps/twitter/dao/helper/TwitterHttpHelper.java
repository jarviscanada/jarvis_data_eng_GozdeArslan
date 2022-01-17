package ca.jrvs.apps.twitter.dao.helper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;


public class TwitterHttpHelper  implements HttpHelper{

    private OAuthConsumer consumer;
    private HttpClient httpClient;

    public TwitterHttpHelper(String consumerKey,String consumerSecret,String accessToken, String tokenSecret){

        //Setup Auth
        OAuthConsumer consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
        consumer.setTokenWithSecret(accessToken, tokenSecret);

        httpClient =new DefaultHttpClient();
    }

}
