package model;

public abstract class ProducerContent {

    private String contentname;
    private String imageURL;
    private int duration;

    public ProducerContent(String contentname, String imageURL, int duration){
        this.contentname = contentname;
        this.imageURL = imageURL;
        this.duration = duration;
    }

    public String getContentName(){
        return this.contentname;
    }

    public String getImageURL(){
        return this.imageURL;
    }

    public int getDuration(){
        return this.duration;
    }
    
}
