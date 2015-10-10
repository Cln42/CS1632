import java.util.Random;

public class Location{

	private String[] locations = new String[] {"Outside City", "Mall", "Bookstore", "Coffee Shop", "University", "Outside City"};
	private int[][] connections = new int[][]{ //for each location, the two other locations it connects to
			{1, 4},
			{2, 3},
			{4, 5},
			{1, 5},
			{2, 3}
		}; 

	String name;	//name of location
	int curr_index;	//0-5
	
	public Location(int num){
		name = locations[num];
		curr_index = num;
	}

	public String get_location_name(){
		return name;
	}
	
	public int get_location_index(){
		return curr_index;
	}
	
	public Location get_next_destination(){
		Random rand = new Random();
		int dest = rand.nextInt(2);//0 or 1	
		return new Location(connections[this.curr_index][dest]);
		
	}


	public String get_road(Location loc2){
	String[][] roads = new String[8][8];
		roads[0][1] = "Fourth Ave.";
		roads[1][2] = "Fourth Ave.";
		roads[1][3] = "Meow St.";
		roads[2][4] = "Chirp St.";
		roads[2][5] = "Fourth Ave.";
		roads[3][1] = "Meow St.";
		roads[3][5] = "Fifth Ave.";
		roads[4][2] = "Chirp St.";
		roads[4][3] = "Fifth Ave";
		roads[0][4] = "Fifth Ave";	
		int i = this.curr_index;
		int j = loc2.get_location_index();
		return roads[i][j];
	}




}