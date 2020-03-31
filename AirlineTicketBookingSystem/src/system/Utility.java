package system;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Utility {
	public static ObservableList<FlightCell> getAllAvailableFlight() {
		ObservableList<FlightCell> flightList = FXCollections.observableArrayList();

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
