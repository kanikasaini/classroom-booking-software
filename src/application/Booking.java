package application;

public class Booking {

	private String day;
	private String time;
	private String roomNo;

	public Booking(String roomNo, String day, String start, String end)
	{
		this.roomNo= roomNo;
		this.day= day;
		this.time= start+"-"+end;
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
}
