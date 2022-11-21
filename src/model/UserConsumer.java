package model;

import java.util.Calendar;

public abstract class UserConsumer extends User{

    private String nickname;
    private String id;

    public UserConsumer(String nickname, String id, Calendar vinculationDate) {
        super(vinculationDate);
        this.nickname = nickname;
        this.id = id; 
        
    }

    public String getNickName(){
        return this.nickname;
    }

    public void setNickName(String nickname){
        this.nickname = nickname;
    }

    public String getId(){
        return this.id;
    }
    /**
     * sharePlaylist: String: This method is for sharing a playlist to another user.
     * @param playlistName: String: the name of the playlist we are about to share.
     * @return: String: a message with the share code.
     */
    public abstract String sharePlaylist(String playlistName);

    /**
     * playlistMatrix: String: This method search for the playlist matrix, to generate the code.
     * @param playlistName: String: the name of the playlist we are about to share.
     * @return: String: a message with the matrix.
     */
    public abstract String playlistMatrix(String playlistName);

    /**
     * printMatrix: String: This method prints a matrix.
     * @param matrix: int: The matrix to print.
     * @return: String: Printed matrix.
     */
    public abstract String printMatrix(int[][] matrix);

    
    
    
}
