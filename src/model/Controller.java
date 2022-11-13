package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Controller {

    private ArrayList<User> users;
    private ArrayList<ProducerContent> content;
    public static final int ROWS = 6;
    public static final int COLUMNS = 6;

    public Controller(){
        users = new ArrayList<User>(10);
        content = new ArrayList<ProducerContent>(40);

    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public ArrayList<ProducerContent> getContent(){
        return content;
    }

    public int[][] createMatrix(){

        int matrix[][] = new int[ROWS][COLUMNS];
        
        for(int i=0; i<ROWS; i++){
            for(int j=0; i<COLUMNS; i++){
                matrix[i][j] = generateNumber();
            }
        }
        return matrix;
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
     * @return: msj: String: This method returns a type string parameter, a messafge assuring that the user has been added or that
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
     * @return msj: String: This method returns an assurring message that the user has been added or a message announcing an error.
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
    /**
     * addSong: String: This method adds a song to an artist and to the content arraylist, there are four different types of song:
     * Rock, Pop, Trap and House.
     * @param contentname: String: This parameter is the name which identifies the song.
     * @param name: String: This parameter is the name of the artist the song belongs to.
     * @param album: String: This parameter is the name of the album were the song is.
     * @param imageURL: String: This parameter is the URL of the image that represents the album.
     * @param duration: int: This parameter is the duration of the song.
     * @param price: double: This parameter is the price of the song.
     * @param typeOfGenreSong: TypeOfGenreSong: This parameter help us sort the type of song that the user is adding, it can be 
     * a rock, pop, trap or house song.
     * @return: msj: String: This method has three different returns, it can be an assurring message that the song has been added, a failed message
     * that alerts that something happened, and a message that inform that the artist cannot be found.
     */
    public String addSong(String contentname,String name, String album, String imageURL, int duration, double price, TypeOfGenreSongs typeOfGenreSong){
        String msj = "";
        UserProducer user = findUserProducer(name);
        Artist artist = ((Artist)(user));

        if(user == null){
            msj= "Sorry we couldn't find this artist, try again";
        }else{

            switch(typeOfGenreSong){
                case ROCK:
                content.add(new Song(contentname, imageURL, duration, album, price));
                
                artist.getSongs().add(new Song(contentname, imageURL, duration, album, price));
                msj = "Song added successfully";
                
                break;
                case POP:
                content.add(new Song(contentname, imageURL, duration, album, price));
                artist.getSongs().add(new Song(contentname, imageURL, duration, album, price));
                msj = "Song added successfully";
    
                break;
                case TRAP:
                content.add(new Song(contentname, imageURL, duration, album, price));
                artist.getSongs().add(new Song(contentname, imageURL, duration, album, price));
                msj = "Song added successfully";
    
                break;
                case HOUSE:
                content.add(new Song(contentname, imageURL, duration, album, price));
                artist.getSongs().add(new Song(contentname, imageURL, duration, album, price));
                msj = "Song added successfully";
    
                break;
                default:
                msj = "Sorry an error happened";
    
                break;

            }
        
        }  
        return msj; 
    }

    /**
     * addPodcast: String: This method adds a podcast to a content creator and to the content arraylist, there are four different types of podcast:
     * Politics, Entertainment, Videogames and Fashion.
     * @param contentname: String: This parameter is the name which identifies the podcast.
     * @param name: String: This parameter is the name of the content creator the podcast belongs to.
     * @param description: String: This parameter is the description of the podcast.
     * @param imageURL: String: This parameter is the URL of the image that represents the podcast.
     * @param duration: int: This parameter is the duration of the podcast.
     * @param typeOfCategoryPodcast: TypeOfCategoryPodcast: This parameter help us sort the type of podcast that the user is adding, it can be politics,
     * entertainment, videogames or fashion.
     * @return: msj: String: This method has three different returns, it can be an assurring message that the podcast has been added, a failed message
     * that alerts that something happened, and a message that inform that the content creator cannot be found. 
     */
    public String addPodcast(String contentname, String name, String description, String imageURL, int duration, TypeOfCategoryPodcast typeOfCategoryPodcast){
        String msj = "";
        UserProducer user = findUserProducer(name);
        ContentCreator contentCreator = ((ContentCreator)(user));

        if(user == null){
            msj= "Sorry we couldn't find this content creator, try again";
        }else{

            switch(typeOfCategoryPodcast){
                case POLITICS:
                content.add(new Podcast(contentname, imageURL, duration, description));
                contentCreator.getPodcasts().add(new Podcast(contentname, imageURL, duration, description));
                msj = "Podcast added successfully";
                
                break;
                case ENTERTAINMENT:
                content.add(new Podcast(contentname, imageURL, duration, description));
                contentCreator.getPodcasts().add(new Podcast(contentname, imageURL, duration, description));
                msj = "Podcast added successfully";
    
                break;
                case VIDEOGAMES:
                content.add(new Podcast(contentname, imageURL, duration, description));
                contentCreator.getPodcasts().add(new Podcast(contentname, imageURL, duration, description));
                msj = "Podcast added successfully";
    
                break;
                case FASHION:
                content.add(new Podcast(contentname, imageURL, duration, description));
                contentCreator.getPodcasts().add(new Podcast(contentname, imageURL, duration, description));
                msj = "Podcast added successfully";
    
                break;
                default:
                msj = "Sorry an error happened";
    
                break;

            }
        
        }  


        return msj; 
    }

    /**
     * addPlaylist: String: This method creates a playlist for an specific user, there are three types
     * of playlist: the ones that have just songs, songs and podcasts or just podcasts.
     * @param nickname: String: This parameter is the identifier of the user that is going to have the new
     * playlist.
     * @param playlistName: String: This parameter is the name of the new playlist.
     * @param option: This parameter helps us sort the type of playlist is getting added.
     * @return: msj: String: This method returns different types of message.
     */
    public String addPlaylist(String nickname,String playlistName, int option){
        String msj = "Playlist created successfully";
        UserConsumer user = findUserConsumer(nickname);

        if (user == null) {
            msj = "Sorry the user doesn't exist, try again";

        }else{
            if(user instanceof Standard){
                int [][]matrix= createMatrix();
                String code= generateCode(option, matrix);
                Standard standard = ((Standard)(user));

                boolean validation = standard.addPlaylist(playlistName, matrix, code, option);
                if(validation ==false){
                  msj="Sorry the playlist already exists";
                }

            }else if(user instanceof Premium){
                int [][]matrix=createMatrix();
                String code= generateCode(option, matrix);
                Premium premium = ( (Premium)(user) );

                boolean validation = premium.addPlaylist(playlistName, matrix, code, option);
                if(validation ==false){
                    msj="Sorry the playlist already exists";
                }

            }else{
                msj="this user is not standard or premium";
            }
        
        }

        return msj;

    }

    /**
     * editAudioToPlaylist: String: This method edits an already created playlist, it can add a song
     * or podcast to the playlist depending of the type.
     * @param option: int: This parameter is used to separated if the user is going to add content to 
     * the playlist or delete it.
     * @param nickname: String: This parameter is the identifier of the user in the streaming service, is
     * used to find the playlist the method is going to edit.
     * @param namePlaylist: String: This parameter is the identifier of the playlist.
     * @param contentname: String: This parameter is to find the name of the content the user is about to add,
     * to see if is already in the playlist or not.
     * @return: msj; String: This method has a message as a return, there are multiple different messages.
     */
    public String editAudioToPlaylist(int option,String nickname,String namePlaylist, String contentname){
        String msj = ""; 
        ProducerContent newAudio = findAudio(contentname);

        if(newAudio == null){
            msj = "Sorry this song already exists";

        }else{
            int type;
            if(newAudio instanceof Song){
                type =1;

            }else{
                type =2;
            }


            User aUser = findUserConsumer(nickname);
            if(aUser == null){
                msj = "Sorry this user doesn't exist"; 

            }else{
                if(option == 1){

                    if(aUser instanceof Standard){
                        Standard newStandart = ((Standard)(aUser));
                        msj = newStandart.addAudioToPlaylist(namePlaylist, type, newAudio,contentname); 

                    }else if(aUser instanceof Premium){
                        Premium newPremium = ((Premium)(aUser));
                        msj = newPremium.addAudioToPlaylist(namePlaylist,type,newAudio, contentname);

                    }else{
                        msj = "Sorry this is not a user consumer";
                    }
                }
                if(option == 2){

                    if(aUser instanceof Standard){
                        Standard newStandart = ((Standard)(aUser));
                        msj = newStandart.deleteAudioOfPlaylist(newAudio, namePlaylist, contentname);

                    }else if(aUser instanceof Premium){
                        Premium newPremium = ((Premium)(aUser));
                        msj = newPremium.deleteAudioOfPlaylist(newAudio, namePlaylist, contentname);

                    }else{
                        msj = "Sorry this is not a user consumer";
                    }

                }
            }
        }

        return msj;

    }


    //////////////////////////////////////////////////

    public int generateNumber(){
        int num = 0;
        Random r = new Random();
        num = (int)(r.nextInt()*9) + 0;

        return num;

    }

    public String generateCode(int option, int[][]matrix){
        String code =null;
        switch(option){
            case 1:
            for(int i=5;i<0;i--){
               code+=matrix[i][0];
            }
            for(int j=1, h=1;j>4 && h>4;j++,h++){
               code+=matrix[j][h];
            }
            for(int k=5;k<0;k--){
               code+=matrix[k][5];
            }
           break;

           case 2:
            for(int i=0;i<2;i++){
               code+=matrix[0][i];
            }
            for(int j=1;j<5;j++){
               code+=matrix[j][2];
            } 
            for(int k=5;k<0;k--){
               code+=matrix[k][3];
            }
            for(int u=3;u>5;u++){
               code+=matrix[0][u];
            }

            break;
              
            case 3:
            for (int i=5;i>=0;i--){
               for(int j=5;j>=0;j--){
                   int sum = i+j;
                   if (sum%2!=0){
                       if(sum!=1){
                           code+=matrix[i][j]+" ";
                       }
                   }

               }
           }
            break;


          }

     return code;

        
    }


    /**
     * findUserProducer: UserProducer: This method search with the name enter by the user the artist or content creator.
     * @param name: String: This parameter is the name of the user that we are searching.
     * @return user: UserProducer: This method return the position of the user, so we know that the user is registered in
     * the array.
     */
    public UserProducer findUserProducer(String name){
        UserProducer user = null;
        boolean isFound = false;
        for(int i = 0; i < users.size() && !isFound; i++){
            if(users.get(i) instanceof UserConsumer){
                if(((UserProducer) users.get(i)).getName().equalsIgnoreCase(name)){
                    user = (UserProducer) users.get(i);
                    isFound = true;
                }
            }
        }

        return user;
    }

    /**
     * findUserConsumer: UserConsumer: This method search with the name enter by the user the user standard or premium.
     * @param name: String: This parameter is the name of the user that we are searching.
     * @return user: UserConsumer: This method return the position of the user, so we know that the user is registered in
     * the array.
     */
    public UserConsumer findUserConsumer(String nickname){
        UserConsumer user = null;
        boolean isFound = false;
        for(int i = 0; i < users.size() && !isFound; i++){
            if(users.get(i) instanceof UserConsumer){
                if(((UserConsumer) users.get(i)).getNickName().equalsIgnoreCase(nickname)){
                    user = (UserConsumer) users.get(i);
                    isFound = true;
                }
            }
        }

        return user;
    }
    /**
     * findAudio: ProducerContent: This method search a content to see if it exist in the array.
     * @param contentname: String: This parameter is the name of the audio that we are searching.
     * @return audio: ProducerContent: This method return the position of the audio, so we know that the audio is in the array.
     */
    public ProducerContent findAudio(String contentname){
        ProducerContent audio = null;
        boolean isFound = false;
        for(int i = 0; i < content.size() && !isFound; i++){
            if(((ProducerContent) content.get(i)).getContentName().equalsIgnoreCase(contentname)){
                audio = (ProducerContent) content.get(i);
                isFound = true;
            }
        }

        return audio;
    }

}

    

