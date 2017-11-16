package controllers;

import java.io.IOException;

import application.Student;
import application.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CoursesController {

	private Student student;

	protected void setUser(User a)
	{
		this.student= (Student)a;
	}
	@FXML private Label coursesLabel;

	@FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		User_StudentController usc= fxmlLoader.<User_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
			((Stage)coursesLabel.getScene().getWindow()).setScene(homepage);
	 }

	@FXML protected void handleAvailableRoomsButton() throws IOException {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		AvailableRooms_StudentController usc= fxmlLoader.<AvailableRooms_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
			((Stage)coursesLabel.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleRequestBookingButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/RequestBooking_Student.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			RequestBooking_StudentController usc= fxmlLoader.<RequestBooking_StudentController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)coursesLabel.getScene().getWindow()).setScene(homepage);

	 }

	 @FXML protected void handleMyBookingsButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Student.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			MyBookings_StudentController usc= fxmlLoader.<MyBookings_StudentController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)coursesLabel.getScene().getWindow()).setScene(homepage);
	 }


	 @FXML protected void handleTimetableButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Timetable.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			TimetableController usc= fxmlLoader.<TimetableController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)coursesLabel.getScene().getWindow()).setScene(homepage);
	 }
}

