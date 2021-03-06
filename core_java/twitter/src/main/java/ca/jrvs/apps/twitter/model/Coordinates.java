package ca.jrvs.apps.twitter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Arrays;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "coordinates",
        "type"})

public class Coordinates {
    private String type;
    private List <Double> coordinates;

    @JsonProperty("type")
    public String getType () {
        return type;
    }
    @JsonProperty("type")
    public void setType (String type) {
        this.type = type;
    }
    @JsonProperty("coordinates")
    public List<Double> getCoordinates () {
        return coordinates;
    }
    @JsonProperty("coordinates")
    public void setCoordinates (List<Double> coordinates) {this.coordinates = coordinates;  }


}
