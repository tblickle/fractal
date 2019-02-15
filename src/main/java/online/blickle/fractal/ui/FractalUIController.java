package online.blickle.fractal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.event.MouseInputAdapter;

import online.blickle.fractal.ifs.affine.Blatt;
import online.blickle.fractal.ifs.affine.Farn;
import online.blickle.fractal.ifs.affine.Koch;
import online.blickle.fractal.ifs.affine.Sierpinski;
import online.blickle.fractal.ifs.complex.Julia;

public class FractalUIController {

	private FractalModel model;
	private Timer timer;
	
	public FractalUIController() {
		this.model = new FractalModel();
	}
	
	public FractalModel getModel() {
		return this.model;
	}
	
	
	public ChaosGameListener createSierpinskiChaosGameListener() {
		return new ChaosGameListener(model, new Sierpinski());
	}
	
	public ChaosGameListener createKochChaosGameListener() {
		return new ChaosGameListener(model, new Koch());
	}
	
	public ChaosGameListener createBlattChaosGameListener() {
		return new ChaosGameListener(model, new Blatt());
	}
	
	public ChaosGameListener createFarnChaosGameListener() {
		return new ChaosGameListener(model, new Farn());
	}
	
	public ChaosGameListener createJuliaChaosGameListener() {
		return new ChaosGameListener(model, new Julia());
	}
	
	public CopyMachineListner createSierpinskiCopyMachineListener() {
		return new CopyMachineListner(model, new Sierpinski());
	}
	
	public CopyMachineListner createFranCopyMachineListener() {
		return new CopyMachineListner(model, new Farn());
	}
	
	public CopyMachineListner createBlattCopyMachineListener() {
		return new CopyMachineListner(model, new Blatt());
	}
	
	public CopyMachineListner createKochCopyMachineListener() {
		return new CopyMachineListner(model, new Koch());
	}
	
	public CopyMachineListner createJuliaCopyMachineListener() {
		return new CopyMachineListner(model, new Julia());
	}
	
	public ClearImageListener createClearImageListener() {
		return new ClearImageListener();
	}
	
	public LoadImageListener createLoadImageListener() {
		return new LoadImageListener();
	}
	
	public MyMouseDraggedListener getMouseDragListener() {
		return new MyMouseDraggedListener ();
	}
	
	public ActionListener getMandelbrotListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.doMandelbrot(0,0,getModel().getImage().getWidth(),getModel().getImage().getHeight());
			}
		};
	}
	
	public ActionListener getAnimationStartButtonListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (timer != null ) {
					timer.stop();
				}
				timer = new Timer(10, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						model.performSierpinskiGameAnimation();
						
					}
				});
				timer.start();
				
			}
		};
	}
	
	public ActionListener getAnimationStopButtonListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 if (timer != null ) {
					 timer.stop();
				 }
				
			}
		};
	}
	
	public ActionListener getAnimationStepButtonListener() {
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 if (timer != null ) {
					 timer.stop();
				 }
				model.performSierpinskiGameAnimation();
			}
		};
	}
	
	
	public  class ClearImageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getModel().clearImage();
		}
	}
		
	
		
	public  class LoadImageListener implements ActionListener {

		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser jfc = new JFileChooser();
			int rueckgabeWert = jfc.showOpenDialog(null);
		    if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
		    	File f = jfc.getSelectedFile();
		    	getModel().loadImage(f);
		    }
			
		}
		
	}
	
	public class MyMouseDraggedListener extends MouseInputAdapter {
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
	         getModel().doMandelbrot(startX,startY,endX,endY);
	      }
	   }
}
