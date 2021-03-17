// separator	Car.java_0_false.txt
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

// separator	Car.java_1_true.txt

package vehicles;

/**
 * Class of car for passengers.
 * 
 * @author Salim Kemal Tirit
 *
 */
public class Car {
	private int ownerID;
	private double fuelAmount;
	private double fuelConsumption;

	/**
	 * Constructor method.
	 * @param ID				Unique id of the owner of car.
	 * @param fuelConsumption	The quantity of fuel which the car uses per a unit length
	 */
	public Car(int ID, double fuelConsumption) {
		this.ownerID = ID;
		this.fuelConsumption = fuelConsumption;
	}

	/**
	 * Refuels the car by given amount.
	 * @param amount
	 */
	public void refuel(double amount) {
		this.fuelAmount += amount;
	}

	/**
	 * Getter method for fuelConsumption
	 * @return Fuel Consumption of car
	 */
	public double getFuelConsumption() {
		return this.fuelConsumption;
	}

	/**
	 * Getter method for remaining fuelAmount
	 * @return fuel amount of the car.
	 */
	public double getFuelAmount() {
		return this.fuelAmount;
	}

	/**
	 * changes the value of fuelAmount as the passenger travels.
	 * @param dFuelAmount 	Used fuel.
	 */
	public void setFuelAmount(double dFuelAmount) {
		fuelAmount -= dFuelAmount;
	}
}


// separator	Car.java_2_false.txt
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

