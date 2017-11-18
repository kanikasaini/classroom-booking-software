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



public ArrayList<Booking> getBookings() {
	return bookings;
}
public void setBookings(ArrayList<Booking> bookings) {
	this.bookings = bookings;
}

private ArrayList<Booking> bookings = new ArrayList<Booking>();
public void addBooking(Booking b)
{
	bookings.add(b);
	System.out.println("booking added");
	}

public void cancelBooking(Booking b)
{
	bookings.remove(b);

}
}
