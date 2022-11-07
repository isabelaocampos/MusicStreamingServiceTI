package model;

import java.util.Calendar;

public class Standard extends UserConsumer implements ICreatePlaylist, IEditPlaylist{

    private Playlist[] playlist;
    public static int TOTAL_PLAYLIST_PER_STANDART = 20;
    public static int TOTAL_SONGS_PER_STANDART = 100;
    
    public Standard(String nickname, String id, Calendar vinculationDate) {
        super(nickname, id, vinculationDate);
        playlist = new Playlist[TOTAL_PLAYLIST_PER_STANDART];
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
                        boolean audiorepit= Aplaylist.searchAudio(contentname);
                        if(audiorepit == false){
                            Aplaylist.getAudios().add(producerContent);
                            msj="audio added";

                        }else{
                            msj="the audio is repit";
                        }
                        }
                        else{
                            msj="you cant add this audio beacuse is diferent type of playlist";
                        }
                    }
                    if(Aplaylist.typePlaylist()==2){
                        if(Aplaylist.typePlaylist()==typeAudio){
                            boolean audiorepit= Aplaylist.searchAudio(contentname);
                            if(audiorepit == false){
                                Aplaylist.getAudios().add(producerContent);
                                msj="audio added";
                            }
                            else{
                                msj="the audio is repit";
                            }
                        }
                        else{
                            msj="you cant add this audio beacuse is difertent type of playlist";
                        }
                    }
                    if(Aplaylist.typePlaylist()==3){
                        
                            boolean audiorepit= Aplaylist.searchAudio(contentname);
                            if(audiorepit == false){
                                Aplaylist.getAudios().add(producerContent);
                                msj="audio added";
                            }
                            else{
                                msj="the audio is repit";
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
            msj="dont exist the playslist";
        }
        else{
            boolean audiorepit=Aplaylist.searchAudio(contentname);
          if(audiorepit==true){
            Aplaylist.getAudios().remove(producerContent);
            msj="has been removed successfully";
            }
            else{
            msj="no such audio found";
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


}
