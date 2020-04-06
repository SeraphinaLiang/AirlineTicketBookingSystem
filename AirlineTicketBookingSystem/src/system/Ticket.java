package system;

public class Ticket {
	private String ticketNumber;
	private String passportNumber;
	private String flightNumber;
	private String baggageAllowance;
	private String specialMeal;
	private String theClass;
	private String baggageAdd;

	public boolean generate=false;
	public static String tax;
	public static String fare;
	public static String total;

	public Ticket(String ticketNumber, String passportNumber, String flightNumber, String baggageAllowance,
			String specialMeal, String theClass) {
		super();
		this.ticketNumber = ticketNumber;
		this.passportNumber = passportNumber;
		this.flightNumber = flightNumber;
		this.baggageAllowance = baggageAllowance;
		this.specialMeal = specialMeal;
		this.theClass = theClass;
	}

	public String getBaggageAdd() {
		return baggageAdd;
	}

	public void setBaggageAdd(String baggageAdd) {
		this.baggageAdd = baggageAdd;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getBaggageAllowance() {
		return baggageAllowance;
	}

	public String getSpecialMeal() {
		return specialMeal;
	}

	public String getTheClass() {
		return theClass;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setBaggageAllowance(String baggageAllowance) {
		this.baggageAllowance = baggageAllowance;
	}

	public void setSpecialMeal(String specialMeal) {
		this.specialMeal = specialMeal;
	}

	public void setTheClass(String theClass) {
		this.theClass = theClass;
	}

}
