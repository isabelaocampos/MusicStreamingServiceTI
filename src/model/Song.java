package model;


public class Song extends ProducerContent {

    private String album;
    private double price;
    private int songSales;

    private TypeOfGenreSongs typeofGenre;

    public Song(String contentname, String imageURL, int duration, String album, double price, int option) {
        super(contentname, imageURL, duration);
        this.album = album;
        this.price= price;
        this.songSales = 0;
        
        switch(option){
            case 1:
            typeofGenre=TypeOfGenreSongs.ROCK;
            case 2:
            typeofGenre=TypeOfGenreSongs.POP;
            case 3:
            typeofGenre=TypeOfGenreSongs.TRAP;
            case 4:
            typeofGenre=TypeOfGenreSongs.HOUSE;
        }
    }

    public String getAlbum(){
        return this.album;
    }

    public double getPrice(){
        return this.price;
    }
    
    public int getSongSales() {
        return songSales;
    }


    public void setSongSales(int songSales) {
        this.songSales = songSales;
    }

    public TypeOfGenreSongs getTypeOfGenre() {
        return typeofGenre;
    }


    public int typeofGenre(){
        switch (typeofGenre) {
            case ROCK:
                return 1;
            case POP:
                return 2;
            case TRAP:
                return 3;
            case HOUSE:
                return 4;
            default:
             return 0;
     }  
}

}