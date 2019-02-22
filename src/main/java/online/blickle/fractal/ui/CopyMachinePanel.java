package online.blickle.fractal.ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class CopyMachinePanel extends JPanel {
	
	CopyMachineController ctrl;
	
	public CopyMachinePanel(ImageModel iModel) {
		this.ctrl = new CopyMachineController(iModel);
		
		this.setBorder(new TitledBorder("Fractal Copy Machine"));
		
		JButton s = new JButton("Sierpinski");
		s.addActionListener(ctrl.createSierpinskiCopyMachineListener());
		add(s);
		
		JButton f = new JButton("Farn");
		f.addActionListener(ctrl.createFarnCopyMachineListener() );
		add(f);
		
		JButton b = new JButton("Blatt");
		b.addActionListener(ctrl.createBlattCopyMachineListener());
		add(b);
		
		JButton k = new JButton("Koch");
		k.addActionListener(ctrl.createKochCopyMachineListener());
		add(k);
		
		JButton j = new JButton("Julia");
		j.addActionListener(ctrl.createJuliaCopyMachineListener());
		add(j);
	}
}