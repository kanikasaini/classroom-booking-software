package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import application.Booking;
import application.Request;
import application.Room;
import application.Student;
import application.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class RequestBooking_StudentController {
	private Student student;
	@FXML private Button submitBtn;
	@FXML private ComboBox<String> roomNo, timeStart, timeEnd;
	@FXML private DatePicker date;
	@FXML private TextField purpose, capacity;
	protected void setUser(User a)
	{
		this.student= (Student)a;
	}
	@FXML private Label requestBookingLabel;

	public void initialize() {
        List<String> list = new ArrayList<String>();
        for(int i=8;i<=19;i++)
        {
        	if(i%13!=0)
        	{
        		String t1 = Integer.toString(i%13)+":00";
        		list.add(t1);
        		String t2 = Integer.toString(i%13)+":30";
        		list.add(t2);
        	}
        }
        ObservableList obList = FXCollections.observableList(list);
        timeStart.getItems().clear();
        timeStart.setItems(obList);
        timeEnd.getItems().clear();
        timeEnd.setItems(obList);
    }

	@FXML protected void handleSubmitButtonAction(ActionEvent event) throws Exception {
	 	String roomNumber = roomNo.getValue();
	 	LocalDate now = date.getValue();
	 	String day = now.getDayOfWeek().name();
	 	String start = timeStart.getValue();
	 	String end= timeEnd.getValue();
	 	String purp= purpose.getText();
	 	int c = Integer.parseInt(capacity.getText());
	 	try
	 	{
	 		if(roomNo.getValue()!=null)

	 		{
	 			ObjectInputStream in = null;
	        in = new ObjectInputStream(new FileInputStream("database/rooms/"+roomNumber+".txt"));
	        in.close();
	        in = new ObjectInputStream(new FileInputStream("database/bookedRooms/"+roomNumber+".txt"));
	        Room room = (Room)in.readObject();
	        boolean flag= room.checkOverlap(day, start, end);
	        if(flag==true)
	        {
	        	Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Classroom Booking System");
				alert.setHeaderText("Room Not Available");
				alert.setContentText("Please choose another one.");
				alert.showAndWait();
				Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/RequestBooking_Student.fxml"));
				Scene homepage = new Scene(rootHomepage);
				((Stage)roomNo.getScene().getWindow()).setScene(homepage);
	        }
	        else
	        {

	        	Request b = new Request(room.getNumber(), purp, student.getUserId(), c,day, start, end);
	        	student.addRequest(b);
	        	serialize(student);
	        	Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Classroom Booking System");
				alert.setHeaderText("Made Request Successfully");
				alert.setContentText("Click OK to continue");
				alert.showAndWait();
				Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/RequestBooking_Student.fxml"));
				Scene homepage = new Scene(rootHomepage);
				((Stage)roomNo.getScene().getWindow()).setScene(homepage);
	        }
	 		}
	 		else
	 		{
	 			Request b = new Request( purp, student.getUserId(), c, day, start, end);
	        	student.addRequest(b);
	        	serialize(student);
	        	Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Classroom Booking System");
				alert.setHeaderText("Made Request Successfully");
				alert.setContentText("Click OK to continue");
				alert.showAndWait();
				Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/RequestBooking_Student.fxml"));
				Scene homepage = new Scene(rootHomepage);
				((Stage)roomNo.getScene().getWindow()).setScene(homepage);
	 		}

	 	}
	 	catch(FileNotFoundException e)
	 	{
	 		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Classroom Booking System");
			alert.setHeaderText("Room Not Available");
			alert.setContentText("Please enter again");
			alert.showAndWait();
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/BookRoom_Faculty.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)roomNo.getScene().getWindow()).setScene(homepage);
	 	}
	}
	public static void serialize(Student user) throws IOException
	{
    ObjectOutputStream out = null;
    try {
        out = new ObjectOutputStream(new FileOutputStream("database/users/"+user.getUserId()+".txt"));
        out.writeObject(user);
    } finally
    {
        out.close();
    }
	}



 @FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		User_StudentController usc= fxmlLoader.<User_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
		((Stage)requestBookingLabel.getScene().getWindow()).setScene(homepage);
 }

 @FXML protected void handleAvailableRoomsButton() throws IOException {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		AvailableRooms_StudentController usc= fxmlLoader.<AvailableRooms_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
		((Stage)requestBookingLabel.getScene().getWindow()).setScene(homepage);
 }

 @FXML protected void handleMyBookingsButton() throws IOException {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		MyBookings_StudentController usc= fxmlLoader.<MyBookings_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
		((Stage)requestBookingLabel.getScene().getWindow()).setScene(homepage);
 }

 @FXML protected void handleCourseCatalogueButton() throws IOException {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Courses.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		CoursesController usc= fxmlLoader.<CoursesController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
		((Stage)requestBookingLabel.getScene().getWindow()).setScene(homepage);
 }

 @FXML protected void handleTimetableButton() throws IOException {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Timetable.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		TimetableController usc= fxmlLoader.<TimetableController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
		((Stage)requestBookingLabel.getScene().getWindow()).setScene(homepage);
 }
}
