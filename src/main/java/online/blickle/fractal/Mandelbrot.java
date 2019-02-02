package online.blickle.fractal;


	import java.awt.Graphics;
	import java.awt.image.BufferedImage;
	import javax.swing.JFrame;
	 
	public class Mandelbrot extends JFrame {
	 
	    private final int MAX_ITER = 300;
	    private final double ZOOM = 500;
	    private BufferedImage I;
	    private double zx, zy, cX, cY, tmp;
	 
	    public Mandelbrot() {
	        super("Mandelbrot Set");
	        setBounds(100, 100, 1000, 1000);
	        setResizable(false);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
	        for (int y = 0; y < getHeight(); y++) {
	            for (int x = 0; x < getWidth(); x++) {
	                zx = zy = 0;
	                cX = (x - 500) / ZOOM;
	                cY = (y - 350) / ZOOM;
	                int iter = MAX_ITER;
	                while (zx * zx + zy * zy < 4 && iter > 0) {
	                    tmp = zx * zx - zy * zy + cX;
	                    zy = 2.0 * zx * zy + cY;
	                    zx = tmp;
	                    iter--;
	                }
	                I.setRGB(x, y, 4*iter );
	                //I.setRGB(x, y, iter | (iter << 8));
	            }
	        }
	    }
	 
	    @Override
	    public void paint(Graphics g) {
	        g.drawImage(I, 0, 0, this);
	    }
	 
	    public static void main(String[] args) {
	        new Mandelbrot().setVisible(true);
	    }
	}

