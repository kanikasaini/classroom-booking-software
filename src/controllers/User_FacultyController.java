package controllers;
import java.io.IOException;
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


	 @FXML protected void handleAvailableRoomsButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/AvailableRooms_Faculty.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)username.getScene().getWindow()).setScene(Homepage);
	 }
	 
	 @FXML protected void handleBookRoomButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/BookRoom_Faculty.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)username.getScene().getWindow()).setScene(Homepage);
	 }
	 
	 @FXML protected void handleMyBookingsButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/MyBookings_Faculty.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)username.getScene().getWindow()).setScene(Homepage);
	 }
	 
}