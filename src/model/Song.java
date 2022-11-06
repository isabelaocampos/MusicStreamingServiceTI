package model;


public class Song extends ProducerContent {

    private String album;
    private double price;

    public Song(String contentname, String imageURL, int duration, String album, double price) {
        super(contentname, imageURL, duration);
        this.album = album;
        this.price= price;
    }

    public String getAlbum(){
        return this.album;
    }

    public double getPrice(){
        return this.price;
    }
    
}
