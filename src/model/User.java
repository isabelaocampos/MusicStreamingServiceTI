package model;

import java.util.Calendar;


public abstract class User {
    private Calendar vinculationDate;

    
    public User(Calendar vinculationDate){

        this.vinculationDate = vinculationDate; 
    }

    

    public Calendar getVinculationDate(){
        return this.vinculationDate;
    }

    
}
