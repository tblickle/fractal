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
	Color[] colorMap = {Color.BLACK,Color.RED, Color.GREEN, Color.BLUE};

	public IFSChaosGame(IFSCalculator calculator) {
		this.calculator = calculator;
		this.currPoint = new FCoordinate(1, 1);
		
	}
	
	public BufferedImage performSteps(BufferedImage image,  int steps) {
		
		CanvasMapper mapper = new CanvasMapper(image.getWidth(), image.getHeight(), calculator.getLowerLeft(),calculator.getUpperRight());
		Graphics2D    graphics = image.createGraphics();
		for (int i = 0; i<steps; i++) {
        	currPoint = calculator.iterate(currPoint);
    		lastPixel = mapper.map(currPoint);
    		graphics.setPaint ( colorMap[calculator.getLastFunctionIdx()]);
    		graphics.fillOval(lastPixel.getX(), lastPixel.getY(), 3, 3);
    	}
		return image;
               
	}
	
	public FCoordinate getPoint() {
		return this.currPoint;
	}
	
	public FPixel getPixel() {
		return this.lastPixel;
	}
	
}
