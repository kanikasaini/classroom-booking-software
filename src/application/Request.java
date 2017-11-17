package application;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Request implements Serializable{

public Request(String prefferedRoom, String purpose, String sentBy, int capacity, String day, String start, String end) {
		super();
		this.purpose = purpose;
		this.prefferedRoom = prefferedRoom;
		this.sentBy = sentBy;
		this.capacity = capacity;
		this.state = 0;
		this.time= start+"-"+end;
		this.day= day;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		dateSent = LocalDate.now();
	}

public Request(String purpose, String sentBy, int capacity,String day, String start, String end) {
	super();
	this.purpose = purpose;
	this.prefferedRoom = "ANY";
	this.sentBy = sentBy;
	this.capacity = capacity;
	this.state = 0;
	this.time= start+"-"+end;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	dateSent = LocalDate.now();
}


public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getPrefferedRoom() {
		return prefferedRoom;
	}
	public void setPrefferedRoom(String prefferedRoom) {
		this.prefferedRoom = prefferedRoom;
	}
	public String getSentBy() {
		return sentBy;
	}
	public void setSentBy(String sentBy) {
		this.sentBy = sentBy;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public LocalDate getDateSent() {
		return dateSent;
	}
	public void setDateSent(LocalDate date) {
		this.dateSent = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day)
	{
		this.day= day;
	}
	public String getTime()
	{
		return time;
	}
private String purpose;
private String prefferedRoom;
private String sentBy;
private int capacity;
private int state; //0 pending 1 accepted -1 rejected
private LocalDate dateSent;
private String day;
private String time;

}
