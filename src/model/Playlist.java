package model;

import java.util.ArrayList;

public class Playlist {

    private String playlistName;
    private ArrayList<ProducerContent> audios;
    private int matrix[][];
    private String code;
    private TypeOfPlaylist typeOfPlaylist;

    public Playlist(String playlistName, int[][] matrix, String code, int option){
        this.playlistName = playlistName;
        this.matrix = matrix;
        this.code = code;

        audios = new ArrayList<ProducerContent>();
        switch(option){
            case 1:
            typeOfPlaylist=TypeOfPlaylist.SONG ;
            break;
            case 2:
            typeOfPlaylist=TypeOfPlaylist.PODCAST ;
            break;
            case 3:
            typeOfPlaylist=TypeOfPlaylist.SONGANDPODCAST;
            break;
        }
    }


    public String getPlaylistName() {
        return playlistName;
    }


    public void setName(String name) {
        this.playlistName = name;
    }


    public ArrayList<ProducerContent> getAudios() {
        return audios;
    }


    public void setAudios(ArrayList<ProducerContent> audios) {
        this.audios = audios;
    }


    public int[][] getMatrix() {
        return matrix;
    }


    public void setMatrix(int[][] matriz) {
        this.matrix = matriz;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public TypeOfPlaylist getTypePlaylist() {
        return typeOfPlaylist;
    }


    public void setTypePlaylist(TypeOfPlaylist typeOfPlaylist) {
        this.typeOfPlaylist = typeOfPlaylist;
    }


    public int typePlaylist(){
        switch (typeOfPlaylist) {
            case SONG:
                return 1;
            case PODCAST:
                return 2;
            case SONGANDPODCAST:
                return 3;
            default:
             return 0;
        }   
    }
    
    /**
     * searchContent: boolean: This method search for content, such as a song or a podcast.
     * @param contentname: String: This parameter is the name of the content we are searching.
     * @return: search: boolean: The return of the method is a boolean.
     */
    public boolean searchContent(String contentname) {

        ProducerContent obj = null;
        boolean search = false;
        if (audios != null) {
            for (int i = 0; i < audios.size() && !search; i++) {
                if (audios.get(i).getContentName().equalsIgnoreCase(contentname)) {
                    obj = audios.get(i);
                    search = true;
                }
            }
        }

        return search;

    }


}
    
    

