package ca.jrvs.apps.twitter.controller;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.util.TweetUtil;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TwitterControllerUnitTest {

    @Mock
    Service service;

    @InjectMocks
    TwitterController controller;

    @Test
    public void postTweet() throws UnsupportedEncodingException, URISyntaxException {
        when(service.postTweet(notNull()))
                .thenReturn(TweetUtil.buildTweet("Currently Working on Twitter CRUD Application", 20d, 30d));

        try {
            controller.postTweet(new String[]{"post", "text only"});
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        try {
            controller.postTweet(new String[]{"post", "text", "20:30:12"});
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        try {
            controller.postTweet(new String[]{"post", "text", "18:32:12"});
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        try {
            controller.postTweet(new String[]{"post", "text", ":30"});
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        Tweet tweet = controller.postTweet(new String[]{"post", "text", "20:30"});
        assertNotNull(tweet);
        assertNotNull(tweet.getText());
    }

    @Test
    public void showTweet() {
        when(service.showTweet(notNull(), any()))
                .thenReturn(TweetUtil.buildTweet("Welcome to the party", 20d, 30d));

        try {
            controller.showTweet(new String[]{"show", "text only", "extra arg", "extra arg"});
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        try {
            controller.showTweet(new String[]{"show"});
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }

        Tweet findTweet = controller.showTweet(new String[]{"show", "1468763845028102148"});
        assertNotNull(findTweet);
        assertNotNull(findTweet.getText());

    }

    @Test
    public void deleteTweet() throws UnsupportedEncodingException, URISyntaxException {
        final int numberOfTweet = 2;
        when(service.postTweet(notNull()))
                .thenReturn(TweetUtil.buildTweet("text", 20d, 30d));
        String idOfTweet = "1468763845028102148";
        String idOfTweet2 = "1481902891292143619";
        String[] deleteIDs = {idOfTweet, idOfTweet2};
        List<Tweet> deletedTweets = new ArrayList<>();
        Tweet tweet = controller.postTweet(new String[]{"post", "text", "20:30"});
        for (int i = 0; i < 3; i++) {
            deletedTweets.add(tweet);
        }
        when(service.deleteTweets(notNull())).thenReturn(deletedTweets);

        try {
            controller.deleteTweet(new String[]{"delete", "1481902891292143619", "1468763845028102148"});
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
        controller.deleteTweet(new String[]{"delete", "1468763845028102148,1468763845028102148"})
                .forEach(streamTweet -> {
                    assertNotNull(streamTweet);
                    assertNotNull(streamTweet.getText());
                    assertEquals(30, streamTweet.getCoordinates().getCoordinates().get(1), 0.01);
                });

    }

}