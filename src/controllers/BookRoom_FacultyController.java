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
import application.Faculty;
import application.Room;
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
import javafx.scene.control.MenuBar;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BookRoom_FacultyController {

	@FXML private MenuBar mainNavBar;
	@FXML private Button bookBtn;
	@FXML private ComboBox<String> roomNo, timeStart, timeEnd;
	@FXML private DatePicker date;
	private Faculty faculty;
	protected void setUser(Faculty a)
	{
		this.faculty= (Faculty)a;
	}

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

	    @FXML protected void handleBookButtonAction(ActionEvent event) throws Exception {
		 	String roomNumber = roomNo.getValue();
		 	LocalDate now = date.getValue();
		 	String day = now.getDayOfWeek().name();
		 	String start = timeStart.getValue();
		 	String end= timeEnd.getValue();
		 	try
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
					alert.setContentText("Please enter again");
					alert.showAndWait();
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Faculty.fxml"));
					Parent rootHomepage = fxmlLoader.load();
					BookRoom_FacultyController usc= fxmlLoader.<BookRoom_FacultyController>getController();
					usc.setUser(faculty);
					Scene homepage = new Scene(rootHomepage);
					((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);
		        }
		        else
		        {
		        	room.addBookedSlot(day, start, end);
		        	Booking b = new Booking(room.getNumber(), day, start, end);
		        	System.out.println(faculty.getType());
		        	System.out.println(b.getRoomNo());
		        	faculty.addBooking(b);
		        	serialize(room);
		        	serialize(faculty);
		        	Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Classroom Booking System");
					alert.setHeaderText("Booked Room Successfully");
					alert.setContentText("Click OK to continue");
					alert.showAndWait();
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Faculty.fxml"));
					Parent rootHomepage = fxmlLoader.load();
					BookRoom_FacultyController usc= fxmlLoader.<BookRoom_FacultyController>getController();
					usc.setUser(faculty);
					Scene homepage = new Scene(rootHomepage);
					((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);
		        }

		 	}
		 	catch(FileNotFoundException e)
		 	{
		 		Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Classroom Booking System");
				alert.setHeaderText("Room Not Available");
				alert.setContentText("Please enter again");
				alert.showAndWait();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Faculty.fxml"));
				Parent rootHomepage = fxmlLoader.load();
				BookRoom_FacultyController usc= fxmlLoader.<BookRoom_FacultyController>getController();
				usc.setUser(faculty);
				Scene homepage = new Scene(rootHomepage);
				((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);
		 	}
		}

	    	public static void serialize(Room pl) throws IOException
	    	{
	        ObjectOutputStream out = null;
	        try {
	            out = new ObjectOutputStream(new FileOutputStream("database/bookedRooms/"+pl.getNumber()+".txt"));
	            out.writeObject(pl);
	        } finally
	        {
	            out.close();
	        }
	    	}
	    	public static void serialize(User user) throws IOException
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
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			User_FacultyController usc= fxmlLoader.<User_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)bookBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleAvailableRoomsButton() throws IOException {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_FacultyController usc= fxmlLoader.<AvailableRooms_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)bookBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleMyBookingsButton() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			MyBookings_FacultyController usc= fxmlLoader.<MyBookings_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)bookBtn.getScene().getWindow()).setScene(homepage);
	 }

}
