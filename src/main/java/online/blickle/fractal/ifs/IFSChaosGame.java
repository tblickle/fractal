package online.blickle.fractal.ifs;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.data.FPixel;
import online.blickle.fractal.data.CanvasMapper;

public class IFSChaosGame  {
	
	private IFSCalculator calculator;
	FCoordinate currPoint;
	FPixel lastPixel;
	int pixelSize;
	Color lastColor;
	
	Color[] colorMap = {Color.BLACK,Color.RED, Color.GREEN, Color.BLUE};

	public IFSChaosGame(IFSCalculator calculator) {
		this(calculator,2);
	}

	public IFSChaosGame(IFSCalculator calculator, int pixelsize) {
		this.calculator = calculator;
		this.currPoint = calculator.getStartPoint();
		setPixelSize(pixelsize);
	}
	
	public void setPixelSize(int pixelsize) {
		if (pixelsize <2) pixelsize = 2; // Minimum size is 2, otherwise nothing is drawn
		if (pixelsize >10) pixelsize =10;
		this.pixelSize = pixelsize;
	}
	
	public BufferedImage performSteps(BufferedImage image,  int steps) {
		
		CanvasMapper mapper = new CanvasMapper(image.getWidth(), image.getHeight(), calculator.getLowerLeft(),calculator.getUpperRight());
		Graphics2D    graphics = image.createGraphics();
		for (int i = 0; i<steps; i++) {
        	currPoint = calculator.iterate(currPoint);
    		lastPixel = mapper.map(currPoint);
    		lastColor = colorMap[calculator.getLastFunctionIdx()%colorMap.length];
    		graphics.setPaint (lastColor );
    		graphics.fillOval(lastPixel.getX()+pixelSize/2, lastPixel.getY()+pixelSize/2, pixelSize, pixelSize);
    	}
		return image;
               
	}
	
	public FCoordinate getPoint() {
		return this.currPoint;
	}
	
	public FPixel getPixel() {
		return this.lastPixel;
	}
	
	public Color getColor() {
		return lastColor;
	}
	
	public IFSCalculator getCalculator() {
		return calculator;
	}
}
