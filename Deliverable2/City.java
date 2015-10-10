
import java.util.Random;



public class City {
		
	public static void main(String[] args){
		int[][] arr = new int[][]{ //index: {num_opt, opt_1, opt_2}
			{1, 1, -1},
			{2, 2, 3},
			{2, 4, 6},
			{2, 1, 7},
			{2, 2, 3},
			{1, 4, -1},
			{0, -1, -1},
			{0, -1, -1}
		}; 
		String[] locations = new String[] {"Outside City", "Mall", "Bookstore", "Coffee Shop", "University", "Outside City", "Outside City", "Outside City"};

		String[][] roads = new String[8][8];
		roads[0][1] = "Fourth Ave.";
		roads[1][2] = "Fourth Ave.";
		roads[1][3] = "Meow St.";
		roads[2][4] = "Chirp St.";
		roads[2][6] = "Fourth Ave.";
		roads[3][1] = "Meow St.";
		roads[3][7] = "Fifth Ave.";
		roads[4][2] = "Chirp St.";
		roads[4][3] = "Fifth Ave";
		roads[5][4] = "Fifth Ave";		
	
		Random rand = new Random();
		Driver d1 = new Driver(rand.nextInt(6));
		int curr_loc = d1.get_start();
		System.out.println("Start at " + locations[curr_loc]);
		int dest; 
		
		while( true ) {
			int num_opt = arr[curr_loc][0];
			
			if (num_opt == 0){
				System.out.println("Driver 1 has left the city!");
				break;
			}
			else if(num_opt == 1){
				dest = arr[curr_loc][1];
				System.out.println("Driver 1 heading from " + locations[curr_loc] + " to " + locations[dest] + " via " + roads[curr_loc][dest]);
			}
			else{
				int temp = rand.nextInt(2);//0 or 1
				dest = arr[curr_loc][temp+1];
				System.out.println("Driver 1 heading from " + locations[curr_loc] + " to " + locations[dest] + " via " + roads[curr_loc][dest]);
			}
			curr_loc = dest;
		}	
	
	}
	
	
	
	
}