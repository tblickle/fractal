package online.blickle.fractal.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import online.blickle.fractal.data.CanvasMapper;
import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.data.FPixel;
import online.blickle.fractal.ifs.IFSCalculator;
import online.blickle.fractal.ifs.IFSChaosGame;
import online.blickle.fractal.ifs.affine.Sierpinski;

public class SierpinskiAnimatedModel {

	private FractalModel model;
	private IFSChaosGame chaosGame;
	private BufferedImage orignalImage;
	private int width;
	private int height;
	private FPixel[] corners;
	private Color[] colorMap = {Color.BLACK,Color.RED, Color.GREEN};
	
	public SierpinskiAnimatedModel(FractalModel model) {
		this.model=model;
		this.width = model.getImage().getWidth();
		this.height = model.getImage().getHeight();
		
		IFSCalculator calculator = new Sierpinski();
		CanvasMapper cm = calculator.getCanvasMapper(height, height);
		corners = new FPixel[]{
				cm.map(new FCoordinate(0, 0)),
				cm.map(new FCoordinate(1, 0)),
				cm.map(new FCoordinate(0.5, 1))
			};
		this.chaosGame = new IFSChaosGame(calculator);
		this.orignalImage = new BufferedImage(width,height, model.getImage().getType());
	}
	
	public void performSierpinskiGameAnimation() {
		FPixel prevPixel= chaosGame.getPixel();
		orignalImage = chaosGame.performSteps(orignalImage, 1);
		
		BufferedImage image = new BufferedImage(width, height, orignalImage.getType());
		Graphics2D currGraphics = image.createGraphics();
		currGraphics.drawImage(orignalImage, 0, 0, null);
		
		FPixel lastPixel =  chaosGame.getPixel();
		
		FPixel corner = corners[chaosGame.getCalculator().getLastFunctionIdx()];
		
		currGraphics.setPaint ( chaosGame.getColor());
		if (prevPixel!= null) {
			currGraphics.drawLine(prevPixel.getX(), prevPixel.getY(), corner.getX(), corner.getY());
		}
		currGraphics.fillOval(lastPixel.getX()-5,lastPixel.getY()-5,10,10);
		model.setImage(image);
		
	}
	
	public void clearImage() {
		Graphics2D    graphics = orignalImage.createGraphics();
		graphics.setPaint ( new Color ( 255,255,255 ) );
		graphics.fillRect ( 0, 0, width,height );
		for (int i=0 ; i<3; i++) {
			graphics.setPaint ( colorMap[i] );
			graphics.fillOval(corners[i].getX()-5, corners[i].getY()-5, 10, 10);
		}
	}
}
