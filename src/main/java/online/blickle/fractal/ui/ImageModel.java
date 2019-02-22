package online.blickle.fractal.ui;

import java.awt.image.BufferedImage;

public interface ImageModel {

	public BufferedImage getImage();
	public void setImage(BufferedImage image);
	public void clearImage();
}
