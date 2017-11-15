package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MyBookings_FacultyController {

	 @FXML private Label myBookingsLabel;

	 @FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/User_Faculty.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleAvailableRoomsButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/AvailableRooms_Faculty.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(Homepage);
	 }
	 
	 @FXML protected void handleBookRoomButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/BookRoom_Faculty.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(Homepage);
	 }	 
}