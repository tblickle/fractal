package online.blickle.fractal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import online.blickle.fractal.ifs.IFSCalculator;
import online.blickle.fractal.ifs.IFSCopyMachine;
import online.blickle.fractal.ifs.affine.Blatt;
import online.blickle.fractal.ifs.affine.Farn;
import online.blickle.fractal.ifs.affine.Koch;
import online.blickle.fractal.ifs.affine.Sierpinski;
import online.blickle.fractal.ifs.complex.Julia;

public class CopyMachineController {
	
	private ImageModel iModel;
	public CopyMachineController(ImageModel imodel) {
		this.iModel =imodel;
	}

	public CopyMachineListner createSierpinskiCopyMachineListener() {
		return new CopyMachineListner( new Sierpinski());
	}
	
	public CopyMachineListner createFarnCopyMachineListener() {
		return new CopyMachineListner( new Farn());
	}
	
	public CopyMachineListner createBlattCopyMachineListener() {
		return new CopyMachineListner( new Blatt());
	}
	
	public CopyMachineListner createKochCopyMachineListener() {
		return new CopyMachineListner( new Koch());
	}
	
	public CopyMachineListner createJuliaCopyMachineListener() {
		return new CopyMachineListner( new Julia());
	}
	
	public class CopyMachineListner implements ActionListener{

		private IFSCopyMachine copyMachine;
		
		public CopyMachineListner( IFSCalculator calculator) {
			
			this.copyMachine = new IFSCopyMachine(calculator);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			iModel.setImage(copyMachine.copyOnce(iModel.getImage()));
		}
	}

}
