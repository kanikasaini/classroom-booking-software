package application;
import java.util.*;

public class Student extends User {

private Timetable timetable;
private ArrayList<Course> coursesTaken;
private static ArrayList<Course> allCourses;
private ArrayList<Request> 	requests;

public Student(String userId, String password, String type)
{
	super(userId, password, type);
	timetable= null; //need to read from file
	coursesTaken = null;
	allCourses= null;
	requests= null;
}


}
