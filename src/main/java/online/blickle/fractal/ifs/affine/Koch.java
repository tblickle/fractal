package online.blickle.fractal.ifs.affine;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.ifs.IFSCalculator;

public class Koch extends IFSCalculator{

	public Koch() {
		super(new FCoordinate(0, 0), new FCoordinate(1, 0.5));
		
		addFunction(new AffineTransformation(1.0/3.0, 0, 0, 1.0/3.0, 0, 0));
		addFunction(new AffineTransformation(1.0/3.0, 0, 0, 1.0/3.0, 2.0/3.0, 0));
		addFunction(new AffineTransformation(1.0/6.0, -0.28867, 0.28867, 1.0/6.0, 1.0/3.0, 0));
		addFunction(new AffineTransformation(-1.0/6.0, 0.28867, 0.28867, 1.0/6.0, 2.0/3.0, 0));
		
	}
}
