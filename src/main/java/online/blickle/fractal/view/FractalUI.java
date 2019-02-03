package online.blickle.fractal.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import online.blickle.fractal.ifs.IFSCopyMachine;
import online.blickle.fractal.ifs.affine.Blatt;
import online.blickle.fractal.ifs.affine.Farn;
import online.blickle.fractal.ifs.affine.Koch;
import online.blickle.fractal.ifs.affine.Sierpinski;

public class FractalUI extends JFrame{

	FractalPanel fp;
	
	public FractalUI() {
		fp= new FractalPanel();
		setTitle("Fractal App");
		JPanel basePanel = new JPanel(new BorderLayout());
		basePanel.add(new BasePanel(fp),BorderLayout.NORTH);
		
		
		basePanel.add(fp,BorderLayout.SOUTH);
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
	
	public static class BasePanel extends JPanel {
		public BasePanel(FractalPanel fp) {
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

			
			this.add(new CmdPanel(fp));
			this.add(new CopyPanel(fp));
			this.add(new ChaosPanel(fp));
				
		}
	}
	
	
	public static class CmdPanel extends JPanel {
		public CmdPanel(FractalPanel fp) {
			JButton l = new JButton("Load");
			l.addActionListener(new LoadImageListener(fp));
			this.add(l);
			
			JButton c = new JButton("Clear");
			c.addActionListener(new ClearImageListener(fp));
			this.add(c);
			
		}
	}
	
	public static class CopyPanel extends JPanel {
		public CopyPanel(FractalPanel fp) {
			
			add(new JLabel("Fractal Copy Machine:"));
			JButton s = new JButton("Sierpinski");
			s.addActionListener(new CopyMachineListner(fp, new Sierpinski()));
			add(s);
			
			JButton f = new JButton("Farn");
			f.addActionListener(new CopyMachineListner(fp, new Farn()));
			add(f);
			
			JButton b = new JButton("Blatt");
			b.addActionListener(new CopyMachineListner(fp, new Blatt()));
			add(b);
			
			JButton k = new JButton("Koch");
			k.addActionListener(new CopyMachineListner(fp, new Koch()));
			add(k);
		}
	}
	
	public static class ChaosPanel extends JPanel {
		public ChaosPanel(FractalPanel fp) {
			
			add(new JLabel("Fractal Chaos Game:"));
			JButton s = new JButton("Sierpinski");
			s.addActionListener(new ChaosGameListener(fp, new Sierpinski()));
			add(s);
			
			JButton f = new JButton("Farn");
			f.addActionListener(new ChaosGameListener(fp, new Farn()));
			add(f);
			
			JButton b = new JButton("Blatt");
			b.addActionListener(new ChaosGameListener(fp, new Blatt()));
			add(b);
			
			JButton k = new JButton("Koch");
			k.addActionListener(new ChaosGameListener(fp, new Koch()));
			add(k);
		}
	}
	
	public static class ClearImageListener implements ActionListener {

		private FractalPanel fp;
		public ClearImageListener(FractalPanel fp) {
			this.fp = fp;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			fp.clearImage();
		}
	}
		
	
		
	public static class LoadImageListener implements ActionListener {

		private FractalPanel fp;
		public LoadImageListener(FractalPanel fp) {
			this.fp = fp;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			int rueckgabeWert = fc.showOpenDialog(null);
		    if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
		    	File f = fc.getSelectedFile();
		    	fp.loadImage(f);
		    }
			
		}
		
	}
	
	public static class FractalPanel extends JPanel {
		
		private static int PREF_SIZE = 800;
		private BufferedImage img;
		public FractalPanel() {
			
	        loadImage(new File("resources/gk.png"));
		}
		
		public void loadImage(File file) {
			try {
	        	img = ImageIO.read(file);
	        	int width = img.getWidth();
	        	double ratio = (double)PREF_SIZE /(double)width;
	        	AffineTransform tx = new AffineTransform();
	            tx.scale(ratio, ratio);

	            AffineTransformOp op = new AffineTransformOp(tx,
	                AffineTransformOp.TYPE_BILINEAR);
	            img = op.filter(img, null);
	            
	           
	        } catch (Exception e){
	        	
	        }
	        
	        setPreferredSize(new Dimension(img.getWidth(), img.getHeight()));
	        this.invalidate();
			this.repaint();
		}
		@Override
		public void paintComponent(Graphics g)  {
			g.drawImage(img, 0, 0, null);
		}
		
		public BufferedImage getImg() {
			return img;
		}
		public void setImg(BufferedImage img) {
			this.img = img;
			this.invalidate();
			this.repaint();
		}
		
		public void clearImage() {
			Graphics2D    graphics = img.createGraphics();
			graphics.setPaint ( new Color ( 255,255,255 ) );
			graphics.fillRect ( 0, 0, img.getWidth(), img.getHeight() );
			this.invalidate();
			this.repaint();
		}
				
	}
}
