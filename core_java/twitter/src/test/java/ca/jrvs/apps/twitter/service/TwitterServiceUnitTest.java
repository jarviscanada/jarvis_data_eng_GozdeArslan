package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class TwitterServiceUnitTest {
    @Mock
    CrdDao dao;

    @InjectMocks
    TwitterService TwitterService;

    @Test
    public void postTweet() throws UnsupportedEncodingException, URISyntaxException {

        when(dao.create(any())).thenReturn(new Tweet());
        try {
            TwitterService.postTweet(TweetUtil.createTweet("test", 50.0, 0.0));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void showTweet() {
        when(dao.findById(any())).thenReturn(new Tweet());
        TwitterService.showTweet("1468763845028102148", null);
    }

    @Test
    public void deleteTweets() {
        String [] ids = new String[] { " 1483988202369204224", "1468763845028102148" };
        when(dao.findById(any())).thenReturn(new Tweet());
        List<Tweet> tweets = TwitterService.deleteTweets(ids);



    }
}