package online.blickle.fractal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import online.blickle.fractal.ifs.IFSCalculator;
import online.blickle.fractal.ifs.IFSChaosGame;
import online.blickle.fractal.ifs.affine.Blatt;
import online.blickle.fractal.ifs.affine.Farn;
import online.blickle.fractal.ifs.affine.Koch;
import online.blickle.fractal.ifs.affine.Sierpinski;
import online.blickle.fractal.ifs.complex.Julia;

public class ChaosGameController {

	private ImageModel iModel;
	public ChaosGameController(ImageModel imodel) {
		this.iModel =imodel;
	}
	
	public ChaosGameListener createSierpinskiChaosGameListener() {
		return new ChaosGameListener( new Sierpinski());
	}
	
	public ChaosGameListener createKochChaosGameListener() {
		return new ChaosGameListener( new Koch());
	}
	
	public ChaosGameListener createBlattChaosGameListener() {
		return new ChaosGameListener( new Blatt());
	}
	
	public ChaosGameListener createFarnChaosGameListener() {
		return new ChaosGameListener( new Farn());
	}
	
	public ChaosGameListener createJuliaChaosGameListener() {
		return new ChaosGameListener( new Julia());
	}
	
	public class ChaosGameListener implements ActionListener{

		private IFSChaosGame chaosGame;
		
		public ChaosGameListener(IFSCalculator calculator) {
			this.chaosGame = new IFSChaosGame(calculator);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
				iModel.setImage(chaosGame.performSteps(iModel.getImage(), 1000));
			}
		}
	}
