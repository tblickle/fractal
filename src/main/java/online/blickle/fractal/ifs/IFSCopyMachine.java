package online.blickle.fractal.ifs;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.data.FPixel;
import online.blickle.fractal.view.CanvasMapper;

public class IFSCopyMachine  {
	
	private IFSCalculator calculator=null;


	public IFSCopyMachine(IFSCalculator calculator){
		this.calculator = calculator;
		
	}
	
		public BufferedImage copyOnce(BufferedImage image) {
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		CanvasMapper mapper =  new CanvasMapper(image.getWidth(), image.getHeight(), calculator.getLowerLeft(), calculator.getUpperRight());
		
		Graphics2D    graphics = newImage.createGraphics();
		graphics.setPaint ( new Color ( 255,255,255 ) );
		graphics.fillRect ( 0, 0, newImage.getWidth(), newImage.getHeight() );
		
		for (int x=0; x< image.getWidth();x++) {
			for (int y=0;y<image.getHeight();y++ ) {
				int color = image.getRGB(x, y);
				if (color!=-1) {
					FCoordinate c = mapper.map(new FPixel(x, y));
					List<FCoordinate> copies = calculator.copy(c);
					for (FCoordinate cp:copies) {
						FPixel p = mapper.map(cp);
						newImage.setRGB(p.getX(), p.getY(), color );
					}
				}
			}
		}
		return newImage;
	}
	
	

}
