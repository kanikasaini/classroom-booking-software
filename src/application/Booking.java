package application;

import java.io.Serializable;

//class to create booking objects

public class Booking implements Serializable {

	private String day;
	private String time;
	private String roomNo;

	public Booking(String roomNo, String day, String start, String end)
	{
		this.roomNo= roomNo;
		this.day= day;
		this.time = start+"-"+end;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	@Override
	public boolean equals(Object a) //checks if booking overlaps with existing booking
	{
		Booking b = (Booking)a;
		if(b.day.equalsIgnoreCase(this.day) && b.time.equals(this.time) && b.roomNo.equals(this.roomNo))
			return true;
		else
			return false;
	}
}
