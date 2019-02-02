package online.blickle.fractal.ifs;

import java.util.List;

import online.blickle.fractal.data.FCoordinate;

public interface IteratedFunction {

	public FCoordinate iterate(FCoordinate coordinate);
	public List<FCoordinate> copy(FCoordinate coordinate);
}
