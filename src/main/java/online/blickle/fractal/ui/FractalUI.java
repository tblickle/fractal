package online.blickle.fractal.ui;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import online.blickle.fractal.ui.MandelbrotController.MandelbrotMouseDraggedListener;

public class FractalUI extends JFrame {

	private SierpinskiAnimatedController sController;
	private FractalImageController fController;
	public FractalUI() {
		
		FractalImagePanel fPanel = new FractalImagePanel();
		fController = fPanel.getController();
		ImageModel iModel = fController.getModel();

		MandelbrotPanel mpanel = new MandelbrotPanel(iModel);
		MandelbrotController mCtrl = mpanel.getController();
		MandelbrotMouseDraggedListener listener = mCtrl.getMouseDragListener();
		fPanel.addMouseListener(listener);
		fPanel.addMouseMotionListener(listener);
		
		
		SierpinskiAnimatedPanel spanel = new SierpinskiAnimatedPanel(iModel);
		sController = spanel.getController();

		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		innerPanel.add(new CmdPanel());
		innerPanel.add(spanel);
		innerPanel.add(new ChaosGamePanel(iModel));
		innerPanel.add(new CopyMachinePanel(iModel));
		innerPanel.add(mpanel);

		JPanel basePanel = new JPanel(new BorderLayout());
		basePanel.add(innerPanel, BorderLayout.EAST);
		basePanel.add(fPanel, BorderLayout.WEST);

		add(basePanel);
		setTitle("Fractal App");
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] agrs) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new FractalUI();
			}
		});
	}

	class CmdPanel extends JPanel {
		public CmdPanel() {

			this.setBorder(new TitledBorder("Commands"));

			JButton l = new JButton("Load");
			l.addActionListener(fController.createLoadImageListener());
			this.add(l);

			JButton c = new JButton("Clear");
			c.addActionListener(fController.createClearImageListener());
			c.addActionListener(sController.getClearImageListender());
			this.add(c);
		}
	}

	
}
