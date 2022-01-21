package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
@JsonPropertyOrder({
        "indices",
        "text"})
public class HashTag {



    private List<Integer> indices;
    private String text;

    @JsonProperty("indices")
    public List<Integer> getIndices() {
        return indices;
    }
    @JsonProperty("indices")
    public void setIndices(List<Integer> hashtag) {
        this.indices=indices;
    }
    @JsonProperty("text")
    public void setText (String text) {
        this.text = text;
    }
    @JsonProperty("text")
    public String getText() {
        return text;
    }


}

