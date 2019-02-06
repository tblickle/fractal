package online.blickle.fractal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import online.blickle.fractal.ifs.IFSCalculator;
import online.blickle.fractal.ifs.IFSCopyMachine;

public class CopyMachineListner implements ActionListener{

	private FractalModel fm;
	private IFSCopyMachine copyMachine;
	
	public CopyMachineListner(FractalModel fm, IFSCalculator calculator) {
		this.fm = fm;
		this.copyMachine = new IFSCopyMachine(calculator);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fm.copyOnce(copyMachine);
	}
}
