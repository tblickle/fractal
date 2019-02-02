package online.blickle.fractal.ifs;

import java.awt.image.BufferedImage;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.data.FPixel;
import online.blickle.fractal.view.CanvasMapper;

public class IFSImage extends BufferedImage {
	

	public IFSImage(int width, int height, int imageType) {
		super(width,height,imageType);
	}
	
	public void generate(IteratedFunction func, FCoordinate lowerLeft, FCoordinate upperRight) {
		
		CanvasMapper mapper = new CanvasMapper(getWidth(), getHeight(), lowerLeft,upperRight);
		FCoordinate currPoint = new FCoordinate(1, 1);
        for (int i = 0; i<10000000; i++) {
        	currPoint = func.iterate(currPoint);
        	if (i<100) {
	        	FPixel p = mapper.map(currPoint);
	        	this.setRGB(p.getX(), p.getY(), i % 0xFFFFFF );
        	}
        }
            
	}

}
