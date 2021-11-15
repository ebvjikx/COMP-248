// -------------------------------------------------------
// Assignment 1: Question 2 
// Written by: Ebrima Jikineh (40187589)
// For COMP 248 Section (R) – Fall 2021

// This program takes client information including name and
// address as input and also delivery information including
// delivery date, distance and value of goods. This info
// is used to generate a receipt of delivery for client.
// --------------------------------------------------------

import java.util.Scanner;


public class MtlDeliveryExpress {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		final String province = "QC"; //province of delivery (always QC)
		final double ratePerKM = 0.55; //rate of delivery per km
		final double TPSrate = 0.05; //TPS rate
		final double TVQrate = 0.09975; //TVQ rate
		
		//display welcome message 
		System.out.println("Welcome to Montréal Delivery Express Receipt Generator");
		System.out.println("------------------------------------------------------\n");

		System.out.println("Client Info\n");
		
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
		
		//prompt for user to enter address
		System.out.print("Please enter your address: ");
		String address = sc.next();
		address = address + sc.nextLine();
		
		System.out.print("City: ");
		String city = sc.next();
		
		//Capitalize first letter of city 
		String firstLetterC = city.substring(0, 1).toUpperCase();
		String remainC = city.substring(1).toLowerCase();
		city = firstLetterC + remainC;
		
		System.out.print("Postal Code: ");
		String postalCode = sc.next();
		
		System.out.println();
		System.out.println("Delivery Info\n");
		
		//prompt for user to enter delivery date 
		System.out.print("Day of delivery (1 - 31): ");
		int DoD = sc.nextInt();
		
		System.out.print("Month of delivery (1 - 12): ");
		int MoD = sc.nextInt();
		
		System.out.print("Year of delivery: ");
		int YoD = sc.nextInt();
		
		String date = DoD + " / " + MoD + " / " + YoD; //date of delivery
		
		//prompt for user to enter distance between source and destination
		System.out.print("Distance to destination (km): ");
		double distance = sc.nextDouble();
		
		//prompt for user to enter value of goods
		System.out.print("Value of goods: ");
		double value = sc.nextDouble();
		
		//calculations for delivery fees, TPS, TVQ, and total based on distance and value of goods
		double deliveryFees = distance * ratePerKM; // distance in km multiplied by rate of delivery per km
		double sTotal = value + deliveryFees; // value of goods + delivery fees
		double TPS = sTotal * TPSrate; //tps to be paid
		double TVQ = sTotal * TVQrate; //tvq to be paid
		double total = sTotal + TPS + TVQ; // total paid
		
		// display receipt
		System.out.println();
		System.out.println("----------------------------------------------------------------------");
		System.out.print("\t\t\t Montréal Delivery Express");
		System.out.println("\t" + date + "\n\n");
		
		System.out.printf("%s %s%n", firstName, lastName);
		System.out.printf("%s%n", address);
		System.out.printf("%s, %s, %S%n%n", city, province, postalCode);
		
		System.out.println("----------------------------------------------------------------------\n");
		
		System.out.printf("%-35s %20.2f $%n", "Sub-total", value);
		System.out.printf("%-35s %20.2f $%n", "Delivery Fees (55 cents * " + distance + " KM)", deliveryFees);
		System.out.printf("%-35s %20.2f $%n", "TPS No. 12345 6789 RT0001 - 5%", TPS);
		System.out.printf("%-35s %20.2f $%n%n", "TVQ No. 1234567890 TQ0020 - 9.975%", TVQ);
		
		System.out.printf("%-35s %20.2f $%n%n", "Total", total);
		
		System.out.println("----------------------------------------------------------------------\n");
		
		// farewell message
		System.out.println("Thank you for choosing Montréal Delivery Express.\n");
		
		System.out.println("Report generated successfully.");
		sc.close();
	}

}
