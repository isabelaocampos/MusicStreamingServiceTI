package model;

import java.util.Calendar;

public abstract class UserConsumer extends User{

    private String nickname;
    private String id;

    public UserConsumer(String nickname, String id, Calendar vinculationDate) {
        super(vinculationDate);
        this.nickname = nickname;
        this.id = id; 
        
    }

    public String getNickName(){
        return this.nickname;
    }

    public void setNickName(String nickname){
        this.nickname = nickname;
    }

    public String getId(){
        return this.id;
    }

    //public abstract String addSong(); 
    
    
}
