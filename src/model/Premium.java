package model;

import java.util.ArrayList;
import java.util.Calendar;

public class Premium extends UserConsumer implements ICreatePlaylist, IEditPlaylist{

    private ArrayList<Playlist> playlistsPremiumUser;
    
    private ArrayList<Song> songsPremiumUser;

    public Premium(String nickname, String id, Calendar vinculationDate){
        super(nickname, id, vinculationDate);
        playlistsPremiumUser = new ArrayList<Playlist>(20);
        songsPremiumUser = new ArrayList<Song>(100);
        
    }

    public ArrayList<Playlist> getPremiumPlaylist(){
        return playlistsPremiumUser;
    }
    

    public ArrayList<Song> getPremiumSongs(){
        return songsPremiumUser;
    }

   

    @Override
    public String addAudioToPlaylist(String playlistName, int typeAudio, ProducerContent producerContent,
            String contentname) {
                String msj="";
                Playlist thePlaylist=searchPlaylist(playlistName);
                if(thePlaylist==null){
                    msj="Sorry this playlist doesn't exist";
                 }
                 else{
                    if(thePlaylist.typePlaylist()==1){
                        if(thePlaylist.typePlaylist()==typeAudio){
                            boolean audiorepit=thePlaylist.searchContent(contentname);
                            if(audiorepit== false){
                                thePlaylist.getAudios().add(producerContent);
                            }
                            else{
                                msj="The audio is repeated";
                            }
                        }
                        else{
                            msj="Sorry, but this type of audio can't be added to this type of playlist";
                        }
                    }
                    if(thePlaylist.typePlaylist()==2){
                        if(thePlaylist.typePlaylist()==typeAudio){
                            boolean audiorepit=thePlaylist.searchContent(contentname);
                            if(audiorepit== false){
                                thePlaylist.getAudios().add(producerContent);
                            }
                            else{
                                msj="The audio is repeated";
                            }
                        }
                        else{
                            msj="Sorry, but this type of audio can't be added to this type of playlist";
                        }
                    }
                    if(thePlaylist.typePlaylist()==3){
                        
                            boolean audiorepit=thePlaylist.searchContent(contentname);
                            if(audiorepit == false){
                                thePlaylist.getAudios().add(producerContent);
                            }
                            else{
                                msj="The audio is repeated";
                            }
                    }
                 }
                
                return msj;
        
            }
    

    @Override
    public String deleteAudioOfPlaylist(ProducerContent producerContent, String playlistName, String contentname) {
        String msj="";
        Playlist thePlaylist=searchPlaylist(playlistName);
        if(thePlaylist==null){
             msj="The playlist doesn't exist";
        }
        else{
            boolean audiorepit=thePlaylist.searchContent(contentname);
            if(audiorepit==true){
            thePlaylist.getAudios().remove(producerContent);
            msj="The audio has been deleted from the playlist successfully";
          }
          else{
            msj="We couldn't found this audio, try again";
          }

          
       }
       return msj;

    }

    @Override
    public boolean addPlaylist(String name, int[][] matrix, String code, int option) {
        boolean msj = true;
        Playlist newPlaylist= searchPlaylist(name);

        if (newPlaylist != null) {
            msj = false;
        } 
        else {
          playlistsPremiumUser.add(new Playlist(name, matrix, code, option));       
             }

        return msj;

    }


    
    @Override
    public Playlist searchPlaylist(String name) {
        Playlist newPlaylist=null;
        boolean validation= false;
         for(int i=0;i<playlistsPremiumUser.size() && !validation ;i++){
            if( playlistsPremiumUser.get(i).getPlaylistName().equalsIgnoreCase(name)){
                newPlaylist=playlistsPremiumUser.get(i);
                validation= true;
            }
         }
    
        return newPlaylist;
    }

    public String delateAudio(ProducerContent newAudio, String namePlaylist, String audio) {
        return null;
    }
}
