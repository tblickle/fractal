package online.blickle.fractal.ifs.complex;

import org.apache.commons.math3.complex.Complex;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.ifs.IFSCalculator;

public class Julia extends IFSCalculator {

	public Julia() {
		super(new FCoordinate(-2, -1.5), new FCoordinate(2, 1.5));
		
		this.addFunction(new ComplexTransformation(new Complex(-1.13,0), true));
		this.addFunction(new ComplexTransformation(new Complex(-1.13,0), false));
	}
}
