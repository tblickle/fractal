package online.blickle.fractal.mandelbrot;

import online.blickle.fractal.data.FCoordinate;

public class Mandelbrot implements FractalFunction{
	
	public Mandelbrot() {

	}

	@Override
	public int compute(FCoordinate coordinate) {
		int iter = 1000;
		double zx = 0;
		double zy = 0;
		double cX = coordinate.getX();
		double cY =  coordinate.getY();
		while (zx * zx + zy * zy < 4 && iter > 0) {
		    double tmp = zx * zx - zy * zy + cX;
		    zy = 2.0 * zx * zy + cY;
		    zx = tmp;
		    iter--;
		}
		return iter;
	}

	
}
