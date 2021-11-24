//-------------------------------------------------------
// Assignment 4
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
	}
	
	// constructor 1
	public Tickets(int reg, int junior, int senior, int daily, int weekly) {
		this.regularTickets = reg;
		this.juniorTickets = junior; 
		this.seniorTickets = senior;
		this.dailyTickets = daily;
		this.weeklyTickets = weekly;
	}
	
	// copy constructor
	public Tickets(Tickets obj) {
		this.regularTickets = obj.regularTickets;
		this.juniorTickets = obj.juniorTickets; 
		this.seniorTickets = obj.seniorTickets;
		this.dailyTickets = obj.dailyTickets;
		this.weeklyTickets = obj.weeklyTickets;
	}
	
	// accessor methods 
	public int getRegTickets() {
		// returns number of regular tickets 
		return this.regularTickets;
	}
	
	public int getJunTickets() {
		// returns number of junior tickets
		return this.juniorTickets;
	}
	
	public int getSenTickets() {
		// returns number of senior tickets
		return this.seniorTickets;
	}
	
	public int getDayTickets() {
		// returns number of daily tickets
		return this.dailyTickets;
	}
	
	public int getWeekTickets() {
		// returns number of weekly tickets
		return this.weeklyTickets;
	}
	
	// mutator methods 
	public void setRegTickets(int reg) {
		/* sets number of regular tickets to integer
		 * given as an argument */
		this.regularTickets = reg;
	}
	
	public void setJunTickets(int junior) {
		/* sets number of junior tickets to integer
		 * given as an argument */
		this.juniorTickets = junior;
	}
	
	public void setSenTickets(int senior) {
		/* sets number of senior tickets to integer
		 * given as an argument */
		this.seniorTickets = senior;
	}
	
	public void setDayTickets(int daily) {
		/* sets number of daily tickets to integer
		 * given as an argument */
		this.dailyTickets = daily;
	}
	
	public void setWeekTickets(int weekly) {
		/* sets number of weekly tickets to integer
		 * given as an argument */
		this.weeklyTickets = weekly;
	}
	
	public void addTickets(int reg, int junior, int senior, int daily, int weekly) {
		/* takes 5 integers as parameters, which are the number of tickets
		 * of each type of ticket and adds these numbers to the already existing
		 * number of tickets */
		this.regularTickets += reg;
		this.juniorTickets += junior; 
		this.seniorTickets += senior;
		this.dailyTickets += daily;
		this.weeklyTickets += weekly;
	}
	
	public double ticketsTotal() {
		/* returns the total value of all the tickets
		 * in the ticket object */
		return (regularPrice * this.regularTickets) +
				(juniorPrice * this.juniorTickets) +
				(seniorPrice * this.seniorTickets) +
				(dailyPrice * this.dailyTickets) +
				(weeklyPrice * this.weeklyTickets);
	}
	 
	public String toString() {
		/* returns a formatted string with a
		 * breakdown of all the type of tickets in
		 * the ticket object*/
		return  String.format("%d Regular($%.2f), %d Junior($%.2f), %d Senior($%.2f), %d Daily($%.2f), %d Weekly($%.2f)", 
				this.regularTickets, regularPrice,
				this.juniorTickets, juniorPrice,
				this.seniorTickets, seniorPrice,
				this.dailyTickets, dailyPrice,
				this.weeklyTickets, weeklyPrice);
	}
	
	public boolean equals(Tickets obj) {
		/* checks if the current ticket object has
		 * the same number of each type of ticket
		 * as the tickets object given as argument */
		return ((this.regularTickets == obj.regularTickets) &&
		(this.juniorTickets == obj.juniorTickets) &&
		(this.seniorTickets == obj.seniorTickets) &&
		(this.dailyTickets == obj.dailyTickets) &&
		(this.weeklyTickets == obj.weeklyTickets));
	}
}
