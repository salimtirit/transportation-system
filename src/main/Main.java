// separator	Main.java_0_false.txt
//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

// separator	Main.java_1_true.txt

package main;

import java.util.*;
import vehicles.*;
import java.io.*;
import passengers.*;
import locations.*;

/**
 * Class which includes main method.
 * 
 * @author Salim Kemal Tirit
 *
 */

public class Main {
	/**
	 * Main method which is a reference for other methods and includes main
	 * properties like ArrayLists, Scanner and PrintStream. Reads the input file and
	 * calls necessary method for operations.
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File(args[0]));
		PrintStream output = new PrintStream(new File(args[1]));
		ArrayList<Passenger> passengers = new ArrayList<Passenger>();
		ArrayList<Location> locations = new ArrayList<Location>();
		ArrayList<PublicTransport> vehicles = new ArrayList<PublicTransport>();

		Location l = new Location(0, 0, 0);
		locations.add(l);

		int operations = input.nextInt();
		for (int i = 0; i < operations; i++) {
			int operation = input.nextInt();
			if (operation == 1) {
				creatingAPassenger(input, passengers, l);
			} else if (operation == 2) {
				creatingALocation(input, locations);
			} else if (operation == 3) {
				creatingAPublicTransportVehicle(input, vehicles);
			} else if (operation == 4) {
				passengerTravelsToALocation(input, passengers, vehicles, locations);
			} else if (operation == 5) {
				passengerPurchasesACar(input, passengers);
			} else if (operation == 6) {
				passengerRefuelsTheirCar(input, passengers);
			} else if (operation == 7) {
				passengerRefillsTheirTravelCard(input, passengers);
			}
		}
		output(output, locations);
		output.close();

	}

	/**
	 * Reads the input in the file and creates a passenger in Passenger class. When
	 * there is "1" in the input file for operation this method is called.Takes the
	 * first string as the type of passenger "S" for standard "D" for discounted.
	 * Then an integer which is one or zero; 1 for having and 0 for not having the
	 * license. After that one more integer for having or not having a car.Based on
	 * these information, adds passenger to the "passengers" ArrayList.Then calls
	 * another method from location classes to locate the passenger. @see
	 * passengers @see Location
	 * 
	 * @param input      To read the file
	 * @param passengers To create and add the passenger
	 * @param l          Zeroth location to passenger in
	 */
	public static void creatingAPassenger(Scanner input, ArrayList<Passenger> passengers, Location l) {
		String typeOfPassenger = input.next();
		int driverLicense = input.nextInt();
		boolean hasDriverLicense = driverLicense == 1 ? true : false;
		int hasCar = input.nextInt();
		if (hasCar == 1) {
			double fuelConsumptionRate = input.nextDouble();
			if (typeOfPassenger.equals("S")) {
				passengers.add(new StandardPassenger(passengers.size(), l, fuelConsumptionRate));
				l.incomingPassenger(passengers.get(passengers.size() - 1));
			} else if (typeOfPassenger.equals("D")) {
				passengers.add(new DiscountedPassenger(passengers.size(), l, fuelConsumptionRate));
				l.incomingPassenger(passengers.get(passengers.size() - 1));
			}
		} else {
			if (typeOfPassenger.equals("S")) {
				passengers.add(new StandardPassenger(passengers.size(), hasDriverLicense, l));
				l.incomingPassenger(passengers.get(passengers.size() - 1));
			} else if (typeOfPassenger.equals("D")) {
				passengers.add(new DiscountedPassenger(passengers.size(), hasDriverLicense, l));
				l.incomingPassenger(passengers.get(passengers.size() - 1));
			}
		}
	}

	/**
	 * Reads the input and creates a location in Location class. When there is "2"
	 * in the input file for operation this method is called. Takes first double as
	 * the x coordinate of the location and second double as the y coordinate of the
	 * location. Then adds the location to locations ArrayList. @see Location
	 * 
	 * @param input     To read the file
	 * @param locations To create and add the new location
	 */
	public static void creatingALocation(Scanner input, ArrayList<Location> locations) {
		double x = input.nextDouble();
		double y = input.nextDouble();
		locations.add(new Location(locations.size(), x, y));
	}

	/**
	 * Reads the input and creates a public transport vehicle in PublicTransport
	 * class.When there is "3" in the input file for operation this method is
	 * called. Takes first integer as the type of the vehicle "1" for bus and "2"
	 * for train. Than creates and adds the vehicle to vehicles ArrayList.
	 * 
	 * @param input    To read the file
	 * @param vehicles To crate and add a public transport vehicle
	 */
	public static void creatingAPublicTransportVehicle(Scanner input, ArrayList<PublicTransport> vehicles) {
		int typeOfTheVehicle = input.nextInt();
		if (typeOfTheVehicle == 1) {
			vehicles.add(new Bus(vehicles.size(), input.nextDouble(), input.nextDouble(), input.nextDouble(),
					input.nextDouble()));
		} else if (typeOfTheVehicle == 2) {
			vehicles.add(new Train(vehicles.size(), input.nextDouble(), input.nextDouble(), input.nextDouble(),
					input.nextDouble()));
		}
	}

