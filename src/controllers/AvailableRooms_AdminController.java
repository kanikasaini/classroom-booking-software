
package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import application.Admin;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.text.Text;

//controls Available Rooms page for Admin

public class AvailableRooms_AdminController {
	@FXML private TextField  capacity;
	@FXML private ComboBox<String> roomNo, timeStart, timeEnd;
	private Admin admin;

	protected void setUser(Admin a)
	{
		this.admin= (Admin)a;
	}
    public void initialize() { //first method 
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

	@FXML private DatePicker date;

	@FXML protected void handleCheckButtonAction(ActionEvent event) throws Exception { //method which executes when check availability button is clicked
		 	String roomNumber = roomNo.getValue();
		 	LocalDate now = date.getValue();
		 	String day = now.getDayOfWeek().name();
		 	int c = Integer.parseInt(capacity.getText());
		 	String start = timeStart.getValue();
		 	String end= timeEnd.getValue();
		 	try
		 	{
		 		ObjectInputStream in = null;
		        in = new ObjectInputStream(new FileInputStream("database/rooms/"+roomNumber+".txt"));
		        in.close();
		        in = new ObjectInputStream(new FileInputStream("database/bookedRooms/"+roomNumber+".txt"));
		        Room room = (Room)in.readObject();

		        boolean flag= room.checkOverlap(day, start, end); //if timings overlap with existing booking, show alert that room unavailable, else show alert that room is available
		        if(flag==true)
		        {
		        	Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Classroom Booking System");
					alert.setHeaderText("Room Not Available");
					alert.setContentText("Please enter again");
					alert.showAndWait();
					Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/AvailableRooms_Admin.fxml"));
					Scene homepage = new Scene(rootHomepage);
					((Stage)roomNo.getScene().getWindow()).setScene(homepage);
		        }
		        else
		        {
		        	Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Classroom Booking System");
					alert.setHeaderText("Room is available.");
					alert.setContentText("Go to BookRoom to book this.");
					alert.showAndWait();
					Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/AvailableRooms_Admin.fxml"));
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
				Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/AvailableRooms_Admin.fxml"));
				Scene homepage = new Scene(rootHomepage);
				((Stage)roomNo.getScene().getWindow()).setScene(homepage);
		 	}
		}
	
	//GUI interconnection
	@FXML private MenuBar mainNavBar;
	@FXML private Button checkBtn;

	@FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		User_AdminController usc= fxmlLoader.<User_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
		((Stage)checkBtn.getScene().getWindow()).setScene(homepage);
	 }
	@FXML protected void handleBookRoomButton(ActionEvent event) throws Exception {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		BookRoom_AdminController usc= fxmlLoader.<BookRoom_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
		((Stage)checkBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleMyBookingsButton(ActionEvent event) throws Exception {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			MyBookings_AdminController usc= fxmlLoader.<MyBookings_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)checkBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleHandleRequestsButton(ActionEvent event) throws Exception {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/HandleRequests_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			HandleRequests_AdminController usc= fxmlLoader.<HandleRequests_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)checkBtn.getScene().getWindow()).setScene(homepage);
	 }

}

