package screen;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.Main;
import system.DownloadFile;
import system.Flight;
import system.Ticket;

public class myBookingController implements Initializable {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	// ------------------------------
	@FXML
	private Rectangle A1, A2, A3, A4, A5, A6, A7, B1, B2, B3, B4, B5, B6, B7, C1, C2, C3, C4, C5, C6, C7;
	@FXML
	private Rectangle D1, D2, D3, D4, D5, D6, D7, E1, E2, E3, E4, E5, E6, E7;
	// -------------------------------------------------------------------------------

    @FXML
    private Button btpay;
	@FXML
	private Button btBill;

	@FXML
	private Button btcancel;

	@FXML
	private TextField tfBookingNumber;

	@FXML
	private Button btComfirmSeat;

	@FXML
	private TextField tfPassportNumber;

	@FXML
	private Button btDownloadForm;

	@FXML
	private Button btSearch;

	// -----------------------
	@FXML
	private ComboBox<String> cbBaggage;
	@FXML
	private ComboBox<String> cbChangeClass;
	@FXML
	private ComboBox<String> cbSpecialMeal;
	// --------------------------
	@FXML
	private Label tDepartArrival;
	@FXML
	private Label tFreebaggage;
	@FXML
	private Label tTerminal1;
	@FXML
	private Label tTerminal2;
	@FXML
	private Label tClass;
	@FXML
	private Label tcompany;
	@FXML
	private Label tPayStatus;
	@FXML
	private Label tflightNumber;
	@FXML
	private Label tplaneType;
	@FXML
	private Label tSeat;
	@FXML
	private Label tDepartTime;
	@FXML
	private Label tArrivalTime;
	@FXML
	private Label tFlightStatus;

//----------------------------------------
	private static String currentFlightNumber;
	private static String currentTicketNumber;
	private static String currentSeat;
	private static String currentTheClass;
	private static String currentPassportNumber;

//----------------------------------------------------------------------------------------------
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.initComboBox();
		seatSelectionListener();
		
