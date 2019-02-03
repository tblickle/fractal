package online.blickle.fractal.ifs.affine;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.ifs.IFSCalculator;

public class Blatt extends IFSCalculator {

	public Blatt() {
		super(new FCoordinate(0, 0), new FCoordinate(1, 1));
		
		addFunction(new AffineTransformation(0.64987, -0.013, 0.013, 0.64987, 0.175, 0));
		addFunction(new AffineTransformation(0.64948,-0.026,0.0256,0.64948,0.165,0.325));
		addFunction(new AffineTransformation(0.3183,-0.3182,0.3182,0.3182,0.2,0));
		addFunction(new AffineTransformation(-0.3183,0.3182,0.3182,0.3182,0.8,0));
	}

}
