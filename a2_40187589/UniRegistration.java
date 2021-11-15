//-------------------------------------------------------
// Assignment 2: Question 1 
// Written by: Ebrima Jikineh (40187589)
// For COMP 248 Section (R) – Fall 2021
//
// This program asks students if they are new or not 
// and depending on their response either welcome them 
// back to Concordia or ask student for info like name,
// date of birth, vaccine status, and department registered
// in and also generate a random 7-digit student id for
// new student. This info is used for registration purposes 
// and is displayed at the end of program.
// --------------------------------------------------------

import java.util.Scanner;

public class UniRegistration {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//welcome message
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		System.out.println("    Welcome to Concordia University    ");
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		
		//prompt to ask if new student
		System.out.print("\nAre you a new student at Concordia (yes or no)? ");
		String newStudent = sc.next();
		
		//if student is new ask info for registration and if not welcome back student
		if (newStudent.toUpperCase().equals("NO")) {
			System.out.println("\nWelcome back! Hope you are having a great semester!\n");
		}
		else {
			//prompt to enter name
			System.out.print("\nPlease enter your name (Lastname, Firstname): ");
			String lastName = sc.next();
			String firstName = sc.nextLine();
			String name = lastName + firstName;
			
			//split name at comma and assign to variables
			lastName = name.split(", |,")[0];
			firstName = name.split(", |,")[1];
			
			//Capitalize first letter of first name
			String firstLetterF = firstName.substring(0, 1).toUpperCase();
			String remainF = firstName.substring(1).toLowerCase();
			firstName = firstLetterF + remainF;
			
			//Capitalize first letter of last name 
			String firstLetterL = lastName.substring(0, 1).toUpperCase();
			String remainL = lastName.substring(1).toLowerCase();
			lastName = firstLetterL + remainL;
			
			name = firstName + " " + lastName; //full name with capitalized first letters
			
			//prompt for date of birth
			System.out.print("\nPlease enter your date of birth: ");
			String DoB = sc.next();
			
			//prompt for covid vaccine status
			System.out.print("\nDo you have your COVID-19 vaccine passport (true or false)? ");
			Boolean vaccineStatus = sc.nextBoolean();
			
			//prompt for department
			System.out.print("\nPlease enter your department: ");
			String department = sc.next();
			
			//generate random 7 digit student ID
			int range = (9_999_999 - 1_000_000) + 1;
			int studentID = (int)(Math.random() * range) + 1_000_000;
			
			//display info 
			System.out.printf("%nCongratulations, %s! You have successfully registered at Concordia University!%n%n", name);
			System.out.printf("Your student ID is %d.%n%n", studentID);
			
			if (!vaccineStatus) {
				System.out.println("Hope you will get your vaccine passport soon! Take care!\n");
			}
		}
			
		//closing  message
		System.out.println("Thank you for using this program!");
		
		sc.close();
	}
}
