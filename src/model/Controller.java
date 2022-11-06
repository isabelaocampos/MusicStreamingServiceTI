package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Controller {

    private ArrayList<User> users;

    public Controller(){
        users = new ArrayList<User>(10);

    }

    public ArrayList<User> getUsers(){
        return users;
    }

   
    /**
     * addUserProducer: String: This method adds an user to the array list of users, the user can be
     * an artist, producer or content creator.
     * @param name: String: This parameter is the name of the user, is a type string parameter.
     * @param vinculationDate: Calendar: This parameter represents the date that the user got register in the streaming
     * service, it a type calendar parameter.
     * @param imageURL: String: This parameter represents the image url of the user that represents it, it is a type 
     * string parameter.
     * @param typeOfUserProducer: TypeOfUserProducer: This parameter helps us to sort the type of user is getting added, 
     * there are three types of user producers: the artist, the producer and the content creator.
     * @return: String: This method returns a type string parameter, a messafge assuring that the user has been added or that
     * an errror has happened.
     */
    public String addUserProducer(String name, Calendar vinculationDate, String imageURL, TypeOfUserProducer typeOfUserProducer){
        String msj = "";
        
        switch(typeOfUserProducer){
            case ARTIST:
            users.add(new Artist(name, imageURL,vinculationDate));
            msj = "Artist added successfully";

            break;
            case PRODUCER:
            users.add(new Producer(name, imageURL, vinculationDate));
            msj = "Producer added successfully";

            break;
            case CONTENTCREATOR:
            users.add(new ContentCreator(name, imageURL, vinculationDate));
            msj = "Content creator added successfully";

            break;

            default:
            msj = "Sorry an error happened";
            break;

        }
        
        return msj;
    
    }

}

    

