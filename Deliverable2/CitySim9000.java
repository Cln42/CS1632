/* Casey Nispel, Cln42@Pitt.edu
 * CitySim9000.java 
 * CS1632 Fall 2015
 * DELIVERABLE 2: Unit Testing and Code Coverage
 * 
 */
import java.util.Random;

public class CitySim9000 {

	public static Random rand;
	public static long seed;

	// check to see if user input is a Long
	public static boolean check_for_long(String arg) {
		boolean isLong = true;
		try {
			Long.parseLong(arg);
		} catch (NumberFormatException e) {
			isLong = false;
		}
		return isLong;
	}

	// checks if user has entered the correct number and type of arguments
	public static void getArguments(String[] args) {
		if (args.length == 0) {
			System.out.println("Please enter an integer seed");
			System.exit(1);
		}
		if (args.length > 1) {
			System.out
					.println("Too many arguments entered. Please enter one integer seed.");
			System.exit(1);
		}
		if (!check_for_long(args[0])) {
			System.out
					.println("Not an integer. Please enter one integer seed.");
			System.exit(1);
		}
	}

	// the inside of the while loop from driveAround, it checks whether the
	// driver has left the city yet
	// if not, it picks a new destination and prints out a message for the user
	// returns boolean: whether the driver is still in the city
	public static boolean while_Loop(Driver d1, Location curr_loc, int i) {
		curr_loc = d1.get_driver_loc();
		if (curr_loc.get_location_index() == 5) {
			System.out.println("Driver " + i + " has left the city!\n-----");
			return false;
		}// end if
		else {
			Location destination = curr_loc.get_next_destination();
			String road = curr_loc.get_road(destination);
			System.out.println("Driver " + i + " heading from "
					+ curr_loc.get_location_name() + " to "
					+ destination.get_location_name() + " via " + road);
			d1.set_driver_loc(destination);
			return true;
		}// end else
	}

	// for each driver, initialize a starting location using a random number
	// generator.
	// Continue to get a next location until the driver ends up at location 5,
	// or outside the city.
	// For each next location, print a message for the user. Returns boolean
	// whether the driver is still in the city 
	private static boolean driveAround(Driver d1) {
		boolean still_driving = true;
		for (int i = 0; i < 5; i++) {
			still_driving = true;
			d1 = new Driver(new Location(rand.nextInt(5), seed));// 0 to 4 inclusive
			Location curr_loc = null;
			while (still_driving) {
				still_driving = while_Loop(d1, curr_loc, i);
			}// end while
		}
		return still_driving;
	}

	// main method. Gets the user's input, sets up random number generator
	// creates a driver, and then calls driveAround
	public static void main(String[] args) {
		getArguments(args);
		seed = Long.parseLong(args[0]);
		rand = new Random(seed);
		Driver d1 = null;
		driveAround(d1);
	}// end main
}// end City class