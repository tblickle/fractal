package online.blickle.fractal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class FractalUIController {

	private FractalModel model;
	
	
	public FractalUIController() {
		this.model = new FractalModel();
	}
	
	
	public FractalModel getModel() {
		return this.model;
	}
	
	
	public ClearImageListener createClearImageListener() {
		return new ClearImageListener();
	}
	
	public LoadImageListener createLoadImageListener() {
		return new LoadImageListener();
	}
	
	public  class ClearImageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			model.clearImage();
		}
	}
		
	public  class LoadImageListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser jfc = new JFileChooser();
			int rueckgabeWert = jfc.showOpenDialog(null);
		    if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
		    	File f = jfc.getSelectedFile();
		    	model.loadImage(f);
		    }
			
		}
		
	}
	
}
