package system;

import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

public class FlightCell extends ListCell<String> {
	private HBox hbox = new HBox();
	
	
	public FlightCell() {
		
	}
	
	public HBox getHbox() {
		return hbox;
	}
}
