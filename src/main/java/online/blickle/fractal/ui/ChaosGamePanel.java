package online.blickle.fractal.ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ChaosGamePanel extends JPanel {
	
	ChaosGameController ctrl;
	
	public ChaosGamePanel(ImageModel iModel) {
		this.ctrl = new ChaosGameController(iModel);
		
		this.setBorder(new TitledBorder("Chaos Game"));
		
		
		JButton s = new JButton("Sierpinski");
		s.addActionListener(ctrl.createSierpinskiChaosGameListener());
		add(s);
		
		JButton f = new JButton("Farn");
		f.addActionListener(ctrl.createFarnChaosGameListener());
		add(f);
		
		JButton b = new JButton("Blatt");
		b.addActionListener(ctrl.createBlattChaosGameListener());
		add(b);
		
		JButton k = new JButton("Koch");
		k.addActionListener(ctrl.createKochChaosGameListener());
		add(k);
		
		JButton j = new JButton("Julia");
		j.addActionListener(ctrl.createJuliaChaosGameListener());
		add(j);
		
	}
}