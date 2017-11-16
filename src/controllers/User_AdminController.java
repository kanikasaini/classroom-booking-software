package controllers;

import application.Admin;
import application.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class User_AdminController {

	@FXML private Menu availableRooms;
	@FXML private Text username;
		private Admin admin;


		protected void setUser(User a)
		{
			this.admin= (Admin)a;
		}
	 @FXML protected void handleAvailableRoomsButton(ActionEvent event) throws Exception {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_AdminController usc= fxmlLoader.<AvailableRooms_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleBookRoomButton(ActionEvent event) throws Exception {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			BookRoom_AdminController usc= fxmlLoader.<BookRoom_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleMyBookingsButton(ActionEvent event) throws Exception {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			MyBookings_AdminController usc= fxmlLoader.<MyBookings_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleHandleRequestsButton(ActionEvent event) throws Exception {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/HandleRequests_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			HandleRequests_AdminController usc= fxmlLoader.<HandleRequests_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }
}
