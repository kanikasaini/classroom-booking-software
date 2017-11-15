package controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TimetableController {
	
	@FXML private Label timetableLabel;
	
	 @FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/User_Student.fxml"));
 			Scene homepage = new Scene(rootHomepage);
 			((Stage)timetableLabel.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleAvailableRoomsButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/AvailableRooms_Student.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)timetableLabel.getScene().getWindow()).setScene(Homepage);
	 }
	 
	 @FXML protected void handleRequestBookingButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/RequestBooking_Student.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)timetableLabel.getScene().getWindow()).setScene(Homepage);
		
	 }
	 
	 @FXML protected void handleMyBookingsButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/MyBookings_Student.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)timetableLabel.getScene().getWindow()).setScene(Homepage);
	 }
	 
	 @FXML protected void handleCourseCatalogueButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/Courses.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)timetableLabel.getScene().getWindow()).setScene(Homepage);
	 }
	 
	 @FXML protected void handleTimetableButton() throws IOException {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/Timetable.fxml"));
			Scene Homepage = new Scene(rootHomepage, 400,400);	
			((Stage)timetableLabel.getScene().getWindow()).setScene(Homepage);
	 }
}
