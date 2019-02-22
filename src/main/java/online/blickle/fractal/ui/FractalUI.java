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
		MandelbrotPanel mpanel = new MandelbrotPanel(fc.getModel());
		FractalPanel fp = new FractalPanel(fc,mpanel.getController());
		setTitle("Fractal App");
		JPanel basePanel = new JPanel(new BorderLayout());
		JPanel innerPanel = new BasePanel(fc);
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
	
	static class BasePanel extends JPanel {
		public BasePanel(FractalUIController fc) {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			this.add(new CmdPanel(fc));
			this.add(new SpecialPanel(fc));
			this.add(new CopyPanel(fc));
			this.add(new ChaosPanel(fc));
			
		}
	}
	
	static class SpecialPanel  extends JPanel {
		public SpecialPanel(FractalUIController fc)		{
			
			this.setBorder(new TitledBorder("Sierpinski Animation"));
			
			JButton s = new JButton("Start Animation");
			s.addActionListener(fc.getAnimationStartButtonListener());
			this.add(s);
			
			JButton s2 = new JButton("Stop Animation");
			s2.addActionListener(fc.getAnimationStopButtonListener());
			this.add(s2);
			
			JButton s3 = new JButton("Step");
			s3.addActionListener(fc.getAnimationStepButtonListener());
			this.add(s3);
		}
	}
	
	static class CmdPanel extends JPanel {
		public CmdPanel(FractalUIController fc) {
			
			this.setBorder(new TitledBorder("Commands"));
			
			JButton l = new JButton("Load");
			l.addActionListener(fc.createLoadImageListener());
			this.add(l);
			
			JButton c = new JButton("Clear");
			c.addActionListener(fc.createClearImageListener());
			this.add(c);
			
			
		}
	}
	
		static class CopyPanel extends JPanel {
		public CopyPanel(FractalUIController fc) {
		
			this.setBorder(new TitledBorder("Fractal Copy Machine"));
			
			JButton s = new JButton("Sierpinski");
			s.addActionListener(fc.createSierpinskiCopyMachineListener());
			add(s);
			
			JButton f = new JButton("Farn");
			f.addActionListener(fc.createFranCopyMachineListener());
			add(f);
			
			JButton b = new JButton("Blatt");
			b.addActionListener(fc.createBlattCopyMachineListener());
			add(b);
			
			JButton k = new JButton("Koch");
			k.addActionListener(fc.createKochCopyMachineListener());
			add(k);
			
			JButton j = new JButton("Julia");
			j.addActionListener(fc.createJuliaCopyMachineListener());
			add(j);
			
		}
	}
	
	static class ChaosPanel extends JPanel {
		public ChaosPanel(FractalUIController fc) {
			this.setBorder(new TitledBorder("Chaos Game"));
			
			
			JButton s = new JButton("Sierpinski");
			s.addActionListener(fc.createSierpinskiChaosGameListener());
			add(s);
			
			JButton f = new JButton("Farn");
			f.addActionListener(fc.createFarnChaosGameListener());
			add(f);
			
			JButton b = new JButton("Blatt");
			b.addActionListener(fc.createBlattChaosGameListener());
			add(b);
			
			JButton k = new JButton("Koch");
			k.addActionListener(fc.createKochChaosGameListener());
			add(k);
			
			JButton j = new JButton("Julia");
			j.addActionListener(fc.createJuliaChaosGameListener());
			add(j);
			
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
