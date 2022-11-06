package model;

import java.util.Calendar;

public abstract class UserProducer extends User {

    private String name;
    private String imageURL;

    public UserProducer(String name, String imageURL, Calendar vinculationDate) {
        super(vinculationDate);
        this.name = name;
        this.imageURL = imageURL;
        
    }

    public String getName(){
    return name;
    }

    public String getImageUrl(){
        return imageURL;
    }
    
}
