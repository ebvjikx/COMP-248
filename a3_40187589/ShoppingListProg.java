//-------------------------------------------------------
// Assignment 3: Question 2
// Written by: Ebrima Jikineh (40187589)
// For COMP 248 Section (R) – Fall 2021
//
// This program takes a shopping list as input from user
// in the form of "item1$price1,item2$price2,..." and
// then separates the items and their prices to display
// as a numbered list and also calculates and displays
// the total price of all items entered.
//-------------------------------------------------------

import java.util.Scanner;

public class ShoppingListProg {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// welcome message
		System.out.println("-------****-------****-------****-------****-------");
		System.out.println("       Welcome to the Shopping List Program!       ");
		System.out.println("-------****-------****-------****-------****-------");
		
		// prompt to enter shopping list
		System.out.println("Please enter your shopping list (item$price and seperate by comma):");
		String allItems = sc.next();
		
		// separate each "item$price" at comma
		String[] items = allItems.split(",");
		
		// arrays that items and price will be stored in
		char[][] itemName = new char[items.length][];
		int[] itemPrice = new int[items.length];
		
		int totalPrice = 0; // sum of all prices
		
		// check if the item entered is 0
		if (items.length == 1 && items[0].equals("0")) {
			// display items
			System.out.printf("%nYou have %d items in the list now!", Integer.parseInt(items[0]));
		} else {
			// loop to iterate through every item and price entered
			for (int i = 0; i < items.length; i++) {
				// store item name in 2d char array
				String item = items[i].split("\\$")[0]; // item separated from its price
				itemName[i] = item.toCharArray(); 
				
				// store price in 1d int array
				int price = Integer.parseInt(items[i].split("\\$")[1]); // price separated from item
				itemPrice[i] = price;
			}
			
			// display items
			System.out.println("\nHere is the list of items: \n");
			
			for (int i = 0; i < items.length; i++) { 
				System.out.printf("No.%d %s%n", i+1, String.valueOf(itemName[i]));
				
				// sum up all prices to get total
				totalPrice += itemPrice[i];
			}
			// display total price 
			System.out.printf("The total price is: $%d.%n", totalPrice); 
		}
		// closing message
		System.out.println("\n\nThank you for using this program!!");
		sc.close();
	}
}