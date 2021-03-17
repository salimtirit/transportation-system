// separator	PublicTransport.java_0_false.txt
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

// separator	PublicTransport.java_1_true.txt

package vehicles;

import locations.Location;

/**
 * Public transportation for passengers to travel.Parent Class of Car and Train.
 * 
 * @author Salim Kemal Tirit
 * 
 */
public abstract class PublicTransport {
	private int ID;
	private double x1, x2, y1, y2;

	/**
	 * Constructor method.
	 * 
	 * @param ID ID of the vehicle
	 * @param x1 Lower limit in x axis
	 * @param y1 Lower limit in y axis
	 * @param x2 Upper limit in x axis
	 * @param y2 Upper limit in y axis
	 */
	public PublicTransport(int ID, double x1, double y1, double x2, double y2) {
		this.ID = ID;
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	/**
	 * Checks if the arrival and departure location both inside the borders of the
	 * vehicle.
	 * 
	 * @param departure Current location of the passenger
	 * @param arrival   Location which the passenger wants ton go
	 * @return If arrival and departure location both inside the borders returns
	 *         true
	 */
	public boolean canRide(Location departure, Location arrival) {
		return arrival.getLocationX() <= Math.max(x1, x2) && arrival.getLocationX() >= Math.min(x1, x2)
				&& arrival.getLocationY() <= Math.max(y1, y2) && arrival.getLocationY() >= Math.min(y1, y2)
				&& departure.getLocationX() <= Math.max(x1, x2) && departure.getLocationX() >= Math.min(x1, x2)
				&& departure.getLocationY() <= Math.max(y1, y2) && departure.getLocationY() >= Math.min(y1, y2);
	}
}


// separator	PublicTransport.java_2_false.txt
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE





