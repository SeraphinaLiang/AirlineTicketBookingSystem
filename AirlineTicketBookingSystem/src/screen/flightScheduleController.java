package screen;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import system.Flight;
import system.FlightCell;
import system.Passenger;
import system.Utility;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;
import main.Main;

public class flightScheduleController implements Initializable {
	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;

	@FXML
	private ToggleGroup tripType;

	@FXML
	private DatePicker returnDate;

	@FXML
	private Button btSearchFlight;

	@FXML
	private TextField tfDeparture;

	@FXML
	private RadioButton rbRoundTrip;

	@FXML
	private TextField tfDestination;

	@FXML
	private DatePicker departureDate;

	@FXML
	private RadioButton rbOneWay;
//-----------------------------------------
	@FXML
	private ListView<FlightCell> flightInfo;

	@FXML
	private Button btBook;

	@FXML
	private ComboBox<String> cbClass;

	@FXML
	private Label departTime;

	@FXML
	private Button btconfirmOrder;

	@FXML
	private Label departandArrival;
	@FXML
	private Label freeBaggage;

	@FXML
	private Label arrivalTime;
	@FXML
	private Label FlightNumber;
//--------------------------------
	@FXML
	private DatePicker birthday;
	@FXML
	private ToggleGroup gender;
	@FXML
	private RadioButton rbfemale;
	@FXML
	private TextField tfPassport;
	@FXML
	private TextField tfemail;
	@FXML
	private DatePicker expireDate;
	@FXML
	private RadioButton rbmale;
	@FXML
	private TextField tffirstName;
	@FXML
	private TextField tfLastName;

//----------------------------------------------------------------------------------------------

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.returnDate.setDisable(true);

		this.cbClass.getItems().clear();
		this.cbClass.getItems().addAll("Economy", "Business", "First-Class");

		classListener();
		initFlightCell();
	}

	// 根据舱位变动免费行李额
	void classListener() {

		this.cbClass.getSelectionModel().selectedItemProperty().addListener(o -> {
			String selected = this.cbClass.getSelectionModel().getSelectedItem();
			if (selected.equals("Business")) {
				this.freeBaggage.setText("36KG--Two Pieces");
			} else if (selected.equals("First-Class")) {
				this.freeBaggage.setText("48KG--Two Pieces");
			} else if (selected.equals("Economy")) {
				this.freeBaggage.setText("24KG--One Piece");
			}
		});
	}

	@FXML
	void comfirmOrder(ActionEvent event) {

		String flightNo = this.FlightNumber.getText();

		if (!this.tffirstName.getText().isEmpty()) {
			if (!this.tffirstName.getText().isEmpty()) {
				if (!this.tfPassport.getText().isEmpty()) {
					if (!this.tfemail.getText().isEmpty()) {
						if (!this.birthday.getEditor().getText().isEmpty()) {
							if (!this.expireDate.getEditor().getText().isEmpty()) {
								if (!flightNo.contains("---")) {

									// 增加一名乘客
									String firstName = this.tffirstName.getText().toUpperCase();
									String lastName = this.tfLastName.getText().toUpperCase();
									String passport = this.tfPassport.getText();
									String email = this.tfemail.getText();
									String birthday = this.birthday.getEditor().getText().replace('/', '-');
									String expirDate = this.expireDate.getEditor().getText().replace('/', '-');
									int gender = 0;

									if (rbmale.isSelected()) {
										gender = 1;
									} else {
										gender = 2;
									}

									Passenger pass = new Passenger(firstName, lastName, gender, passport, expirDate,
											email, birthday);

									if (!Main.sql.alreadyAddPassenger(passport)) {
										Main.sql.addPassenger(pass);
									}

									// -------乘客book航班---------------
									Main.sql.passengerBookFlight(passport, flightNo);
									// -------产生预定的ticket-----------------
									String theclass = this.cbClass.getSelectionModel().getSelectedItem();
									String baggage = this.freeBaggage.getText();

									if (this.cbClass.getSelectionModel().getSelectedItem() == null) {
										theclass = "Economy";
										baggage = "24KG--One Piece";
									}

									String ticketNo = new String();
									int hash = Math.abs(flightNo.hashCode()*passport.hashCode());
									ticketNo = (hash + String.valueOf(getRandom())).substring(0, 9);

									Main.getSQLDemo().generateTicket(ticketNo, flightNo, passport, baggage, theclass);

									// ----------弹窗-显示ticket预定编号---------------
									Utility.currentTicketNo = ticketNo;
									try {

										Pane pane = FXMLLoader.load(getClass().getResource("bookTicketPopUp.fxml"));
										Scene scene = new Scene(pane);
										Stage s = new Stage();
										s.setScene(scene);
										s.initStyle(StageStyle.UTILITY);
										s.show();

									} catch (IOException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
							}
						}
					}
				}
			}
		}

	}

	int getRandom() {
		double j = System.currentTimeMillis();
        
		double i = Math.random() * 100;
		return (int) (j * i);
	}

	@FXML
	void searchFlight(ActionEvent event) {//TODO

		String departCity = null;
		String desCity = null;
		int tripType = 1; // 1-oneway 2-roundtrip
		String departDate;
		String returnDate;

		if (!this.tfDeparture.getText().isEmpty()) {
			departCity = this.tfDeparture.getText();
		}
		if (!this.tfDestination.getText().isEmpty()) {
			desCity = this.tfDestination.getText();
		}

		if (this.rbOneWay.isSelected()) {
			tripType = 1;
			departDate = this.departureDate.getValue().toString();// 2020-01-29
		} else if (this.rbRoundTrip.isSelected()) {
			tripType = 2;
			departDate = this.departureDate.getValue().toString();// 2020-01-29
			returnDate = this.returnDate.getValue().toString();
		}

	}

	@FXML
	void ClickOneWay(ActionEvent event) {
		this.returnDate.setDisable(true);
	}

	@FXML
	void ClickRoundTrip(ActionEvent event) {
		this.returnDate.setDisable(false);
	}

	@FXML
	void bookFlight(ActionEvent event) {
		if (this.flightInfo.getSelectionModel().getSelectedItem() != null) {
			FlightCell cell = this.flightInfo.getSelectionModel().getSelectedItem();
			if (cell != null) {
				String number = cell.getFlightNumber();
				Flight f = Main.sql.getFlightPickByCustomer(number);

				String deAr = f.getDepartureCity() + "/" + f.getArrivalCity();
				String deTime = f.getDepartureDay() + " " + f.getDepartureTime().substring(0, 5);
				String arTime = f.getArrivalDay() + " " + f.getArrivalTime().substring(0, 5);

				this.FlightNumber.setText(f.getNumber());
				this.departandArrival.setText(deAr);
				this.arrivalTime.setText(arTime);
				this.departTime.setText(deTime);

			}

		}

	}

	void initFlightCell() {
		this.flightInfo.setCellFactory(new Callback<ListView<FlightCell>, ListCell<FlightCell>>() {
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
		this.flightInfo.setItems(Utility.getAllAvailableFlightSchedule());
	}
}
