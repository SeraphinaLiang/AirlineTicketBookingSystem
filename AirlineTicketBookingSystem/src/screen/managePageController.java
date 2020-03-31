package screen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import main.Main;
import system.Flight;

public class managePageController implements Initializable {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	// ---------------------------------
	@FXML
	private AnchorPane basic;
	// ---------------------------------
	@FXML
	private Button btLogin;

	@FXML
	private PasswordField tfPassword;

	@FXML
	private TextField tfAccount;
	// ---------------------------------

	@FXML
	private TextField departureTime;

	@FXML
	private TextField tfflightNumber;

	@FXML
	private DatePicker arrivalDay;

	@FXML
	private Label businessRate;

	@FXML
	private TextField tfDeparture;

	@FXML
	private ListView<?> lvPassenger;

	@FXML
	private TextField tfArrival;

	@FXML
	private Button btCancel;

	@FXML
	private TextField tfPlaneType;

	@FXML
	private ListView<?> lvAllFlight;

	@FXML
	private DatePicker departureDay;

	@FXML
	private Label economyRate;

	@FXML
	private Label firstclassRate;

	@FXML
	private TextField tfCompany;

	@FXML
	private Label totalRate;

	@FXML
	private Button btAdd;

	@FXML
	private TextField arrivalTime;
//------------------------------------------------------------------------------------------

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	void cancelFlight(ActionEvent event) {

	}

	@FXML
	void addFlight(ActionEvent event) {
		Flight flight;
		if (!this.tfflightNumber.getText().isEmpty()) {
			if (!this.tfDeparture.getText().isEmpty()) {
				if (!this.tfArrival.getText().isEmpty()) {
					if (!this.tfPlaneType.getText().isEmpty()) {
						if (!this.tfCompany.getText().isEmpty()) {
							if (!this.arrivalTime.getText().isEmpty()) {
								if (!this.departureTime.getText().isEmpty()) {
									if (!this.arrivalDay.getEditor().getText().isEmpty()) {
										if (!this.departureDay.getEditor().getText().isEmpty()) {

											flight = new Flight(
													this.tfflightNumber.getText(),
													this.tfDeparture.getText(), 
													this.tfArrival.getText(),
													this.departureDay.getEditor().getText(),
													this.arrivalDay.getEditor().getText(),
													this.departureTime.getText(),
													this.arrivalTime.getText(), 
													this.tfPlaneType.getText(),
													this.tfCompany.getText());
											
											Main.getSQLDemo().addFlight(flight);
											
											//clear input
											this.tfflightNumber.clear();
											this.tfDeparture.clear();
											this.tfArrival.clear();
											this.departureDay.getEditor().clear();
											this.arrivalDay.getEditor().clear();
											this.departureTime.clear();
											this.arrivalTime.clear();
											this.tfPlaneType.clear();
											this.tfCompany.clear();
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	void allFlightsListViewListener() {

	}

	@FXML
	void managerLogin(ActionEvent event) {
//最后改回登录
//		String account = null, key = null;
//
//		if (!this.tfAccount.getText().isEmpty()) {
//			account = this.tfAccount.getText();
//		}
//		if (!this.tfPassword.getText().isEmpty()) {
//			key = this.tfPassword.getText();
//		}
//		if ((account != null) && (key != null)) {
//			if (account.equals(main.Main.managerAccount) && key.equals(main.Main.managerPassword)) {
//				  
//				try {
//					Pane pane = FXMLLoader.load(getClass().getResource("managePage.fxml"));
//					this.basic.getChildren().setAll(pane);
//
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}

		try {
			Pane pane = FXMLLoader.load(getClass().getResource("managePage.fxml"));
			this.basic.getChildren().setAll(pane);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
