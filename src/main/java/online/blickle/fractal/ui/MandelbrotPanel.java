package online.blickle.fractal.ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MandelbrotPanel extends JPanel {
	
	private MandelbrotController mc;
	
	public MandelbrotPanel(ImageModel im) {
		this.mc = new MandelbrotController(im);
		
		this.setBorder(new TitledBorder("Mandelbrot"));
		
		
		JButton m = new JButton("Mandelbrot");
		m.addActionListener(mc.getMandelbrotListener());
		this.add(m);
	}
	
	public MandelbrotController getController() {
		return mc;
	}
}