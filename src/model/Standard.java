package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

public class Standard extends UserConsumer implements ICreatePlaylist, IEditPlaylist, IPlayContent{

    private Playlist[] playlist;
    public static int TOTAL_PLAYLIST_PER_STANDART = 20;
    public static int TOTAL_SONGS_PER_STANDART = 100;
    private ArrayList <ProducerContent> audios;
    
    public Standard(String nickname, String id, Calendar vinculationDate) {
        super(nickname, id, vinculationDate);
        playlist = new Playlist[TOTAL_PLAYLIST_PER_STANDART];
        audios= new ArrayList<ProducerContent>();
    }
    

    @Override
    public String addAudioToPlaylist(String playlistName, int typeAudio, ProducerContent producerContent, String contentname) {
        String msj= "";
        Playlist Aplaylist = searchPlaylist(playlistName);

            if(Aplaylist == null){
                msj = "Sorry we couldn't find this playlist";

            }else{
                if(Aplaylist.typePlaylist() == 1){
                    if(Aplaylist.typePlaylist()==typeAudio){
                        boolean audiorepit= Aplaylist.searchContent(contentname);
                        if(audiorepit == false){
                            Aplaylist.getAudios().add(producerContent);
                            msj="Audio added successfully";

                        }else{
                            msj="Sorry, the audio is repeated";
                        }
                        }
                        else{
                            msj="Sorry, but this type of audio can't be added to this type of playlist";
                        }
                    }
                    if(Aplaylist.typePlaylist()==2){
                        if(Aplaylist.typePlaylist()==typeAudio){
                            boolean audiorepit= Aplaylist.searchContent(contentname);
                            if(audiorepit == false){
                                Aplaylist.getAudios().add(producerContent);
                                msj="Audio added successfully";
                            }
                            else{
                                msj="Sorry, the audio is repeated";
                            }
                        }
                        else{
                            msj="Sorry, but this type of audio can't be added to this type of playlist";
                        }
                    }
                    if(Aplaylist.typePlaylist()==3){
                        
                            boolean audiorepit= Aplaylist.searchContent(contentname);
                            if(audiorepit == false){
                                Aplaylist.getAudios().add(producerContent);
                                msj="Audio added successfully";
                            }
                            else{
                                msj="Sorry, the audio is repeated";
                            }
                    }
                 }
                
                return msj;
        
            }

    @Override
    public String deleteAudioOfPlaylist(ProducerContent producerContent, String playlistName, String contentname) {
        String msj="";
        Playlist Aplaylist=searchPlaylist(playlistName);
        if(Aplaylist==null){
            msj="The playlist doesn't exist";
        }
        else{
            boolean audiorepit=Aplaylist.searchContent(contentname);
          if(audiorepit==true){
            Aplaylist.getAudios().remove(producerContent);
            msj="The audio has been delete of the playlist successfully";
            }
            else{
            msj="We couldn't found this audio, try again";
            }

          
       }
       return msj;

    }
    
    @Override
    public boolean addPlaylist(String playlistName, int[][] matrix, String code, int option) {
        
        boolean validation = true;
        Playlist newPlaylist = searchPlaylist(playlistName);
        if(newPlaylist != null){
            validation = false;
        } else{
            boolean otherValidation = availablePlaylist();
            if(otherValidation == true){
                newPlaylist = new Playlist(playlistName, matrix, code, option);
                otherValidation = false;
                for(int i=0; i<20 && !otherValidation ; i++){
                    if(playlist[i] == null){
                        playlist[i]= newPlaylist;
                        otherValidation = true;
                    }
                }
            }
        }
        return validation;
    }

    @Override
    public Playlist searchPlaylist(String playlistName) {
        Playlist newPlaylist = null;
        boolean validation = false;
        for(int i =0; i<20 && !validation; i++){
            if(playlist[i] != null && playlist[i].getPlaylistName().equals(playlistName)){
                newPlaylist = playlist[i];
                validation = true;
            }
        }
        return newPlaylist;
    }

    /**
     * availablePlaylist: This method searh for an available position in the array of playlist.
     * @return validation: boolean: true if is not there, false if is there.
     */
    public boolean availablePlaylist(){
        boolean validation = true;
        if(playlist[19] != null){
            validation = false;
        }

        return validation;
    }

