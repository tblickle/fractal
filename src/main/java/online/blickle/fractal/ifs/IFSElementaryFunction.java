package online.blickle.fractal.ifs;

import online.blickle.fractal.data.FCoordinate;

/**
 * Elemary function is the mapping between two 2-dimensional Coordinatess
 * @author Tobias
 *
 */
public interface IFSElementaryFunction {
	
	public FCoordinate map(FCoordinate ins);

}
