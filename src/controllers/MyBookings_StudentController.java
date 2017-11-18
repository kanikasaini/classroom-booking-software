package controllers;

import java.io.IOException;

import application.Booking;
import application.Request;
import application.Student;
import application.User;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class MyBookings_StudentController {
	private Student student;

	protected void setUser(User a)
	{
		this.student= (Student)a;
	}
	@FXML private Label myBookingsLabel;
	@FXML private TableView<Request> tableView;
    @FXML private TableColumn<Request, String> roomColumn;
    @FXML private TableColumn<Request, String> dayColumn;
    @FXML private TableColumn<Request, String> timeColumn;
    @FXML private TableColumn<Request, String> purposeColumn;
    @FXML private TableColumn<Request, Integer> stateColumn;
    private ObservableList<Request> requestlist = FXCollections.observableArrayList();

	public void makeList() throws IOException
    {
		System.out.println(student.getUserId());
		requestlist = FXCollections.observableArrayList(student.getRequests());
    }
	public void initializer() throws IOException {
        makeList();
        tableView.setItems(requestlist);
        roomColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("prefferedRoom"));
    	dayColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("day"));
        timeColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("time"));
        purposeColumn.setCellValueFactory(new PropertyValueFactory<Request, String>("purpose"));
        stateColumn.setCellValueFactory(new PropertyValueFactory<Request,Integer>("state"));
        tableView.setItems(requestlist);
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    }

	@FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		User_StudentController usc= fxmlLoader.<User_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }
	@FXML protected void handleAvailableRoomsButton() throws IOException {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		AvailableRooms_StudentController usc= fxmlLoader.<AvailableRooms_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleRequestBookingButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/RequestBooking_Student.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			RequestBooking_StudentController usc= fxmlLoader.<RequestBooking_StudentController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);

	 }

	 @FXML protected void handleCourseCatalogueButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Courses.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			CoursesController usc= fxmlLoader.<CoursesController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleTimetableButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Timetable.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			TimetableController usc= fxmlLoader.<TimetableController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)myBookingsLabel.getScene().getWindow()).setScene(homepage);
	 }
}

