package online.blickle.fractal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

public class FractalImageController {

	private FractalImageModel model;
	
	public FractalImageController() {
		this.model = new FractalImageModel();
	}
	
	public FractalImageModel getModel() {
		return this.model;
	}
	
	public ActionListener createClearImageListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				model.clearImage();
			}
		};
	}
	
	public ActionListener createLoadImageListener() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				int rueckgabeWert = jfc.showOpenDialog(null);
			    if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
			    	File f = jfc.getSelectedFile();
			    	model.loadImage(f);
			    }
			}
		};
	}
	
}
