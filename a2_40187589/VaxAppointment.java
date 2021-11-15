//-------------------------------------------------------
// Assignment 2: Question 2
// Written by: Ebrima Jikineh (40187589)
// For COMP 248 Section (R) – Fall 2021
//
// This program books a covid19 appointment vaccine for 
// user depending on the choice of vaccine, choice of 
// location and choice of time to take a vaccine. Appt 
// information is displayed if appt is booked successfully
// otherwise user is asked if they would like to try 
// booking an appt again or quit program. Program also 
// checks if the input entered by user is valid according
// to the options available and displays a warning if not
// and prompts to try again.
// --------------------------------------------------------

import java.util.Scanner;

public class VaxAppointment {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//options for vaccine
		final String 
				option1 = "Pfizer",
				option2 = "Moderna",
				option3 = "AstraZeneca",
				option4 = "Johnson&Johnson",
				option5 = "Sinovac",
				option6 = "Gamaleya",
				option7 = "Exit";
		int vaccineChoice; //choice of vaccine
		
		//locations to get vaccine
		final String 
				location1 = "Pharmaprix",
				location2 = "Jean Coutu",
				location3 = "Uniprix Clinique",
				location4 = "Health Center";
		int locationChoice = 0; // variable to store location choice
		
		//time slots to get vaccine
		final String 
				timeSlot1 = "2:00 - 2:15",
				timeSlot2 = "2:20 - 2:35",
				timeSlot3 = "2:40 - 2:55",
				timeSlot4 = "3:00 - 3:15";
		int timeChoice =  0; // variable to store time slot choice
		
		//vaccine shot
		final String 
				shot1 = "1st dose",
				shot2 = "2nd dose";
		int shotChoice = 0; // variable to store shot choice
		
		String retry = "yes"; // condition for while loop
		
