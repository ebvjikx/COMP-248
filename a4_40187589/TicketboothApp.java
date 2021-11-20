//-------------------------------------------------------
// Assignment 3
// Written by: Ebrima Jikineh (40187589) & Lyna Taleb ()
// For COMP 248 Section (R) – Fall 2021
//
// This program creates 5 tickets objects, 5 arrays of 
// opus card objects and 5 ticketbooths objects containing
// these tickets and opus card arrays. It asks user for a
// choice from 0-9 for what they want to do from a printed
// menu and depending on this choice carries out the 
// respective actions. The user is constantly asked for a 
// choice after each action until they choose to quit by
// choosing 0.
//-------------------------------------------------------

import java.util.Scanner;

public class TicketboothApp {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// tickets objects
		Tickets 
			tickets0 = new Tickets(4, 4, 3, 2, 1), 
			tickets1 = new Tickets(tickets0),
			tickets2 = new Tickets(4, 8, 3, 1, 0),
			tickets3 = new Tickets(6, 3, 1, 0, 1),
			tickets4 = new Tickets(tickets3);
		
		// opus card object arrays
		OPUSCard[] opus1 = new OPUSCard[2];
		opus1[0] = new OPUSCard("STM", "L. Hill", 10, 2022);
		opus1[1] = new OPUSCard("RTL", "H. Dada", 12, 2021);
		
		OPUSCard[] opus2 = new OPUSCard[2];
		opus2[0] = new OPUSCard("REM", "F. Ocean", 1, 2023);
		opus2[1] = new OPUSCard("STL", "K. West", 6, 2024);
		
		OPUSCard[] opus3 = new OPUSCard[0];
		
		OPUSCard[] opus4 = new OPUSCard[4];
		opus4[0] = new OPUSCard("REM", "M. Miller", 1, 2024);
		opus4[1] = new OPUSCard("STM", "M. Doom", 2, 2022);
		opus4[2] = new OPUSCard("STL", "B. Faiyaz", 9, 2022);
		opus4[3] = new OPUSCard("RTL", "D. Caesar", 6, 2022);
		
		// ticketbooth object
		Ticketbooth 
			booth0 = new Ticketbooth(tickets0, opus1),
			booth1 = new Ticketbooth(tickets1, opus2),
			booth2 = new Ticketbooth(tickets2, opus4),
			booth3 = new Ticketbooth(tickets3, opus3),
			booth4 = new Ticketbooth(tickets4, opus3);
		
		// array of all ticketbooth objects
		Ticketbooth[] booths = {booth0, booth1, booth2, booth3, booth4};
		
		int cardChoice; // choice of opus card
		int boothChoice; // choice of ticketbooth
		
		Boolean quit = false; // condition for while loop
		
		// welcome message
		System.out.println("====================================================================\n" +
						   "   Welcome to Concordia's 2021 Fall Geek Ticketbooth Application    \n" +
						   "====================================================================");
		
