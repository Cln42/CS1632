public class Driver{
	Location current_loc;
	
	public Driver(Location loc){
		current_loc = loc;
	}
	
	public Location get_driver_loc(){
		return current_loc;
	}
	
	public void set_driver_loc(Location new_loc){
		current_loc = new_loc;
	}
	

}