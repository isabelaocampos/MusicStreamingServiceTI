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
        int typeOfUser = 0;
        String msj, name, imageURL, id, nickname= "";
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

        }
    }

    ////////////////

    public Calendar dateToday(){
        
        Calendar calendar=new GregorianCalendar(2022,Calendar.NOVEMBER,8);
        return calendar ;
         
    }

}