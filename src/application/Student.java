package application;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Student extends User {

private Timetable timetable = new Timetable();
private ArrayList<Course> coursesTaken = new ArrayList<Course>();
private static ArrayList<Course> allCourses = new  ArrayList<Course>();
private ArrayList<Request> 	requests= new ArrayList<Request>();
private ArrayList<Booking> bookings = new ArrayList<Booking>();
public void addBooking(Booking b)
{
	System.out.print("error");
	bookings.add(b);
}

public Student(String userId, String password, String type)
{
	super(userId, password, type);
	timetable= null; //need to read from file
	coursesTaken = null;
	allCourses= null;
}

public void addRequest(Request r) throws Exception
{
	requests.add(r);

	ObjectOutputStream out = null;
    try {
        out = new ObjectOutputStream(new FileOutputStream("database/requests/"+r.getPurpose()+".txt"));
        out.writeObject(r);
    } finally
    {
        out.close();
    }
}
public Timetable getTimetable() {
	return timetable;
}

public void setTimetable(Timetable timetable) {
	this.timetable = timetable;
}

public ArrayList<Course> getCoursesTaken() {
	return coursesTaken;
}

public void setCoursesTaken(ArrayList<Course> coursesTaken) {
	this.coursesTaken = coursesTaken;
}

public static ArrayList<Course> getAllCourses() {
	return allCourses;
}

public static void setAllCourses(ArrayList<Course> allCourses) {
	Student.allCourses = allCourses;
}

public ArrayList<Request> getRequests() {
	return requests;
}

public void setRequests(ArrayList<Request> requests) {
	this.requests = requests;
}


}
