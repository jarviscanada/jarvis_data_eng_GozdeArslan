package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.util.JsonUtil;
import ca.jrvs.apps.twitter.util.TweetUtil;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class TwitterDaoIntTest {
    private TwitterDao twitterDao;
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

    /**
     *
     * @throws UnsupportedEncodingException
     * @throws URISyntaxException
     */
    @Test
    public void create() throws UnsupportedEncodingException, URISyntaxException {

        String hashtag = "#Testing Twitter DAO";
        String text = "TwitterDaoIntTest" + hashtag + " " + System.currentTimeMillis();
        Double lat = 1d;
        Double lon = -1d;
        Tweet tweet = TweetUtil.buildTweet(text, lat, lon);

        Tweet postedTweet = twitterDao.create(tweet);

        assertEquals(text, postedTweet.getText());
        assertNotNull(postedTweet.getCoordinates());
        assertEquals(2, postedTweet.getCoordinates().getCoordinates().size());
        assertEquals(lon, postedTweet.getCoordinates().getCoordinates().get(0));
        assertEquals(lat, postedTweet.getCoordinates().getCoordinates().get(1));
        assertTrue(hashtag.contains(postedTweet.getEntities().getHashtag().get(0).getText()));
    }

    @Test
    public void findById() {
        String id = "1483988202369204224";
        twitterDao.findById(id);
    }

    @Test
    public void deleteById() {
        String id = "1483988202369204224";
         twitterDao.deleteById(id);
    }
}