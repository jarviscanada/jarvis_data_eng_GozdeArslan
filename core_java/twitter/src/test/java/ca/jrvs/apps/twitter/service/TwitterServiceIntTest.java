package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TwitterServiceIntTest {

    private TwitterDao twitterDao;
    private TwitterService twitterService;
    @Before
    public void setUp() throws Exception {

        String CONSUMER_KEY = System.getenv("consumerKey");
        String CONSUMER_SECRET = System.getenv("consumerSecret");
        String ACCESS_TOKEN = System.getenv("accessToken");
        String TOKEN_SECRET = System.getenv("tokenSecret");
        System.out.println(CONSUMER_KEY + "||" + CONSUMER_SECRET + "||" + ACCESS_TOKEN + "||" + TOKEN_SECRET);
        HttpHelper httpHelper = new TwitterHttpHelper(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN,
                TOKEN_SECRET);

        //pass dependency
        this.twitterDao = new TwitterDao(httpHelper);
       this.twitterService= new TwitterService(twitterDao);

    }
    @Test
    public void postTweet() {
        Tweet tweet = new Tweet();
        Coordinates coordinates = new Coordinates();
              Double[] coordinateOfTweet = new Double[] {50d, -50d};

        coordinates.setCoordinates(Arrays.asList(coordinateOfTweet));
        tweet.setCoordinates(coordinates);
        tweet.setText("Twitter App/ service  integration test");

        try {
            Tweet tweetPost = twitterService.postTweet(tweet);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void showTweet() {
        String id = " 1483988202369204224";
        Tweet tweet = twitterService.showTweet(id, null);
    }

    @Test
    public void deleteTweets() {
        String [] ids = new String[] { " 1483988202369204224", "1468763845028102148" };
        List<Tweet> tweets = twitterService.deleteTweets(ids);
    }
}