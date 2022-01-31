package ca.jrvs.apps.twitter.controller;

import ca.jrvs.apps.twitter.model.Tweet;
import ca.jrvs.apps.twitter.service.Service;
import ca.jrvs.apps.twitter.util.TweetUtil;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.List;

public class TwitterController implements Controller{

        private static final String COORD_SEP =":";
        private static final String COMMA = ",";
        private Service service;
        //@Autowired
        public TwitterController(Service service) { this.service = service; }
    /**
     * Parse user argument and post a tweet by calling service classes
     *
     * @param args
     * @return a posted tweet
     * @throws IllegalArgumentException if args are invalid
     */
    @Override
    public Tweet postTweet(String[] args) throws UnsupportedEncodingException, URISyntaxException {
        if (args.length != 3) {
            throw new IllegalArgumentException(
                    "USAGE: TwitterCLIApp post \"tweet text\" \"latitude:longitude\"");
        }
        String tweetTxt = args[1];
        String coordinatesOfTweet= args[2];
        String[] splitCoordinates = coordinatesOfTweet.split(COORD_SEP);
        if (splitCoordinates.length != 2 || tweetTxt.isEmpty()) {
            throw new IllegalArgumentException("Please provide tweet text and the correct " + "number of coordinates.\nUsage:"
                    + " TwitterAppC" +
                    "LI post \"text\" \"longitude:latitude\"");
        }

        Double latitude, longitude;

        try {
            latitude = Double.parseDouble(splitCoordinates[0]);
            longitude = Double.parseDouble(splitCoordinates[1]);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    "Coordinates not valid.\nUsage: TwitterAppCLI post \"text\" \"longitude:latitude\"");
        }

        Tweet tweetPost = TweetUtil.buildTweet(tweetTxt, longitude, latitude);
        return service.postTweet(tweetPost);
    }

    /**
     * Parse user argument and search a tweet by calling service classes
     *
     * @param args
     * @return a tweet
     * @throws IllegalArgumentException if args are invalid
     */
    @Override
    public Tweet showTweet(String[] args) {
        if (args.length !=2) {
            throw new IllegalArgumentException(
                    "Error! Number of Arguments does not match. \nUSAGE: TwitterCLIApp show \"tweet_id\" \"[field1, field2]]\"");
        }
        String[] ids = args[2].split(COMMA);
        return service.showTweet(ids[1], null);


    }

    /**
     * Parse user argument and delete tweets by calling service classes
     *
     * @param args
     * @return a list of deleted tweets
     * @throws IllegalArgumentException if args are invalid
     */
    @Override
    public List<Tweet> deleteTweet(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "Error! Number of Arguments does not match. USAGE: TwitterCLIApp delete \"[id1,id2,..]\" ");
        }
        String[] ids = args[2].split(COMMA);
        return service.deleteTweets(ids);
    }
}
