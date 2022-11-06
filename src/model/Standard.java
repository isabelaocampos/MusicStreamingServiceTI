package model;

import java.util.Calendar;

public class Standard extends UserConsumer {

    public Standard(String nickname, String id, Calendar vinculationDate) {
        super(nickname, id, vinculationDate);
    
    }
    public static int TOTAL_PLAYLIST_PER_STANDART = 20;
    public static int TOTAL_SONGS_PER_STANDART = 100;
    @Override
    public String addSong() {

        return null;
    }


}
