package model;

import java.util.Calendar;

public class Standard extends UserConsumer implements ICreatePlaylist, IEditPlaylist, IPlayContent{

    private Playlist[] playlist;
    public static int TOTAL_PLAYLIST_PER_STANDART = 20;
    public static int TOTAL_SONGS_PER_STANDART = 100;
    private Song[] boughtSongs;
    
    public Standard(String nickname, String id, Calendar vinculationDate) {
        super(nickname, id, vinculationDate);
        playlist = new Playlist[TOTAL_PLAYLIST_PER_STANDART];
        boughtSongs = new Song[TOTAL_SONGS_PER_STANDART];
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

    public boolean availablePlaylist(){
        boolean validation = true;
        if(playlist[19] != null){
            validation = false;
        }

        return validation;
    }

    public boolean availableSong(){
        boolean validation = true;
        if(boughtSongs[99] != null){
            validation = false;
        }

        return validation;
    }

/* 
    @Override
    public boolean buySong(String nickname, String contentname) {
        boolean validate = true;
        Song newBoughtSong = searchSong(contentname);
        if(newBoughtSong != null){
            validate = false;
        }else{
            boolean secondValidate = availableSong();
            if(secondValidate == true){
                newBoughtSong = new Song(contentname);
                secondValidate = false;
                for(int i= 0; i<20 && !secondValidate; i++){
                    if(boughtSongs[i] == null){
                        boughtSongs[i] = newBoughtSong;
                        secondValidate = true;
                    }
                }
            }
        }
        
        return true;
    }
*/
/* 
    @Override
    public Song searchSong(String contentName) {
        // TODO Auto-generated method stub
        return null;
    }
*/

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
        // TODO Auto-generated method stub
        return null;
    }
    
    


}
