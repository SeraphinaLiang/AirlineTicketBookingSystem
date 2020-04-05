package screen;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import system.Utility;

public class PopUpController implements Initializable{
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	  @FXML
	    private Text message;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		showBookingNumber();
	}
	
	void showBookingNumber() {
		String mess="Your booking number is "+Utility.currentTicketNo+"."
				+ "\nPlease note down your booking number, and move to MyBooking Page.";
		message.setText(mess);
	}

}
