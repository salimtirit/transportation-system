// separator	Location.java_0_false.txt
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

// separator	Location.java_1_true.txt

package locations;

import java.util.ArrayList;

import passengers.Passenger;

/**
 * Class with the properties of the locations created.
 * 
 * @author Salim Kemal Tirit
 *
 */
public class Location {
	private int ID;
	private double locationX;
	private double locationY;
	private ArrayList<Passenger> history = new ArrayList<Passenger>();
	private ArrayList<Passenger> current = new ArrayList<Passenger>();

	/**
	 * Constructor method for location.
	 * 
	 * @param ID        Unique ID of the location
	 * @param locationX X coordinate of the location
	 * @param locationY Y coordinate of the locaiton
	 */
	public Location(int ID, double locationX, double locationY) {
		this.ID = ID;
		this.locationX = locationX;
		this.locationY = locationY;
	}

	/**
	 * Finds the shortest distance between this location and other location.
	 * 
	 * @param other
	 * @return Distance between two locations
	 */
	public double getDistance(Location other) {
		double dX = other.locationX - this.locationX;
		double dY = other.locationY - this.locationY;
		return Math.sqrt(dX * dX + dY * dY);
	}

	/**
	 * Adds the incoming passenger to current ArrayList. If the passenger has not
	 * come before also adds it to history array.
	 * 
	 * @param p Incoming passenger.
	 */
	public void incomingPassenger(Passenger p) {
		current.add(p);
		boolean cameBefore = false;
		for (int i = 0; i < history.size(); i++) {
			if (history.get(i).getID() == p.getID()) {
				cameBefore = true;
			}
		}
		if (!cameBefore) {
			history.add(p);
		}
	}

	/**
	 * Removes the passenger from current array.
	 * 
	 * @param p Outgoing passenger.
	 */
	public void outgoingPassenger(Passenger p) {
		for (int i = 0; i < current.size(); i++) {
			if (current.get(i).getID() == p.getID()) {
				current.remove(i);
			}
		}
	}

	/**
	 * Getter method for ID.
	 * 
	 * @return ID of the location.
	 */
	public int getID() {
		return this.ID;
	}

	/**
	 * GEtter method for locationX
	 * 
	 * @return
	 */
	public double getLocationX() {
		return this.locationX;
	}

	/**
	 * Getter method for locationY
	 * 
	 * @return
	 */
	public double getLocationY() {
		return this.locationY;
	}

	/**
	 * Getter method for current ArrayList
	 * 
	 * @return
	 */
	public ArrayList<Passenger> getCurrent() {
		return this.current;
	}

	/**
	 * Overrides toString method. Returns location with its ID and its x and y
	 * coordinate. Double values have two digits after decimal point.{@inheritDoc}
	 * 
	 * @return
	 */
	public String toString() {
		return "Location " + this.ID + ": (" + findDecimal(this.locationX) + ", " + findDecimal(this.locationY) + ")";
	}

	/**
	 * Makes sure given double values has two digits after the decimal point.
	 * 
	 * @param d Given double value.
	 * @return Value with two digits after decimal point.
	 */
	private String findDecimal(double d) {
		String s = d + "00";// I add two zeros to make sure there is at least two numbers after decimal
							// point
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {// finds the decimal point
				s = s.substring(0, i + 3);// takes two numbers after decimal point
			}
		}
		return s;
	}
}


// separator	Location.java_2_false.txt
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

