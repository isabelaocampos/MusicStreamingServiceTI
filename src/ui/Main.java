package ui;

import model.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;



public class Main{
    private Scanner reader;
    private Controller controller;
    
    public Main(){
        this.reader = new Scanner(System.in);
        controller = new Controller();
    }

    public Scanner getReader(){
        return reader;
    }

    public static void main(String[] args){
        Main main = new Main();

        int option = 0; 

				do{

					option = main.getOptionShowMenu(); 
					main.executeOption(option);

				}while(option != 0);

				main.getReader().close();
	}
	
	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println("<<<<< Welcome to NeoTunes your #1 music streaming system >>>>>");
		System.out.println(
				"1. Register producer users, artists and content creators.\n" +
				"2. Register standart users and premium users \n" +
				"3. Register song and podcasts \n" + 
                "4. Create a playlist \n" +
                "5. Edit a playlist \n" +
				"0. Exit. ");
		option = reader.nextInt(); 

		return option; 
	}

    public void executeOption(int option){
        int typeOfUser, duration, typeOfContent, typeOfGenreSong, typeOfCategoryPodcast, typeOfPlaylist, typeOfEdition = 0;
        double price = 0;
        String msj, name, imageURL, id, nickname, contentname, album, description, playlistName= "";
        Calendar vinculationDate = dateToday();
    

        switch(option){
            case 1: 
            
            System.out.println("You are about to register a producer, artist or content creator");
            System.out.println("Choose the type of user you are about to register: ");
            System.out.println("1. Artist \n" +
            "2. Content Creator");
            typeOfUser = reader.nextInt();
            if(typeOfUser == 1){
                System.out.println("Write the name of the artist:");
				name = reader.next();
				System.out.println("Write the URL of the image that represents the artist the best: ");
				imageURL = reader.next();
				
				msj = controller.addUserProducer(name,vinculationDate,imageURL, TypeOfUserProducer.ARTIST);
				System.out.println(msj);


            }else if(typeOfUser == 2){
                System.out.println("Write the name of the content creator:");
				name = reader.next();
				System.out.println("Write the URL of the image that represents the content creator the best: ");
				imageURL = reader.next();
				
				msj = controller.addUserProducer(name,vinculationDate,imageURL, TypeOfUserProducer.CONTENTCREATOR);
				System.out.println(msj);

            }else{
                System.out.println("Invalid Option");

            }

            break;
            case 2:
            
            System.out.println("You are about to register an user, it can be Standard or Premium");
            System.out.println("Choose the type of user you are about to register: ");
            System.out.println("1. Standard \n" +
            "2. Premium");
            typeOfUser = reader.nextInt();
            if(typeOfUser == 1){
                System.out.println("Write the nickname of the user:");
				nickname = reader.next();
				System.out.println("Write the id of the user: ");
				id = reader.next();

				msj = controller.addUserConsumer(nickname,id,vinculationDate, TypeOfUserConsumer.STANDARD);
				System.out.println(msj);


            }else if(typeOfUser == 2){
                System.out.println("Write the nickname of the user:");
				nickname = reader.next();
				System.out.println("Write the id of the user: ");
				id = reader.next();

				msj = controller.addUserConsumer(nickname,id,vinculationDate, TypeOfUserConsumer.PREMIUM);
				System.out.println(msj);

            }else{
                System.out.println("Invalid Option");

            }
            
            break;
            case 3:
            System.out.println("You are know adding a new song or a podcast");
            System.out.println("Please write the name of the artist or content creator: ");
            name = reader.next();
            System.out.println("Write the name of the content");
            contentname = reader.next();
            System.out.println("Type the URL of the image that represents the content");
            imageURL = reader.next();
            System.out.println("Write the duration of the content");
            duration = reader.nextInt();
            System.out.println("Choose the type of content you are adding:");
            System.out.println("1. Song \n"+
            "2. Podcast");
            typeOfContent = reader.nextInt();

            if(typeOfContent == 1){
                System.out.println("Choose the genre of the song you are adding: ");
                System.out.println("1. Rock \n" +
                "2. Pop \n" +
                "3. Trap \n"+
                "4. House");
                typeOfGenreSong = reader.nextInt();
                if(typeOfGenreSong == 1){
                    System.out.println("Write the name of the album");
                    album = reader.next(); 
                    System.out.println("Write the price of the song");
                    price= reader.nextDouble();
                    System.out.println(controller.addSong(contentname, name, album, imageURL, duration, price, TypeOfGenreSongs.ROCK));

                 }else if(typeOfGenreSong == 2){
                    System.out.println("Write the name of the album");
                    album = reader.next(); 
                    System.out.println("Write the price of the song");
                    price= reader.nextDouble();
                    System.out.println(controller.addSong(contentname, name, album, imageURL, duration, price, TypeOfGenreSongs.POP));

                 }else if(typeOfGenreSong == 3){
                    System.out.println("Write the name of the album");
                    album = reader.next(); 
                    System.out.println("Write the price of the song");
                    price= reader.nextDouble();
                    System.out.println(controller.addSong(contentname, name, album, imageURL, duration, price, TypeOfGenreSongs.TRAP));

                }else if(typeOfGenreSong == 4){
                    System.out.println("Write the name of the album");
                    album = reader.next(); 
                    System.out.println("Write the price of the song");
                    price= reader.nextDouble();
                    System.out.println(controller.addSong(contentname, name, album, imageURL, duration, price, TypeOfGenreSongs.HOUSE));

                 }else{
                    System.out.println("Sorry, this is not a valid option");

                }
            }else if(typeOfContent == 2){
                System.out.println("Choose the genre of the podcast you are adding: ");
                System.out.println("1. Politics \n" +
                "2. Entertainment \n" +
                "3. Videogames \n"+
                "4. Fashion");
                typeOfCategoryPodcast = reader.nextInt();
                if(typeOfCategoryPodcast == 1){
                    System.out.println("Write the name of the podcast");
                    album = reader.next(); 
                    System.out.println("Write the description of the podcast");
                    description= reader.next();
                    System.out.println(controller.addPodcast(contentname, name, description, imageURL, duration, TypeOfCategoryPodcast.POLITICS));

                 }else if(typeOfCategoryPodcast == 2){
                    System.out.println("Write the name of the podcast");
                    album = reader.next(); 
                    System.out.println("Write the description of the podcast");
                    description= reader.next();
                    System.out.println(controller.addPodcast(contentname, name, description, imageURL, duration, TypeOfCategoryPodcast.ENTERTAINMENT));

                 }else if(typeOfCategoryPodcast == 3){
                    System.out.println("Write the name of the podcast");
                    album = reader.next(); 
                    System.out.println("Write the description of the podcast");
                    description= reader.next();
                    System.out.println(controller.addPodcast(contentname, name, description, imageURL, duration, TypeOfCategoryPodcast.VIDEOGAMES));

                 }else if(typeOfCategoryPodcast == 4){
                    System.out.println("Write the name of the podcast");
                    album = reader.next(); 
                    System.out.println("Write the description of the podcast");
                    description= reader.next();
                    System.out.println(controller.addPodcast(contentname, name, description, imageURL, duration, TypeOfCategoryPodcast.FASHION));

                 }else{

                 }
                }else{
                
                 msj = "Sorry, an error happen";
                }

            
            break;
            case 4: 
            System.out.println("You are know creating a playlist");
            System.out.println("Write the user nickname");
            nickname = reader.next();
            System.out.println("Write the playlist name");
            playlistName = reader.next();
            System.out.println("Choose the type of playlist");
            System.out.println("1. Just Songs \n" +
            "2.Just podcasts \n" +
            "3.Podcast and Songs");
            typeOfPlaylist = reader.nextInt();
            System.out.println(controller.addPlaylist(nickname, playlistName, typeOfPlaylist));

            break;

            case 5: 
            System.out.println("You are know editing a playlist");
            System.out.println("Write the user nickname");
            nickname= reader.next();
            System.out.println("Choose the option you want");
            System.out.println("1. Add audio to the playlist \n" +
            "Delete audio of playlist");
            typeOfEdition = reader.nextInt();
            System.out.println("Write the playlist name");
            playlistName = reader.next();
            System.out.println("Write the name of the audio");
            contentname = reader.next();

            System.out.println(controller.editAudioToPlaylist(option, nickname, playlistName, playlistName));

            break;

        }
    }

    ////////////////

    public Calendar dateToday(){
        
        Calendar calendar=new GregorianCalendar(2022,Calendar.NOVEMBER,8);
        return calendar ;
         
    }

}