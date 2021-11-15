//-------------------------------------------------------
// Assignment 1: Question 1 
// Written by: Ebrima Jikineh (40187589)
// For COMP 248 Section (R) – Fall 2021

// This program takes user information and user vaccination
// info as input and displays it as a report of proof of
// vaccination.
// --------------------------------------------------------

import java.util.Scanner;

public class VaxProof {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//display welcome message
		System.out.println("Welcome to the COVID-19 Vaccine Proof Generator:");
		System.out.println("------------------------------------------------");
		
		//prompt for user to enter first name
		System.out.print("Please enter your first name: ");
		String firstName = sc.next();
		
		//Capitalize first letter of first name
		String firstLetterF = firstName.substring(0, 1).toUpperCase();
		String remainF = firstName.substring(1).toLowerCase();
		firstName = firstLetterF + remainF;
		
		//prompt for user to enter last name 
		System.out.print("Please enter your last name: ");
		String lastName = sc.next();
		
		//Capitalize first letter of last name 
		String firstLetterL = lastName.substring(0, 1).toUpperCase();
		String remainL = lastName.substring(1).toLowerCase();
		lastName = firstLetterL + remainL;
		
		System.out.println();
		
		//prompt for user to enter date of birth
		System.out.print("Day of birth (1 - 31)? ");
		int DoB = sc.nextInt(); 
		
		System.out.print("Month of birth (1 - 12)? ");
		int MoB = sc.nextInt();
		
		System.out.print("Year of birth (1920 - 2006)? ");
		int YoB = sc.nextInt();
		
		System.out.println();
		
		//prompt for user to enter date of vaccination
		System.out.print("Day of vaccination (1 - 31)? ");
		int DoV = sc.nextInt();
		
		System.out.print("Month of vaccination (1 - 12)? ");
		int MoV = sc.nextInt();
		
		System.out.print("Year of vaccination (2020 - 2021)? ");
		int YoV = sc.nextInt();
		
		System.out.println();
		
		//prompt to enter name of vaccine taken
		System.out.print("Name of vaccine [Pfizer, Moderna, Astrazeneca, ..]? ");
		String vaccine = sc.next();
		
		//prompt to enter city where vaccine was taken
		System.out.print("Where did you get vaccinated? ");
		String location = sc.next();

		//Capitalize first letter of city 
		String firstLetterC = location.substring(0, 1).toUpperCase();
		String remainC = location.substring(1).toLowerCase();
		location = firstLetterC + remainC;
		
		//prompt to enter lot of vaccination
		System.out.print("Lot of vaccination? ");
		String lot = sc.next();	
		
		//display vaccine proof in report form
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.print("Health and Social Services");
		System.out.println("\t\t COVID-19 Vaccine Proof");
		System.out.println();
		
		System.out.println("User Information");
		System.out.println();
		
		System.out.printf("%-7s %s%n", "Name", lastName + ", " + firstName);
		System.out.printf("%-7s %s%n", "DOB", DoB + "/" + MoB + "/" + YoB);
	
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println();
		
		System.out.println("Vaccine Administered");
		System.out.println();
		
		System.out.printf("%-15s %s%n", "Name", vaccine);
		System.out.printf("%-15s %s%n", "Lot", lot);
		System.out.printf("%-15s %s%n", "Date", DoV + "/" + MoV + "/" + YoV);
		System.out.printf("%-15s %s%n", "Location", location);
		
		System.out.println();
		System.out.println("---------------------------------------------------------------");
		System.out.println();
		
		//farewell message
		System.out.println("Thank you for choosing our services.\n");
		
		System.out.println("Report generated successfully.");
		sc.close();
	}

}
