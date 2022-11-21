package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class Controller {

    private ArrayList<User> users;
    private ArrayList<ProducerContent> content;
    private ArrayList<BoughtSong> boughtSongs;
    public static final int ROWS = 6;
    public static final int COLUMNS = 6;

    public Controller(){
        users = new ArrayList<User>(10);
        content = new ArrayList<ProducerContent>(40);
        boughtSongs = new ArrayList<BoughtSong>(10);

    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public ArrayList<ProducerContent> getContent(){
        return content;
    }

    public ArrayList<BoughtSong> getBoughtSongs(){
        return boughtSongs;
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

    public Calendar date(){
        Calendar calendar = new GregorianCalendar(2022, Calendar.NOVEMBER,20);
        return calendar;
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
    public String addUserProducer(String name, String imageURL, TypeOfUserProducer typeOfUserProducer){
        String msj = "";
        Calendar vinculationDate = date();
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
    public String addUserConsumer(String nickname, String id, TypeOfUserConsumer typeOfUserConsumer){
        String msj = "";
        Calendar vinculationDate = date();
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
                content.add(new Song(contentname, imageURL, duration, album, price, 1));
                
                artist.getSongs().add(new Song(contentname, imageURL, duration, album, price, 1));
                msj = "Song added successfully";
                
                break;
                case POP:
                content.add(new Song(contentname, imageURL, duration, album, price,2));
                artist.getSongs().add(new Song(contentname, imageURL, duration, album, price,2));
                msj = "Song added successfully";
    
                break;
                case TRAP:
                content.add(new Song(contentname, imageURL, duration, album, price,3));
                artist.getSongs().add(new Song(contentname, imageURL, duration, album, price,3));
                msj = "Song added successfully";
    
                break;
                case HOUSE:
                content.add(new Song(contentname, imageURL, duration, album, price,4));
                artist.getSongs().add(new Song(contentname, imageURL, duration, album, price,4));
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
                content.add(new Podcast(contentname, imageURL, duration, description,1));
                contentCreator.getPodcasts().add(new Podcast(contentname, imageURL, duration, description,1));
                msj = "Podcast added successfully";
                
                break;
                case ENTERTAINMENT:
                content.add(new Podcast(contentname, imageURL, duration, description,2));
                contentCreator.getPodcasts().add(new Podcast(contentname, imageURL, duration, description,2));
                msj = "Podcast added successfully";
    
                break;
                case VIDEOGAMES:
                content.add(new Podcast(contentname, imageURL, duration, description,3));
                contentCreator.getPodcasts().add(new Podcast(contentname, imageURL, duration, description,3));
                msj = "Podcast added successfully";
    
                break;
                case FASHION:
                content.add(new Podcast(contentname, imageURL, duration, description,4));
                contentCreator.getPodcasts().add(new Podcast(contentname, imageURL, duration, description,4));
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
        ProducerContent newContent = findAudio(contentname);

        if(newContent == null){
            msj = "Sorry this song already exists";

        }else{
            int type;
            if(newContent instanceof Song){
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
                        msj = newStandart.addAudioToPlaylist(namePlaylist, type, newContent,contentname); 

                    }else if(aUser instanceof Premium){
                        Premium newPremium = ((Premium)(aUser));
                        msj = newPremium.addAudioToPlaylist(namePlaylist,type,newContent, contentname);

                    }else{
                        msj = "Sorry this is not a user consumer";
                    }
                }
                if(option == 2){

                    if(aUser instanceof Standard){
                        Standard newStandart = ((Standard)(aUser));
                        msj = newStandart.deleteAudioOfPlaylist(newContent, namePlaylist, contentname);

                    }else if(aUser instanceof Premium){
                        Premium newPremium = ((Premium)(aUser));
                        msj = newPremium.deleteAudioOfPlaylist(newContent, namePlaylist, contentname);

                    }else{
                        msj = "Sorry this is not a user consumer";
                    }

                }
            }
        }

        return msj;

    }

   
    public String sharePlaylist(String nickname, String namePlaylist){
        String numberCode = "";

        User user = findUserConsumer(nickname);

        if(user == null){
            numberCode = "Sorry this user doesn't exists";
        }else{
            if(user instanceof Standard){
                Standard newStandard = ((Standard)(user));
                numberCode = newStandard.sharePlaylist(namePlaylist) + "\n" + newStandard.playlistMatrix(namePlaylist);

            }else if(user instanceof Premium){
                Premium newPremium = ((Premium)(user));
                numberCode = newPremium.sharePlaylist(namePlaylist) + "\n" + newPremium.playlistMatrix(namePlaylist);
            }else{
                numberCode = "Sorry, this is not a user consumer. Try again";
            }   
        }

        return numberCode;
    }

    public String playingAudio(String nickname, String contentname){

        String msj = ""; 
        User user = findUserConsumer(nickname);

        if(user == null){
            msj = "Sorry, we couldn't find the user. Try again";
        }
        else{
            ProducerContent newContent = findAudio(contentname);
            if(newContent == null){
                msj = "the audio doesnt exist";
            }
               else{
                if(user instanceof Standard){
                    Standard newStandart = ( (Standard)(user) );
                    msj = newStandart.playContent(newContent);
                    updateState(newContent);
                }
                else if(user instanceof Premium){
                    Premium newPremium = ( (Premium)(user) );
                    msj = newPremium.playContent(newContent);
                    updateState(newContent);
                }
                else{
                    msj = "Sorry, the user you wrote is not an user consumer"; 
                }
            } 
        }

         

        return msj;

    }

    public String buySong(String nickname, String songName){

        String msj = ""; 
        User user = findUserConsumer(nickname);

        if(user == null){
            msj = "Sorry, we couldn't find this user. Try again";
        }
        else{
            ProducerContent newAudio = findAudio(songName);
            if(newAudio == null){
                msj = "the audio doesnt exist";
            }

            else{
                if(newAudio instanceof Song){
                    Song newSong = ( (Song)(newAudio) );
                    if(user instanceof Standard){
                        int userSongsBought = countBuysForUser(nickname);
                        if(userSongsBought<100){
                            BoughtSong newBSong = new BoughtSong(date(), nickname, songName); 
                            boughtSongs.add(newBSong); 
                            newSong.setSongSales(newSong.getSongSales()+1);

                        }else{
                            msj = "the purchasing limit has been reached "; 
                        }

                    } else if( user instanceof Premium){
                        BoughtSong newBSong = new BoughtSong(date(), nickname, songName); 
                        boughtSongs.add(newBSong); 
                        newSong.setSongSales(newSong.getSongSales()+1);

                    }
                }
                else if(newAudio instanceof Podcast){
                    msj = "is not posible buy a podcast";
                    
                }
                else{
                    msj = "must enter a user type consumer"; 
                }
            } 

        }
        return msj; 

    }

    public String accumulatedViews(){
        String msj = ""; 
        int totalViews=0;
        if(content.size()!=0){
            for(int i=0;i<content.size();i++){
            totalViews+=content.get(i).getView();
            }
        }
        msj = "The accumulated Views is:  " + totalViews ;
        return msj;
    }

    public String mostViewSongForUser(String nickname){
        String msj = ""; 
        User user = findUserConsumer(nickname);

        if(user == null){
            msj = "this user doesnt exist";
        }
        else{

            if(user instanceof Standard){
                Standard standard = ((Standard)(user)); 
                 msj=mostSongViews() + standard.mostSongAmountByUser();
            }
            else if(user instanceof Premium){
                Premium premium = ((Premium)(user)); 
                 msj=mostSongViews() + premium.mostSongAmountByUser();

            }
            else{
                msj="you must enter a user type consumer";
            }
        }
    return msj;

    }

    public String mostViewPodcastForUser(String nickname){
        String msj = ""; 
        User user = findUserConsumer(nickname);

        if(user == null){
            msj = "this user doesnt exist";
        }
        else{

            if(user instanceof Standard){
                Standard standard = (Standard) user; 
                 msj=mostPodcastViews() + standard.mostPodcastViews();
            }
            else if(user instanceof Premium){
                Premium premium = ( Premium) user; 
                msj=mostPodcastViews() + premium.mostPodcastViews();

            }
            else{
                msj="you must enter a user type consumer";
            }
        }
        return msj;
    }

    public String mostSongViews(){
      String msj="";
      int [] geners= {0,0,0,0};
      int position=0;
       if(content.size()!=0){
         for(int i=0; i<content.size();i++){
           if(content.get(i) instanceof Song){
             Song song = ( (Song)(content.get(i)) );
             switch(song.typeofGenre()){
               case 1:
                geners[0]++;
                break;
               case 2:
               geners[1]++;
                break;
               case 3:
               geners[2]++;
                break;
               case 4:
               geners[3]++;
                break;
               default:
                break;
             }
           }
         }
         int mayor=0;
          for(int i=0; i<4;i++){
           if(geners[i]>mayor){
             position=i;
           }
          }
         switch(position){
           case 0:
           msj="Most listened genre is rock \n"+"Views: "+geners[position];
           break;
           case 1:
           msj="Most listened genre is pop \n"+"Views: "+geners[position];
           break;
           case 2:
           msj="Most listened genre is trap \n"+"Views: "+geners[position];
           break;
           case 3:
           msj="Most listened genre is house \n"+"Views: "+geners[position];
           break;
           case 4:
           msj="the dont exist song";
           break;
         }
         
       }
       else{
         msj="the user dont have reproduction";
       }
      return msj;
     }

     public String mostPodcastViews(){
      String msj="";
      int [] geners= {0,0,0,0};
      int position=0;
       if(content.size()!=0){
         for(int i=0; i<content.size();i++){
           if(content.get(i) instanceof Podcast){
            Podcast podcast = ( (Podcast)(content.get(i)) );
             switch(podcast.typeOfCategory()){
               case 1:
                geners[0]++;
                break;
               case 2:
               geners[1]++;
                break;
               case 3:
               geners[2]++;
                break;
               case 4:
               geners[3]++;
                break;
               default:
                break;
             }
           }
         }
         int mayor=0;
          for(int i=0; i<4;i++){
           if(geners[i]>mayor){
             position=i;
           }
          }
         switch(position){
           case 0:
           msj="Most listened category is Politic \n"+"Views: "+geners[position];
           break;
           case 1:
           msj="Most listened category is Entertaiment \n"+"Views: "+geners[position];
           break;
           case 2:
           msj="Most listened category is Fashion \n"+"Views: "+geners[position];
           break;
           case 3:
           msj="Most listened category is Videogame \n"+"Views: "+geners[position];
           break;
           case 4:
           msj="the dont exist podcast";
           break;
         }
         
       }
       else{
         msj="the user dont have reproduction";
       }
      return msj;
     }

     public String infoSongsSold(){
        String msj = ""; 
        int countRock = 0;
        int countPop =0;
        int countTrap =0;
        int countHouse =0; 
        if(content.size()!=0){
                for(int i =0; i< content.size(); i++){
                    if(content.get(i) instanceof Song){
                        Song song = ( (Song)(content.get(i)) );
                        switch(song.typeofGenre()){
                         case 1:
                          countRock += song.getSongSales(); 
                          break;
                         case 2:
                         countPop += song.getSongSales(); 
                          break;
                         case 3:
                         countTrap += song.getSongSales(); 
                          break;
                         case 4:
                         countHouse += song.getSongSales(); 
                          break;
    
                         default:
                          break;
                       }
    
                    }
                }
            }else{
                 msj="There is no content in the platform";
            }
    
            msj = "Sales per genre: \n" +
                "Rock: " + countRock + "\n"+
                "Pop: " +  countPop + "\n"+
                "Trap: " + countTrap +"\n"+
                "House: "+ countHouse + "\n"; 
            return msj; 
    
       }

       public String totalSalesSongs(){
        String msj = ""; 
        double totalSales = 0.0; 
        if(content.size()!=0){
                for(int i =0; i< content.size(); i++){
                    if(content.get(i) instanceof Song){
                        Song song = ( (Song)(content.get(i)) );
                        totalSales += song.getSongSales() *  song.getPrice(); 
                    }
                }
            }else{
                msj="There is no content in the platform";
            }
            msj = "Total sales is " + totalSales; 
            return msj; 
       }

    //////////////////////////////////////////////////

    public int generateNumber(){
        int num = 0;
        Random r = new Random();
        num = r.nextInt(8+1) + 1;

        return num;

    }

    public String generateCode(int option, int[][]matrix){

        String code="";
        switch(option){
            case 1:
                for (int i = matrix.length; i > 0; i--) {
                    code += matrix[i - 1][0];
                }
                for (int i = 1, j = 1; i < matrix.length -1; i++, j++) {           
                    code+= matrix[i][j];        
                }
                for (int i = matrix.length; i > 0; i--) { 
                    code += matrix[i - 1][matrix[0].length - 1];
                }
            
            break;
  
            case 2:
                for (int j = 0; j < matrix.length -4; j++) { 
                    code+= matrix[0][j];
                }
                for (int i = 0; i < matrix.length; i++) { 
                    code += matrix[i][2];
                }
                for (int i = matrix.length; i > 0; i--) { 
                    code += matrix[i - 1][3];
                }
                for (int j = matrix.length -2; j < matrix.length; j++ ) { 
                    code += matrix[0][j];
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
            if(users.get(i) instanceof UserProducer){
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

    public void updateState(ProducerContent content){
        if(content instanceof Song){
            Song song = ( (Song)(content) );
            boolean val=false;
            for(int i=0;i<users.size() && !val;i++){
                if(users.get(i) instanceof Artist){
                    Artist artist = ( (Artist) (users.get(i)) );
                    if(artist.findSongArtist(song)){
                        artist.setTotalViews(artist.getTotalPlayedTime()+1);
                        artist.setTotalPlayedTime(song.getDuration()+artist.getTotalPlayedTime());
                        song.setView(song.getView()+1);
                        val=true;
                    }
                }
            }
    
        }
        else if(content instanceof Podcast){
           Podcast podcast = ( ( Podcast)(content) );
               boolean val=false;
               for(int i=0;i<users.size() && !val;i++){
                   if(users.get(i) instanceof ContentCreator){
                       ContentCreator creator = ( (ContentCreator)(users.get(i)) );
                       if(creator.findPodcastCreator(podcast)){
                          creator.setTotalViews(creator.getTotalPlayedTime()+1);
                          creator.setTotalPlayedTime(podcast.getDuration()+creator.getTotalPlayedTime());
                          podcast.setView(podcast.getView()+1);
                           val=true;
                       }
                   }
                }
    
            }
        }

    public int countBuysForUser(String nickname){
        int count =0; 
        if(boughtSongs.size() != 0){
    
            for(int i = 0; i <boughtSongs.size(); i++ ){
                boughtSongs.get(i).getNickname().equalsIgnoreCase(nickname);
                count++;
            }
    
        }
        return count; 
    
        } 

}

    

