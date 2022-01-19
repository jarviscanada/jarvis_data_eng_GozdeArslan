package ca.jrvs.apps.twitter.dao.helper;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.net.URI;


public class TwitterHttpHelper  implements HttpHelper {

    private OAuthConsumer consumer;
    private HttpClient httpClient;



    /**
     * @param consumerKey
     * @param consumerSecret
     * @param accessToken
     * @param tokenSecret
     */

    public TwitterHttpHelper(String consumerKey, String consumerSecret, String accessToken, String tokenSecret) {

        //Setup Auth
        consumer = new CommonsHttpOAuthConsumer(consumerKey, consumerSecret);
        consumer.setTokenWithSecret(accessToken, tokenSecret);
        /**
         * Default = single collection. Discuss source code if time permit.
         */
        httpClient = new DefaultHttpClient();
    }



    @Override
    public HttpResponse httpPost(URI uri) {
        try {

            return executeHttpRequest(HttpMethod.POST, uri, null);
        } catch (OAuthException | IOException e) {

            throw new RuntimeException("Failed to execute", e);
        }

    }

    @Override
    public HttpResponse httpGet(URI uri) {
        try {

            return executeHttpRequest(HttpMethod.GET, uri, null);
        } catch (OAuthException | IOException e) {

            throw new RuntimeException("Failed to execute", e);
        }

    }

    private HttpResponse executeHttpRequest(HttpMethod method, URI uri, StringEntity stringEntity)
            throws OAuthException, IOException {
        if (method == HttpMethod.GET) {

            HttpGet requestGet= new HttpGet(uri);
            consumer.sign(requestGet);
        return httpClient.execute(requestGet);

        } else if (method == HttpMethod.POST) {
            HttpPost requestPost = new HttpPost(uri);
            if (stringEntity != null) ;
            requestPost.setEntity(stringEntity);
        }
        consumer.sign(requestPost);
        return httpClient.execute(requestPost);
    }else

    {
        throw new IllegalArgumentException("unknown HTTP method :" + method.name());

    }

}








