import static org.junit.Assert.*;

import org.junit.*;

import static org.mockito.Mockito.*;

public class CitySim9000Test {

	// checks that a Long as input will result in True
	@Test
	public void testCheck_for_long_valid() {
		String number1 = "0";
		String number2 = "9000";
		String number3 = "-1";

		assertTrue(CitySim9000.check_for_long(number1));
		assertTrue(CitySim9000.check_for_long(number2));
		assertTrue(CitySim9000.check_for_long(number3));
	}

	// checks that anything that is not a long will result in False
	@Test
	public void testCheck_for_long_invalid() {
		String number1 = "10.5";
		String string1 = "hello";
		String char1 = "a";

		assertFalse(CitySim9000.check_for_long(number1));
		assertFalse(CitySim9000.check_for_long(string1));
		assertFalse(CitySim9000.check_for_long(char1));
	}

	// checks that when the driver leaves the city, still_driving is set to
	// false and the while loop will break in driveAround
	@Test
	public void testWhileLoopLeaving() {
		Driver mockDriver = mock(Driver.class);
		Location mockLoc = mock(Location.class);
		when(mockDriver.get_driver_loc()).thenReturn(mockLoc);
		when(mockLoc.get_location_index()).thenReturn(5);
		boolean bool = CitySim9000.while_Loop(mockDriver, mockLoc, 5);
		assertFalse(bool);
	}

	// checks that while the driver is still within the city, still_driving is
	// set to true and the while loop in driveAround will continue
	@Test
	public void testWhileLoopStaying() {
		Driver mockDriver = mock(Driver.class);
		Location mockLoc = mock(Location.class);
		Location mockDest = mock(Location.class);
		when(mockDriver.get_driver_loc()).thenReturn(mockLoc);
		when(mockLoc.get_location_index()).thenReturn(0);
		when(mockLoc.get_location_name()).thenReturn("Current Location");
		when(mockDest.get_location_name()).thenReturn("Destination");
		when(mockLoc.get_next_destination()).thenReturn(mockDest);
		when(mockLoc.get_road(mockDest)).thenReturn("a Road.");
		when(mockDriver.set_driver_loc(mockLoc)).thenReturn(0);
		boolean bool = CitySim9000.while_Loop(mockDriver, mockLoc, 5);
		assertTrue(bool);
	}

}
