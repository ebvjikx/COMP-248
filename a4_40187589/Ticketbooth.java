//-------------------------------------------------------
// Assignment 4
// Written by: Ebrima Jikineh (40187589) & Lyna Taleb ()
// For COMP 248 Section (R) � Fall 2021
//-------------------------------------------------------

public class Ticketbooth {
	
	private Tickets tickets; 
	private OPUSCard[] opusCards; 
	
	//default constructor
	public Ticketbooth() {
		tickets = new Tickets();
		opusCards = null;
	}
	
	//constructor 1
	public Ticketbooth(Tickets ticket, OPUSCard[] cards) {
		tickets = ticket;
		opusCards = (cards.length == 0) ? null: cards;
	}
	
	public Boolean equalsTicketTotal(Ticketbooth obj) {
		/* checks if two ticketbooth objects have the same 
		 * tickets' value and returns true if they do and false otherwise */
		return tickets.ticketsTotal() == obj.tickets.ticketsTotal();
	}

	public Boolean equalsNumTicket(Ticketbooth obj) {
		/* checks if two ticketbooth objects have the same 
		 * number of each type of tickets and returns true 
		 * if they do and false otherwise */
		return tickets.equals(obj.tickets);
	}

	public double ticketsTotal() {
		/* returns total value of tickets 
		 * in a ticketbooth */
		return tickets.ticketsTotal();
	}

	public int numOpusCard() {
		/* returns the number of opus cards 
		 * in a ticketbooth */
		if (opusCards != null)
			return opusCards.length;
		else
			return 0;
	}

	public int addOpusCard(OPUSCard opus) {
		/* takes an OPUSCard object as a parameter
		 * and adds it to the new copy of existing OPUSCard 
		 * object array of the ticketbooth and returns the 
		 * length of the new array */
		OPUSCard[] cards = new OPUSCard[1];
		if (opusCards == null) {
			cards[0] = opus;
		}
		else {
			cards = new OPUSCard[opusCards.length + 1];
			for (int i = 0; i < opusCards.length; i++) {
				cards[i] = opusCards[i];
			}
			cards[opusCards.length] = opus;
		}
		opusCards = cards;
		
		return opusCards.length;
	}

	public Boolean remOpusCard(int card) {
		/* takes an integer as a parameter and removes 
		 * the OPUSCard at that index in the OPUSCard object array
		 * of the ticketbooth and returns true if removed successfully 
		 * and false otherwise */
		if (opusCards == null)
			return false;
		else {
			OPUSCard[] cards = new OPUSCard[opusCards.length - 1];
			for (int i = 0, k = 0; k < cards.length; i++) {
				if (i != card) 
					cards[k++] = opusCards[i];
			}
			
			opusCards = cards;
			return true;
		}
	}
	
	public void updateExp(int card, int month, int year) {
		/* takes three integers as parameters, card which
		 * is the index of the card to be updated and month and 
		 * year which is the new expiry month and year of 
		 * that OPUSCard */
		opusCards[card].setExpMonth(month);
		opusCards[card].setExpYear(year); 
	}
	
	public double addTickets(int reg, int junior, int senior, int daily, int weekly) {
		/* takes 5 integers as parameters, which are the number of tickets
		 * of each type of ticket and adds these numbers to the already existing
		 * number of tickets in the ticketbooth and then returns the new total
		 * tickets' value */
		tickets.addTickets(reg, junior, senior, daily, weekly);
		
		return tickets.ticketsTotal();
	}
	
	public boolean equals(Ticketbooth obj) {
		/* takes a ticketbooth object as a paramater
		 * and compares the total tickets value and number of
		 * opus cards of the current ticketbooth object to the 
		 * one passed as a parameter and returns true if they 
		 * are equal and false otherwise */
		return ((tickets.ticketsTotal() == obj.tickets.ticketsTotal()) && 
				numOpusCard() == obj.numOpusCard());	
	}
	
	public String toString() {
		/* returns a string of the breakdown 
		 * of tickets in the ticketbooth and also the information
		 * of each OPUSCard object in the ticketbooth */
		String opus = "";
		if (opusCards == null)
			opus = "\nNo OPUS cards";
		else {
		for (int i = 0; i < opusCards.length; i++)
			opus += "\n" + opusCards[i].toString();
		}
		
		return tickets.toString() + opus + "\n";		
	}
	
	public String ticketsInfo() {
		/* returns only a string of the breakdown 
		 * of tickets in the ticketbooth */
		return tickets.toString();
	}
}
