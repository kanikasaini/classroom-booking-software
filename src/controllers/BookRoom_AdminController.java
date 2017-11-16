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
import application.Admin;
import application.Booking;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class BookRoom_AdminController {

	@FXML private MenuBar mainNavBar;
	@FXML private Button bookBtn;
	@FXML private ComboBox<String> roomNo, timeStart, timeEnd;
	@FXML private DatePicker date;
	private Admin admin;


	protected void setUser(Admin a)
	{
		this.admin= (Admin)a;
		System.out.println(a.getPassword());
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
	        //Room room = (Room)in.readObject();
	        ArrayList<String> timeSlots= new ArrayList<String>();
	        timeSlots.add("Monday 10:00-12:00");
	        Room room = new Room(roomNumber, 180, timeSlots);
	        boolean flag= room.checkOverlap(day, start, end);
	        if(flag==true)
	        {
	        	Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Classroom Booking System");
				alert.setHeaderText("Room Not Available");
				alert.setContentText("Please enter again");
				alert.showAndWait();
				Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/BookRoom_Admin.fxml"));
				Scene homepage = new Scene(rootHomepage);
				((Stage)roomNo.getScene().getWindow()).setScene(homepage);
	        }
	        else
	        {
	        	room.addBookedSlot(day, start, end);
	        	serialize(room);
	        	Booking b = new Booking(room.getNumber(), day, start, end);

	        	admin.addBooking(b);
	        	Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Classroom Booking System");
				alert.setHeaderText("Booked Room Successfully");
				alert.setContentText("Click OK to continue");
				alert.showAndWait();
				Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/BookRoom_Admin.fxml"));
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
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/BookRoom_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)roomNo.getScene().getWindow()).setScene(homepage);
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
	 @FXML protected void handleHomeButton(ActionEvent event) throws Exception {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			User_AdminController usc= fxmlLoader.<User_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)bookBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleAvailableRoomsButton(ActionEvent event) throws Exception {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_AdminController usc= fxmlLoader.<AvailableRooms_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)bookBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleMyBookingsButton(ActionEvent event) throws Exception {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			MyBookings_AdminController usc= fxmlLoader.<MyBookings_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)bookBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleHandleRequestsButton(ActionEvent event) throws Exception {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/HandleRequests_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			HandleRequests_AdminController usc= fxmlLoader.<HandleRequests_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)bookBtn.getScene().getWindow()).setScene(homepage);
	 }
}
