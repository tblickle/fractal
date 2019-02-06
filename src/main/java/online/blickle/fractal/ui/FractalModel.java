package online.blickle.fractal.ui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Observable;

import javax.imageio.ImageIO;

import online.blickle.fractal.ifs.IFSChaosGame;
import online.blickle.fractal.ifs.IFSCopyMachine;

public class FractalModel extends Observable{

	private static int PREF_SIZE = 500;
	private BufferedImage image;
	
	public FractalModel() {
		image = new BufferedImage(PREF_SIZE, PREF_SIZE, BufferedImage.TYPE_INT_RGB );
				
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
        	
        }
	}
	
	public void copyOnce(IFSCopyMachine copyMachine) {
		setImage(copyMachine.copyOnce(getImage()));
	}
	
	public void performChaosSteps(IFSChaosGame chaosGame, int numSteps) {
		setImage(chaosGame.performSteps(getImage(), numSteps));
	}
 
	public void clearImage() {
		Graphics2D    graphics = getImage().createGraphics();
		graphics.setPaint ( new Color ( 255,255,255 ) );
		graphics.fillRect ( 0, 0, getImage().getWidth(), getImage().getHeight() );
		setChanged();
		notifyObservers();
	}

	protected void setImage(BufferedImage image) {
		this.image = image;
		setChanged();
		notifyObservers();
	}
	
	
}