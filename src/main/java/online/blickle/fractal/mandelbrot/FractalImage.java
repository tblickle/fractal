package online.blickle.fractal.mandelbrot;

import java.awt.image.BufferedImage;

import online.blickle.fractal.data.CanvasMapper;
import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.data.FPixel;

public class FractalImage extends BufferedImage{

	public FractalImage(int width, int height, int imageType) {
		super(width,height,imageType);
	}
	
	public void generate(FractalFunction func, FCoordinate lowerLeft, FCoordinate upperRight) {
		
		CanvasMapper mapper = new CanvasMapper(getWidth(), getHeight(), lowerLeft,upperRight);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
            	FCoordinate currVal = mapper.map(new FPixel(x, y));
                int iter = func.compute(currVal);
                this.setRGB(x, y, iter );
            }
        }
	}
}
