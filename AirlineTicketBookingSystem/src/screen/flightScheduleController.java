package screen;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import system.FlightCell;
import system.Utility;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;

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

	@FXML
	private ListView<FlightCell> flightInfo;

	@FXML
	private Button btBook;
	
	 @FXML
	    private ComboBox<String> cbClass;



//----------------------------------------------------------------------------------------------

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.returnDate.setDisable(true);
		
		this.cbClass.getItems().clear();
		this.cbClass.getItems().addAll("Economy","Business","First-Class");
		
		initFlightCell();
	}

	@FXML
	void searchFlight(ActionEvent event) {

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
