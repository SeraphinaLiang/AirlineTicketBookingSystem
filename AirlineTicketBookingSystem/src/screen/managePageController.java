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

public class managePageController implements Initializable {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	// -------------------------------
	@FXML
	private Button btLogin;

	@FXML
	private TextField tfPassword;

	@FXML
	private TextField tfAccount;
	// --------------------------------
	@FXML
	private AnchorPane basic;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

	@FXML
	void managerLogin(ActionEvent event) {
		String account = null, key = null;

		if (!this.tfAccount.getText().isEmpty()) {
			account = this.tfAccount.getText();
		}
		if (!this.tfPassword.getText().isEmpty()) {
			key = this.tfPassword.getText();
		}
		if ((account != null) && (key != null)) {
			if (account.equals(main.Main.managerAccount) && key.equals(main.Main.managerPassword)) {
				  
				try {
					Pane pane = FXMLLoader.load(getClass().getResource("managePage.fxml"));
					this.basic.getChildren().setAll(pane);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
