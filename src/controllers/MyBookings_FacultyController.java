package controllers;

import java.io.IOException;

import application.Faculty;
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
	 private Faculty faculty;
		protected void setUser(Faculty a)
		{
			this.faculty= (Faculty)a;
		}
	 @FXML protected void handleHomeButton(ActionEvent event) throws Exception {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			User_FacultyController usc= fxmlLoader.<User_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleAvailableRoomsButton() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_FacultyController usc= fxmlLoader.<AvailableRooms_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleBookRoomButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			BookRoom_FacultyController usc= fxmlLoader.<BookRoom_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }
}