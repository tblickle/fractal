package online.blickle.fractal.ifs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import online.blickle.fractal.data.CanvasMapper;
import online.blickle.fractal.data.FCoordinate;

/**
 * Base class of all Iterated Function Calculator
 * @author Tobias
 *
 */
public class IFSCalculator {
	
	private List<IFSElementaryFunction> IFSList = new ArrayList<>();
	private List<Double>IFSProbability = new ArrayList<>();
	
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
		computeProbabilities();
	}
	
	public FCoordinate iterate(FCoordinate in) {
		double rnd = Math.random();
		double probSum=0;
		lastFunction = IFSProbability.size()-1;
		for (int i=0; i< IFSProbability.size();i++) {
			probSum += IFSProbability.get(i);
			if (rnd < probSum) {
				lastFunction = i;
				break;
			}
		}
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
	
	private void computeProbabilities() {
		double sum=0;
		List<Double>probs = new ArrayList<>();
		for (IFSElementaryFunction f : IFSList) {
			sum+= f.getDeterminante()+0.1;
			probs.add(f.getDeterminante()+0.1);
		}
		//Normalize
		IFSProbability.clear();
		for (Double p: probs) {
			IFSProbability.add(p/sum);
		}
	}

}
