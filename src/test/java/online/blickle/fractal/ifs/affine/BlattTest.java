package online.blickle.fractal.ifs.affine;

import static org.junit.Assert.assertEquals;

import java.util.List;

import online.blickle.fractal.data.FCoordinate;

import org.junit.Test;

public class BlattTest {

	@Test
	public void copyWithNullObject_returnArrayWithNulls() {
		Blatt b = new Blatt();
		List<FCoordinate> res =b.copy(null);
		assertEquals(4,res.size());
		for (FCoordinate c:res) {
			assertEquals(null,c);
		}
	}

}
