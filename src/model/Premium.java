package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Premium extends UserConsumer{

    private ArrayList<Playlist> playlistsPremiumUser;
    
    private ArrayList<Song> songsPremiumUser;

    public Premium(String nickname, String id, Calendar vinculationDate){
        super(nickname, id, vinculationDate);
        playlistsPremiumUser = new ArrayList<Playlist>(20);
        songsPremiumUser = new ArrayList<Song>(100);
        
    }

    public ArrayList<Playlist> getPremiumPlaylist(){
        return playlistsPremiumUser;
    }
    

    public ArrayList<Song> getPremiumSongs(){
        return songsPremiumUser;
    }

    @Override
    public String addSong() {
      
        return null;
    }
}
