package online.blickle.fractal.ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import online.blickle.fractal.ui.MandelbrotController.MandelbrotMouseDraggedListener;

public class FractalImagePanel extends JPanel implements Observer {

	private FractalImageModel fm;
	private FractalImageController fController;

	public FractalImagePanel() {
		fController = new FractalImageController();
		this.fm = fController.getModel();
		fm.addObserver(this);
		fm.clearImage();
		setPreferredSize(new Dimension(fm.getImage().getWidth(), fm
				.getImage().getHeight()));
		
		/*
		MandelbrotMouseDraggedListener listener = mc.getMouseDragListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		*/
		
	}
	
	public FractalImageController getController() {
		return fController;
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(fm.getImage(), 0, 0, null);
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setPreferredSize(new Dimension(fm.getImage().getWidth(), fm
				.getImage().getHeight()));
		this.invalidate();
		this.repaint();

	}

}