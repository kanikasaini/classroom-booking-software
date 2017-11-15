package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class BookRoom_AdminController {

	@FXML private MenuBar mainNavBar;
	@FXML private Button bookBtn;
	
	 @FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/User_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)bookBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleAvailableRoomsButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/AvailableRooms_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)bookBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleMyBookingsButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/MyBookings_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)bookBtn.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleHandleRequestsButton(ActionEvent event) throws Exception {
		 	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/HandleRequests_Admin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)bookBtn.getScene().getWindow()).setScene(homepage);
	 }
}
