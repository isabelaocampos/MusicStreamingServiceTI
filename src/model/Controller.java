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
     * @param typeOfUserProducer: TypeOfUserProducer: This parameter helps us to sort the type of user that is getting added, 
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

    /**
     * addUserConsumer: String: This method adds an user to the array list of users, the user can be
     * an standard or premium. 
     * @param nickname: String: This paraemeter is the nickname of the user, is a type string parameter.
     * @param id: String: This parameter identifies the user, is a type string parameter.
     * @param vinculationDate: Calender: This parameter represents the date that the user got register in the streaming
     * service, it a type calendar parameter.
     * @param typeOfUserConsumer: TypeOfUserConsumer: This parameter helps us to sort the type of user that is getting added, 
     * there are two types of user consumers: the standard and the premium user.
     * @return
     */
    public String addUserConsumer(String nickname, String id, Calendar vinculationDate, TypeOfUserConsumer typeOfUserConsumer){
        String msj = "";
        
        switch(typeOfUserConsumer){
            case STANDARD:
            users.add(new Standard(nickname, id,vinculationDate));
            msj = "User standard added successfully";

            break;
            case PREMIUM:
            users.add(new Premium(nickname, id, vinculationDate));
            msj = "Premium user added successfully";

            break;
            default:
            msj = "Sorry an error happened";
            break;

        }
        
        return msj;
    
    }

}

    

