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
import application.Student;
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
//class which controls Homepage of Student
public class User_StudentController {

	@FXML private MenuBar mainNavBar;
	@FXML private Menu availableRooms;
	@FXML private Text userName;
	@FXML private MenuItem openAvailableRooms;
	@FXML private MenuItem openRequestBooking;
	@FXML private MenuItem openMyBookings;
	@FXML private MenuItem openCourseCatalogue;
	@FXML private MenuItem openTimetable;
	@FXML private Text username;
	 @FXML private ImageView imageView;


	private Student student;
	@FXML private TextArea notes;


	protected void setUser(User a)
	{
		this.student= (Student)a;
		System.out.println("student set");
	}

	@FXML public void initializer() throws IOException
	{
		notes.setText(student.getNotes());
		System.out.println("initializer called");
		username.setText(student.getUserId());
	}
	 @FXML protected void handleNotes(MouseEvent event) throws Exception {
		 	String n= notes.getText();
		 student.setNotes(n);
		 serialize(student);
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
             student.setImageUrl("database/"+file.getName());
             Image image = SwingFXUtils.toFXImage(bufferedImage, null);
             student.setImage(image);
             imageView.setImage(image);
             serialize(student);
         } catch (IOException ex) {
         }

	 }
	 @FXML protected void handleAvailableRoomsButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Student.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			AvailableRooms_StudentController usc= fxmlLoader.<AvailableRooms_StudentController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleRequestBookingButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/RequestBooking_Student.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			RequestBooking_StudentController usc= fxmlLoader.<RequestBooking_StudentController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);

	 }

	 @FXML protected void handleMyBookingsButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Student.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			MyBookings_StudentController usc= fxmlLoader.<MyBookings_StudentController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);

	 }

	 @FXML protected void handleCourseCatalogueButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Courses.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			CoursesController usc= fxmlLoader.<CoursesController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleTimetableButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Timetable.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			TimetableController usc= fxmlLoader.<TimetableController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);
	 }
	 @FXML protected void handleLogoutButton(ActionEvent event) throws Exception {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Signin.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			LoginController usc= fxmlLoader.<LoginController>getController();
			Scene homepage = new Scene(rootHomepage);
			((Stage)mainNavBar.getScene().getWindow()).setScene(homepage);
	 }
}