package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.dao.TwitterDao;
import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.service.TwitterService;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;

public class TwitterControllerIntTest {
    private TwitterController controller;
    private Service service;
    private CrdDao twitterDao;

    @Before
    public void setUp() throws Exception {

        String CONSUMER_KEY = System.getenv("consumerKey");
        String CONSUMER_SECRET = System.getenv("consumerSecret");
        String ACCESS_TOKEN = System.getenv("accessToken");
        String TOKEN_SECRET = System.getenv("tokenSecret");
        System.out.println(CONSUMER_KEY + "||" + CONSUMER_SECRET + "||" + ACCESS_TOKEN + "||" + TOKEN_SECRET);
        HttpHelper httpHelper = new TwitterHttpHelper(CONSUMER_KEY, CONSUMER_SECRET, ACCESS_TOKEN,
                TOKEN_SECRET);
        this.twitterDao = new TwitterDao(httpHelper);
    }
    @Test
    public void postTweet() {
        String[] args = {"post", "TwitterController integration test", "45:-45"};
        try {
            Tweet tweet = controller.postTweet(args);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void showTweet() throws UnsupportedEncodingException, URISyntaxException {
        String[] ids = {"show", "1470473033458622466"};
        Tweet tweet = controller.postTweet(ids);
    }

    @Test
    public void deleteTweet() {
        String[] ids = {"delete", "1470473033458622466, 1470427538807836678"};
        List<Tweet> tweets = controller.deleteTweet(ids);
    }

}