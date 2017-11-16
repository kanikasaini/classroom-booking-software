package controllers;

import application.Admin;
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
	private Admin admin;
	protected void setUser(Admin a)
	{
		this.admin= (Admin)a;
	}
	@FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		User_AdminController usc= fxmlLoader.<User_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
		((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);
	 }
	@FXML protected void handleAvailableRoomsButton(ActionEvent event) throws Exception {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		AvailableRooms_AdminController usc= fxmlLoader.<AvailableRooms_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
			((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);
	 }

	@FXML protected void handleBookRoomButton(ActionEvent event) throws Exception {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		BookRoom_AdminController usc= fxmlLoader.<BookRoom_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
		((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);
	 }
	@FXML protected void handleMyBookingsButton(ActionEvent event) throws Exception {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Admin.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		MyBookings_AdminController usc= fxmlLoader.<MyBookings_AdminController>getController();
		usc.setUser(admin);
		Scene homepage = new Scene(rootHomepage);
			((Stage)handleRequestsLabel.getScene().getWindow()).setScene(homepage);
	 }
}

