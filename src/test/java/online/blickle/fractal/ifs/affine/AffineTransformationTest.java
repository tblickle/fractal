package online.blickle.fractal.ifs.affine;

import static org.junit.Assert.*;
import online.blickle.fractal.data.FCoordinate;

import org.junit.Test;

public class AffineTransformationTest {

	@Test
	public void callTransformationWithNullCoordinate_returnNull() {
		AffineTransformation a = new AffineTransformation(0,0,0,0,0,0);
		assertEquals(null,a.map(null));
	}
	
	@Test
	public void callTransformatioWithUnitMatrix_returnSameValue() {
		AffineTransformation a = new AffineTransformation(1,0,0,1,0,0); // Uunit Matrix;
		FCoordinate in = new FCoordinate(1.7, 2.3); // random values
		assertEquals(in,a.map(in));
	}
	
	@Test
	public void callTransformatioWithZeroMatrix_return_b() {
		AffineTransformation a = new AffineTransformation(0,0,0,0,1,2); // Zero Matrix; B=(1,2)
		FCoordinate in = new FCoordinate(1.7, 2.3); // random values
		FCoordinate expected = new FCoordinate(1, 2);
		assertEquals(expected,a.map(in));
	}

}
