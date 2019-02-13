package online.blickle.fractal.ifs.affine;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.ifs.IFSCalculator;

public class Quadrat extends IFSCalculator {

	public Quadrat() {
		super(new FCoordinate(-0.01, -0.1), new FCoordinate(1.01, 1), new FCoordinate(0, 0));
		
		
		addFunction(new AffineTransformation(0.5, 0, 0, 0.5, 0, 0));
		addFunction(new AffineTransformation(0.5, 0, 0, 0.5, 0.5, 0));
		addFunction(new AffineTransformation(0.5, 0, 0, 0.5, 0, 0.5));
		addFunction(new AffineTransformation(0.5, 0, 0, 0.5, 0.5, 0.5));
	}

}
