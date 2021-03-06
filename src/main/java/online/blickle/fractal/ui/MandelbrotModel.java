package online.blickle.fractal.ui;

import java.awt.image.BufferedImage;

import online.blickle.fractal.data.CanvasMapper;
import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.data.FPixel;
import online.blickle.fractal.mandelbrot.FractalImage;
import online.blickle.fractal.mandelbrot.Mandelbrot;

public class MandelbrotModel {


	private ImageModel model;
	private FCoordinate lowerLeft;
	private FCoordinate upperRight;
	 
	public MandelbrotModel(ImageModel model) {
		this.model=model;
		reset();
	}
	

	public void compute(int startX, int startY, int endX, int endY) {
		int width = model.getImage().getWidth();
		int height = model.getImage().getHeight();
		CanvasMapper mapper = new CanvasMapper(width, height, lowerLeft, upperRight);
		this.lowerLeft = mapper.map(new FPixel(Math.min(startX,endX), Math.max(startY,endY)));
		this.upperRight = mapper.map(new FPixel(Math.max(startX,endX), Math.min(startY,endY)));
		
		FractalImage mb = new FractalImage(width,height, BufferedImage.TYPE_INT_RGB);
		mb.generate(new Mandelbrot(), lowerLeft,upperRight);
		model.setImage(mb);
	}
	
	public void reset() {
		this.lowerLeft = new FCoordinate(-1.5, -1);
		this.upperRight = new FCoordinate(0.5, 1);
	}
}
