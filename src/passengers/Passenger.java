// separator	Passenger.java_0_false.txt
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

// separator	Passenger.java_1_true.txt

package passengers;

import interfaces.*;
import locations.Location;
import vehicles.*;

/**
 * Class which includes the properties of passengers in the transportation
 * system.
 * 
 * @author Salim Kemal Tirit
 *
 */
public class Passenger implements ownCar, usePublicTransport {
	private int ID = 0;
	private boolean hasDriversLicense;
	private double cardBalance = 0;
	private Car car;
	private Location currentLocation;
	private boolean hasCar = false;

	/**
	 * Constructor method for passenger who does not have a car.
	 * 
	 * @param ID               Unique ID of the passenger.
	 * @param hasDriverLicense True if passenger has a driver license.
	 * @param l                Starting location of the passenger.
	 */
	public Passenger(int ID, boolean hasDriverLicense, Location l) {
		this.ID = ID;
		this.hasDriversLicense = hasDriverLicense;
		this.currentLocation = l;
	}

	/**
	 * Constructor method for passenger who has a car
	 * 
	 * @param ID              Unique ID of the passenger.
	 * @param l               Starting location of the passenger.
	 * @param fuelConsumption Fuel consumption rate of the car @see Car
	 */
	public Passenger(int ID, Location l, double fuelConsumption) {
		this.hasDriversLicense = true;
		this.ID = ID;
		this.currentLocation = l;
		this.car = new Car(this.ID, fuelConsumption);
		this.hasCar = true;
	}

	/**
	 * Checks if the passenger is appropriate to go to the arrival location and if
	 * so changes its location. Uses getPrice method from Bus and Train classes.
	 * Gives %50 discount for the bus and %20 discount if the passenger is
	 * discounted. Uses canRide method from parent class. Checks if the passenger
	 * has enough money to go. @see Location @see PublicTransport
	 * 
	 * @param p Transportation type of the passenger.
	 * @param l Headed location.
	 */
	public void ride(PublicTransport p, Location l) {
		int price = 0;
		if (p instanceof Bus) {
			if (this instanceof DiscountedPassenger) {
				price = ((Bus) p).getPrice() * 50 / 100;
			} else {
				price = ((Bus) p).getPrice();
			}
		} else if (p instanceof Train) {
			if (this instanceof DiscountedPassenger) {
				price = ((Train) p).getPrice(currentLocation.getDistance(l)) * 80 / 100;
			} else {
				price = ((Train) p).getPrice(currentLocation.getDistance(l));
			}
		}
		if (p.canRide(currentLocation, l) && price <= cardBalance) {
			this.currentLocation.outgoingPassenger(this);
			l.incomingPassenger(this);
			this.currentLocation = l;
			this.cardBalance -= price;
		}
	}

	/**
	 * Adds given amount to travel card of the passenger.
	 * 
	 * @param amount Amount to be added to passengers travel card.
	 */
	public void refillCard(double amount) {
		this.cardBalance += amount;
	}

	/**
	 * Adds given amount to Car of the passenger if the passenger has one.
	 * 
	 * @param amount Amount to be added to passengers Car.
	 */
	public void refuel(double amount) {
		if (hasCar)
			this.car.refuel(amount);
	}

	/**
	 * Checks if the passenger is appropriate to go to the arrival location by its
	 * own car. Uses getDistance method to find the distance and multiplies it with
	 * the fuel consumption of the car to find the fuel used. Then changes the
	 * location of the passenger. @see Car @see Location
	 * 
	 * @param l Headed location
	 */
	public void drive(Location l) {
		if (hasCar) {
			double dFuelAmount = car.getFuelConsumption() * currentLocation.getDistance(l);
			if (dFuelAmount <= car.getFuelAmount()) {
				this.currentLocation.outgoingPassenger(this);
				l.incomingPassenger(this);
				this.currentLocation = l;
				this.car.setFuelAmount(dFuelAmount);
			}
		}

	}

	/**
	 * Creates a car for the passenger and changes drivers license status to true.
	 * 
	 * @see Car
	 * @param fuelConsumption Fuel consumption rate of the car.
	 */
	public void purchaseCar(double fuelConsumption) {
		this.car = new Car(this.ID, fuelConsumption);
		this.hasDriversLicense = true;
		this.hasCar = true;
	}

	/**
	 * Getter method for the ID of the passenger
	 * 
	 * @return ID of the passenger
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Checks if the passenger has a car
	 * 
	 * @return True if the passenger has a car.
	 */
	public boolean hasCar() {
		return this.hasCar;
	}

	/**
	 * Remaining fuel of the car @see Car
	 * 
	 * @return Remaining fuel of the car
	 */
	public double remainingFuel() {
		return this.car.getFuelAmount();
	}

	/**
	 * Getter method for card balance.
	 * 
	 * @return card balance
	 */
	public double getCardBalance() {
		return this.cardBalance;
	}

	/**
	 * Overrides toString method. If the passenger has a car writes the cars
	 * remaining fuel with two digits after decimal point. If not writes passengers
	 * card balance with two digits after decimal point. {@inheritDoc}
	 */
	public String toString() {
		if (this.hasCar) {
			return "Passenger " + this.ID + ": " + findDecimal(this.remainingFuel());
		} else {
			return "Passenger " + this.ID + ": " + findDecimal(this.cardBalance);
		}
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


// separator	Passenger.java_2_false.txt
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

