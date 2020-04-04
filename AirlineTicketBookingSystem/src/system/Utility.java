package system;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import main.Main;

public class Utility {
	public static String currentTicketNo;
	
	//manager page 返回该航班乘客名单
	public static ObservableList<String> getPassengersListWithFlight(){
		ObservableList<String> list = null;
		
		return list;
	}
	
	//manager page 显示所有航班，包括取消的航班
	public static ObservableList<FlightCell> getAllAvailableFlightManager() {
		ArrayList<Flight> flights=Main.sql.getAllFlights();
		ObservableList<FlightCell> flightList = FXCollections.observableArrayList();
		
		Iterator<Flight> iter=flights.iterator();
		while(iter.hasNext()) {
			Flight f=iter.next();
			String state=null;
			if(f.isCancel()) {
				state="CANCEL";
			}else {
				state="ON SCHEDULE";
			}
			
			String other="  "+f.getPlaneType()+"  "+f.getCompany()+"  "
			+f.getDepartureCity()+" -> "+f.getArrivalCity()+"  DEPART "
			+f.getDepartureDay()+" "+f.getDepartureTime()+"  ARRIVE "+
			f.getArrivalDay()+" "+f.getArrivalTime()+"  "+state;
			
			FlightCell cell=new FlightCell(f.getNumber(),other);
			flightList.add(cell);	
		}

		return flightList;
	}
	
	//flight schedule page 只显示未被取消的航班
	public static ObservableList<FlightCell> getAllAvailableFlightSchedule() {
		ArrayList<Flight> flights=Main.sql.getAllFlights();
		ObservableList<FlightCell> flightList = FXCollections.observableArrayList();
		
		Iterator<Flight> iter=flights.iterator();
		while(iter.hasNext()) {
			Flight f=iter.next();
			//如果航班没被取消，则显示
			if(!f.isCancel()) {
				String other="  "+f.getPlaneType()+"  "+f.getCompany()+"  "
						+f.getDepartureCity()+" -> "+f.getArrivalCity()+"  DEPART "
						+f.getDepartureDay()+" "+f.getDepartureTime()+"  ARRIVE "+
						f.getArrivalDay()+" "+f.getArrivalTime()+"  ";
						
						FlightCell cell=new FlightCell(f.getNumber(),other);
						flightList.add(cell);	
			}
		}

		return flightList;
	}

	@SuppressWarnings("static-access")
	public static java.sql.Time strToTime(String strDate) {
		String str = strDate;
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		java.util.Date d = null;
		try {
			d = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Time time = new java.sql.Time(d.getTime());
		return time.valueOf(str);
	}

}
