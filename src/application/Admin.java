package application;
import java.util.*;

public class Admin extends User {

private ArrayList<Room> bookings;
private ArrayList<Request> pendingRequests;

public Admin()
{
	super();
}
public Admin(String userId,String password,String type)
{
	super(userId, password, type);
	bookings= null;
	pendingRequests = null;
}
}
