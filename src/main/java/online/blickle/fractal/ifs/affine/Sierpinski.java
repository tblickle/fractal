package online.blickle.fractal.ifs.affine;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.ifs.IFSCalculator;


public class Sierpinski extends IFSCalculator {

	public Sierpinski() {
		super(new FCoordinate(0, -0.1), new FCoordinate(1, 1));
		
		addFunction(new AffineTransformation(0.5, 0, 0, 0.5, 0, 0));
		addFunction(new AffineTransformation(0.5, 0, 0, 0.5, 0.5, 0));
		addFunction(new AffineTransformation(0.5, 0, 0, 0.5, 0.25, 0.5));
	}
}
