package controllers;
import java.io.IOException;

import application.Admin;
import application.Faculty;
import application.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class User_FacultyController {

	 @FXML private Text username;

	 private Faculty faculty;
		protected void setUser(User a)
		{
			this.faculty= (Faculty)a;
		}
	 @FXML protected void handleAvailableRoomsButton() throws IOException {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_FacultyController usc= fxmlLoader.<AvailableRooms_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleBookRoomButton() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_FacultyController usc= fxmlLoader.<AvailableRooms_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleMyBookingsButton() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_FacultyController usc= fxmlLoader.<AvailableRooms_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }

}