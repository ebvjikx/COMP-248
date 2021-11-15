//-------------------------------------------------------
// Assignment 3
// Written by: Ebrima Jikineh (40187589) & Lyna Taleb ()
// For COMP 248 Section (R) – Fall 2021
//-------------------------------------------------------

public class OPUSCard {
	
	//attributes
	private String 
		cardType,
		cardHolder;
	private int
		expiryMonth,
		expiryYear;
	
	// default constructor
	public OPUSCard() {
		cardType = "";
		cardHolder = "";
		expiryMonth = 0;
		expiryYear = 0;
	}
	
	// constructor 1
	public OPUSCard(String type, String name, int month, int year) {
		cardType = type;
		cardHolder = name;
		expiryMonth = (month < 1 || month > 12) ? 0 : month;
		expiryYear = year;
	}
	
	// copy constructor
	public OPUSCard(OPUSCard obj) {
		cardType = obj.cardType;
		cardHolder = obj.cardHolder;
		expiryMonth = obj.expiryMonth;
		expiryYear = obj.expiryYear;
	}
	
	// accessor methods
	public String getType() {
		// returns type of opus card
		return cardType;
	}
	
	public String getName() {
		// return owner name on opus card
		return cardHolder;
	}
	
	public int getExpMonth() {
		// return expiry month of opus card
		return expiryMonth;
	}
	
	public int getExpYear() {
		// return expiry year of opus card
		return expiryYear;
	}
	
	// mutator methods
	public void setExpMonth(int month) {
		/* set expiry month to the integer passed as a param
		 * and sets it to 0 if integer not between 1 and 12 */
		expiryMonth = (month < 1 || month > 12) ? 0 : month;
	}
	
	public void setExpYear(int year) {
		// set expiry year to the integer passed as a param 
		expiryYear = year;
	}
	 
	public String toString() {
		/* returns a formatted string with the 
		 * information of the OPUSCard object */
		return  String.format("%s - %s - %s/%s",
				cardType, cardHolder, (expiryMonth < 10) ?  "0" + expiryMonth : expiryMonth, expiryYear);
	}
	
	public Boolean equals(OPUSCard obj) {
		/* checks if the the current OPUSCard object 
		 * has the same name, same type, same expiry month and year
		 * as the object passed as a param */
		return ((cardType.equals(obj.cardType)) && 
				(cardHolder.equals(obj.cardHolder)) && 
				(expiryMonth == obj.expiryMonth) && 
				(expiryYear == obj.expiryYear));
	}
}
