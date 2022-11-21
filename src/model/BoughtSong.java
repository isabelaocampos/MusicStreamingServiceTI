package model;

import java.util.Calendar;
public class BoughtSong {


	private Calendar date;
	private String nickname;
	private String songName; 

	public BoughtSong(Calendar date, String nickname, String songName){

	this.date = date;
	this.nickname = nickname;
	this.songName = songName; 

	}

	public String getNickname() {
        return nickname;
    }

    public String getSongName() {
        return songName;
    }

    public Calendar getDate(){
    	return date; 
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

}