//-------------------------------------------------------
// Assignment 4
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
	}
	
	// constructor 1
	public OPUSCard(String type, String name, int month, int year) {
		this.cardType = type;
		this.cardHolder = name;
		this.expiryMonth = (month < 1 || month > 12) ? 0 : month;
		this.expiryYear = year;
	}
	
	// copy constructor
	public OPUSCard(OPUSCard obj) {
		this.cardType = obj.cardType;
		this.cardHolder = obj.cardHolder;
		this.expiryMonth = obj.expiryMonth;
		this.expiryYear = obj.expiryYear;
	}
	
	// accessor methods
	public String getType() {
		// returns type of opus card
		return this.cardType;
	}
	
	public String getName() {
		// return owner name on opus card
		return this.cardHolder;
	}
	
	public int getExpMonth() {
		// return expiry month of opus card
		return this.expiryMonth;
	}
	
	public int getExpYear() {
		// return expiry year of opus card
		return this.expiryYear;
	}
	
	// mutator methods
	public void setExpMonth(int month) {
		/* set expiry month to the integer passed as a param
		 * and sets it to 0 if integer not between 1 and 12 */
		this.expiryMonth = (month < 1 || month > 12) ? 0 : month;
	}
	
	public void setExpYear(int year) {
		// set expiry year to the integer passed as a param 
		this.expiryYear = year;
	}
	 
	public String toString() {
		/* returns a formatted string with the 
		 * information of the OPUSCard object */
		return  String.format("%s - %s - %s/%s",
				this.cardType, this.cardHolder, (this.expiryMonth < 10) ?  "0" + this.expiryMonth : this.expiryMonth, this.expiryYear);
	}
	
	public Boolean equals(OPUSCard obj) {
		/* checks if the the current OPUSCard object 
		 * has the same name, same type, same expiry month and year
		 * as the object passed as a param */
		return ((this.cardType.equals(obj.cardType)) && 
				(this.cardHolder.equals(obj.cardHolder)) && 
				(this.expiryMonth == obj.expiryMonth) && 
				(this.expiryYear == obj.expiryYear));
	}
}
