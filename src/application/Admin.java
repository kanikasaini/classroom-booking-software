package application;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.*;

public class Admin extends User {

private ArrayList<Booking> bookings = new ArrayList<Booking>();
private ArrayList<Request> pendingRequests= new ArrayList<Request>();

public Admin()
{
	super();
}
public Admin(String userId,String password,String type) throws Exception
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

     in.close();

}
public ArrayList<Booking> getBookings() {
	return bookings;
}
public void setBookings(ArrayList<Booking> bookings) {
	this.bookings = bookings;
}
public ArrayList<Request> getPendingRequests() {
	return pendingRequests;
}
public void setPendingRequests(ArrayList<Request> pendingRequests) {
	this.pendingRequests = pendingRequests;
}
public void BookRoom(String roomNumber)
{

}
public void cancelBooking(String roomNumber)
{

}
public void handleRequest(Request request)
{

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