    @Override
    public String sharePlaylist(String playlistName) {
        String msj = "";
        Playlist playlist = searchPlaylist(playlistName);
        if(playlist == null){
            msj = "Sorry, we couldn't find this playlist";

        }else{
            msj = playlist.getCode();
        }
        return msj;
    }

    @Override
    public String playlistMatrix(String playlistName) {
        String msj = "";
        Playlist playlist = searchPlaylist(playlistName);
        if(playlist == null){
            msj = "Sorry an unexpected error happened";
        }else{
            msj = printMatrix(playlist.getMatrix());
        }
        return msj;
    }

    @Override
    public String printMatrix(int [][] matrix){
        String pmatrix = "";
        for (int i = 0; i < matrix.length; i++) { // filas numbers.length
        for (int j = 0; j < matrix[0].length; j++) { // columnas numbers[0].length
          pmatrix += matrix[i][j] + " ";
        }
        pmatrix += "\n";
      }
  
      return pmatrix;
        
    }

    @Override
    public String playContent(ProducerContent content) {
        String msj = "." + "\n"+ "." + "\n"+ "." +  "\n" + " the audio is playing" + "." + "\n";   ; 
        if(audios.size()==0){

        }
        else{
            int reproduction =audios.size();
            String ad1 = "Nike -Just Do It" + "\n";
            String ad2 = "Coca-Cola -Open Happiness" + "\n";
            String ad3= "M&Ms -  Melts in your mouth" + "\n";

            if(reproduction %2 ==0){
                int number = generateNumber();
                switch(number){
                case 1: 
                    msj = ad1;
                    break;
                case 2:
                    msj = ad2;
                    break;
                case 3:
                    msj = ad3;
                    break;
                }
            }
            else{
                audios.add(content);
            }
        }

        return msj;
    }

    /**
     * generateNumber: This method generates a random number.
     * @return value : int: Random number. 
     */
    public int generateNumber(){

        Random r= new Random();
       
         int value = r.nextInt(2 + 1) + 1;
       
        return value;
    }
    /**
     * mostSongAmountByUser: String: This method reports the most played song in the app.
     * @return msj: String : A message with the most listened song.
     */
    public String mostSongAmountByUser(){
        String msj="";
        int [] geners= {0,0,0,0};
        int position=0;
         if(audios.size()!=0){
           for(int i=0; i<audios.size();i++){
             if(audios.get(i) instanceof Song){
               Song song = ( (Song)(audios.get(i)) );
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
             msj="Most listened genre is Rock \n"+"Amount of Views: "+geners[position];
             break;
             case 1:
             msj="Most listened genre is Pop \n"+"Amount of Views: "+geners[position];
             break;
             case 2:
             msj="Most listened genre is Trap \n"+"Amount of Views: "+geners[position];
             break;
             case 3:
             msj="Most listened genre is House \n"+"Amount of Views: "+geners[position];
             break;
             case 4:
             msj="Sorry the song doesn't exist";
             break;
           }
           
         }
         else{
           msj="User doesn't have reproductions";
         }
        return msj;
       }


       /**
     * mostPodcastViews: This method reports the podcast with most Views. 
     * @return msj: String : A message with the most listened podcast.
     */
       public String mostPodcastViews(){
        String msj="";
        int [] geners= {0,0,0,0};
        int position=0;
         if(audios.size()!=0){
           for(int i=0; i<audios.size();i++){
             if(audios.get(i) instanceof Podcast){
              Podcast podcast = ( (Podcast)(audios.get(i)) );
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
             msj="Most listened category: Politic \n"+"Views: "+geners[position];
             break;
             case 1:
             msj="Most listened category: Entertaiment \n"+"Views: "+geners[position];
             break;
             case 2:
             msj="Most listened category: Fashion \n"+"Views: "+geners[position];
             break;
             case 3:
             msj="Most listened category: Videogame \n"+"Views: "+geners[position];
             break;
             case 4:
             msj="This podcast doesn't exist";
             break;
           }
           
         }
         else{
           msj="the user dont have reproduction";
         }
        return msj;
       }
    
    


}
