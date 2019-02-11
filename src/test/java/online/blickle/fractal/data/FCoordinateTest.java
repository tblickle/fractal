package online.blickle.fractal.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class FCoordinateTest {

	@Test
	public void testEquals() {
		FCoordinate x = new FCoordinate(1.0, 0.5);
		FCoordinate auchx = new FCoordinate(1.0, 0.5);
		assertEquals(x,auchx);
	}
	
	@Test
	public void testNotEquals() {
		FCoordinate x = new FCoordinate(1.0, 0.5);
		FCoordinate y = new FCoordinate(-1.0, 0.5);
		assertEquals(false,x.equals(y));
	}

}
