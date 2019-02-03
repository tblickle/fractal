package online.blickle.fractal.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import online.blickle.fractal.ifs.IFSCalculator;
import online.blickle.fractal.ifs.IFSChaosGame;
import online.blickle.fractal.ifs.IFSCopyMachine;
import online.blickle.fractal.view.FractalUI.FractalPanel;

public class ChaosGameListener implements ActionListener{

	private FractalPanel fp;
	private IFSCalculator calculator;
	private IFSChaosGame chaosGame;
	
	public ChaosGameListener(FractalPanel fp, IFSCalculator calculator) {
		this.fp = fp;
		this.calculator = calculator;
		this.chaosGame = new IFSChaosGame(calculator);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		BufferedImage img = fp.getImg();
		this.chaosGame.performSteps(img, 1000);
		fp.setImg(img);
		
	}
	

}
