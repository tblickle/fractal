package online.blickle.fractal.ifs;

import java.util.ArrayList;
import java.util.List;

import online.blickle.fractal.data.CanvasMapper;
import online.blickle.fractal.data.FCoordinate;

/**
 * Base class of all Iterated Function Calculator
 * @author Tobias
 *
 */
public class IFSCalculator {
	
	private List<IFSElementaryFunction> IFSList = new ArrayList<>();
	private FCoordinate lowerLeft;
	private FCoordinate upperRight;
	private FCoordinate startPoint;
	private int lastFunction;
	
	public IFSCalculator(FCoordinate lowerLeft, FCoordinate upperRight) {
		this(lowerLeft,upperRight,new FCoordinate(1, 1));
	}
	
	public IFSCalculator(FCoordinate lowerLeft, FCoordinate upperRight, FCoordinate startPoint) {
		this.lowerLeft = lowerLeft;
		this.upperRight = upperRight;
		this.startPoint = startPoint;
	}
	
	public void addFunction(IFSElementaryFunction function) {
		IFSList.add(function);
	}
	
	public FCoordinate iterate(FCoordinate in) {
		lastFunction = (int)(Math.random()*IFSList.size());
		return IFSList.get(lastFunction).map(in);
	}
	
	public List<FCoordinate>copy(FCoordinate in) {
		ArrayList<FCoordinate> res = new ArrayList<>();
		for (IFSElementaryFunction f:IFSList) {
			res.add(f.map(in));
		}
		return res;
	}

	public FCoordinate getLowerLeft() {
		return lowerLeft;
	}

	public FCoordinate getUpperRight() {
		return upperRight;
	}
	
	public int getLastFunctionIdx() {
		return lastFunction;
	}
	
	public CanvasMapper getCanvasMapper(int width, int height) {
		return new CanvasMapper(width, height, lowerLeft, upperRight);
	}
	
	public FCoordinate getStartPoint() {
		return startPoint;
	}
	

}
