package main;

import java.io.IOException;

import database.SQLDemo;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class Main extends Application {

	public static Stage stage = new Stage();
	public static SQLDemo sql = new SQLDemo();
	
	public static String managerAccount="airline";
	public static String managerPassword="00000000";
	
	public static void main(String[] args) {
		
		sql.initDatabase();  //关闭数据库在homepageController--toExit()
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("screen/homepage.fxml"));
		Scene mainScene = new Scene(root);
		stage.setHeight(529);
		stage.setWidth(764);
		stage.setResizable(false);
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.setScene(mainScene);
		stage.show();
	}
	
	public static Stage getPrimaryStage() {
		return stage;
	}

	public static SQLDemo getSQLDemo() {
		return sql;
	}
}
