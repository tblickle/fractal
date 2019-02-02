package online.blickle.fractal.ifs;

import java.util.List;

import online.blickle.fractal.data.FCoordinate;

public class Sierpinski implements IteratedFunction {

	private IFSCollection IFSs = new IFSCollection();
	public Sierpinski() {
		IFSs.addFunction(new AffineTransformation(0.5, 0, 0, 0.5, 0, 0));
		IFSs.addFunction(new AffineTransformation(0.5, 0, 0, 0.5, 0.5, 0));
		IFSs.addFunction(new AffineTransformation(0.5, 0, 0, 0.5, 0.25, 0.5));
	}
	@Override
	public FCoordinate iterate(FCoordinate coordinate) {
		return IFSs.iterate(coordinate);
	}
	@Override
	public List<FCoordinate> copy(FCoordinate coordinate) {
		return IFSs.copy(coordinate);
	}

	

}
