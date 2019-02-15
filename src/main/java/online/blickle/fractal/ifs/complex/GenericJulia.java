package online.blickle.fractal.ifs.complex;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.ifs.IFSCalculator;

import org.apache.commons.math3.complex.Complex;

public class GenericJulia extends IFSCalculator{
	
	public GenericJulia(Complex c, int power) {
		super(new FCoordinate(-2, -1.5), new FCoordinate(2, 1.5));
		for (int i=0;i<power;i++) {
			addFunction(new ComplexTransformation(c, power, i));
		}
	}

}