		//welcome message
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("      Welcome to the COVID-19 Vaccine Appointment Progam      ");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//display vaccine menu 
		System.out.println("Here is the COVID-19 vaccine menu:");
		System.out.printf("%6s %s%n", "1.", option1);
		System.out.printf("%6s %s%n", "2.", option2);
		System.out.printf("%6s %s%n", "3.", option3);
		System.out.printf("%6s %s%n", "4.", option4);
		System.out.printf("%6s %s%n", "5.", option5);
		System.out.printf("%6s %s%n", "6.", option6);
		System.out.printf("%6s %s%n", "7.", option7);
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		// loop to keep trying again if retry is yes
		retry: while (retry.toUpperCase().equals("YES")) {
			//prompt to enter choice for vaccine
			System.out.print("\nPlease enter your choice (1-7): ");
			vaccineChoice = sc.nextInt(); //choice of vaccine
			
			// loop to keep asking for choice if not between 1 and 7
			while (vaccineChoice < 1 || vaccineChoice > 7){
				System.out.print("\nThis is a wrong input. Please try again!");
				System.out.print("\nPlease enter your choice (1-7): ");
				vaccineChoice = sc.nextInt();
			}
			
			switch(vaccineChoice) {
			case 1:
				// print vaccine choice
				System.out.printf("Your choice is: %s%n", option1); 
				
				// prompt to choose location
				System.out.printf("%nPlease choose the location of vaccine %s:%n", option1);
				System.out.printf("\t1 - %s%n", location1);
				System.out.printf("\t2 - %s%n", location2);
				System.out.print("Please enter your choice: ");
				locationChoice = sc.nextInt();
				
				// loop to keep asking if input is invalid
				while (locationChoice != 1 && locationChoice != 2) {
					System.out.print("\nThis is a wrong input. Please try again!");
					System.out.print("\nPlease enter your choice: ");
					locationChoice = sc.nextInt();
				}
				
				// prompt to choose time slot
				System.out.println("\nPlease choose the time slots: ");
				System.out.printf("\t1 - %s%n", timeSlot1);
				System.out.printf("\t2 - %s%n", timeSlot2);
				System.out.printf("\t3 - %s%n", timeSlot3);
				System.out.printf("\t4 - %s%n", timeSlot4);
				System.out.printf("\t5 - %s%n", "Quit");
				System.out.print("Please enter your choice (1-5): ");
				timeChoice = sc.nextInt();
				
				//loop to keep asking if input is invalid
				while (timeChoice < 1 || timeChoice > 5){
					System.out.print("\nThis is a wrong input. Please try again!");
					System.out.print("\nPlease enter your choice: ");
					timeChoice = sc.nextInt();
				}
				
				switch(timeChoice) {
				case 5:
					// confirm that user wants to quit or retry booking appt
					System.out.print("\nYour appointment is not booked successfully! Would you like to try again (yes or no)? ");
					retry = sc.next();
					continue;
				default:
					// prompt to enter dose of vaccine being taken
					System.out.print("Please  enter if 1st or 2nd vaccine shot (1 or 2): ");
					shotChoice = sc.nextInt();
					
					// loop to keep asking if input not valid
					while (shotChoice != 1 && shotChoice != 2) {
						System.out.print("\nThis is a wrong input. Please try again!");
						System.out.print("\nPlease enter your choice: ");
						shotChoice = sc.nextInt();
					}
					break;
				}
		
				// display vaccine being taken and dose being taken depending on input
				switch(shotChoice) {
				case 1:
					System.out.printf("%nYour booked appointment is: %s, %s.%n", option1, shot1);
					break;
				case 2:
					System.out.printf("%nYour booked appointment is: %s, %s.%n", option1, shot2);
					break;
				}
				break retry; //break out of while loop because appt is booked successfully
			case 2:
				//print vaccine choice
				System.out.printf("Your choice is: %s%n", option2);
				
				//prompt to enter choice of location
				System.out.printf("%nPlease choose the location of vaccine %s:%n", option2);
				System.out.printf("\t1 - %s%n", location1);
				System.out.printf("\t3 - %s%n", location3);
				System.out.printf("\t4 - %s%n", location4);
				System.out.print("Please enter your choice: ");
				locationChoice = sc.nextInt();
				
				// loop to keep asking if input is invalid
				while (locationChoice != 1 && locationChoice != 3 && locationChoice != 4){
					System.out.print("\nThis is a wrong input. Please try again!");
					System.out.print("\nPlease enter your choice: ");
					locationChoice = sc.nextInt();
				}
				
				// prompt to choose time slot
				System.out.println("\nPlease choose the time slots: ");
				System.out.printf("\t1 - %s%n", timeSlot1);
				System.out.printf("\t2 - %s%n", timeSlot2);
				System.out.printf("\t3 - %s%n", timeSlot3);
				System.out.printf("\t4 - %s%n", timeSlot4);
				System.out.printf("\t5 - %s%n", "Quit");
				System.out.print("Please enter your choice (1-5): ");
				timeChoice = sc.nextInt();
				
				//loop to keep asking if input is invalid
				while (timeChoice < 1 || timeChoice > 5){
					System.out.print("\nThis is a wrong input. Please try again!");
					System.out.print("\nPlease enter your choice: ");
					timeChoice = sc.nextInt();
				}
				
				switch(timeChoice) {
				case 5:
					// confirm that user wants to quit or retry booking appt
					System.out.print("\nYour appointment is not booked successfully! Would you like to try again (yes or no)? ");
					retry = sc.next();
					continue;
				default:
					// prompt to enter dose of vaccine being taken
					System.out.print("Please  enter if 1st or 2nd vaccine shot (1 or 2): ");
					shotChoice = sc.nextInt();
					
					// loop to keep asking if input not valid
					while (shotChoice != 1 && shotChoice != 2) {
						System.out.print("\nThis is a wrong input. Please try again!");
						System.out.print("\nPlease enter your choice: ");
						shotChoice = sc.nextInt();
					}
					break;
				}

				// display vaccine being taken and dose being taken depending on input
				switch(shotChoice) {
				case 1:
					System.out.printf("%nYour booked appointment is: %s, %s.%n", option2, shot1);
					break;
				case 2:
					System.out.printf("%nYour booked appointment is: %s, %s.%n", option2, shot2);
					break;
				}
				break retry; //break out of while loop because appt is booked successfully
			case 3:
				//print vaccine choice
				System.out.printf("Your choice is: %s%n", option3);
				
				//prompt to enter choice of location
				System.out.printf("%nPlease choose the location of vaccine %s:%n", option3);
				System.out.printf("\t2 - %s%n", location2);
				System.out.printf("\t3 - %s%n", location3);
				System.out.print("Please enter your choice: ");
				locationChoice = sc.nextInt();
				
				// loop to keep asking if input is invalid
				while (locationChoice != 2 && locationChoice != 3){
					System.out.print("\nThis is a wrong input. Please try again!");
					System.out.print("\nPlease enter your choice: ");
					locationChoice = sc.nextInt();
				}
				
				// prompt to choose time slot
				System.out.println("\nPlease choose the time slots: ");
				System.out.printf("\t1 - %s%n", timeSlot1);
				System.out.printf("\t2 - %s%n", timeSlot2);
				System.out.printf("\t3 - %s%n", timeSlot3);
				System.out.printf("\t4 - %s%n", timeSlot4);
				System.out.printf("\t5 - %s%n", "Quit");
				System.out.print("Please enter your choice (1-5): ");
				timeChoice = sc.nextInt();
				
				//loop to keep asking if input is invalid
				while (timeChoice < 1 || timeChoice > 5){
					System.out.print("\nThis is a wrong input. Please try again!");
					System.out.print("\nPlease enter your choice: ");
					timeChoice = sc.nextInt();
				}
			 
				switch(timeChoice) {
				case 5:
					// confirm that user wants to quit or retry booking appt
					System.out.print("\nYour appointment is not booked successfully! Would you like to try again (yes or no)? ");
					retry = sc.next();
					continue;
				default:
					// prompt to enter dose of vaccine being taken
					System.out.print("Please  enter if 1st or 2nd vaccine shot (1 or 2): ");
					shotChoice = sc.nextInt();
					
					// loop to keep asking if input not valid
					while (shotChoice != 1 && shotChoice != 2) {
						System.out.print("\nThis is a wrong input. Please try again!");
						System.out.print("\nPlease enter your choice: ");
						shotChoice = sc.nextInt();
					}
					break;
				}
				
				// display vaccine being taken and dose being taken depending on input 
				switch(shotChoice) {
				case 1:
					System.out.printf("%nYour booked appointment is: %s, %s.%n", option3, shot1);
					break;
				case 2:
					System.out.printf("%nYour booked appointment is: %s, %s.%n", option3, shot2);
					break;
				}
				break retry; //break out of while loop because appt is booked successfully
			case 4: 
				//print vaccine choice
				System.out.printf("Your choice is: %s%n", option4);
				
				//prompt to enter choice of location
				System.out.printf("%nPlease choose the location of vaccine %s:%n", option4);
				System.out.printf("\t4 - %s%n", location4);
				System.out.print("Please enter your choice: ");
				locationChoice = sc.nextInt();
				
				// loop to keep asking if input is invalid
				while (locationChoice != 4) {
					System.out.print("\nThis is a wrong input. Please try again!");
					System.out.print("\nPlease enter your choice: ");
					locationChoice = sc.nextInt();
				}
				
				// prompt to choose time slot
				System.out.println("\nPlease choose the time slots: ");
				System.out.printf("\t1 - %s%n", timeSlot1);
				System.out.printf("\t2 - %s%n", timeSlot2);
				System.out.printf("\t3 - %s%n", timeSlot3);
				System.out.printf("\t4 - %s%n", timeSlot4);
				System.out.printf("\t5 - %s%n", "Quit");
				System.out.print("Please enter your choice (1-5): ");
				timeChoice = sc.nextInt();
				
				//loop to keep asking if input is invalid
				while (timeChoice < 1 || timeChoice > 5){
					System.out.print("\nThis is a wrong input. Please try again!");
					System.out.print("\nPlease enter your choice: ");
					timeChoice = sc.nextInt();
				}
		 
				switch(timeChoice) {
				case 5:
					// confirm that user wants to quit or retry booking appt
					System.out.print("\nYour appointment is not booked successfully! Would you like to try again (yes or no)? ");
					retry = sc.next();
					continue;
				default:
					// prompt to enter dose of vaccine being taken
					System.out.print("Please  enter if 1st or 2nd vaccine shot (1 or 2): ");
					shotChoice = sc.nextInt();
					
					// loop to keep asking if input not valid
					while (shotChoice != 1 && shotChoice != 2) {
						System.out.print("\nThis is a wrong input. Please try again!");
						System.out.print("\nPlease enter your choice: ");
						shotChoice = sc.nextInt();
					}	
					break;
				}
				
				// display vaccine being taken and dose being taken depending on input 
				switch(shotChoice) {
				case 1:
					System.out.printf("%nYour booked appointment is: %s, %s.%n", option4, shot1);
					break;
				case 2:
					System.out.printf("%nYour booked appointment is: %s, %s.%n", option4, shot2);
					break;
				}
				break retry; //break out of while loop because appt is booked successfully
			case 5: 
				//print that chosen option is not available and ask to retry
				System.out.printf("Sorry, %s is not available now.%n", option5);
				System.out.print("Your appointment is not booked successfully! Would you like to try again (yes or no)? ");
				retry = sc.next();
				break;
			case 6:
				//print that chosen option is not available and ask to retry
				System.out.printf("Sorry, %s is not available now.%n", option6);
				System.out.print("Your appointment is not booked successfully! Would you like to try again (yes or no)? ");
				retry = sc.next();
				break;
			default:
				// ask to retry if user chooses to exit 
				System.out.print("\nYour appointment is not booked successfully! Would you like to try again (yes or no)? ");
				retry = sc.next();
				break;
			}
		}
		
