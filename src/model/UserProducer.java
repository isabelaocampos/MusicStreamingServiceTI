package model;

import java.util.Calendar;

public abstract class UserProducer extends User {

    private String name;
    private String imageURL;
    private int totalViews;
    private int totalPlayedTime;

    public UserProducer(String name, String imageURL, Calendar vinculationDate) {
        super(vinculationDate);
        this.name = name;
        this.imageURL = imageURL;
        totalViews = 0;
        totalPlayedTime = 0;
        
    }

    public String getName(){
    return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl(){
        return imageURL;
    }

    public void setImageUrl(String url) {
        this.imageURL = url;
    }

    public int getTotalViews() {
        return totalViews;
    }


    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }


    public int getTotalPlayedTime() {
        return totalPlayedTime;
    }


    public void setTotalPlayedTime(int totalPlayedTime) {
        this.totalPlayedTime = totalPlayedTime;
    }
    
}
