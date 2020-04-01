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
import javafx.util.Callback;
import main.Main;
import system.Flight;
import system.FlightCell;
import system.Utility;

public class managePageController implements Initializable {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
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
	private ListView<FlightCell> lvAllFlight;

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
		
		initFlightCell();
		allFlightsListViewListener();
	}

	@FXML
	void cancelFlight(ActionEvent event) {
		this.lvAllFlight.getSelectionModel().selectedItemProperty().addListener(o->{
			FlightCell cell=this.lvAllFlight.getSelectionModel().getSelectedItem();
			String flightNumber=cell.getFlightNumber();
			
			
		});
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
													this.tfCompany.getText(),0);
											
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

	void allFlightsListViewListener() {//TODO
		
		this.lvAllFlight.getSelectionModel().selectedItemProperty().addListener(o->{
			FlightCell cell=this.lvAllFlight.getSelectionModel().getSelectedItem();
			String flightNumber=cell.getFlightNumber();
			
			
		});

	}
	void initFlightCell() {
		this.lvAllFlight.setCellFactory(new Callback<ListView<FlightCell>, ListCell<FlightCell>>() {
			@Override
			public ListCell<FlightCell> call(ListView<FlightCell> arg0) {
				ListCell<FlightCell> cell = new ListCell<FlightCell>() {
					@Override
					protected void updateItem(FlightCell n, boolean bt) {
						super.updateItem(n, bt);
						if (n != null) {
							setGraphic(n.getHbox());
						}
					}
				};
				return cell;
			}
		});
		this.lvAllFlight.setItems(Utility.getAllAvailableFlightManager());
	}



}
