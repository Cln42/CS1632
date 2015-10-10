
import java.util.Random;


public class City {

	public static boolean check(String arg){
		boolean isInt = true;
		try{
			Long.parseLong(arg);
		}catch(NumberFormatException e){
			isInt = false;
		}
		return isInt;
	}
		
	public static void main(String[] args){
		if (args.length == 0){
			System.out.println("Please enter an integer seed");
			System.exit(1);
		}
		if (args.length > 1){
			System.out.println("Too many arguments entered. Please enter one integer seed.");
			System.exit(1);
		}
		if (!check(args[0])){
			System.out.println("Not an integer. Please enter one integer seed.");
			System.exit(1);
		}
	
	
		long seed = Long.parseLong(args[0]);	
		Random rand = new Random(seed);
		
		for(int i=1; i<5; i++){
			Driver d1 = new Driver(new Location(rand.nextInt(5)));//0 to 4 inclusive
			System.out.println("Starting Location: " + (d1.get_driver_loc()).get_location_index());
			Location curr_loc;
			while(true){
				curr_loc = d1.get_driver_loc();
				
				if(curr_loc.get_location_index() == 5){
					System.out.println("Driver " + i + " has left the city!\n");
					break;
				}//end if
				else{
					Location destination = curr_loc.get_next_destination();
					String road = curr_loc.get_road(destination);
					System.out.println("Driver " + i + " headed from " + curr_loc.get_location_name() + " to " + destination.get_location_name() + " via " + road);
					d1.set_driver_loc(destination);
				}//end else
			}//end while
		}//end for	
	}//end main		
}//end City class