package controllers;
import java.io.IOException;

import application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

	 @FXML private TextField actiontarget;

	 @FXML protected void handleSubmitButtonAction(ActionEvent event) throws IOException {
	        //actiontarget.setText("Sign in button pressed");
	       // Login login = new Login();
		//	login.signUp("sakkjd", "sjdka", "sdja");
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/User_Student.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400, 400);
			  ((Stage)actiontarget.getScene().getWindow()).setScene(Homepage);

	 }
}
