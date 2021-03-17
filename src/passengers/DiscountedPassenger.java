// separator	DiscountedPassenger.java_0_false.txt
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

// separator	DiscountedPassenger.java_1_true.txt

package passengers;

import locations.Location;

/**
 * Children class of Passenger, gets discount as passenger travels. @see Passenger
 * 
 * @author Salim Kemal Tirit
 *
 */
public class DiscountedPassenger extends Passenger {

	/**
	 * Constructor method for passenger who does not have a car.
	 * 
	 * @param ID               Unique ID of the passenger.
	 * @param hasDriverLicense True if passenger has a driver license.
	 * @param l                Starting location of the passenger.
	 */
	public DiscountedPassenger(int ID, boolean hasDriverLicense, Location l) {
		super(ID, hasDriverLicense, l);
	}

	/**
	 * Constructor method for passenger who has a car
	 * 
	 * @param ID              Unique ID of the passenger.
	 * @param l               Starting location of the passenger.
	 * @param fuelConsumption Fuel consumption rate of the car @see Car
	 */
	public DiscountedPassenger(int ID, Location l, double fuelConsumption) {
		super(ID, l, fuelConsumption);
	}
}


// separator	DiscountedPassenger.java_2_false.txt
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

