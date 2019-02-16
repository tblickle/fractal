package online.blickle.fractal.ifs.affine;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.ifs.IFSElementaryFunction;

/*
 * Simple affine Transformation A*x + b
 */
public class AffineTransformation implements IFSElementaryFunction{
	
	private double a11=0;
	private double a12=0;
	private double a21=0;
	private double a22=0;
	private double b1;
	private double b2;
	
	public AffineTransformation(double a11, double a12, double a21, double a22,
			double b1, double b2) {
		super();
		this.a11 = a11;
		this.a12 = a12;
		this.a21 = a21;
		this.a22 = a22;
		this.b1 = b1;
		this.b2 = b2;
	}

	@Override
	public FCoordinate map(FCoordinate in) {
		if (in == null) {
			return null;
		}
		double x = in.getX();
		double y = in.getY();
		
		double fx = a11*x + a12 *y + b1;
		double fy = a21*x + a22 *y + b2;
		
		return new FCoordinate(fx, fy);

	}
	
	@Override
	public double getDeterminante() {
		return Math.abs(a11*a22-a12*a21);
	}
	
	

}
