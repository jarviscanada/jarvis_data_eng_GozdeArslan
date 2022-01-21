package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Entities {

    @JsonPropertyOrder({
            "hashtags",
            "user_mentions"})
       private List<HashTag> hashtag;
        private List<UserMention> userMention;

        @JsonProperty("hashtag")
        public List<HashTag> getHashtag() {
            return hashtag;
        }@JsonProperty("hashtag")
        public void setHashtag(List<HashTag> hashtag) {
            this.hashtag=hashtag;
        }
        @JsonProperty("userMentions")
        public void setUserMention (List<UserMention> userMention) {
            this.userMention = userMention;
        }
    @JsonProperty("userMentions")
        public List<UserMention> getCoordinates () {
            return userMention;
        }



}
