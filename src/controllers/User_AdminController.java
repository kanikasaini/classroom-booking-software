package controllers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

import application.Admin;
import application.User;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class User_AdminController {

	@FXML private Menu availableRooms;
	@FXML private Text username;
	@FXML private TextArea notes;
	 @FXML private ImageView imageView;

		private Admin admin;


		protected void setUser(User a)
		{
			this.admin= (Admin)a;
		}
		@FXML public void initializer() throws IOException
		{
			notes.setText(admin.getNotes());
			username.setText(admin.getUserId());
			System.out.println("initializer called");
		}

		 @FXML protected void handleUploadButton(ActionEvent e) throws IOException {
			 FileChooser fileChooser = new FileChooser();

	         //Set extension filter
	         FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
	         FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
	         fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

	         //Show open file dialog
	         File file = fileChooser.showOpenDialog(null);

	         try {
	             BufferedImage bufferedImage = ImageIO.read(file);
	             admin.setImageUrl("database/"+file.getName());
	             Image image = SwingFXUtils.toFXImage(bufferedImage, null);
	             admin.setImage(image);
	             imageView.setImage(image);
	             serialize(admin);
	         } catch (IOException ex) {
	         }

		 }
	 @FXML protected void handleAvailableRoomsButton(ActionEvent event) throws Exception {

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Admin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_AdminController usc= fxmlLoader.<AvailableRooms_AdminController>getController();
			usc.setUser(admin);
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleNotes(MouseEvent event) throws Exception {
		 	String n= notes.getText();
		 admin.setNotes(n);
		 serialize(admin);
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
	 public static User deserialize(String userId) throws Exception
	    {
	        ObjectInputStream in = null;
	        User user= null;
	        in = new ObjectInputStream(new FileInputStream("database/users/"+userId+".txt"));
	        user = (User)in.readObject();
	        in.close();
	        return user;
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
	 @FXML protected void handleLogoutButton(ActionEvent event) throws Exception {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Signin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			LoginController usc= fxmlLoader.<LoginController>getController();
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }
}
