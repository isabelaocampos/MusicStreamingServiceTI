package model;

import java.util.Date;


public abstract class User {
    private String nickname;
    private String id;
    private Date vinculationDate;
    
    public User(String nickname, String id, Date vinculationDate){
        this.nickname = nickname;
        this.id = id;
        this.vinculationDate = vinculationDate; 
    }

    public abstract String addSong(); 
    
}
