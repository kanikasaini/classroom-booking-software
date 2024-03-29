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


//Class which handles book room page of Admin object
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

    public void initialize() { //first method, gets called itself
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

    @FXML protected void handleBookButtonAction(ActionEvent event) throws Exception { //method that executes when book room is pressed
	 	String roomNumber = roomNo.getValue();
	 	LocalDate now = date.getValue();
	 	String day = now.getDayOfWeek().name();
	 	String start = timeStart.getValue();
	 	String end= timeEnd.getValue();
	 	try
	 	{
	 		ObjectInputStream in = null; //tries to read room from database
	        in = new ObjectInputStream(new FileInputStream("database/rooms/"+roomNumber+".txt"));
	        in.close();
	        in = new ObjectInputStream(new FileInputStream("database/bookedRooms/"+roomNumber+".txt"));
	        Room room = (Room)in.readObject();
	        boolean flag= room.checkOverlap(day, start, end); //if timings entered by user overlap with existing bookings in database, throw an alert saying room not available
	        if(flag==true)
	        {
	        	Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Classroom Booking System");
				alert.setHeaderText("Room Not Available");
				alert.setContentText("Please enter again");
				alert.showAndWait();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Admin.fxml"));
				Parent rootHomepage = fxmlLoader.load();
				BookRoom_AdminController usc= fxmlLoader.<BookRoom_AdminController>getController();
				usc.setUser(admin);
				Scene homepage = new Scene(rootHomepage);
				((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);
	        }
	        else
	        { //else book room and add to database and show alert saying room booked
	        	room.addBookedSlot(day, start, end);
	        	Booking b = new Booking(room.getNumber(), day, start, end);
	        	System.out.println(admin.getType());
	        	System.out.println(b.getRoomNo());
	        	admin.addBooking(b);
	        	serialize(room);
	        	serialize(admin);
	        	Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Classroom Booking System");
				alert.setHeaderText("Booked Room Successfully");
				alert.setContentText("Click OK to continue");
				alert.showAndWait();
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Admin.fxml"));
				Parent rootHomepage = fxmlLoader.load();
				BookRoom_AdminController usc= fxmlLoader.<BookRoom_AdminController>getController();
				usc.setUser(admin);
				Scene homepage = new Scene(rootHomepage);
				((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);
	        }

	 	}
	 	catch(FileNotFoundException e) //exception if room doesnt exist
	 	{
	 		Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Classroom Booking System");
			alert.setHeaderText("Room Not Available");
			alert.setContentText("Please enter again");
			alert.showAndWait();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			BookRoom_AdminController usc= fxmlLoader.<BookRoom_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);
	 	}
	}

    	public static void serialize(Room pl) throws IOException //write to file
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
    	public static void serialize(User user) throws IOException //write to file
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
    	//GUI interconnection
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
