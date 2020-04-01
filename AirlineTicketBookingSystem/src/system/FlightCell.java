package system;

import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class FlightCell extends ListCell<String> {
	private HBox hbox = new HBox();
	
	private Label fNumber=new Label();
	private Label info=new Label();
	private String flightNumber;

	public FlightCell(String Number,String other) {
		this.fNumber.setText(Number);
		info.setText(other);
		hbox.getChildren().addAll(fNumber,info);
		this.flightNumber=Number;
	}
	
	public HBox getHbox() {
		return hbox;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

}
