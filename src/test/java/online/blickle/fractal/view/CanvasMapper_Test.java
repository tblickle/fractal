package online.blickle.fractal.view;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import online.blickle.fractal.data.CanvasMapper;
import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.data.FPixel;

public class CanvasMapper_Test {

	@Test
	public void testPixel2CoordinateMapping() {
		int width =200;
		int height = 100;
		double precision = 1E-04;
		FCoordinate lowerLeft = new FCoordinate(-1, -1);
		FCoordinate upperRight = new FCoordinate(1, 1);
		CanvasMapper m = new CanvasMapper(width, height, lowerLeft, upperRight);
		
		FCoordinate c = m.map(new FPixel(0, 0));
		assertEquals(-1, c.getX(), precision);
		assertEquals(1, c.getY(), precision);
		
		c = m.map(new FPixel(width/2, height/2));
		assertEquals(0, c.getX(), precision);
		assertEquals(0, c.getY(), precision);
		
		c = m.map(new FPixel(width, height));
		assertEquals(1, c.getX(), precision);
		assertEquals(-1, c.getY(), precision);
		
	}
	
	@Test
	public void testPixel2CoordinateMappingNomSymm() {
		int width =100;
		int height = 100;
		double precision = 1E-04;
		FCoordinate lowerLeft = new FCoordinate(-1, -1);
		FCoordinate upperRight = new FCoordinate(1, 4);
		CanvasMapper m = new CanvasMapper(width, height, lowerLeft, upperRight);
		
		FCoordinate c = m.map(new FPixel(0, 0));
		assertEquals(-1, c.getX(), precision);
		assertEquals(4, c.getY(), precision);
		
		c = m.map(new FPixel(width/2, height/2));
		assertEquals(0, c.getX(), precision);
		assertEquals(1.5, c.getY(), precision);
		
		c = m.map(new FPixel(width, height));
		assertEquals(1, c.getX(), precision);
		assertEquals(-1, c.getY(), precision);
		
	}
	
	@Test 
	public void testCoordinate2PixelMapping() {
		int width =100;
		int height = 100;
		double precision = 1E-04;
		FCoordinate lowerLeft = new FCoordinate(-1, -1);
		FCoordinate upperRight = new FCoordinate(1, 4);
		CanvasMapper m = new CanvasMapper(width, height, lowerLeft, upperRight);
		
		FCoordinate c = lowerLeft;
		FPixel p = m.map(c);
		assertEquals(0,p.getX());
		assertEquals(100,p.getY());
		
		
		c = upperRight;
		p = m.map(c);
		assertEquals(100,p.getX());
		assertEquals(0,p.getY());
		
	}

}
