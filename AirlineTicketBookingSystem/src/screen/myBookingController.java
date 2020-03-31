package screen;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.shape.Rectangle;
import main.Main;

public class myBookingController implements Initializable {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	//------------------------------
	@FXML
    private Rectangle A1,A2,A3,A4,A5,A6,A7,B1,B2,B3,B4,B5,B6,B7,C1,C2,C3,C4,C5,C6,C7;
    @FXML
    private Rectangle D1,D2,D3,D4,D5,D6,D7,E1,E2,E3,E4,E5,E6,E7,F1,F2,F3,F4,F5,F6,F7;
    //-------------------------------------------------------------------------------
    
    @FXML
    private Button btBill;

    @FXML
    private Button btcancel;

    @FXML
    private TextField tfBookingNumber;

    @FXML
    private MenuButton mbChangeClass;

    @FXML
    private Button btComfirmSeat;

    @FXML
    private TextField tfPassportNumber;

    @FXML
    private MenuButton mbSpecialMeal;

    @FXML
    private MenuButton mbBaggage;

    @FXML
    private Button btDownloadForm;

    @FXML
    private Button btSearch;
//----------------------------------------
    private static String currentFlightNumber;

//----------------------------------------------------------------------------------------------
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
       this.initMenuButton();
    	
	}
    
    void initMenuButton() {
    	//------------baggage allowance--------------
    	MenuItem bag1 = new MenuItem("24KG--One piece");
    	MenuItem bag2 = new MenuItem("48KG--Two pieces");
    	this.mbBaggage.getItems().clear();
    	this.mbBaggage.getItems().addAll(bag1,bag2);
    	//-----------class-------------------------
    	MenuItem EC = new MenuItem("Economy");
    	MenuItem BC = new MenuItem("Business");
    	MenuItem FC = new MenuItem("First-Class");
    	this.mbChangeClass.getItems().clear();
    	this.mbChangeClass.getItems().addAll(EC,BC,FC);
    	//---------------meal------------------------
    	MenuItem meal7 = new MenuItem("No lactose");
    	MenuItem meal1 = new MenuItem("Muslim");
    	MenuItem meal2 = new MenuItem("Diabetic");
    	MenuItem meal3 = new MenuItem("Low Sodium");
    	MenuItem meal4 = new MenuItem("Vegetarian");
    	MenuItem meal5 = new MenuItem("Kosher");
    	
    	this.mbSpecialMeal.getItems().clear();
    	this.mbSpecialMeal.getItems().addAll(meal7,meal1,meal2,meal3,meal4,meal5);
    	
    }
    
    void refreshSeat() {
    	//-------------A-----------------
    		if(!Main.getSQLDemo().getSeatAvailableState("A1", currentFlightNumber)) {
    			this.A1.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("A2", currentFlightNumber)) {
    			this.A2.setStyle("-fx-fill:#eb5757");
    		} 
    		if(!Main.getSQLDemo().getSeatAvailableState("A3", currentFlightNumber)) {
    			this.A3.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("A4", currentFlightNumber)) {
    			this.A4.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("A5", currentFlightNumber)) {
    			this.A5.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("A6", currentFlightNumber)) {
    			this.A6.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("A7", currentFlightNumber)) {
    			this.A7.setStyle("-fx-fill:#eb5757");
    		}
    	//-----------B-----------------------------
    		if(!Main.getSQLDemo().getSeatAvailableState("B1", currentFlightNumber)) {
    			this.B1.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("B2", currentFlightNumber)) {
    			this.B2.setStyle("-fx-fill:#eb5757");
    		} 
    		if(!Main.getSQLDemo().getSeatAvailableState("B3", currentFlightNumber)) {
    			this.B3.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("B4", currentFlightNumber)) {
    			this.B4.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("B5", currentFlightNumber)) {
    			this.B5.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("B6", currentFlightNumber)) {
    			this.B6.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("B7", currentFlightNumber)) {
    			this.B7.setStyle("-fx-fill:#eb5757");
    		}
    	//--------C---------------------
    		if(!Main.getSQLDemo().getSeatAvailableState("C1", currentFlightNumber)) {
    			this.C1.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("C2", currentFlightNumber)) {
    			this.C2.setStyle("-fx-fill:#eb5757");
    		} 
    		if(!Main.getSQLDemo().getSeatAvailableState("C3", currentFlightNumber)) {
    			this.C3.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("C4", currentFlightNumber)) {
    			this.C4.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("C5", currentFlightNumber)) {
    			this.C5.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("C6", currentFlightNumber)) {
    			this.C6.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("C7", currentFlightNumber)) {
    			this.C7.setStyle("-fx-fill:#eb5757");
    		}
    		//--------------D-----------------------
    		if(!Main.getSQLDemo().getSeatAvailableState("D1", currentFlightNumber)) {
    			this.D1.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("D2", currentFlightNumber)) {
    			this.D2.setStyle("-fx-fill:#eb5757");
    		} 
    		if(!Main.getSQLDemo().getSeatAvailableState("D3", currentFlightNumber)) {
    			this.D3.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("D4", currentFlightNumber)) {
    			this.D4.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("D5", currentFlightNumber)) {
    			this.D5.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("D6", currentFlightNumber)) {
    			this.D6.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("D7", currentFlightNumber)) {
    			this.D7.setStyle("-fx-fill:#eb5757");
    		}
    		//-------------------E---------------------
    		if(!Main.getSQLDemo().getSeatAvailableState("E1", currentFlightNumber)) {
    			this.E1.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("E2", currentFlightNumber)) {
    			this.E2.setStyle("-fx-fill:#eb5757");
    		} 
    		if(!Main.getSQLDemo().getSeatAvailableState("E3", currentFlightNumber)) {
    			this.E3.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("E4", currentFlightNumber)) {
    			this.E4.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("E5", currentFlightNumber)) {
    			this.E5.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("E6", currentFlightNumber)) {
    			this.E6.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("E7", currentFlightNumber)) {
    			this.E7.setStyle("-fx-fill:#eb5757");
    		}
    		//-----------------F-----------------
    		if(!Main.getSQLDemo().getSeatAvailableState("F1", currentFlightNumber)) {
    			this.F1.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("F2", currentFlightNumber)) {
    			this.F2.setStyle("-fx-fill:#eb5757");
    		} 
    		if(!Main.getSQLDemo().getSeatAvailableState("F3", currentFlightNumber)) {
    			this.F3.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("F4", currentFlightNumber)) {
    			this.F4.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("F5", currentFlightNumber)) {
    			this.F5.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("F6", currentFlightNumber)) {
    			this.F6.setStyle("-fx-fill:#eb5757");
    		}
    		if(!Main.getSQLDemo().getSeatAvailableState("F7", currentFlightNumber)) {
    			this.F7.setStyle("-fx-fill:#eb5757");
    		}
    }
    
    @FXML
    void searchMyBooking(ActionEvent event) {

    }

    @FXML
    void changeClass(ActionEvent event) {

    }


    @FXML
    void purchaseBaggageAllowance(ActionEvent event) {

    }


    @FXML
    void selectSpecialMeal(ActionEvent event) {

    }


    @FXML
    void comfirmSeatSelection(ActionEvent event) {

    }


    @FXML
    void payTicket(ActionEvent event) {

    }


    @FXML
    void cancelFlight(ActionEvent event) {

    }

    @FXML
    void downloadTicketCollectionForm(ActionEvent event) {

    }

    @FXML
    void downloadTicketBills(ActionEvent event) {

    }
}
