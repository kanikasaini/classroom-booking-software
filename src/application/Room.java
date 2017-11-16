package application;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class Room implements Serializable {

public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public ArrayList<String> getbookedSlots() {
		return bookedSlots;
	}
	public void setbookedSlots(ArrayList<String> bookedSlots) {
		this.bookedSlots = bookedSlots;
	}
	public void addBookedSlot(String slot)
	{
		this.bookedSlots.add(slot);
	}
	public void addBookedSlot(String day, String start, String end)
	{
		String slot=day+" "+start+"-"+end;
		this.bookedSlots.add(slot);
	}
	public String number;
    private int capacity;
    public ArrayList<String> bookedSlots = new ArrayList<String>();
	public Room(String number, int capacity, ArrayList<String> bookedSlots) {
		super();
		this.number = number;
		this.capacity = capacity;
		this.bookedSlots = bookedSlots;
	}
	public Room(String number, int capacity) {
		super();
		this.number = number;
		this.capacity = capacity;
	}
	public boolean checkOverlap(String day, String start1, String end1)
	{
		boolean flag= false;
		for(int i=0; i<bookedSlots.size(); i++)
		{
			String slot= bookedSlots.get(i);
			String[] dayntime = slot.split(" ");
			String[] timeS2E = dayntime[1].split("-");
			String start2=timeS2E[0]; String end2=timeS2E[1];
			if(dayntime[0].equalsIgnoreCase(day))
			{
				boolean b1 = (greater(end1,start2)==1 & greater(start2,start1)!=0) || (greater(end1,end2)!=0 & greater(end2,start1)==1);
				boolean b2 = (greater(end2,start1)==1 & greater(start1,start2)!=0) || (greater(end2,end1)!=0 & greater(end1,start2)==1);
				if(b1 || b2)
					flag=true;
				else
					flag=false;
				System.out.println(flag);
			}
		}
		return flag;
	}
	public int greater(String start, String end) //returns 1 if start>end, returns 0 if start<=end
	{
		String[] start1 = start.split("");
		String[] end1 = end.split("");
		int time1=0; int time2=0; int start_is=0; int end_is=0;
		if(start1.length==4)
		{
			time1=Integer.parseInt(start1[0]);
			start_is=(time1-8)%12;
		}
		else
			start_is=(Integer.parseInt(start1[0].concat(start1[1]))-8)%12;
		if(end1.length==4)
		{
			time2=Integer.parseInt(end1[0]);
			end_is=(time2-8)%12;
		}
		else
			end_is=(Integer.parseInt(end1[0].concat(end1[1]))-8)%12;
		if(start_is<0)
			start_is+=12;
		if(end_is<0)
			end_is+=12;
		if(start_is<end_is)
			return 0;
		else if(start_is>end_is)
			return 1;
		else
		{
			if(Integer.parseInt(start1[start1.length-2]) > Integer.parseInt(end1[end1.length-2]))
				return 1;
			else if(Integer.parseInt(start1[start1.length-2]) < Integer.parseInt(end1[end1.length-2]))
				return 0;
			else
				return -1;
		}
	}

}
