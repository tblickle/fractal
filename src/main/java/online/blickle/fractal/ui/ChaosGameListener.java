package online.blickle.fractal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import online.blickle.fractal.ifs.IFSCalculator;
import online.blickle.fractal.ifs.IFSChaosGame;

public class ChaosGameListener implements ActionListener{

	private FractalModel fm;
	private IFSChaosGame chaosGame;
	
	public ChaosGameListener(FractalModel fm, IFSCalculator calculator) {
		this.fm = fm;
		this.chaosGame = new IFSChaosGame(calculator);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		fm.performChaosSteps(chaosGame, 1000);;
	}
}
