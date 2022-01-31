package ca.jrvs.apps.twitter.util;



import ca.jrvs.apps.twitter.model.Coordinates;
import ca.jrvs.apps.twitter.model.Tweet;
import com.google.gdata.util.common.base.PercentEscaper;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Arrays;

public class TweetUtil {

        public static Tweet buildTweet(String text, Double longt, Double lat) {
            Tweet tweet = new Tweet();
            PercentEscaper percentEscaper = new PercentEscaper("", false);
            Coordinates coordinates = new Coordinates();
            coordinates.setCoordinates(new Double[]{longt, lat});
            coordinates.setType("Point");

            tweet.setText(percentEscaper.escape(text));
            tweet.setCoordinates(coordinates);
            return tweet;
        }


        public static Tweet createTweet(String text,
                                        double longitude,
                                        double latitude) {

            final Logger logger = LoggerFactory.getLogger(TweetUtil.class);

            Coordinates geoCoordinates = new Coordinates();
            Tweet tweet = new Tweet();

            try {
                geoCoordinates.setCoordinates(Arrays.asList(longitude, latitude));
                geoCoordinates.setType("Point");
                tweet.setText(text);
                tweet.setCoordinates(geoCoordinates);
            } catch (Exception ex) {

                logger.error(ex.getMessage());
            }
            return tweet;
        }

    }