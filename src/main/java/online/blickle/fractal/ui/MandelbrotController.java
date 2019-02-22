package online.blickle.fractal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;


public class MandelbrotController {
	private MandelbrotModel model;
	private int initalWidth, initialHeight;
	

	public MandelbrotController(ImageModel imodel) {
		this.model = new MandelbrotModel(imodel);
		this.initalWidth = imodel.getImage().getWidth();
		this.initialHeight = imodel.getImage().getHeight();
		
	}
	
	public ActionListener getMandelbrotListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.reset();
				model.compute(0,0,initalWidth,initialHeight);
			}
		};
	}
	
	
	public MandelbrotMouseDraggedListener getMouseDragListener() {
		return new MandelbrotMouseDraggedListener ();
	}
	
	public class MandelbrotMouseDraggedListener extends MouseInputAdapter {
		int startX,startY,endX,endY;
	      @Override
	      public void mousePressed(MouseEvent evt) {
	         startX = evt.getX();
	         startY = evt.getY();
	         
	      }
	      @Override
	      public void mouseDragged(MouseEvent evt) {
	         endX = evt.getX();
	         endY = evt.getY();
	         
	      }
	      @Override
	         public void mouseReleased(MouseEvent evt) {
	         endX = evt.getX();
	         endY = evt.getY();
	         model.compute(startX,startY,endX,endY);
	      }
	   }

	
	
}