package screen;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.PasswordField;

public class managerLoginController {
	@FXML
	private AnchorPane basic;
	@FXML
	private TextField tfAccount;
	@FXML
	private Button btLogin;
	@FXML
	private PasswordField tfPassword;

	// Event Listener on Button[#btLogin].onAction
	@FXML
	public void managerLogin(ActionEvent event) {
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
