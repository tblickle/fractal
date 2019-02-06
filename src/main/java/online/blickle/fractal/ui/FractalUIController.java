package online.blickle.fractal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import online.blickle.fractal.ifs.affine.Blatt;
import online.blickle.fractal.ifs.affine.Farn;
import online.blickle.fractal.ifs.affine.Koch;
import online.blickle.fractal.ifs.affine.Sierpinski;

public class FractalUIController {

	private FractalModel model;
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
	
	public ClearImageListener createClearImageListener() {
		return new ClearImageListener();
	}
	
	public LoadImageListener createLoadImageListener() {
		return new LoadImageListener();
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
}
