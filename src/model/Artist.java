package model;

import java.util.Calendar;
import java.util.ArrayList;

public class Artist extends UserProducer{

    private ArrayList<Song> songs;

    public Artist(String name, String imageURL, Calendar vinculationDate) {
        super(name, imageURL, vinculationDate);

        songs= new ArrayList<Song>();
    }

    public ArrayList<Song> getSongs(){
        return songs;
    }

    public void setSongs(ArrayList<Song> songs){
        this.songs = songs;
    }
   
    
}
