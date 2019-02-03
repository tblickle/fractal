package online.blickle.fractal.ifs.affine;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.ifs.IFSCalculator;

public class Farn extends IFSCalculator {

	public Farn() {
		super(new FCoordinate(-10, 0), new FCoordinate(10, 20));
		
		addFunction(new AffineTransformation(0, 0, 0, 0.17, 0, 0));
		addFunction(new AffineTransformation(0.84962,0.0255,-0.0255,0.84962,0,3));
		addFunction(new AffineTransformation(-0.1554,0.235,0.19583,0.18648,0,1.2));
		addFunction(new AffineTransformation(0.1554,-0.235,0.19583,0.18648,0,3));
	}

}
