package model;

public class Podcast extends ProducerContent {

    private String description;

    public Podcast(String contentname, String imageURL, int duration, String description) {
        super(contentname, imageURL, duration);
        this.description = description;
    }
    
    public String getDescription(){
        return this.description;
    }
}
