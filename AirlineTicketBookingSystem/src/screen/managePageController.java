package screen;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	private ListView<String> lvPassenger;

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

	@FXML
	private Button btavailable;

//------------------------------------------------------------------------------------------

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		initFlightCell();
		allFlightsListViewListener();
	}

	void refreshment() {// 刷新界面
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

	@FXML
	void cancelFlight(ActionEvent event) {

		if (this.lvAllFlight.getSelectionModel().getSelectedItem() != null) {
			FlightCell cell = this.lvAllFlight.getSelectionModel().getSelectedItem();
			String number = cell.getFlightNumber();
			Main.sql.modifiedFlightState(number, 1);
			// 刷新界面
			refreshment();
		}

	}

	@FXML
	void availableFlight(ActionEvent event) {
		if (this.lvAllFlight.getSelectionModel().getSelectedItem() != null) {
			FlightCell cell = this.lvAllFlight.getSelectionModel().getSelectedItem();
			String number = cell.getFlightNumber();
			Main.sql.modifiedFlightState(number, 0);
			// 刷新界面
			refreshment();
		}
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

											flight = new Flight(this.tfflightNumber.getText(),
													this.tfDeparture.getText(), this.tfArrival.getText(),
													this.departureDay.getEditor().getText(),
													this.arrivalDay.getEditor().getText(), this.departureTime.getText(),
													this.arrivalTime.getText(), this.tfPlaneType.getText(),
													this.tfCompany.getText(), 0);

											Main.getSQLDemo().addFlight(flight);

											// clear input
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
		refreshment();
	}

	void allFlightsListViewListener() {

		this.lvAllFlight.getSelectionModel().selectedItemProperty().addListener(o -> {
			FlightCell cell = this.lvAllFlight.getSelectionModel().getSelectedItem();

			if (cell != null) {
				String number = cell.getFlightNumber();
				this.initPassengerListview(number);

				int FC = Main.sql.getSeatBookingNumber(number, "FIRST-CLASS");
				int BC = Main.sql.getSeatBookingNumber(number, "BUSINESS");
				int EC = Main.sql.getSeatBookingNumber(number, "ECONOMY");

				double FRate = (((double) FC) / 35) * 100;
				double BRate = (((double) BC) / 35) * 100;
				double ERate = (((double) EC) / 35) * 100;
				double totalRate = (((double) (FC + BC + EC)) / 105) * 100;

				this.firstclassRate.setText(String.format("%.2f", FRate) + " %");
				this.businessRate.setText(String.format("%.2f", BRate) + " %");
				this.economyRate.setText(String.format("%.2f", ERate) + " %");
				this.totalRate.setText(String.format("%.2f", totalRate) + " %");

			}
		});

	}

	void initPassengerListview(String number) {
		ArrayList<String> list = Main.sql.getPassengerListofTheFlight(number);
		ObservableList<String> pass = FXCollections.observableArrayList(list);
		this.lvPassenger.setItems(pass);
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
