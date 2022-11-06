package model;

import java.util.ArrayList;
import java.util.Calendar;

public class ContentCreator extends UserProducer {

    private ArrayList<Podcast> podcasts;

    public ContentCreator(String name, String imageURL, Calendar vinculationDate) {
        super(name, imageURL, vinculationDate);
        
        podcasts = new ArrayList<Podcast>();
    }

    public ArrayList<Podcast> getPodcasts(){
        return podcasts;
    }
  
    public void setPodcasts(ArrayList<Podcast> podcasts){
        this.podcasts = podcasts;
    }
}
