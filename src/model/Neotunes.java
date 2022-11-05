package model;

import java.util.ArrayList;

public class Neotunes {

    private ArrayList<User> users;

    public Neotunes(){
        users = new ArrayList<User>(10);

    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public boolean addUser(User user){
        return users.add(user);
    }
    
}
