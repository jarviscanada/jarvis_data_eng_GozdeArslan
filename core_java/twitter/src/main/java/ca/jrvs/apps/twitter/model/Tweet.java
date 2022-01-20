package ca.jrvs.apps.twitter.model;

public class Tweet {

    private String text;
    private String created_at;
    private User user;
    private Coordinates coordinates;

    public tweet();

    public tweet (String text, String created_at, User user, Coordinates coordinates);

    public String getText () {
        return text;
    }
    public void setText (String text) {
        this.text = text;
    }
    public String getCreated_at () {
        return created_at;
    }
    public void setCreated_at (String created_at) {
        this.created_at = created_at;
    }
    public User getUser () {
        return user;
    }
    public void setUser (User user) {
        this.user = user;
    }
    public Coordinates getCoordinates () {
        return coordinates;
    }
    public void setCoordinates (Coordinates coordinates) {
        this.coordinates = coordinates;
    }
    @Override
    public String toString() {
        return "ClassPojo [text = "+text+", created_at = "+created_at+", user = "+user+", coordinates = "+coordinates+"]";
    }
}
