import static org.junit.Assert.*;
import org.junit.*;
import static org.mockito.Mockito.*;

public class DriverTest {

	// ensures that a valid driver is created only if there is a valid location
	// input
	@Test
	public void testDriver() {
		Location mockLoc = mock(Location.class);
		try {
			new Driver(mockLoc);
		} catch (Exception e) {
			fail();
		}
	}

	// ensures that get_driver_loc returns the current location saved by the
	// driver
	@Test
	public void testGet_driver_loc() {
		Location mockLoc = mock(Location.class);
		Driver driver = new Driver(mockLoc);
		assertEquals(mockLoc, driver.get_driver_loc());
		assertEquals(driver.get_driver_loc(), driver.current_loc);
	}

	// ensures that set_driver_loc saves the new location in the driver object
	// and can receive that
	@Test
	public void testSet_driver_loc() {
		Location mockLoc = mock(Location.class);
		Location mockLoc2 = mock(Location.class);
		Driver driver = new Driver(mockLoc);
		driver.set_driver_loc(mockLoc2);
		assertEquals(mockLoc2, driver.current_loc);
	}

}
