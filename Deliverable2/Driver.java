/*
 * Basic Driver class. 
 * contains a current location 
 * get_driver_loc returns the driver's current location
 * set_driver_loc sets a new location for the driver and returns it's index
 */
public class Driver {
	Location current_loc;

	public Driver(Location loc) {
		current_loc = loc;
	}

	public Location get_driver_loc() {
		return current_loc;
	}

	public int set_driver_loc(Location new_loc) {
		current_loc = new_loc;
		return new_loc.get_location_index();
	}

}