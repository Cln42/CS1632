import java.util.Random;

/*
 * Stores information about all of the locations in the city
 * 'locations' contains all the names for each location
 * 'connections' contains the two other locations that each location connects to
 */
public class Location {

	private String[] locations = new String[] { "Outside City", "Mall",
			"Bookstore", "Coffee Shop", "University", "Outside City" };
	private int[][] connections = new int[][] { { 1, 4 }, { 2, 3 }, { 4, 5 },
			{ 1, 5 }, { 2, 3 } };

	String name; // name of location
	int curr_index; // 0-5
	long seed; // for random number generator

	public Location(int num, long user_input) {
		name = locations[num];
		curr_index = num;
		seed = user_input;
	}

	// return name of location
	public String get_location_name() {
		return name;
	}

	// return index of location
	public int get_location_index() {
		return curr_index;
	}

	// chooses a random number 0 or 1 and uses that to pick
	// a connection location that is returned to the user
	public Location get_next_destination() {
		Random rand = new Random(seed);
		int dest = rand.nextInt(2);// 0 or 1
		return new Location(connections[this.curr_index][dest], seed);
	}

	// returns the road that connects two locations
	// if non exists, it returns null
	public String get_road(Location loc2) {
		String[][] roads = new String[8][8];
		roads[0][1] = "Fourth Ave.";
		roads[1][2] = "Fourth Ave.";
		roads[1][3] = "Meow St.";
		roads[2][4] = "Chirp St.";
		roads[2][5] = "Fourth Ave.";
		roads[3][1] = "Meow St.";
		roads[3][5] = "Fifth Ave.";
		roads[4][2] = "Chirp St.";
		roads[4][3] = "Fifth Ave.";
		roads[0][4] = "Fifth Ave.";
		int i = this.curr_index;
		int j = loc2.get_location_index();
		return roads[i][j];
	}

}