		//display appointment info depending on location choice and time slot choice
		switch(locationChoice) {
		case 1:
			switch(timeChoice) {
			case 1:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot1, location1);
				break;
			case 2:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot2, location1);
				break;
			case 3:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot3, location1);
				break;
			case 4:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot4, location1);
				break;
			}
			break;
		case 2:
			switch(timeChoice) {
			case 1: 
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot1, location2);
				break;
			case 2:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot2, location2);
				break;
			case 3:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot3, location2);
				break;
			case 4:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot4, location2);
				break;
			}
			break;
		case 3:
			switch(timeChoice) {
			case 1: 
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot1, location3);
				break;
			case 2:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot2, location3);
				break;
			case 3:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot3, location3);
				break;
			case 4:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot4, location3);
				break;
			}
			break;
		case 4:
			switch(timeChoice) {
			case 1: 
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot1, location4);
				break;
			case 2:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot2, location4);
				break;
			case 3:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot3, location4);
				break;
			case 4:
				System.out.printf("Your schedule is: %s @ %s.%n", timeSlot4, location4);
				break;
			}
			break;
		}

		//closing  message
		System.out.print("\nThank you for using the COVID-19 Vaccine Appointment Program");	
		
		sc.close();
	}
}