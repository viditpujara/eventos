package com.project.eventos.console;

import com.project.eventos.models.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int choice;
		
		do {
			System.out.println("1. Customer");
			System.out.println("2. Organizer");
			System.out.println("0. Exit");
			System.out.print("Select User Type:-> ");
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice){
			
				case 1:
					System.out.println("You have selected Customer User...");
					System.out.println();
					System.out.println("1. Register");
					System.out.println("2. Login");
					System.out.print("Select Operation :-> ");
					choice = sc.nextInt();
					sc.nextLine();
					
					models.Customers cust = new Customers();
					
					switch(choice) {
					case 1:
						
				
					}
					break;
				case 2:
					System.out.println("You have selected Organizer User...");
					System.out.println();
					System.out.println("1. Register");
					System.out.println("2. Login");
					System.out.print("Select Operation :-> ");
					choice = sc.nextInt();
					sc.nextLine();
					
					switch(choice) {
					// organizer 
				
					}
					break;
				
				case 0:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid Selection...");
					System.out.println("Select again...");
			}		
		}while (choice != 0);
	}

}
