package ui;

import model.*;
import java.util.Scanner;

public class Main{
    private Scanner reader;
    private Neotunes neotunes;
    
    public Main(){
        this.reader = new Scanner(System.in);
        neotunes = new Neotunes();
    }

    public Neotunes inmobiliarySystem(){
        return neotunes;
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
				"1. Register producers, artists and content creators \n" +
				"2. Register standart users and premium users \n" +
				"3. Register song and podcasts \n" + 
                "4. Create a playlist \n" +
                "5. Edit a playlist \n" +
				"0. Exit. ");
		option = reader.nextInt(); 

		return option; 
	}

    public void executeOption(int option){
    }

}