package online.blickle.fractal.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.omg.PortableServer.ServantLocatorPackage.CookieHolder;

import online.blickle.fractal.Mandelbrot;
import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.data.FPixel;
import online.blickle.fractal.ifs.IFSCopyMachine;
import online.blickle.fractal.ifs.IFSImage;
import online.blickle.fractal.ifs.IteratedFunction;
import online.blickle.fractal.ifs.Sierpinski;

public class FScreen extends JFrame {
	 
    private BufferedImage FI;
   
 
    int pixelX=800;
    int pixelY=800;
    
    public FScreen() {
        super("Fractal Viewer");
        
        BufferedImage img=null;
        try {
        	img = ImageIO.read(new File("gk.png"));
        } catch (Exception e){
        	
        }
        
        IFSCopyMachine cp = new IFSCopyMachine(img,new Sierpinski());
        cp.copyOnce();
        cp.copyOnce();
        FI = cp.getImage();
        setBounds(0, 0, FI.getWidth(), FI.getHeight());
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        /*
        FI = new FractalImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        FractalFunction f = new online.blickle.fractal.view.Mandelbrot();
        FI.generate(f, new FCoordinate(-2, -1.5), new FCoordinate(1, 1.5));
        */
        /*
        IFSImage IF = new IFSImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        IF.generate(new Sierpinski(), new FCoordinate(-0.1, -0.1), new FCoordinate(1.1, 1.1));
        FI=IF;
        */
    }

	 
    @Override
    public void paint(Graphics g) {
        g.drawImage(FI, 0, 0, this);
    }
 
    public static void main(String[] args) {
    	long start = System.currentTimeMillis();
    	FScreen f = new FScreen();
    	long duration = System.currentTimeMillis() -start;
        f.setVisible(true);
        System.out.println("Duration "+duration);
    }
}