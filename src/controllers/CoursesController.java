package controllers;

import application.Course;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import application.Student;
import application.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CoursesController {

	@FXML private TextField searchWord;
	@FXML private TableView<Course> tableView;
    @FXML private TableColumn<Course, String> codeColumn;
    @FXML private TableColumn<Course, String> nameColumn;
    @FXML private TableColumn<Course, String> prereqColumn;
    @FXML private TableColumn<Course, String> facultyColumn;
    @FXML private TableColumn<Course, String> postconColumn;
    @FXML private TableColumn<Course, String> timingColumn; 
    private ObservableList<Course> courselist = FXCollections.observableArrayList();
    
    
    public void initialize() throws IOException {
    	codeColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("code"));
    	nameColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));
        prereqColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("prereq"));
        facultyColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("faculty"));
        postconColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("postcon"));
        timingColumn.setCellValueFactory(new PropertyValueFactory<Course, String>("timing"));
        //courselist.add(new Course("CSE201","AP","IP","Vivek","Dev","Never"));
        //List<Course> parseCourseList = new ArrayList<Course>();
        //parseCourseList.add(new Course("CSE201","AP","IP","Vivek","Dev","Never"));
        makeList();
        tableView.setItems(courselist);
    }
    
    
    
    
    @FXML protected void onClickingSearch(ActionEvent event) throws Exception {
		String word = searchWord.getText();
		System.out.println(word);
		ObservableList<Course> searchCourseList = FXCollections.observableArrayList();
		if(word.equals(""))
			searchCourseList = courselist;
		else
		{
			for(int i=0;i<courselist.size();i++)
			{
				String[] searchArray = courselist.get(i).getPostcon().split(" ");
				for(int j=0;j<searchArray.length;j++)
				{
					if(searchArray[j].equalsIgnoreCase(word))
					{
						//System.out.println(Arrays.toString(searchArray));
						searchCourseList.add(courselist.get(i));
						//System.out.println("found it!="+searchArray[j]+"at "+j);
						break;
					}
				}
			}
		}
		tableView.setItems(searchCourseList);
	 }
    
    public void makeList() throws IOException
    {
    	BufferedReader a = new BufferedReader(new FileReader("database/timetable/timetable.csv"));
    	String heading[] = a.readLine().split(",");
        for(int j=0;j<=15;j++) {
        	String[] coursen = a.readLine().split(",");
        	
        	String allTimings="";
        	String allTimingsNextLine="";
        	for(int i=6;i<12;i++)
        	{
        		if(coursen[i].equals("")!=true)
        			allTimings = allTimings + heading[i] +" "+coursen[i]+" "; 
        	}
        	//System.out.println(allTimings);
        	String[] allTimingsArray = allTimings.split("\\$");
        	
        	//System.out.println(Arrays.toString(allTimingsArray));
        	for(int k=0;k<allTimingsArray.length;k++) {
        		allTimingsNextLine = allTimingsNextLine + allTimingsArray[k] + '\n';
        	}
        	
        	String[] postconditions = coursen[14].split("\\.");
        	String postconadd="";
        	for(int z=0;z<postconditions.length;z++)
        		postconadd = postconadd + postconditions[z] + '\n' ;
        
        	courselist.add(new Course(coursen[2],coursen[1],coursen[13],coursen[3],postconadd,allTimings));
        	//System.out.println(allTimings);
        }
    	
    }
	
	@FXML private Label coursesLabel;
	

	private Student student;

	protected void setUser(User a)
	{
		this.student= (Student)a;
	}

	@FXML protected void handleHomeButton(ActionEvent event) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/User_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		User_StudentController usc= fxmlLoader.<User_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
		((Stage)coursesLabel.getScene().getWindow()).setScene(homepage);
	 }

	@FXML protected void handleAvailableRoomsButton() throws IOException {
	 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/AvailableRooms_Student.fxml"));
		Parent rootHomepage = fxmlLoader.load();
		AvailableRooms_StudentController usc= fxmlLoader.<AvailableRooms_StudentController>getController();
		usc.setUser(student);
		Scene homepage = new Scene(rootHomepage);
			((Stage)coursesLabel.getScene().getWindow()).setScene(homepage);
	 }

	 @FXML protected void handleRequestBookingButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/RequestBooking_Student.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			RequestBooking_StudentController usc= fxmlLoader.<RequestBooking_StudentController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)coursesLabel.getScene().getWindow()).setScene(homepage);

	 }

	 @FXML protected void handleMyBookingsButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/MyBookings_Student.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			MyBookings_StudentController usc= fxmlLoader.<MyBookings_StudentController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)coursesLabel.getScene().getWindow()).setScene(homepage);
	 }


	 @FXML protected void handleTimetableButton() throws IOException {
		 	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../view/Timetable.fxml"));
			Parent rootHomepage = fxmlLoader.load();
			TimetableController usc= fxmlLoader.<TimetableController>getController();
			usc.setUser(student);
			Scene homepage = new Scene(rootHomepage);
			((Stage)coursesLabel.getScene().getWindow()).setScene(homepage);
	 }
}

