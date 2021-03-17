// separator	StandardPassenger.java_0_false.txt
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

// separator	StandardPassenger.java_1_true.txt

package passengers;

import locations.Location;

/**
 * Children class of Passenger, does not get discount. @see Passenger
 * 
 * @author Salim Kemal Tirit
 *
 */
public class StandardPassenger extends Passenger{
	
	/**
	 * Constructor method for passenger who has a car
	 * 
	 * @param ID              Unique ID of the passenger.
	 * @param l               Starting location of the passenger.
	 * @param fuelConsumption Fuel consumption rate of the car @see Car
	 */
	public StandardPassenger(int ID, Location l, double fuelConsumption) {
		super(ID, l, fuelConsumption);
	}
	
	/**
	 * Constructor method for passenger who does not have a car.
	 * 
	 * @param ID               Unique ID of the passenger.
	 * @param hasDriverLicense True if passenger has a driver license.
	 * @param l                Starting location of the passenger.
	 */
	public StandardPassenger(int ID, boolean hasDriverLicense, Location l) {
		super(ID, hasDriverLicense, l);
	}
}

// separator	StandardPassenger.java_2_false.txt
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

