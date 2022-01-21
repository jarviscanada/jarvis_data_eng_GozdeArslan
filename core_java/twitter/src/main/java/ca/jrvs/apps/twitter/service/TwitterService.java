package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import ch.qos.logback.core.status.Status;

import java.awt.image.CropImageFilter;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class TwitterService implements Service {

    private CrdDao cDao;
    /**
     * Constructor
     */
    public TwitterService() {
    }

    /**
     * Validate and post a user input Tweet
     *
     * @param tweet tweet to be created
     * @return created tweet
     * @throws IllegalArgumentException if text exceed max number of allowed characters or lat/long out of range
     */
    @Override
    public Tweet postTweet(Tweet tweet) throws UnsupportedEncodingException, URISyntaxException {

        return (Tweet) cDao.create(tweet);
    }

    /**
     * Search a tweet by ID
     *
     * @param id     tweet id
     * @param fields set fields not in the list to null
     * @return Tweet object which is returned by the Twitter API
     * @throws IllegalArgumentException if id or fields param is invalid
     */
    @Override
    public Tweet showTweet(String id, String[] fields) {
      /*  Status tweetById = twitter.showStatus(cDao.findById(id));
        String url= "https://twitter.com/" + tweetById.getUser().getHashtag()
                + "/status/" + tweetById.getId();*/
        return (Tweet) cDao.findById(id);

    }

    /**
     * Delete Tweet(s) by id(s).
     *
     * @param ids tweet IDs which will be deleted
     * @return A list of Tweets
     * @throws IllegalArgumentException if one of the IDs is invalid.
     */
    @Override
    public List<Tweet> deleteTweets(String[] ids) {

          List<Tweet> listOfTweets = new ArrayList<Tweet>();
        return (List<Tweet>) cDao.deleteById(listOfTweets);

    }
}
