package ca.jrvs.apps.twitter.controller;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.when;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.util.TweetUtil;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

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
        Tweet tweet = controller.postTweet(new String[]{"post", "text", "20:30"});
        assertNotNull(tweet);
        assertNotNull(tweet.getText());
    }


}