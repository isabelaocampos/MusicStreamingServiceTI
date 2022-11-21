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
   

    /**
     * findSongArtist: boolean: This method search for a song of an artist in the array of song 
     * of that artist
     * @param song: Song: is the name of the song that we are looking for.
     * @return: isFound: boolean: If it finds the song will return true, if not it'll return false.
     */
    public boolean findSongArtist(Song song){
        boolean isFound= false;
        for(int i=0;i<songs.size() && !isFound ;i++){
            if( songs.get(i) == song){
                isFound= true;
            }
         }
    
        return isFound;
    }
    
}
