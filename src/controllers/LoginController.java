package controllers;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import application.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginController {

	 @FXML private TextField loginEmail, loginPassword, signupEmail, signupPassword;
	 @FXML final ToggleGroup group = new ToggleGroup();
	 @FXML private ToggleButton adminType, studentType, facultyType;

	 @FXML protected void handleLoginButtonAction(ActionEvent event) throws Exception {
		 	String checkEmail, checkPassword;
			checkEmail = loginEmail.getText();
			checkPassword = loginPassword.getText();
			signIn(checkEmail, checkPassword);
	 }
	@FXML protected void handleSignupButtonAction(ActionEvent event) throws Exception {
			String email, password;
			email = signupEmail.getText();
			password = signupPassword.getText();
			if(adminType.isSelected())
				signUp(email, password, "Admin");
			else if(studentType.isSelected())
				signUp(email, password, "Student");
			else if(facultyType.isSelected())
				signUp(email, password, "Faculty");
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/Signin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)loginEmail.getScene().getWindow()).setScene(homepage);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Classroom Booking System");
			alert.setHeaderText("You have successfully signed up!");
			alert.setContentText("Please login to continue.");
			alert.showAndWait();
	}
	@FXML protected void addToToggleGroup(ActionEvent event) throws Exception {
		adminType.setToggleGroup(group);
		studentType.setToggleGroup(group);
		facultyType.setToggleGroup(group);
	}
	public void signIn(String email, String password) throws Exception
	{
		try
		{
			User user= deserialize(email);
			if(password.equals(user.getPassword()))
					{
						if(user.getType().equals("Student"))
						{	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/User_Student.fxml"));
							Scene homepage = new Scene(rootHomepage);
							((Stage)loginEmail.getScene().getWindow()).setScene(homepage);
						}
						else if(user.getType().equals("Admin"))
						{	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/User_Admin.fxml"));
							Scene homepage = new Scene(rootHomepage);
							((Stage)loginEmail.getScene().getWindow()).setScene(homepage);
						}
						else if(user.getType().equals("Faculty"))
						{	Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/User_Faculty.fxml"));
						Scene homepage = new Scene(rootHomepage);
						((Stage)loginEmail.getScene().getWindow()).setScene(homepage);
						}
					}
			else
			{
				Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/Signin.fxml"));
				Scene homepage = new Scene(rootHomepage);
				((Stage)loginEmail.getScene().getWindow()).setScene(homepage);
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Classroom Booking System");
				alert.setHeaderText("Incorrect Password");
				alert.setContentText("Please try again.");
				alert.showAndWait();
			}
		}
		catch(FileNotFoundException e)
		{
			Parent rootHomepage = FXMLLoader.load(getClass().getResource("../view/Signin.fxml"));
			Scene homepage = new Scene(rootHomepage);
			((Stage)loginEmail.getScene().getWindow()).setScene(homepage);
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Classroom Booking System");
			alert.setHeaderText("You don't have an account yet.");
			alert.setContentText("Please sign up to continue.");
			alert.showAndWait();
		}
	}
	public void signUp(String userId, String password, String type) throws Exception
	{
		User user = new User();
		if(type.equals("Admin"))
			user = new Admin(userId, password, type);
		else if(type.equals("Student"))
			user= new Student(userId, password, type);
		else if(type.equals("Faculty"))
			user= new Faculty(userId, password, type);
		serialize(user);
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
}
