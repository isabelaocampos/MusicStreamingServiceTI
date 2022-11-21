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
                "6. Share playlist \n" +
                "7. Play song or podcast \n" +
                "8. Buy a song \n" +
                "9. Get reports \n" +
				"0. Exit. ");
		option = reader.nextInt(); 

		return option; 
	}

    public void executeOption(int option){
        int typeOfUser, duration, typeOfContent, typeOfGenreSong, typeOfCategoryPodcast, typeOfPlaylist, typeOfEdition, typeOfReport = 0;
        double price = 0;
        String  msj, name, imageURL, nickname, contentname, album, description, playlistName, songName, audioToPlay, id= "";
    

        switch(option){
            case 1: 
            
            System.out.println("You are about to register a producer, artist or content creator");
            System.out.println("Choose the type of user you are about to register: ");
            System.out.println("1. Artist \n" +
            "2. Content Creator");
            typeOfUser = validateIntegerInput();
            if((typeOfUser==2||typeOfUser==1) && typeOfUser != -1){
                if(typeOfUser == 1){
                    System.out.println("Write the name of the artist:");
                    name = reader.next();
                    System.out.println("Write the URL of the image that represents the artist the best: ");
                    imageURL = reader.next();
                    
                    msj = controller.addUserProducer(name,imageURL, TypeOfUserProducer.ARTIST);
                    System.out.println(msj);
    
    
                }else if(typeOfUser == 2){
                    System.out.println("Write the name of the content creator: ");
                    name = reader.next();
    
                    System.out.println("Write the URL of the image that represents the content creator the best: ");
                    imageURL = reader.next();
                    
                    msj = controller.addUserProducer(name,imageURL, TypeOfUserProducer.CONTENTCREATOR);
                    System.out.println(msj);
    
                }else{
                    System.out.println("Invalid Option");
    
                }
            }
             else{
                System.out.println("Invalid Option");
             }
           

            break;
            case 2:
            
            System.out.println("You are about to register an user, it can be Standard or Premium");
            System.out.println("Choose the type of user you are about to register: ");
            System.out.println("1. Standard \n" +
            "2. Premium");
            typeOfUser = validateIntegerInput();
            if((typeOfUser==2 || typeOfUser==1) && typeOfUser != -1){
                if(typeOfUser == 1){
                    System.out.println("Write the nickname of the new user:");
                    nickname = reader.next();
                    System.out.println("Write the id (cedula) of the new user(example. 100023434): ");
                    id = reader.next();
    
                    msj = controller.addUserConsumer(nickname,id, TypeOfUserConsumer.STANDARD);
                    System.out.println(msj);
    
    
                }else if(typeOfUser == 2){
                    System.out.println("Write the nickname of the new user:");
                    nickname = reader.next();
                    System.out.println("Write the id (cedula) of the new user(example. 100023434): ");
                    id = reader.next();
    
                    msj = controller.addUserConsumer(nickname,id, TypeOfUserConsumer.PREMIUM);
                    System.out.println(msj);
    
                }else{
                    System.out.println("Invalid Option");
    
                }
            } else{
               System.out.println("Invalid Option");
            } 
            
            
            break;
            case 3:
            System.out.println("Choose the type of content you are adding: ");
            System.out.println("1. A song \n" +
            "2. A podcast");
            typeOfContent = validateIntegerInput();
            
            if((typeOfContent==2 || typeOfContent==1) && typeOfContent != -1){

                if(typeOfContent == 1){
                    System.out.println("You are know adding a song, please write the name of the artist: ");
                    name = reader.next();
                    System.out.println("Write the name of the song you are creating: ");
                    contentname = reader.next();
                    System.out.println("Write the duration of the song you are adding (Example. 3:44 -> 344): ");
                    duration = reader.nextInt();
                    System.out.println("Write the URL of the image that represents the album: ");
                    imageURL = reader.next();
                    System.out.println("Write the name of the album whom the song belongs: ");
                    album = reader.next(); 
                    System.out.println("Write the price of the song: ");
                    price= validateDoubleInput();
		            if(price == -1){
		        	System.out.println("Invalid Option"); 
		        	}
                    System.out.println("Choose the genre of the song you are adding: ");
                    System.out.println("1. Rock \n" +
                    "2. Pop \n" +
                    "3. Trap \n"+
                    "4. House");
                    typeOfGenreSong = reader.nextInt();
                    if(typeOfGenreSong == 1){
                        System.out.println(controller.addSong(contentname, name, album, imageURL, duration, price, TypeOfGenreSongs.ROCK));
    
                    }else if(typeOfGenreSong == 2){
                        System.out.println(controller.addSong(contentname, name, album, imageURL, duration, price, TypeOfGenreSongs.POP));
    
                    }else if(typeOfGenreSong == 3){
                        System.out.println(controller.addSong(contentname, name, album, imageURL, duration, price, TypeOfGenreSongs.TRAP));
    
                    }else if(typeOfGenreSong == 4){
                        System.out.println(controller.addSong(contentname, name, album, imageURL, duration, price, TypeOfGenreSongs.HOUSE));
    
                     }else{
                        System.out.println("Sorry, this is not a valid option");
    
                    }
                }else if(typeOfContent == 2){
                    System.out.println(" You are know adding a podcast, please write the name of the content creator: ");
                    name= reader.next();
                    System.out.println("Write the name of the podcast: ");
                    contentname = reader.next();
                    System.out.println("Write the imageURL that represents the podcast: ");
                    imageURL = reader.next();
                    System.out.println("Write the duration of the podcast (Example. 10:34 -> 1034): ");
                    duration = reader.nextInt();
                    System.out.println("Write the description of the podcast");
                    description= reader.next();
                    System.out.println("Choose the genre of the podcast you are adding: ");
                    System.out.println("1. Politics \n" +
                    "2. Entertainment \n" +
                    "3. Videogames \n"+
                    "4. Fashion");
                    typeOfCategoryPodcast = reader.nextInt();
                    if(typeOfCategoryPodcast == 1){
                        System.out.println(controller.addPodcast(contentname, name, description, imageURL, duration, TypeOfCategoryPodcast.POLITICS));
    
                     }else if(typeOfCategoryPodcast == 2){
                        System.out.println(controller.addPodcast(contentname, name, description, imageURL, duration, TypeOfCategoryPodcast.ENTERTAINMENT));
    
                     }else if(typeOfCategoryPodcast == 3){
                        System.out.println(controller.addPodcast(contentname, name, description, imageURL, duration, TypeOfCategoryPodcast.VIDEOGAMES));
    
                     }else if(typeOfCategoryPodcast == 4){
                        System.out.println(controller.addPodcast(contentname, name, description, imageURL, duration, TypeOfCategoryPodcast.FASHION));
    
                     }else{
                        System.out.println("Sorry this is not a valid option");
                     }
                    }else{
                        System.out.println("Sorry, an error happen");
                    }
             } else{
                System.out.println("enter a available option... :(");
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
            typeOfPlaylist = validateIntegerInput();
		        if(typeOfPlaylist>4|| typeOfPlaylist<1){
		            System.out.println("Invalid Option");
		        }
		        else{
                    System.out.println(controller.addPlaylist(nickname, playlistName, typeOfPlaylist));
		        }

           

            break;

            case 5: 
            System.out.println("You are know editing a playlist");
            System.out.println("Write the nickname of the user to whom the playlist belongs: ");
            nickname= reader.next();
            System.out.println("Choose the option you want");
            System.out.println("1. Add audio to the playlist \n" +
            "2. Delete audio of playlist");
            typeOfEdition = validateIntegerInput(); 
            if((typeOfEdition==1 || typeOfEdition==2) && typeOfEdition != -1){
                System.out.println("Write the playlist name: ");
                playlistName = reader.next();
                System.out.println("Write the name of the audio: ");
                contentname = reader.next();
    
                System.out.println(controller.editAudioToPlaylist(typeOfEdition, nickname, playlistName, contentname));
       
             }else{
                System.out.println("Invalid Option");
             }
            
            break;

            case 6:
            System.out.println("You are know sharing a playlist");
            System.out.println("Please write the name of the user");
            nickname = reader.next();
            System.out.println("Write the name of the playlist");
            playlistName = reader.next();

            msj = controller.sharePlaylist(nickname, playlistName);
            System.out.println(msj);
            break;
            
            case 7:
            System.out.println("You are about to play a song or podcast");
            System.out.println("Write the nickname of the user");
            nickname = reader.next();

            System.out.println("Write the name of the song or podcast: ");
            audioToPlay = reader.next();

            msj = controller.playingAudio(nickname, audioToPlay);
            
            System.out.println(msj);
            break;
            
            case 8: 
            System.out.println("You are about to buy a song");
            System.out.println("Write the nickname of the user");
            nickname = reader.next();
            System.out.println("Write the name of the song you want to buy");
            songName = reader.next();

            msj = controller.buySong(nickname, songName);
            System.out.println(msj);
            

            break;

            case 9:
            System.out.println("You are know in the reports, choose the report you want to see:");
            System.out.println("1. Accumulated views of songs and podcast across the platform \n" +
            "2. Most listened song genre for a user and on the platform \n" + 
            "3. Most listened podcast category for a user and on the platform \n" +
            "4. Amount of songs sold and total sales value per genre \n" +
            "5. Best selling song on the platform \n" +
            "6. Show all reports");
            typeOfReport = reader.nextInt();

            switch(typeOfReport){

                case 1:
                msj = controller.accumulatedViews() ;
                System.out.println(msj);
                break;
                case 2:
                System.out.println("Write the user nickname: ");
                nickname = reader.next();
                msj = controller.mostViewSongForUser(nickname);
                System.out.println(msj);
                break;

                case 3:
                System.out.println("Write the user nickname: ");
                nickname = reader.next();
                msj = controller.mostViewPodcastForUser(nickname);
                System.out.println(msj);
                break;


                case 4:
                msj = controller.infoSongsSold();
                System.out.println(msj);
                break;

                case 5:
                msj = controller.totalSalesSongs() ;
                System.out.println(msj);
                break;

                case 6:
                System.out.println("Write the user nickname: ");
                nickname = reader.next();
                System.out.println(controller.accumulatedViews());
                System.out.println(controller.mostViewSongForUser(nickname));
                System.out.println(controller.mostViewPodcastForUser(nickname));
                System.out.println(controller.infoSongsSold());
                System.out.println(controller.totalSalesSongs());
                break;


                default:

                break;
                }

            break;

            case 0:

            break;

            default:

            break;


        }
    }

    ////////////////

    /**
	 * validateIntergerInput: This method validates that the input is an interger
	 * @return option: Is the input by the user or the number -1 to represent that is not an interger 
	 */
    public int validateIntegerInput(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{ 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

	/**
	 * validateDoubleInput: This method validates that the input is a double
	 * @return option: Is the input by the user or the number -1 to represent that is not a double
	 */

	public double validateDoubleInput(){
		double option = 0; 

		if(reader.hasNextDouble()){
			option = reader.nextDouble(); 
		}
		else{
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

}