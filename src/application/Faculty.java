package application;
import java.util.*;

public class Faculty  extends User{

public Faculty(String userId, String password, String type) {
	super(userId, password, type);
	}
public Faculty()
{
	super();
}

private ArrayList<Booking> bookings = new ArrayList<Booking>();
public void addBooking(Booking b)
{
	System.out.print("error");
	bookings.add(b);
}
}
