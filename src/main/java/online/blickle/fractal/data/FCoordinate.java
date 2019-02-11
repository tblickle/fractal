package online.blickle.fractal.data;

public class FCoordinate {

	private double x;
	private double y;
	
	
	public FCoordinate(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object other) {
		if (other instanceof FCoordinate) {
			FCoordinate fo = (FCoordinate)other;
			return (this.getX()==fo.getX() && this.getY()==fo.getY());
		} else {
			return false;
		}
		
	}
		
}
