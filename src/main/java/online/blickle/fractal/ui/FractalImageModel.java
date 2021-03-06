package online.blickle.fractal.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Observable;

import javax.imageio.ImageIO;

public class FractalImageModel  extends Observable implements ImageModel {

	private static int PREF_SIZE = 900;
	private BufferedImage image;
	
	public FractalImageModel() {
		clearImage();
	}

	public BufferedImage getImage() {
		return image;
	}
	
	public void loadImage(File file) {
		try {
        	BufferedImage img = ImageIO.read(file);
        	int width = img.getWidth();
        	double ratio = (double)PREF_SIZE /(double)width;
        	AffineTransform tx = new AffineTransform();
            tx.scale(ratio, ratio);

            AffineTransformOp op = new AffineTransformOp(tx,
                AffineTransformOp.TYPE_BILINEAR);
            img = op.filter(img, null);
            setImage(img);
        } catch (Exception e){
        	e.printStackTrace();
        }
	}
	
	public void clearImage() {
		
		image = new BufferedImage(PREF_SIZE, PREF_SIZE, BufferedImage.TYPE_INT_RGB );
		Graphics2D graphics = image.createGraphics();
		graphics.setPaint ( new Color ( 255,255,255 ) );
		graphics.fillRect ( 0, 0, getImage().getWidth(), getImage().getHeight() );
		
		setChanged();
		notifyObservers();
	}

	
	public void setImage(BufferedImage image) {
		this.image = image;
		setChanged();
		notifyObservers();
	}
	
	
}
