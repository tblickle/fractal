package online.blickle.fractal.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

import online.blickle.fractal.ui.MandelbrotController.MandelbrotMouseDraggedListener;


public class FractalUI extends JFrame{

	
	public FractalUI() {
		FractalUIController fc = new FractalUIController();
		ImageModel iModel = fc.getModel();
		MandelbrotPanel mpanel = new MandelbrotPanel(iModel);
		SierpinskiAnimatedPanel spanel = new SierpinskiAnimatedPanel(iModel);
		SierpinskiAnimatedController sController = spanel.getController();
				
		FractalPanel fp = new FractalPanel(fc,mpanel.getController());
		
		setTitle("Fractal App");
		JPanel basePanel = new JPanel(new BorderLayout());
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
		innerPanel.add(new CmdPanel(fc, sController));
		innerPanel.add(spanel);
		innerPanel.add(new ChaosGamePanel(iModel));
		innerPanel.add(new CopyMachinePanel(iModel));
		innerPanel.add(mpanel);
		
	
		basePanel.add(innerPanel,BorderLayout.EAST);
		basePanel.add(fp,BorderLayout.WEST);
		
		add(basePanel);
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
	
		
	static class CmdPanel extends JPanel {
		public CmdPanel(FractalUIController fc, SierpinskiAnimatedController sc) {
			
			this.setBorder(new TitledBorder("Commands"));
			
			JButton l = new JButton("Load");
			l.addActionListener(fc.createLoadImageListener());
			this.add(l);
			
			JButton c = new JButton("Clear");
			c.addActionListener(fc.createClearImageListener());
			c.addActionListener(sc.getClearImageListender());
			this.add(c);
			
			
		}
	}
	
	
	
	static class FractalPanel extends JPanel implements Observer{
		
		private FractalModel fm;
		public FractalPanel(FractalUIController fc, MandelbrotController mc) {
			this.fm=fc.getModel();
			fm.addObserver(this);
			setPreferredSize(new Dimension(fm.getImage().getWidth(),fm.getImage().getHeight()));
			MandelbrotMouseDraggedListener listener = mc.getMouseDragListener();
		    addMouseListener(listener);
		    addMouseMotionListener(listener);
		    fm.clearImage();
		}
		@Override
		public void paintComponent(Graphics g)  {
			g.drawImage(fm.getImage(), 0, 0, null);
		}

		@Override
		public void update(Observable o, Object arg) {
			this.setPreferredSize(new Dimension(fm.getImage().getWidth(),fm.getImage().getHeight()));
			this.invalidate();
			this.repaint();
			
		}
				
	}
}
