//-------------------------------------------------------
// Assignment 3: Question 1
// Written by: Ebrima Jikineh (40187589)
// For COMP 248 Section (R) – Fall 2021
//
// This program takes a valid 4 digit year as input
// from user and determines if the year is a leap
// year or not. It also iterates through every date
// of each month in the year and determines the dates
// that are not a multiple of that month. It displays
// this information along with if the year is a leap
// year or a common year.
//-------------------------------------------------------

import java.util.Scanner;

public class CalendarProg {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//welcome message
		System.out.println("-------****-------****-------****-------****-------");
		System.out.println("         Welcome to the Calendar Program!          ");
		System.out.println("-------****-------****-------****-------****-------\n");
		
		int year;
		do {
		//prompt to enter 4 digit year
			System.out.println("Please enter a 4-digit year: ");
			year = sc.nextInt();
		} while (year < 1000 || year > 9999);
		
		//determine if year is a leap year or not 
		Boolean leapYear = (year % 100 != 0 && year % 4 == 0) || (year % 100 == 0 && year % 400 == 0);
		
		for (int month = 1; month <= 12; month++) {
			int daysInMonth = 0; //days in the month
			String monthName = ""; //name of month
			
			// determine number of days in current month 
			switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				// 31 days in jan, march, may, july, aug, oct & dec
				daysInMonth = 31;
				break;
			case 4: case 6: case 9: case 11:
				// 30 days in april, june, sep and nov
				daysInMonth = 30;
				break;
			case 2:
				// 29 or 28 days in feb depending on if leap year or not
				daysInMonth = (leapYear) ? 29 : 28;
				break;
			}
			
			// determine name of current month
			switch (month) {
			case 1:
				monthName = "January";
				break;
			case 2:
				monthName = "February";
				break;
			case 3:
				monthName = "March";
				break;
			case 4:
				monthName = "April";
				break;
			case 5:
				monthName = "May";
				break;
			case 6:
				monthName = "June";
				break;
			case 7:
				monthName = "July";
				break;
			case 8:
				monthName = "August";
				break;
			case 9:
				monthName = "September";
				break;
			case 10:
				monthName = "October";
				break;
			case 11:
				monthName = "November";
				break;
			case 12:
				monthName = "December";
				break;
			}

			// determine how many days in month are not multiples of month
			int count = 0;
			for (int day = 1; day <= daysInMonth; day++) {
				if (day % month != 0) {
					count++;
				}
			}
			// array to store non multiples of month
			int [] notMultiples = new int[count];
			
			// iterate through number of days in a month and determine if not multiple and then store in array
			for (int day = 1, i = 0; day <= daysInMonth; day++) {
				if (day % month != 0) {
					notMultiples[i++] = day;
				}
			}
			// display month name, number and non multiples of that number
			switch(month) {
			case 2:
				System.out.printf("%n%nIn %s in a " + ((leapYear) ? "leap" : "common")
						+ " year, the dates that are not a multiple of %d are:%n", monthName, month);
				
				// display non multiples of month stored in the array
				for (int i = 0; i < notMultiples.length-1; i++) {
						System.out.printf("%d, ", notMultiples[i]);
				}
				System.out.printf("%d", notMultiples[notMultiples.length-1]);
				break;
			default:
				System.out.printf("%n%nIn %s, the dates that are not a multiple of "
						+ "%d are:%n", monthName, month);
				
				// determine if there are any days that are not multiples of month
				// and then display them
				switch (notMultiples.length) {
				case 0: 
					// no non multiples in month 
					System.out.print("No dates found in this month!");
					break;
				default:
					// display non multiples of month stored in the array
					for (int i = 0; i < 15; i++) {
						System.out.printf("%d, ", notMultiples[i]);
					}
					System.out.println();
					for (int i = 15; i < notMultiples.length-1; i++) {
						System.out.printf("%d, ", notMultiples[i]);
					}
					System.out.printf("%d", notMultiples[notMultiples.length-1]);
					break;
				}
				break;
			}
		}
		//closing message
		System.out.println("\n\nThank you for using this program!!");
		sc.close();
	}
}