package online.blickle.fractal.ifs.complex;

import java.util.List;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.ifs.IFSElementaryFunction;

import org.apache.commons.math3.complex.Complex;

public class ComplexTransformation implements IFSElementaryFunction{

	private Complex c;
	private int exp;
	private int rootIdx;

	public ComplexTransformation(Complex c, int exp, int rootIdx) {
		this.c = c;
		this.exp = exp;
		this.rootIdx = rootIdx;
		if (rootIdx>=exp || rootIdx <0) {
			throw new IllegalArgumentException(rootIdx+"th root not defined as exponent is "+exp);
		}
	}
	
	@Override
	public FCoordinate map(FCoordinate ins) {
		Complex z = toComplex(ins);
		Complex newZ = z.subtract(c);
		List<Complex> roots = newZ.nthRoot(exp);
		return toCoordinate(roots.get(rootIdx));
	}
	
	private Complex toComplex(FCoordinate cord) {
		return new Complex(cord.getX(), cord.getY());
	}
	
	private FCoordinate toCoordinate(Complex c) {
		return new FCoordinate(c.getReal(), c.getImaginary());
	}
	
}
