package online.blickle.fractal.ifs;

import java.util.ArrayList;
import java.util.List;

import online.blickle.fractal.data.FCoordinate;

public class IFSCollection {
	
	private List<IFSFunction> IFSList = new ArrayList<>();
	
	public void addFunction(IFSFunction function) {
		IFSList.add(function);
	}
	
	public FCoordinate iterate(FCoordinate in) {
		int idx = (int)(Math.random()*IFSList.size());
		return IFSList.get(idx).map(in);
	}
	
	public List<FCoordinate>copy(FCoordinate in) {
		ArrayList<FCoordinate> res = new ArrayList<>();
		for (IFSFunction f:IFSList) {
			res.add(f.map(in));
		}
		return res;
	}

}
