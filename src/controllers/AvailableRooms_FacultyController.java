package controllers;

import java.io.IOException;

import application.Faculty;
import application.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class AvailableRooms_FacultyController {

	@FXML private MenuBar mainNavBar;
	@FXML private Button checkBtn;
	private Faculty faculty;
	protected void setUser(Faculty a)
	{
		this.faculty= (Faculty)a;
	}
	 @FXML protected void handleHomeButton(ActionEvent event) throws Exception {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_FacultyController usc= fxmlLoader.<AvailableRooms_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)checkBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleBookRoomButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_FacultyController usc= fxmlLoader.<AvailableRooms_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)checkBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleMyBookingsButton() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_FacultyController usc= fxmlLoader.<AvailableRooms_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)checkBtn.getScene().getWindow()).setScene(homepage);
	 }
}

