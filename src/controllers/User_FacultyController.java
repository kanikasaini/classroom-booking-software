package controllers;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.ImageIO;

import com.sun.javafx.logging.Logger;

import application.Admin;
import application.Faculty;
import application.User;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
//class which controls Homepage of Faculty
public class User_FacultyController {

	 @FXML private Text username;

	 private Faculty faculty;
	 @FXML private ImageView imageView;
	@FXML private TextArea notes;

		protected void setUser(User a)
		{
			this.faculty= (Faculty)a;
		}

		@FXML public void initializer() throws IOException
			{
				notes.setText(faculty.getNotes());
				username.setText(faculty.getUserId());
				BufferedImage bufferedImage = ImageIO.read(new File(faculty.getImageUrl()));
	            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
				imageView.setImage(image);
				System.out.println("initializer called");
			}
		 @FXML protected void handleNotes(MouseEvent event) throws Exception {
			 String n= notes.getText();
			 faculty.setNotes(n);
			 System.out.println("notes called");
			 serialize(faculty);
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
	 @FXML protected void handleAvailableRoomsButton() throws IOException {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_FacultyController usc= fxmlLoader.<AvailableRooms_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleBookRoomButton() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/BookRoom_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			BookRoom_FacultyController usc= fxmlLoader.<BookRoom_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleMyBookingsButton() throws IOException {
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Faculty.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			MyBookings_FacultyController usc= fxmlLoader.<MyBookings_FacultyController>getController();
			usc.setUser(faculty);
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
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
             faculty.setImageUrl("database/"+file.getName());
             Image image = SwingFXUtils.toFXImage(bufferedImage, null);
             faculty.setImage(image);
             imageView.setImage(image);
             serialize(faculty);
         } catch (IOException ex) {
         }

	 }
	 @FXML protected void handleLogoutButton(ActionEvent event) throws Exception {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Signin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			LoginController usc= fxmlLoader.<LoginController>getController();
			Scene homepage = new Scene(rootHomepage);
			((Stage)username.getScene().getWindow()).setScene(homepage);
	 }

}