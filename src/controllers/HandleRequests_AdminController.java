package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class HandleRequests_AdminController {

	@FXML private MenuBar mainNavBar;
	@FXML private Label handleRequestsLabel;
	
	 @FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/User_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleAvailableRoomsButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/AvailableRooms_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);
	 }
			
	 @FXML protected void handleBookRoomButton(ActionEvent event) throws Exception {
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/BookRoom_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);			
	 }
	 @FXML protected void handleMyBookingsButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/MyBookings_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);
	 }
}

