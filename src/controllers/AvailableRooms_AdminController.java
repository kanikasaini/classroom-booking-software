
package controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.User;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.text.Text;


public class AvailableRooms_AdminController {
	@FXML private TextField roomNo, capacity;
	@FXML protected void handleCheckButtonAction(ActionEvent event) throws Exception {
		 	String roomNumber = roomNo.getText();
		 	Date now = new Date();
		 	SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");
		 	String day = simpleDateformat.format(now);
		 	int c= Integer.parseInt(capacity.getText());
		 	String time= "10:00-11:00";
		 	try
		 	{
		 		ObjectInputStream in = null;
		        User user= null;
		        in = new ObjectInputStream(new FileInputStream("database/rooms/"+roomNumber+".txt"));
		        System.out.println(roomNumber);
		        in.close();
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
	@FXML private MenuBar mainNavBar;
	@FXML private Button checkBtn;

	 @FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/User_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)checkBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleBookRoomButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/BookRoom_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)checkBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleMyBookingsButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/MyBookings_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)checkBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleHandleRequestsButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/HandleRequests_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)checkBtn.getScene().getWindow()).setScene(homepage);
	 }

}

