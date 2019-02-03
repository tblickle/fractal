package online.blickle.fractal.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import online.blickle.fractal.ifs.IFSCalculator;
import online.blickle.fractal.ifs.IFSCopyMachine;
import online.blickle.fractal.view.FractalUI.FractalPanel;

public class CopyMachineListner implements ActionListener{

	private FractalPanel fp;
	private IFSCalculator calculator;
	private IFSCopyMachine copyMachine;
	
	public CopyMachineListner(FractalPanel fp, IFSCalculator calculator) {
		this.fp = fp;
		this.calculator = calculator;
		this.copyMachine = new IFSCopyMachine(calculator);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BufferedImage img =  fp.getImg();
		BufferedImage newImage = copyMachine.copyOnce(img);
		fp.setImg(newImage);
	}
}
