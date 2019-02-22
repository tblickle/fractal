package online.blickle.fractal.ui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class SierpinskiAnimatedPanel extends JPanel {
	
	private SierpinskiAnimatedController sController;
	public SierpinskiAnimatedPanel(ImageModel iModel)		{
		
		this.sController = new SierpinskiAnimatedController(iModel);
		
		this.setBorder(new TitledBorder("Sierpinski Animation"));
		
		JButton s = new JButton("Start Animation");
		s.addActionListener(sController.getAnimationStartButtonListener());
		this.add(s);
		
		JButton s2 = new JButton("Stop Animation");
		s2.addActionListener(sController.getAnimationStopButtonListener());
		this.add(s2);
		
		JButton s3 = new JButton("Step");
		s3.addActionListener(sController.getAnimationStepButtonListener());
		this.add(s3);
	}
	
	public SierpinskiAnimatedController getController() {
		return sController;
	}
}