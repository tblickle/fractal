package online.blickle.fractal.ifs;

import java.awt.image.BufferedImage;
import java.util.List;

import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.data.FPixel;
import online.blickle.fractal.view.CanvasMapper;

public class IFSCopyMachine  {
	
	private BufferedImage image = null;
	private IteratedFunction f=null;
	private CanvasMapper mapper = null;

	public IFSCopyMachine(BufferedImage origImage,IteratedFunction f){
		this.image = origImage;
		this.f = f;
		this.mapper = new CanvasMapper(image.getWidth(), image.getHeight(), new FCoordinate(-0.1, -0.1), new FCoordinate(1.1, 1.1));
		
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void copyOnce() {
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
		for (int x=0; x< image.getWidth();x++) {
			for (int y=0;y<image.getHeight();y++ ) {
				int color = image.getRGB(x, y);
				if (color!=-1) {
					FCoordinate c = mapper.map(new FPixel(x, y));
					List<FCoordinate> copies = f.copy(c);
					for (FCoordinate cp:copies) {
						FPixel p = mapper.map(cp);
						newImage.setRGB(p.getX(), p.getY(), color | newImage.getRGB(p.getX(), p.getY()));
					}
				}
			}
		}
		this.image = newImage;
	}
	
	

}