		this.btComfirmSeat.setDisable(true);
		this.btDownloadForm.setDisable(true);
		this.btpay.setDisable(true);
		this.btBill.setDisable(true);
		this.btcancel.setDisable(true);
		
	}

	void seatSelectionListener() {

		A1.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass); currentSeat="A1";
			this.A1.setStyle("-fx-fill:#ebd759");
		});

		A2.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="A2";
			this.A2.setStyle("-fx-fill:#ebd759");
		});
		A3.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="A3";
			this.A3.setStyle("-fx-fill:#ebd759");
		});
		A4.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="A4";
			this.A4.setStyle("-fx-fill:#ebd759");
		});
		A5.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="A5";
			this.A5.setStyle("-fx-fill:#ebd759");
		});
		A6.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="A6";
			this.A6.setStyle("-fx-fill:#ebd759");
		});
		A7.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="A7";
			this.A7.setStyle("-fx-fill:#ebd759");
		});
		//--------------------------------------
		B1.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass); currentSeat="B1";
			this.B1.setStyle("-fx-fill:#ebd759");
		});

		B2.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="B2";
			this.B2.setStyle("-fx-fill:#ebd759");
		});
		B3.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="B3";
			this.B3.setStyle("-fx-fill:#ebd759");
		});
		B4.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="B4";
			this.B4.setStyle("-fx-fill:#ebd759");
		});
		B5.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="B5";
			this.B5.setStyle("-fx-fill:#ebd759");
		});
		B6.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="B6";
			this.B6.setStyle("-fx-fill:#ebd759");
		});
		B7.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="B7";
			this.B7.setStyle("-fx-fill:#ebd759");
		});
		//-------------------------------
		C1.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass); currentSeat="C1";
			this.C1.setStyle("-fx-fill:#ebd759");
		});

		C2.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="C2";
			this.C2.setStyle("-fx-fill:#ebd759");
		});
		C3.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="C3";
			this.C3.setStyle("-fx-fill:#ebd759");
		});
		C4.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="C4";
			this.C4.setStyle("-fx-fill:#ebd759");
		});
		C5.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="C5";
			this.C5.setStyle("-fx-fill:#ebd759");
		});
		C6.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="C6";
			this.C6.setStyle("-fx-fill:#ebd759");
		});
		C7.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="C7";
			this.C7.setStyle("-fx-fill:#ebd759");
		});
		//-----------------------------------
		D1.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass); currentSeat="D1";
			this.D1.setStyle("-fx-fill:#ebd759");
		});

		D2.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="D2";
			this.D2.setStyle("-fx-fill:#ebd759");
		});
		D3.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="D3";
			this.D3.setStyle("-fx-fill:#ebd759");
		});
		D4.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="D4";
			this.D4.setStyle("-fx-fill:#ebd759");
		});
		D5.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="D5";
			this.D5.setStyle("-fx-fill:#ebd759");
		});
		D6.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="D6";
			this.D6.setStyle("-fx-fill:#ebd759");
		});
		D7.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="D7";
			this.D7.setStyle("-fx-fill:#ebd759");
		});
		//------------------------------
		E1.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass); currentSeat="E1";
			this.E1.setStyle("-fx-fill:#ebd759");
		});

		E2.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="E2";
			this.E2.setStyle("-fx-fill:#ebd759");
		});
		E3.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="E3";
			this.E3.setStyle("-fx-fill:#ebd759");
		});
		E4.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="E4";
			this.E4.setStyle("-fx-fill:#ebd759");
		});
		E5.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="E5";
			this.E5.setStyle("-fx-fill:#ebd759");
		});
		E6.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="E6";
			this.E6.setStyle("-fx-fill:#ebd759");
		});
		E7.setOnMouseClicked(o1 -> {
			refreshSeat(currentTheClass);currentSeat="E7";
			this.E7.setStyle("-fx-fill:#ebd759");
		});

	}

	void initComboBox() {
		// ------------baggage allowance--------------
		this.cbBaggage.getItems().clear();
		this.cbBaggage.getItems().addAll("24KG--One piece", "48KG--Two pieces");

		// -----------class-------------------------
		this.cbChangeClass.getItems().clear();
		this.cbChangeClass.getItems().addAll("Economy", "Business", "First-Class");

		// ---------------meal------------------------
		this.cbSpecialMeal.getItems().clear();
		this.cbSpecialMeal.getItems().addAll("No lactose", "Muslim", "Diabetic", "Low Sodium", "Vegetarian", "Kosher");

	}

	void refreshSeat(String theClass) {
		// -------------A-----------------
		if (!Main.getSQLDemo().getSeatAvailableState("A1", currentFlightNumber,theClass)) {
			this.A1.setStyle("-fx-fill:#eb5757");
		} else {
			this.A1.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("A2", currentFlightNumber,theClass)) {
			this.A2.setStyle("-fx-fill:#eb5757");
		} else {
			this.A2.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("A3", currentFlightNumber,theClass)) {
			this.A3.setStyle("-fx-fill:#eb5757");
		} else {
			this.A3.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("A4", currentFlightNumber,theClass)) {
			this.A4.setStyle("-fx-fill:#eb5757");
		} else {
			this.A4.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("A5", currentFlightNumber,theClass)) {
			this.A5.setStyle("-fx-fill:#eb5757");
		} else {
			this.A5.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("A6", currentFlightNumber,theClass)) {
			this.A6.setStyle("-fx-fill:#eb5757");
		} else {
			this.A6.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("A7", currentFlightNumber,theClass)) {
			this.A7.setStyle("-fx-fill:#eb5757");
		} else {
			this.A7.setStyle("-fx-fill:#56afeb");
		}

		// -----------B-----------------------------
		if (!Main.getSQLDemo().getSeatAvailableState("B1", currentFlightNumber,theClass)) {
			this.B1.setStyle("-fx-fill:#eb5757");
		} else {
			this.B1.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("B2", currentFlightNumber,theClass)) {
			this.B2.setStyle("-fx-fill:#eb5757");
		} else {
			this.B2.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("B3", currentFlightNumber,theClass)) {
			this.B3.setStyle("-fx-fill:#eb5757");
		} else {
			this.B3.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("B4", currentFlightNumber,theClass)) {
			this.B4.setStyle("-fx-fill:#eb5757");
		} else {
			this.B4.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("B5", currentFlightNumber,theClass)) {
			this.B5.setStyle("-fx-fill:#eb5757");
		} else {
			this.B5.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("B6", currentFlightNumber,theClass)) {
			this.B6.setStyle("-fx-fill:#eb5757");
		} else {
			this.B6.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("B7", currentFlightNumber,theClass)) {
			this.B7.setStyle("-fx-fill:#eb5757");
		} else {
			this.B7.setStyle("-fx-fill:#56afeb");
		}

		// --------C---------------------
		if (!Main.getSQLDemo().getSeatAvailableState("C1", currentFlightNumber,theClass)) {
			this.C1.setStyle("-fx-fill:#eb5757");
		} else {
			this.C1.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("C2", currentFlightNumber,theClass)) {
			this.C2.setStyle("-fx-fill:#eb5757");
		} else {
			this.C2.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("C3", currentFlightNumber,theClass)) {
			this.C3.setStyle("-fx-fill:#eb5757");
		} else {
			this.C3.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("C4", currentFlightNumber,theClass)) {
			this.C4.setStyle("-fx-fill:#eb5757");
		} else {
			this.C4.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("C5", currentFlightNumber,theClass)) {
			this.C5.setStyle("-fx-fill:#eb5757");
		} else {
			this.C5.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("C6", currentFlightNumber,theClass)) {
			this.C6.setStyle("-fx-fill:#eb5757");
		} else {
			this.C6.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("C7", currentFlightNumber,theClass)) {
			this.C7.setStyle("-fx-fill:#eb5757");
		} else {
			this.C7.setStyle("-fx-fill:#56afeb");
		}

		// --------------D-----------------------
		if (!Main.getSQLDemo().getSeatAvailableState("D1", currentFlightNumber,theClass)) {
			this.D1.setStyle("-fx-fill:#eb5757");
		} else {
			this.D1.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("D2", currentFlightNumber,theClass)) {
			this.D2.setStyle("-fx-fill:#eb5757");
		} else {
			this.D2.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("D3", currentFlightNumber,theClass)) {
			this.D3.setStyle("-fx-fill:#eb5757");
		} else {
			this.D3.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("D4", currentFlightNumber,theClass)) {
			this.D4.setStyle("-fx-fill:#eb5757");
		} else {
			this.D4.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("D5", currentFlightNumber,theClass)) {
			this.D5.setStyle("-fx-fill:#eb5757");
		} else {
			this.D5.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("D6", currentFlightNumber,theClass)) {
			this.D6.setStyle("-fx-fill:#eb5757");
		} else {
			this.D6.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("D7", currentFlightNumber,theClass)) {
			this.D7.setStyle("-fx-fill:#eb5757");
		} else {
			this.D7.setStyle("-fx-fill:#56afeb");
		}
		// -------------------E---------------------
		if (!Main.getSQLDemo().getSeatAvailableState("E1", currentFlightNumber,theClass)) {
			this.E1.setStyle("-fx-fill:#eb5757");
		} else {
			this.E1.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("E2", currentFlightNumber,theClass)) {
			this.E2.setStyle("-fx-fill:#eb5757");
		} else {
			this.E2.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("E3", currentFlightNumber,theClass)) {
			this.E3.setStyle("-fx-fill:#eb5757");
		} else {
			this.E3.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("E4", currentFlightNumber,theClass)) {
			this.E4.setStyle("-fx-fill:#eb5757");
		} else {
			this.E4.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("E5", currentFlightNumber,theClass)) {
			this.E5.setStyle("-fx-fill:#eb5757");
		} else {
			this.E5.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("E6", currentFlightNumber,theClass)) {
			this.E6.setStyle("-fx-fill:#eb5757");
		} else {
			this.E6.setStyle("-fx-fill:#56afeb");
		}

		if (!Main.getSQLDemo().getSeatAvailableState("E7", currentFlightNumber,theClass)) {
			this.E7.setStyle("-fx-fill:#eb5757");
		} else {
			this.E7.setStyle("-fx-fill:#56afeb");
		}

	}

	@FXML
	void searchMyBooking(ActionEvent event) {
		if (!this.tfPassportNumber.getText().isEmpty()) {
			if (!this.tfBookingNumber.getText().isEmpty()) {
				String passport = this.tfPassportNumber.getText();
				String ticketNo = this.tfBookingNumber.getText();
				currentTicketNumber = ticketNo;

				if (Main.sql.isBookingNumberAndPassportMatch(passport, ticketNo)) {
					// 根据ticketNo 得到 航班号
					String flightNo = Main.sql.getFlightNoFromBookingNo(ticketNo);
					Flight f = Main.sql.getFlightPickByCustomer(flightNo);
					currentFlightNumber=flightNo;

					// 更新界面--航班信息
					this.tflightNumber.setText(f.getNumber());
					this.tcompany.setText(f.getCompany());
					this.tplaneType.setText(f.getPlaneType());
					this.tDepartArrival.setText(f.getDepartureCity() + "/" + f.getArrivalCity());
					this.tDepartTime.setText(f.getDepartureDay() + " " + f.getDepartureTime());
					this.tArrivalTime.setText(f.getArrivalDay() + " " + f.getArrivalTime());
					if (f.isCancel()) {
						this.tFlightStatus.setText("Cancel");
					} else {
						this.tFlightStatus.setText("On Schedule");
					}
					this.tTerminal1.setText(f.getT1());
					this.tTerminal2.setText(f.getT2());

					// 更新界面--机票信息
					Ticket t = Main.sql.getTicketFromTicketNo(ticketNo);
					this.tFreebaggage.setText(t.getBaggageAllowance());
					this.tClass.setText(t.getTheClass());
					
					currentPassportNumber=passport;
					currentTheClass=t.getTheClass();
					
					// ----seat----				
					String seat=Main.sql.getSeatifAlreadyChoose(flightNo,passport);
					
					if(!seat.equals("NO")) {
						this.btComfirmSeat.setDisable(true);
						this.tSeat.setText(seat);
						currentSeat=seat;
					}else {
						this.btComfirmSeat.setDisable(false);
					}
					
					// ---pay status---
					if(Main.sql.ifpaid(currentTicketNumber)) {
						this.tPayStatus.setText("Yes");
						this.btpay.setDisable(true);
						this.btDownloadForm.setDisable(false);
					}else {
						this.btpay.setDisable(false);
						this.btDownloadForm.setDisable(true);
					}
					this.btBill.setDisable(false);
					this.btcancel.setDisable(false);

				} else {
					// pop up 预定编号或护照号码错误
					try {

						Pane pane = FXMLLoader.load(getClass().getResource("PopUpSearchBooking.fxml"));
						Scene scene = new Scene(pane);
						Stage s = new Stage();
						s.setScene(scene);
						s.initStyle(StageStyle.UTILITY);
						s.setTitle("Attention");
						s.show();

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}

		refreshSeat(currentTheClass);
	}

//-----------------------menu button----------------------------------
	@FXML
	void changeClass(ActionEvent event) {
		String newClass = this.cbChangeClass.getSelectionModel().getSelectedItem();
		Main.sql.changeClass(currentTicketNumber, newClass);
		this.tClass.setText(newClass);
		currentTheClass=newClass;

		// change baggage allowance
		if (newClass.equals("First-Class")) {
			Main.sql.changeBaggageAllowance(currentTicketNumber, "48KG--Two Pieces");
			this.tFreebaggage.setText("48KG--Two Pieces");
		} else if (newClass.equals("Business")) {
			Main.sql.changeBaggageAllowance(currentTicketNumber, "36KG--Two Pieces");
			this.tFreebaggage.setText("36KG--Two Pieces");
		} else if (newClass.equals("Economy")) {
			Main.sql.changeBaggageAllowance(currentTicketNumber, "24KG--One Piece");
			this.tFreebaggage.setText("24KG--Two Piece");
		}

		refreshSeat(currentTheClass);
	}

	@FXML
	void purchaseBaggageAllowance(ActionEvent event) {
		String add = this.cbBaggage.getSelectionModel().getSelectedItem();
		Main.sql.addBaggageAllowance(currentTicketNumber, add);
	}

	@FXML
	void selectSpecialMeal(ActionEvent event) {
		String meal = this.cbSpecialMeal.getSelectionModel().getSelectedItem();
		Main.sql.changeMeal(currentTicketNumber, meal);
	}
//-----------------------menu button-----------------------------------

	@FXML
	void comfirmSeatSelection(ActionEvent event) {
		if (!Main.getSQLDemo().getSeatAvailableState(currentSeat, currentFlightNumber,currentTheClass)) {
			try {

				Pane pane = FXMLLoader.load(getClass().getResource("PopUpSeatUnavailable.fxml"));
				Scene scene = new Scene(pane);
				Stage s = new Stage();
				s.setScene(scene);
				s.initStyle(StageStyle.UTILITY);
				s.setTitle("Attention");
				s.show();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			this.tSeat.setText(currentSeat);
			Main.sql.chooseSeat(currentSeat, currentFlightNumber,currentTheClass, currentPassportNumber);
			this.btComfirmSeat.setDisable(true);
		}

	}

	@FXML
	void payTicket(ActionEvent event) {
		this.tPayStatus.setText("Yes");
		this.btpay.setDisable(true);
		Main.sql.payBill(currentTicketNumber);
		this.btDownloadForm.setDisable(false);
	}

	@FXML
	void cancelFlight(ActionEvent event) {
		
		Main.sql.cancelBooking(currentTicketNumber);
		
		try {
			
			//---------返回主页-------------
			Pane home = FXMLLoader.load(getClass().getResource("homepage.fxml"));
			Scene scenehome = new Scene(home);
			Stage ss=Main.getPrimaryStage();
			ss.setScene(scenehome);
			//---------弹窗------------
			Pane pane = FXMLLoader.load(getClass().getResource("PopUpCancelBooking.fxml"));
			Scene scene = new Scene(pane);
			Stage s = new Stage();
			s.setScene(scene);
			s.initStyle(StageStyle.UTILITY);
			s.setTitle("Notice");
			s.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@FXML
	void downloadTicketCollectionForm(ActionEvent event) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Save to ...");
		File directory = directoryChooser.showDialog(Main.getPrimaryStage());
		if (directory != null) {
			String filePath = directory + "/ticket_collection_form.pdf";
			DownloadFile.collectForm(filePath);
		}
	}

	@FXML
	void downloadTicketBills(ActionEvent event) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Save to ...");
		File directory = directoryChooser.showDialog(Main.getPrimaryStage());
		if (directory != null) {
			String filePath = directory + "/bill.pdf";
			DownloadFile.bill(filePath);
		}
	}
}
