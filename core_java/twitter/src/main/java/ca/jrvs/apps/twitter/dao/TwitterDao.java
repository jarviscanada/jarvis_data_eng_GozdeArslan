package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.example.JsonParser;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

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

    /**
     *
     * @param httpHelper
     */

    public TwitterDao(HttpHelper httpHelper) {
        this.httpHelper = httpHelper;
    }

    /**
     *
     * @param entity entity that to be created
     * @return
     * @throws URISyntaxException
     * @throws UnsupportedEncodingException
     */
    @Override
    public Tweet create(Tweet entity) throws URISyntaxException, UnsupportedEncodingException {
        URI uri ;
        uri= getPostUri(entity);
        //Execute Http Request
        HttpResponse response =httpHelper.httpPost(uri);
        return parseResponseBody(response,HTTP_OK);
    }
    private URI getPostUri(Tweet twt) throws URISyntaxException {

        List<Double> coordinates = twt.getCoordinates().getCoordinates();
       return URI.create(new URI(API_BASE_URI + POST_PATH + QUERY_SYM+ "status" + EQUAL + twt.getText()+ AMPERSAND + "lon" + EQUAL + coordinates.get(0))
                + AMPERSAND + "lat" + EQUAL + coordinates.get(1));


    }

   /* private URI getPostUri(Tweet entity) throws URISyntaxException {

        URI u = new URI(u).parseServerAuthority();
        return null;
    }*/

    /**
     *
     * @param response
     * @param httpOkCode
     * @return
     */
    protected Tweet parseResponseBody(HttpResponse response, int httpOkCode) {

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
                String jsonString;

        try{

            jsonString =EntityUtils.toString(response.getEntity());

        } catch (IOException e) {
            throw new RuntimeException("Cannot convert entity to String",e);
        }


        try{
            twt= JsonParser.toObjectFromJson(jsonString,Tweet.class);
        }catch(IOException e){

            throw new RuntimeException("Error! Cannot convert Json string to Object",e);
        }

        return twt;
    }

    /**
     *
     * @param s
     * @return
     */

    @Override
    public Tweet findById(String s) {

        URI uri;


        try{


            uri= new URI(API_BASE_URI+SHOW_PATH+QUERY_SYM+"id"+EQUAL);

        }catch (URISyntaxException e){

            throw new IllegalArgumentException("Failed! Please enter valid id data! ",e);


        }
        HttpResponse response ;

        response = httpHelper.httpGet(uri);

        return parseResponseBody(response,HTTP_OK);

    }


    /**
     *
     * @param s
     * @return
     */
    @Override
    public Tweet deleteById(String s) {
        URI uri;


        try{


            uri= new URI(API_BASE_URI+DELETE_PATH+"/"+".json");

        }catch (URISyntaxException e){

            throw new IllegalArgumentException("Failed! Please enter valid data id! ",e);


        }

        HttpResponse response=httpHelper.httpPost(uri);

        return parseResponseBody(response,HTTP_OK);




    }
}
