package online.blickle.fractal.data;


public class CanvasMapper {

	private int withInPixel;
	private int heightInPixel;
	private FCoordinate lowerLeft;
	private FCoordinate upperRight;
	
	public CanvasMapper(int withInPixel, int heightInPixel, FCoordinate lowerLeft, FCoordinate upperRight) {
		super();
		this.withInPixel = withInPixel;
		this.heightInPixel = heightInPixel;
		this.lowerLeft = lowerLeft;
		this.upperRight = upperRight;
	}
	
	
	
	public int getWithInPixel() {
		return withInPixel;
	}

	public int getHeightInPixel() {
		return heightInPixel;
	}

	public FCoordinate getLowerLeft() {
		return lowerLeft;
	}

	public FCoordinate getUpperRight() {
		return upperRight;
	}


	public FCoordinate map(FPixel point) {
		double cX = lowerLeft.getX() + point.getX()* (upperRight.getX()-lowerLeft.getX()) / getWithInPixel(); 
        double cY = upperRight.getY() - point.getY()* (upperRight.getY()-lowerLeft.getY()) / getHeightInPixel();
        return new FCoordinate(cX, cY);
	}
	
	public FPixel map(FCoordinate coord) {
		int px = (int) (((coord.getX()-lowerLeft.getX())*getWithInPixel()) / (upperRight.getX() - lowerLeft.getX()));
		int py = - (int) (((coord.getY()-upperRight.getY())*getHeightInPixel()) / (upperRight.getY() - lowerLeft.getY()));
		if (px<0) px=0;
		if (py<0) py=0;
		if (px>=getWithInPixel()) px=getWithInPixel()-1;
		if (py>=getHeightInPixel()) py=getHeightInPixel()-1;
		return new FPixel(px, py);
		
	}
	
}
