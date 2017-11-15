package application;
import java.io.Serializable;
import java.util.*;

public class Room implements Serializable {

private String number;
private int capacity;
private ArrayList<String> availableSlots;
public Room(String number, int capacity, ArrayList<String> availableSlots) {
	super();
	this.number = number;
	this.capacity = capacity;
	this.availableSlots = availableSlots;
}
}
