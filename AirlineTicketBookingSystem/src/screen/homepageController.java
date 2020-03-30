package screen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class homepageController implements Initializable {
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;

	@FXML
	private Button btBooking;

	@FXML
	private Button btFlight;

	@FXML
	private Button btExit;
	
	@FXML
	private Pane homePane;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	void toFlightSchedulePage(ActionEvent event) {
		
		this.btFlight.setStyle("-fx-background-color: #C0C0C0;");
        this.btBooking.setStyle("-fx-background-color: #87CEEB;");
     // 进入界面
     		try {
     			Pane pane = FXMLLoader.load(getClass().getResource("flightSchedule.fxml"));
     			this.homePane.getChildren().setAll(pane);

     		} catch (IOException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
	}

	@FXML
	void toMyBookingPage(ActionEvent event) {
		this.btFlight.setStyle("-fx-background-color: #87CEEB;");
        this.btBooking.setStyle("-fx-background-color: #C0C0C0;");
     // 进入界面
 		try {
 			Pane pane = FXMLLoader.load(getClass().getResource("myBooking.fxml"));
 			this.homePane.getChildren().setAll(pane);

 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
        
	}

	@FXML
	void toExit(ActionEvent event) {
		main.Main.getPrimaryStage().close();
	}

}
