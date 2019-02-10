package online.blickle.fractal.ifs.complex;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.ifs.IFSElementaryFunction;

import org.apache.commons.math3.complex.Complex;

public class ComplexTransformation implements IFSElementaryFunction{

	private Complex c;
	private boolean first;

	public ComplexTransformation(Complex c, boolean first) {
		this.c = c;
		this.first = first;
	}
	
	@Override
	public FCoordinate map(FCoordinate ins) {
		Complex z = toComplex(ins);
		Complex newZ = z.subtract(c).sqrt();
		if (!first) {
			newZ = newZ.multiply(-1.0);
		}
		return toCoordinate(newZ);
	}
	
	private Complex toComplex(FCoordinate cord) {
		return new Complex(cord.getX(), cord.getY());
	}
	
	private FCoordinate toCoordinate(Complex c) {
		return new FCoordinate(c.getReal(), c.getImaginary());
	}
	
}
