package model;

import java.util.Date;

public class Standard extends User {
    public Standard(String nickname, String id, Date vinculationDate) {
        super(nickname, id, vinculationDate);
    
    }
    public static int TOTAL_PLAYLIST_PER_STANDART = 20;
    public static int TOTAL_SONGS_PER_STANDART = 100;
    @Override
    public String addSong() {
        // TODO Auto-generated method stub
        return null;
    }


}
