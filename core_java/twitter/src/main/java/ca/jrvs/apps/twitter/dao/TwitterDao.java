package ca.jrvs.apps.twitter.dao;
import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import com.sun.corba.se.impl.logging.UtilSystemException;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

public class TwitterDao implements CrdDao<Tweet, String> {
    //URI constants
    private static final String API_BASE_URI ="https://api.twitter.com";
    private static final String POST_PATH ="/1.1/statuses/update.json";
    private static final String SHOW_PATH ="/1.1/statuses/show.json";
    private static final String DELETE_PATH ="/1.1/statuses/destroy";

    //URI symbols
    private static final String QUERY_SYM ="?";
    private static final String AMPERSAND ="&";
    private static final String EQUAL ="=";

    //Response Code
    private static final int HTTP_OK=200;

    private HttpHelper httpHelper;
    private String tokenSecret;
    private String consumerKey;
    private String accessToken;
    private String consumerSecret;

    //Constructor

    public TwitterDao(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    @Override
    public Tweet create(Tweet entity) {
        URI uri ;
        try{

            uri= getPostUri(entity);


        } catch(URISyntaxException | UnsupportedEncodingException e){

            throw  new IllegalArgumentException("Invalid tweet input",e);

        }
        //Execute Http Request

        HttpResponse response =httpHelper.httpPost(uri);
        return parseResponseBody(response,HTTP_OK);
    }

    private URI getPostUri(Tweet entity) throws URISyntaxException {

        URI u = new URI(entity).parseServerAuthority();
        return null;
    }

    private Tweet parseResponseBody(HttpResponse response, int httpOkCode) {

        Tweet twt =null;

        //Checking status for the response
        int statusCode=response.getStatusLine().getStatusCode();
        if(statusCode!=httpOkCode){
         try{
             System.out.println(EntityUtils.toString(response.getEntity()));


         } catch (IOException e) {
             e.printStackTrace();
         }throw new RuntimeException("Unexpected HTTP status:"+statusCode);

        }

        if (response.getEntity()==null){


            throw new RuntimeException("Error! Response body empty");
        }

        //Converting Response Entity to string
        String jsonString;

        try{

            jsonString =EntityUtils.toString(response.getEntity());

        } catch (IOException e) {
            throw new RuntimeException("Cannot convert entity to String",e);
        }

        // Json string to tweet object

        try{
            twt= JsonParser.toObjectFromJson(jsonString,Tweet.class);
        }catch(IOException e){

            throw new RuntimeException("Error! Cannot convert Json string to Object",e);
        }

        return twt;
    }



    @Override
    public Tweet findById(String s) {


        HttpResponse response=null;
        HttpClient httpClient = HttpClientBuilder.create().build();
        OAuthConsumer consumer =new CommonsHttpOAuthConsumer(consumerKey,consumerSecret);
        consumer.setTokenWithSecret(accessToken,tokenSecret);
        return null;
    }

    @Override
    public Tweet deleteById(String s) {
        return null;
    }
}
