import static org.junit.Assert.*;
import org.junit.*;

//import static org.mockito.Mockito.*;

public class LocationTest {

	// makes sure that only valid locations are created
	@Test
	public void testLocation_Valid() {
		try {
			new Location(0, 10);
			new Location(5, 100);
			new Location(3, 2147483647);
			new Location(0, -1000);
		} catch (Exception e) {
			fail();
		}
	}

	// ensure that get_location_name returns the correct name
	@Test
	public void testGet_location_name() {
		Location loc1 = new Location(4, 10);
		assertEquals("University", loc1.get_location_name());
		Location loc2 = new Location(0, 10);
		assertEquals("Outside City", loc2.get_location_name());
	}

	// ensure that get_location_index returns the correct index
	@Test
	public void testGet_location_index() {
		Location loc1 = new Location(4, 10);
		assertEquals(4, loc1.get_location_index());
		Location loc2 = new Location(0, 10);
		assertEquals(0, loc2.get_location_index());
	}

	// checks that when getting the next destination, it only returns one of two
	// possible locations and not any invalid locations
	@Test
	public void testGet_next_destination() {
		Location loc1 = new Location(0, 10);
		Location dest1 = new Location(1, 10);
		Location dest2 = new Location(4, 10);
		Location dest = loc1.get_next_destination();
		assertTrue(dest.get_location_name().equals(dest1.get_location_name())
				|| dest.get_location_name().equals(dest2.get_location_name()));
		assertTrue(dest.get_location_index() == dest1.get_location_index()
				|| dest.get_location_index() == dest2.get_location_index());
	}

	// ensures that the road between two valid locations is correct
	@Test
	public void testGet_road_Valid() {
		Location loc1 = new Location(2, 10);
		Location loc2 = new Location(5, 10);
		assertEquals("Fourth Ave.", loc1.get_road(loc2));
		loc1 = new Location(1, 10);
		loc2 = new Location(3, 10);
		assertEquals("Meow St.", loc1.get_road(loc2));
		loc1 = new Location(0, 10);
		loc2 = new Location(4, 10);
		assertEquals("Fifth Ave.", loc1.get_road(loc2));
	}

	// checks that entering two invalid locations results in a 'null' road
	@Test
	public void testGet_road_Invalid() {
		Location loc1 = new Location(0, 10);
		Location loc2 = new Location(3, 10);
		assertNull(loc1.get_road(loc2));
		loc1 = new Location(1, 10);
		loc2 = new Location(4, 10);
		assertNull(loc1.get_road(loc2));

	}

}