	/**
	 * Reads the input and makes the passenger travel to another location by
	 * changing its current location. When there is "4" in the input file for
	 * operation this method is called. Takes first integer as the ID of the
	 * passenger,second as location ID, third as transportation type "1" for bus "2"
	 * for train and "3" for personal car. If the transportation type is one or two
	 * another integer as the ID of the public transportation vehicle. Than calls
	 * ride or drive methods from Passenger class. @see Passenger
	 * 
	 * @param input      To read the file
	 * @param passengers To find the passenger and change its location
	 * @param vehicles   To find the vehicle for passenger
	 * @param locations  To transfer passenger from its current to its arrival
	 *                   location
	 */
	public static void passengerTravelsToALocation(Scanner input, ArrayList<Passenger> passengers,
			ArrayList<PublicTransport> vehicles, ArrayList<Location> locations) {
		int passengerID = input.nextInt();
		int locationID = input.nextInt();
		int transportationType = input.nextInt();
		int vehicleID = transportationType == 3 ? 0 : input.nextInt();
		if (transportationType == 1 && vehicles.get(vehicleID) instanceof Bus) {
			passengers.get(passengerID).ride(vehicles.get(vehicleID), locations.get(locationID));
		} else if (transportationType == 2 && vehicles.get(vehicleID) instanceof Train) {
			passengers.get(passengerID).ride(vehicles.get(vehicleID), locations.get(locationID));
		} else if (transportationType == 3) {
			passengers.get(passengerID).drive(locations.get(locationID));
		}
	}

	/**
	 * Reads the input and creates a car with the given property for the passenger
	 * given. When there is "5" in the input file for operation this method is
	 * called. Takes an integer as the ID of the passenger who will purchase the car
	 * and a double as the rate of consumption of the car. Then calls purchaseCar
	 * method from Passenger class. @see Passenger
	 * 
	 * @param input      To read the file
	 * @param passengers To find the passenger and make it purchase a car
	 */
	public static void passengerPurchasesACar(Scanner input, ArrayList<Passenger> passengers) {
		int ID = input.nextInt();
		double fuelConsumptionRate = input.nextDouble();
		passengers.get(ID).purchaseCar(fuelConsumptionRate);
	}

	/**
	 * Reads the input and refuels the car of the passenger given by given amount.
	 * When there is "6" in the input file for operation this method is called.
	 * Takes an integer as the ID of the passenger whose car will be refueled and a
	 * double as the fuel amount which will be added to the car. Then refuel method
	 * from Passenger class. @see Passenger
	 * 
	 * @param input      To read the file
	 * @param passengers To find the passenger and make it refuel its car
	 */
	public static void passengerRefuelsTheirCar(Scanner input, ArrayList<Passenger> passengers) {
		int ID = input.nextInt();
		double fuelAmount = input.nextDouble();
		passengers.get(ID).refuel(fuelAmount);
	}

	/**
	 * Reads the input and refills the card of the passenger given by given amount.
	 * When there is "7" in the input file for operation this method is called.
	 * Takes an integer as the ID of the passenger whose card will be refilled and a
	 * double as the amount which will be added to the card. Then refillCard method
	 * from Passenger class. @see Passenger
	 * 
	 * @param input      To read the file
	 * @param passengers To find the passenger and make it refill its car
	 */
	public static void passengerRefillsTheirTravelCard(Scanner input, ArrayList<Passenger> passengers) {
		int ID = input.nextInt();
		double amountToBeAdded = input.nextDouble();
		passengers.get(ID).refillCard(amountToBeAdded);
	}

	/**
	 * Prints locations and passengers in ascending order with their attributes.
	 * After everything done by operations this method is called to print to output
	 * file. It uses toString and getCurrent from classes Passenger and Location. It
	 * uses listSort method below to print in ascending order.
	 * 
	 * @see Passenger @see Location
	 * 
	 * @param output    To write the file
	 * @param locations The things which will be printed
	 */
	public static void output(PrintStream output, ArrayList<Location> locations) {
		for (int i = 0; i < locations.size(); i++) {
			output.println(locations.get(i).toString());
			if (!locations.get(i).getCurrent().equals(null)) {
				ArrayList<Passenger> sorted = listSort(locations.get(i).getCurrent());
				for (int k = 0; k < sorted.size(); k++) {
					if (k == sorted.size() - 1 && i == locations.size() - 1) {
						output.print(sorted.get(k).toString());
					} else {
						output.println(sorted.get(k).toString());
					}
				}
			}
		}
	}

	/**
	 * Sorts the given list in ascending order of the ID's of the passengers.
	 * Basically uses bubble sort algorithm and changes the order of passengers.
	 * Uses getID method. @see Passenger
	 * 
	 * @param passengerList To sort
	 * @return Sorted list
	 */
	public static ArrayList<Passenger> listSort(ArrayList<Passenger> passengerList) {
		for (int i = 0; i < passengerList.size(); i++) {
			for (int j = i + 1; j < passengerList.size(); j++) {
				if (passengerList.get(i).getID() > passengerList.get(j).getID()) {
					Passenger temp = passengerList.get(j);
					passengerList.set(j, passengerList.get(i));
					passengerList.set(i, temp);
				}
			}
		}
		return passengerList;
	}

}


// separator	Main.java_2_false.txt
//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE

