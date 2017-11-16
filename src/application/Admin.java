package application;
import java.util.*;

public class Admin extends User {

private ArrayList<Booking> bookings = new ArrayList<Booking>();
private ArrayList<Request> pendingRequests= new ArrayList<Request>();

public Admin()
{
	super();
}
public Admin(String userId,String password,String type)
{
	super(userId, password, type);
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
