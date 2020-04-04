package system;

public class Flight {

	private String number;
	
	private String departureCity;
	private String arrivalCity;
	
	private String departureDay;
	private String arrivalDay;
	
	private String departureTime;
	private String arrivalTime;
	
	private String planeType;
	private String company;
	
	private boolean isCancel=false; // 1-cancel 0-available
	
	public Flight(String number, String departureCity, String arrivalCity, String departureDay, String arrivalDay,
			String departureTime, String arrivalTime, String planeType, String company,int cancel) {
		super();
		this.number = number;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.departureDay = departureDay;
		this.arrivalDay = arrivalDay;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.planeType = planeType;
		this.company = company;
		if(cancel==1) {
			this.isCancel=true;
		}
	}
	
	public boolean isCancel() {
		return isCancel;
	}

	public void setCancel(boolean isCancel) {
		this.isCancel = isCancel;
	}

	public String getNumber() {
		return number;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public String getDepartureDay() {
		return departureDay;
	}
	public String getArrivalDay() {
		return arrivalDay;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public String getPlaneType() {
		return planeType;
	}
	public String getCompany() {
		return company;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public void setDepartureDay(String departureDay) {
		this.departureDay = departureDay;
	}
	public void setArrivalDay(String arrivalDay) {
		this.arrivalDay = arrivalDay;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public void setPlaneType(String planeType) {
		this.planeType = planeType;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	
}