		while (!quit) {
			switch (getChoice()) {
			case 0:
				// quit program
				quit = true;
				break;
			case 1:
				// print content of all ticket booths
				System.out.println("Content of each Ticketbooth:");
				System.out.println("--------------------");
				for (int i = 0; i < booths.length; i++) {
					System.out.printf("Ticketbooth #%d:%n", i);
					System.out.println(booths[i]);
				}
				break;
			case 2:
				// print content of chosen ticket booth
				System.out.println("Which Ticketbooth would you like to see the content of? ");
				boothChoice = getBoothChoice();
				
				System.out.printf("Ticketbooth #%d:%n", boothChoice);
				System.out.println(booths[boothChoice]);
				break;
			case 3:
				// print ticket booths that have the same amount of ticket values
				System.out.println("List of Ticketbooths with same amount of money: \n");
				for (int i = 0; i < booths.length; i++) {
					for (int j = i+1; j < booths.length; j++) {
						if (booths[i].equalsTicketTotal(booths[j]))
							System.out.printf("\tTicketbooths %d and %d both have $%.2f%n", 
									i, j, booths[i].ticketsTotal());
					}
				}
				break;
			case 4:
				// print ticket booths that have the same number of each type of ticket
				System.out.println("List of Ticketbooths with same Tickets amount: \n");
				for (int i = 0; i < booths.length; i++) {
					for (int j = i+1; j < booths.length; j++) {
						if (booths[i].equalsNumTicket(booths[j]))
							System.out.printf("\tTicketbooths %d and %d both have %s%n", 
									i, j, booths[i].ticketsInfo());
					}
				}
				break;
			case 5:
				// print ticket booths that have the same amount of ticket values and same number of opus cards
				System.out.println("List of Ticketbooths with same amount of money and same number of opus cards: \n");
				for (int i = 0; i < booths.length; i++) {
					for (int j = i+1; j < booths.length; j++) {
						if (booths[i].equals(booths[j]))
							System.out.printf("\tTicketbooths %d and %d%n", i, j);
					}
				}
				break;
			case 6:
				// add new opus card to chosen ticket booth 
				System.out.println("Which Ticketbooth do you want to add an OPUS card to? ");
				boothChoice = getBoothChoice();
				OPUSCard newOpus = createNewOpus();
				
				System.out.printf("You now have %d OPUS cards in Ticketbooth %d%n", 
						booths[boothChoice].addOpusCard(newOpus), boothChoice);
				break;
			case 7:
				// remove opus card from chosen ticketbooth 
				System.out.println("Which Ticketbooth do you want to remove a OPUS card from? ");
				boothChoice = getBoothChoice();
				String prompt = "Which card do you want to remove?";
				cardChoice = getCardChoice(boothChoice, booths, prompt);
				
				if (cardChoice != -1) {
					if (booths[boothChoice].remOpusCard(cardChoice))
						System.out.println("Card was removed successfully");
				}
				break;
			case 8:
				// update expiry month and year of chosen opus card
				System.out.println("Which Ticketbooth do you want to update a OPUS card from? ");
				boothChoice = getBoothChoice();
				prompt = "Which card do you want to update?";
				cardChoice = getCardChoice(boothChoice, booths, prompt);
				
				if (cardChoice != -1) {
					System.out.print("--> Enter new expiry month number and year (separate by a space): ");
					int month = sc.nextInt();
					int year = sc.nextInt();
					
					booths[boothChoice].updateExp(cardChoice, month, year);
					System.out.println("Expiry date updated");
				}
				break;
			case 9:
				// add tickets to chosen ticket booth 
				System.out.println("Which Ticketbooth do you want to add tickets to? ");
				boothChoice = getBoothChoice();
				
				System.out.println("How many regular, junior, senior, daily and weekly tickets do you want to add?");
				System.out.print("Enter 5 numbers (separated by a space): ");
				int reg = sc.nextInt();
				int junior = sc.nextInt();
				int senior = sc.nextInt();
				int daily = sc.nextInt();
				int weekly = sc.nextInt();
				
				System.out.printf("You now have $%.2f in Ticketbooth %d%n", 
						booths[boothChoice].addTickets(reg, junior, senior, daily, weekly), boothChoice);
				break;
			}
		}
		// closing message
		System.out.println("Thank you for using Concordia's Fall Geek Ticketbooth Application");
	}
	
	private static int getChoice() {
		/* method to print menu and get choice from user
		   then return choice */
		int choice = 0;
		do {
			System.out.println("\nWhat would you like to do?\n" +
					"  1. See the content of all Ticketbooths\n" +
					"  2. See the content of one Ticketbooth\n" +
					"  3. List Ticketbooths with same amount of tickets' values\n" +
					"  4. List Ticketbooths with same Tickets amount\n" +
					"  5. List Ticketbooths with same amount of tickets values and same number of OPUS cards\n" +
					"  6. Add a OPUS card to an existing Ticketbooth\n" +
					"  7. Remove an existing OPUS card from a ticketbooth\n" +
					"  8. Update the expiry date of an existing OPUS card\n" +
					"  9. Add Tickets to a Ticketbooth\n" +
					"  0. Quit");
			
			System.out.print("\nPlease enter your choice and press <Enter>: ");
			choice =  sc.nextInt();
			if (choice < 0 || choice > 9)
				System.out.println("Sorry that is not a valid choice. Try again.");
			} while (choice < 0 || choice > 9);
		
		return choice;
	}
	
	private static int getBoothChoice() {
		/* method to ask user for choice of booth
		   then return choice */
		int boothChoice = 0;
		do {
			if (boothChoice < 0 || boothChoice > 4)
				System.out.printf("Sorry Ticketbooth %d does not exist. Try again.%n", boothChoice);
			System.out.print("Enter a number (0 - 4): ");
			boothChoice = sc.nextInt();	
		} while (boothChoice < 0 || boothChoice > 4);
		
		return boothChoice;
	}
	
	private static int getCardChoice(int boothChoice, Ticketbooth[] booths, String prompt) {
		/* method to ask user for choice of opus card
		   then return choice */
		switch (booths[boothChoice].numOpusCard()) {
		case 0:
			System.out.println("Sorry that Ticketbooth has no cards");
			return -1;
		default:
			System.out.println(prompt);
			int cardChoice = 0;
			do {
				if (cardChoice < 0 || cardChoice > booths[boothChoice].numOpusCard() - 1) {
					System.out.printf("Sorry but there is no card number %d%n", cardChoice);
					System.out.println("--> Try again");
				}
				System.out.printf("Enter a card number (%d - %d): ", 0, booths[boothChoice].numOpusCard() - 1);
				cardChoice = sc.nextInt();
			} while (cardChoice < 0 || cardChoice > booths[boothChoice].numOpusCard() - 1);
		
			return cardChoice;
		}
	}
	
	private static OPUSCard createNewOpus() {
		/* method to ask user for new opus card info
		   and return the new opuscard object with this info */
		System.out.println("Please enter the following information");
		System.out.print("  --> Type of OPUS card (STL, RTL, etc..): ");
		String type = sc.next();
		
		System.out.print("  --> Full name on OPUS card: ");
		String name = sc.next();
		name += sc.nextLine();
		
		System.out.print("  --> Expiry month number and year (separate by a space): ");
		int month = sc.nextInt();
		int year = sc.nextInt();
		
		OPUSCard newOpus = new OPUSCard(type, name, month, year);
		return newOpus;
	}
}
