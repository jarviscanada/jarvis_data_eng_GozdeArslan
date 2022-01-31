package ca.jrvs.apps.twitter.dao.helper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SuppressWarnings("Duplicates")

@Component
public class TwitterHttpHelper implements HttpHelper {

    private  OAuthConsumer consumer;
    private  HttpClient httpClient;



    public TwitterHttpHelper(String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {

        //Setup Authentication
        consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
        consumer.setTokenWithSecret(accessToken, tokenSecret);
        httpClient = HttpClientBuilder.create().build();

    }




    @Override
    public HttpResponse httpPost(URI uri) {
        try {

            return getHttpRequest(HttpMethod.POST, uri, null);
        } catch (OAuthException | IOException e) {

            throw new RuntimeException("Failed to execute", e);
        }

    }




    @Override
    public HttpResponse httpGet(URI uri) {
        try {

            return getHttpRequest(HttpMethod.GET, uri, null);
        } catch (OAuthException | IOException e) {

            throw new RuntimeException("Failed to execute", e);
        }

    }

    public  HttpResponse getHttpRequest(HttpMethod method, URI uri, StringEntity stringEntity)
            throws OAuthException, IOException {
        if (method == HttpMethod.GET) {

            HttpGet requestGet = new HttpGet(uri);
            consumer.sign(requestGet);
            return httpClient.execute(requestGet);

        } else if (method == HttpMethod.POST) {
            HttpPost requestPost = new HttpPost(uri);
            if (stringEntity != null) {
                requestPost.setEntity(stringEntity);
            }
            consumer.sign(requestPost);
            return httpClient.execute(requestPost);

        } else {
            throw new IllegalArgumentException("unknown HTTP method :" + method.name());

        }

    }




}








