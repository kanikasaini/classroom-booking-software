package application;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Student extends User {

private Timetable MonTimetable;
private Timetable TuesTimetable;
private Timetable WedTimetable;
private Timetable ThursTimetable;
private Timetable FriTimetable;
private ArrayList<Course> coursesTaken = new ArrayList<Course>();
private static ArrayList<Course> allCourses = new  ArrayList<Course>();
private ArrayList<Request> 	requests= new ArrayList<Request>();
private ArrayList<Booking> bookings = new ArrayList<Booking>();
public void addBooking(Booking b)
{
	System.out.print("error");
	bookings.add(b);
}

public Student(String userId, String password, String type) throws IOException
{
	super(userId, password, type);
	MonTimetable = new Timetable("","","","","","AP\nC21",".","Tut AP\nGp1,2,3,4\nLR1,LR2,S01,S01",".","","","","","","","","","","");;
	TuesTimetable = new Timetable("","","","","","","","","","CO\nC21",".","DM\nC21",".","","","","","","");
	WedTimetable = new Timetable("","","","","","AP\nC21",".","","","CO\n",".","DM\nC21",".","Tut CO\nGp1,2,3,4\nLR1,LR2,S01,S01",".",".","Tut DM\nGp1\nS01",".","");
	ThursTimetable = new Timetable("","","","","","AP\nC21",".","Lab AP\nGp1,2,3,4\nL21,L22,L23",".","","","","","","",".","CO\nC21",".","");
	FriTimetable = new Timetable("","","","","","","",".","DM\nC21",".","","","","","",".","Tut DM\nGp2,3,4\nLR1,LR2,LR3",".","");

	//need to read from file
	coursesTaken = null;
	allCourses= null;
}
public void setState(String purpose, int state)
{
	for(int i=0; i<requests.size(); i++)
	{
		if(requests.get(i).getPurpose().equals(purpose))
			requests.get(i).setState(state);
	}
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

public Timetable getMonTimetable() {
	return MonTimetable;
}

public void setMonTimetable(Timetable monTimetable) {
	MonTimetable = monTimetable;
}

public Timetable getTuesTimetable() {
	return TuesTimetable;
}

public void setTuesTimetable(Timetable tuesTimetable) {
	TuesTimetable = tuesTimetable;
}

public Timetable getWedTimetable() {
	return WedTimetable;
}

public void setWedTimetable(Timetable wedTimetable) {
	WedTimetable = wedTimetable;
}

public Timetable getThursTimetable() {
	return ThursTimetable;
}

public void setThursTimetable(Timetable thursTimetable) {
	ThursTimetable = thursTimetable;
}

public Timetable getFriTimetable() {
	return FriTimetable;
}

public void setFriTimetable(Timetable friTimetable) {
	FriTimetable = friTimetable;
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
