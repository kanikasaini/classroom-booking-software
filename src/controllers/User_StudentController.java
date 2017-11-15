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

public class User_StudentController {

	@FXML private MenuBar mainNavBar;
	@FXML private Menu availableRooms;
	@FXML private Text userName;
	@FXML private MenuItem openAvailableRooms;
	@FXML private MenuItem openRequestBooking;
	@FXML private MenuItem openMyBookings;
	@FXML private MenuItem openCourseCatalogue;
	@FXML private MenuItem openTimetable;


	 @FXML protected void handleAvailableRoomsButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/AvailableRooms_Student.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)mainNavBar.getScene().getWindow()).setScene(Homepage);
	 }
	 
	 @FXML protected void handleRequestBookingButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/RequestBooking_Student.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)mainNavBar.getScene().getWindow()).setScene(Homepage);
		
	 }
	 
	 @FXML protected void handleMyBookingsButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/MyBookings_Student.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)mainNavBar.getScene().getWindow()).setScene(Homepage);
	 }
	 
	 @FXML protected void handleCourseCatalogueButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/Courses.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)mainNavBar.getScene().getWindow()).setScene(Homepage);
	 }
	 
	 @FXML protected void handleTimetableButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/Timetable.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)mainNavBar.getScene().getWindow()).setScene(Homepage);
	 }
}