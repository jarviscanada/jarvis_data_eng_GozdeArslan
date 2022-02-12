package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdDao;
import ca.jrvs.apps.twitter.model.Tweet;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class TwitterService implements Service {

    private CrdDao cDao;
    /**
     * Constructor
     * @param cDao
     */
    public TwitterService(CrdDao cDao) { this.cDao = cDao; }

    /**
     * Validate and post a user input Tweet
     *
     * @param tweet tweet to be created
     * @return created tweet
     * @throws IllegalArgumentException if text exceed max number of allowed characters or lat/long out of range
     */
    @Override
    public Tweet postTweet(Tweet tweet) throws UnsupportedEncodingException, URISyntaxException {
        validatePostTweet(tweet);
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
        validateId(id);
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
        /*  Arrays.stream(ids).forEach(this::validateId);
            Arrays.stream(ids).forEach(id -> existingTweets.add((Tweet) dao.deleteById(id)));*/

    }

    private void validatePostTweet(Tweet tweet) {

        final Integer maxTextBody = 140;
        final Integer minGeoAddress = -90;
        final Integer maxGeoAddress = 90;
        String textBody = tweet.getText();
        Double longitude = tweet.getCoordinates().getCoordinates().get(0);
        Double latitude = tweet.getCoordinates().getCoordinates().get(1);

        if (textBody.length() > maxTextBody) {

            throw new IllegalArgumentException(
                    "max tweet range is 140 characters");
        } else if (longitude > maxGeoAddress || longitude < minGeoAddress) {


        } else if (latitude > maxGeoAddress || latitude < minGeoAddress) {

        }
    }

    private void validateId(String id) {
        try {
            Long.parseLong(id);
        } catch (NumberFormatException ex) {

            throw new IllegalArgumentException(
                    "Failed!: incorrect tweet id");
        }
    }
}
