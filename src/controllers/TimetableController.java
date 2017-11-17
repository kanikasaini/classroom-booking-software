package controllers;

import application.Timetable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import application.Course;
import application.Student;
import application.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TimetableController {
	
	@FXML private TableView<Timetable> tableView;
	@FXML private TableColumn<Timetable, String> eightThirtyNineColumn;
	@FXML private TableColumn<Timetable, String> nineNineThirtyColumn;
	@FXML private TableColumn<Timetable, String> nineThirtyTenColumn;
	@FXML private TableColumn<Timetable, String> tenTenThirtyColumn;
	@FXML private TableColumn<Timetable, String> tenThirtyElevenColumn;
	@FXML private TableColumn<Timetable, String> elevenElevenThirtyColumn;
	@FXML private TableColumn<Timetable, String> elevenThirtyTwelveColumn;
	@FXML private TableColumn<Timetable, String> twelveTwelveThirtyColumn;
	@FXML private TableColumn<Timetable, String> twelveThirtyOneColumn;
	@FXML private TableColumn<Timetable, String> oneOneThirtyColumn;
	@FXML private TableColumn<Timetable, String> oneThirtyTwoColumn;
	@FXML private TableColumn<Timetable, String> twoTwoThirtyColumn;
	@FXML private TableColumn<Timetable, String> twoThirtyThreeColumn;
	@FXML private TableColumn<Timetable, String> threeThreeThirtyColumn;
	@FXML private TableColumn<Timetable, String> threeThirtyFourColumn;
	@FXML private TableColumn<Timetable, String> fourFourThirtyColumn;
	@FXML private TableColumn<Timetable, String> fourThirtyFiveColumn;
	@FXML private TableColumn<Timetable, String> fiveFiveThirtyColumn;
	@FXML private TableColumn<Timetable, String> fiveThirtySixColumn;
    private ObservableList<Timetable> dayslist = FXCollections.observableArrayList();
	
    public void initialize() throws IOException {
    	eightThirtyNineColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("eightThirtyNine"));
    	nineNineThirtyColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("nineNineThirty"));
        nineThirtyTenColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("nineThirtyTen"));
        tenTenThirtyColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("tenTenThirty"));
        tenThirtyElevenColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("tenThirtyEleven"));
        elevenElevenThirtyColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("elevenElevenThirty")); 
        elevenThirtyTwelveColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("elevenThirtyTwelve"));
        twelveTwelveThirtyColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("twelveTwelveThirty"));
        twelveThirtyOneColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("twelveThirtyOne"));
        oneOneThirtyColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("oneOneThirty"));
        oneThirtyTwoColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("oneThirtyTwo"));
        twoTwoThirtyColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("twoTwoThirty"));
        twoThirtyThreeColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("twoThirtyThree"));
        threeThreeThirtyColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("threeThreeThirty"));
        threeThirtyFourColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("threeThirtyFour"));
        fourFourThirtyColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("fourFourThirty"));
        fourThirtyFiveColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("fourThirtyFive"));
        fiveFiveThirtyColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("fiveFiveThirty"));
        fiveThirtySixColumn.setCellValueFactory(new PropertyValueFactory<Timetable, String>("fiveThirtySix"));
        makeList();
        for(int i=0;i<dayslist.size();i++)
        {
        	System.out.println(dayslist.get(i));
        }
        tableView.setItems(dayslist);
    }
    
    public void makeList() throws IOException {
    	//Timetable Monday = new Timetable(".","Tut M3\nGp1\nLR1","." , "NT\nC12","." , "AP\nC21","." , "Tut AP\nGp1,2,3,4\nLR1,LR2,S01.S02",".");
    	Timetable Monday = new Timetable("","","","","","AP\nC21",".","Tut AP\nGp1,2,3,4\nLR1,LR2,S01,S01",".","","","","","","","","","","");
    	Timetable Tuesday = new Timetable("","","","","","","","","","CO\nC21",".","DM\nC21",".","","","","","","");
    	Timetable Wednesday = new Timetable("","","","","","AP\nC21",".","","","CO\n",".","DM\nC21",".","Tut CO\nGp1,2,3,4\nLR1,LR2,S01,S01",".",".","Tut DM\nGp1\nS01",".","");
    	Timetable Thursday = new Timetable("","","","","","AP\nC21",".","Lab AP\nGp1,2,3,4\nL21,L22,L23",".","","","","","","",".","CO\nC21",".","");
    	Timetable Friday = new Timetable("","","","","","","",".","DM\nC21",".","","","","","",".","Tut DM\nGp2,3,4\nLR1,LR2,LR3",".","");
    	dayslist.add(Monday); 
    	dayslist.add(Tuesday); 
    	dayslist.add(Wednesday); 
    	dayslist.add(Thursday); 
    	dayslist.add(Friday);
    	//System.out.println(dayslist.get(0));
        }	
    
    
	private Student student;

	protected void setUser(User a)
	{
		this.student= (Student)a;
	}
	@FXML private Label timetableLabel;

	@FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		User_StudentController usc= fxmlLoader.<User_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
 			((Stage)timetableLabel.getScene().getWindow()).setScene(homepage);
	 }
	@FXML protected void handleAvailableRoomsButton() throws IOException {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		AvailableRooms_StudentController usc= fxmlLoader.<AvailableRooms_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
			((Stage)timetableLabel.getScene().getWindow()).setScene(homepage);
	 }

	@FXML protected void handleRequestBookingButton() throws IOException {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/RequestBooking_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		RequestBooking_StudentController usc= fxmlLoader.<RequestBooking_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
			((Stage)timetableLabel.getScene().getWindow()).setScene(homepage);

	 }

	 @FXML protected void handleMyBookingsButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Student.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			MyBookings_StudentController usc= fxmlLoader.<MyBookings_StudentController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)timetableLabel.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleCourseCatalogueButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Courses.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			CoursesController usc= fxmlLoader.<CoursesController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)timetableLabel.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleTimetableButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Timetable.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			TimetableController usc= fxmlLoader.<TimetableController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)timetableLabel.getScene().getWindow()).setScene(homepage);
	 }
}
