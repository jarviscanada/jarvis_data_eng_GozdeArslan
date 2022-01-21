package ca.jrvs.apps.twitter.dao;

import ca.jrvs.apps.twitter.dao.helper.HttpHelper;
import ca.jrvs.apps.twitter.dao.helper.TwitterHttpHelper;
import ca.jrvs.apps.twitter.model.Tweet;
import org.junit.Before;
import org.junit.Test;

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
  @Test
    public void create() throws Exception {
        String hashTag = "abc";
        String text = "Example of twitter data object " +hashTag + " "+System.currentTimeMillis();
        Double lat = 1d;
        Double lon = -1d;
        Tweet post = TweetUtil.buildTweet(text, lon, lat);
        System.out.println(Jsonutil.toPrettyJson (post));
        Tweet tweet = twitterDao.create(post);
        assertEquals(text, tweet.getText());
        assertNotNull(tweet.getCoordinates());
        assertEquals( 2, tweet.getCoordinates().getCoordinates().size());
        assertEquals(lon, tweet.getCoordinates().getCoordinates().get(0));
        assertEquals(lat, tweet.getCoordinates().getCoordinates().get(1));
        assertTrue (hashTag.contains (tweet.getEntities().getHashtag().get(0).getText()));

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