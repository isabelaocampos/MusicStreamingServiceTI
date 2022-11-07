package model;

public interface IEditPlaylist {

    public String addAudioToPlaylist(String playlistName, int typeAudio, ProducerContent producerContent, String contentname);
    public String deleteAudioOfPlaylist(ProducerContent producerContent, String playlistName, String contentname);
    
}
