package application;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.*;

import controllers.RequestBooking_StudentController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

// Admin class
public class Admin extends User {

private ArrayList<Booking> bookings = new ArrayList<Booking>(); //Hold details of room bookings made by admin
private ArrayList<Request> pendingRequests= new ArrayList<Request>(); // Hold the requests made by students to book room

public Admin() //Constructor
{
	super();
}
public Admin(String userId,String password,String type) throws Exception  //Reads admin details from file
{
	super(userId, password, type);
	 ObjectInputStream in = null;
     Request r;
     File folder = new File("database/requests");
     File[] listOfFiles = folder.listFiles();
     for (int i = 0; i < listOfFiles.length; i++) {

    	  	in = new ObjectInputStream(new FileInputStream("database/requests/"+listOfFiles[i].getName()));
    	     r = (Request)in.readObject();
    	     pendingRequests.add(r);
     }
     if(in!=null)
    	 in.close();

}
public ArrayList<Booking> getBookings() {
	return bookings;
}
public void setBookings(ArrayList<Booking> bookings)  {
	this.bookings = bookings;
}
public ArrayList<Request> getPendingRequests()throws Exception { //Read from file to get pending requests
	pendingRequests= new ArrayList<Request>();
	ObjectInputStream in = null;
    Request r;
    File folder = new File("database/requests");
    File[] listOfFiles = folder.listFiles();
    for (int i = 0; i < listOfFiles.length; i++) {

   	  	in = new ObjectInputStream(new FileInputStream("database/requests/"+listOfFiles[i].getName()));
   	     r = (Request)in.readObject();
   	     pendingRequests.add(r);
    }
    if(in!=null)
   	 in.close();
	return pendingRequests;
}
public void setPendingRequests(ArrayList<Request> pendingRequests) {
	this.pendingRequests = pendingRequests;
}
public void BookRoom(Request request, Student student) throws IOException, ClassNotFoundException //Method to book room, adds data to file
{
	String roomNumber = request.getPrefferedRoom();
 	String day = request.getDay();
 	String time = request.getTime();
 	String[] startnend = time.split("-");
 	String start= startnend[0];
 	String end = startnend[1];
 	try
 	{
 		ObjectInputStream in = null;
        in = new ObjectInputStream(new FileInputStream("database/rooms/"+roomNumber+".txt"));
        in.close();
        in = new ObjectInputStream(new FileInputStream("database/bookedRooms/"+roomNumber+".txt"));
        Room room = (Room)in.readObject();
       // System.out.println(room.getNumber());
        boolean flag= room.checkOverlap(day, start, end); //If timings of Booking overlap with already existing booking then throw alert, else book room
        if(flag==true)
        {
        	Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Classroom Booking System");
			alert.setHeaderText("Room Not Available");
			alert.setContentText("Cannot accept request.");
			alert.showAndWait();
        }
        else
        {
        	room.addBookedSlot(day, start, end);
        	Booking b = new Booking(room.getNumber(), day, start, end);
        	this.addBooking(b);
        	serialize(room);
        	serialize(this);
        	Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Classroom Booking System");
			alert.setHeaderText("Booked Room Successfully");
			alert.setContentText("Click OK to continue");
			alert.showAndWait();
        }

 	}
 	catch(FileNotFoundException e)
 	{
 	}
}
public void cancelBooking(Booking b)
{
	bookings.remove(b);

}
public static void serialize(Room pl) throws IOException
{
ObjectOutputStream out = null;
try {
    out = new ObjectOutputStream(new FileOutputStream("database/bookedRooms/"+pl.getNumber()+".txt"));
    out.writeObject(pl);
} finally
{
    out.close();
}
}
public void deleteRequest(Request request) throws Exception //method to delete request made by students
{
    File r = new File("database/requests/"+request.getPurpose()+".txt");
    r.delete();
    Student student = (Student)deserialize(request.getSentBy());
    student.setState(request.getPurpose(), -1);
    serialize(student);

}
public void acceptRequest(Request request) throws Exception
{
	File r = new File("database/requests/"+request.getPurpose()+".txt");
    r.delete();
    Student student = (Student)deserialize(request.getSentBy());
    student.setState(request.getPurpose(), +1);
    this.BookRoom(request, student);
    serialize(student);
}
public static void serialize(User user) throws IOException //method to write to file
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
public static User deserialize(String userId) throws Exception //method to read from file
{
    ObjectInputStream in = null;
    User user= null;
    in = new ObjectInputStream(new FileInputStream("database/users/"+userId+".txt"));
    user = (User)in.readObject();
    in.close();
    return user;
}
public void addBooking(Booking b)
{
	System.out.print("error");
	bookings.add(b);
}
public void addRequest(Request r)
{
	pendingRequests.add(r);
}
}
