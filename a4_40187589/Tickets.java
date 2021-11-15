//-------------------------------------------------------
// Assignment 3
// Written by: Ebrima Jikineh (40187589) & Lyna Taleb ()
// For COMP 248 Section (R) – Fall 2021
//-------------------------------------------------------

public class Tickets {
	
	// static attributes
	private static final double 
		regularPrice = 3.5,
		juniorPrice = 2.5,
		seniorPrice = 1,
		dailyPrice = 10,
		weeklyPrice = 40;
	
	// attributes
	private int 
		regularTickets,
		juniorTickets,
		seniorTickets,
		dailyTickets,
		weeklyTickets;
	
	//default constructor 
	public Tickets() {
		regularTickets = 0;
		juniorTickets = 0;
		seniorTickets = 0;
		dailyTickets = 0;
		weeklyTickets = 0;
	}
	
	// constructor 1
	public Tickets(int reg, int junior, int senior, int daily, int weekly) {
		regularTickets = reg;
		juniorTickets = junior; 
		seniorTickets = senior;
		dailyTickets = daily;
		weeklyTickets = weekly;
	}
	
	// copy constructor
	public Tickets(Tickets obj) {
		regularTickets = obj.regularTickets;
		juniorTickets = obj.juniorTickets; 
		seniorTickets = obj.seniorTickets;
		dailyTickets = obj.dailyTickets;
		weeklyTickets = obj.weeklyTickets;
	}
	
	// accessor methods 
	public int getRegTickets() {
		// returns number of regular tickets 
		return regularTickets;
	}
	
	public int getJunTickets() {
		// returns number of junior tickets
		return juniorTickets;
	}
	
	public int getSenTickets() {
		// returns number of senior tickets
		return seniorTickets;
	}
	
	public int getDayTickets() {
		// returns number of daily tickets
		return dailyTickets;
	}
	
	public int getWeekTickets() {
		// returns number of weekly tickets
		return weeklyTickets;
	}
	
	// mutator methods 
	public void setRegTickets(int reg) {
		/* sets number of regular tickets to integer
		 * given as an argument */
		regularTickets = reg;
	}
	
	public void setJunTickets(int junior) {
		/* sets number of junior tickets to integer
		 * given as an argument */
		juniorTickets = junior;
	}
	
	public void setSenTickets(int senior) {
		/* sets number of senior tickets to integer
		 * given as an argument */
		seniorTickets = senior;
	}
	
	public void setDayTickets(int daily) {
		/* sets number of daily tickets to integer
		 * given as an argument */
		dailyTickets = daily;
	}
	
	public void setWeekTickets(int weekly) {
		/* sets number of weekly tickets to integer
		 * given as an argument */
		weeklyTickets = weekly;
	}
	
	public void addTickets(int reg, int junior, int senior, int daily, int weekly) {
		/* takes 5 integers as parameters, which are the number of tickets
		 * of each type of ticket and adds these numbers to the already existing
		 * number of tickets */
		regularTickets += reg;
		juniorTickets += junior; 
		seniorTickets += senior;
		dailyTickets += daily;
		weeklyTickets += weekly;
	}
	
	public double ticketsTotal() {
		/* returns the total value of all the tickets
		 * in the ticket object */
		return (regularPrice * regularTickets) +
				(juniorPrice * juniorTickets) +
				(seniorPrice * seniorTickets) +
				(dailyPrice * dailyTickets) +
				(weeklyPrice * weeklyTickets);
	}
	 
	public String toString() {
		/* returns a formatted string with a
		 * breakdown of all the type of tickets in
		 * the ticket object*/
		return  String.format("%d Regular($%.2f), %d Junior($%.2f), %d Senior($%.2f), %d Daily($%.2f), %d Weekly($%.2f)", 
				regularTickets, regularPrice,
				juniorTickets, juniorPrice,
				seniorTickets, seniorPrice,
				dailyTickets, dailyPrice,
				weeklyTickets, weeklyPrice);
	}
	
	public boolean equals(Tickets obj) {
		/* checks if the current ticket object has
		 * the same number of each type of ticket
		 * as the tickets object given as argument */
		return ((regularTickets == obj.regularTickets) &&
		(juniorTickets == obj.juniorTickets) &&
		(seniorTickets == obj.seniorTickets) &&
		(dailyTickets == obj.dailyTickets) &&
		(weeklyTickets == obj.weeklyTickets));
	}
}
