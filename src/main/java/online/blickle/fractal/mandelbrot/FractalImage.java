package online.blickle.fractal.mandelbrot;

import java.awt.Color;
import java.awt.image.BufferedImage;

import online.blickle.fractal.data.CanvasMapper;
import online.blickle.fractal.data.FCoordinate;
import online.blickle.fractal.data.FPixel;

public class FractalImage extends BufferedImage{

	private Color[] colorPalette = {ColorEnum.LIGHT_RED.getColor(), ColorEnum.RED.getColor(),ColorEnum.DARK_RED.getColor(),
			ColorEnum.LIGHT_GREEN.getColor(), ColorEnum.GREEN.getColor(), ColorEnum.DARK_GREEN.getColor(),
			ColorEnum.LIGHT_BLUE.getColor(), ColorEnum.BLUE.getColor(), ColorEnum.DARK_BLUE.getColor(),
			ColorEnum.LIGHT_ORANGE.getColor(), ColorEnum.ORANGE.getColor(), ColorEnum.DARK_ORANGE.getColor(),
			ColorEnum.LIGHT_YELLOW.getColor(), ColorEnum.YELLOW.getColor(), ColorEnum.DARK_YELLOW.getColor(),
			ColorEnum.LIGHT_PURPLE.getColor(), ColorEnum.PURPLE.getColor(), ColorEnum.DARK_PURPLE.getColor()};
	
	
	public FractalImage(int width, int height, int imageType) {
		super(width,height,imageType);
	}
	
	public void generate(FractalFunction func, FCoordinate lowerLeft, FCoordinate upperRight) {
		
		CanvasMapper mapper = new CanvasMapper(getWidth(), getHeight(), lowerLeft,upperRight);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
            	FCoordinate currVal = mapper.map(new FPixel(x, y));
                int iter = func.compute(currVal);
                int color = 0;
                if (iter > 0 ) {
                  color= (colorPalette[iter % colorPalette.length]).getRGB();
                }
                this.setRGB(x, y, color );
            }
        }
	}
	
	public static enum ColorEnum
    {
        LIGHT_RED(255,0,0), RED(192,0,0), DARK_RED(128,0,0),
        LIGHT_GREEN(0,255,0), GREEN(0,192,0), DARK_GREEN(0,128,0),
        LIGHT_BLUE(0,0,255), BLUE(0,0,192), DARK_BLUE(0,0,128),
        LIGHT_ORANGE(255,102,0), ORANGE(255,102,0), DARK_ORANGE(192,88,0),
        LIGHT_YELLOW(255,204,0), YELLOW(255,204,0), DARK_YELLOW(192,150,0),
        LIGHT_PURPLE(136,0,182), PURPLE(102,0,153), DARK_PURPLE(78,0,124);

        private int red;
        private int green;
        private int blue;

        private ColorEnum(int r, int g, int b)
        {
            this.red = r;
            this.green = g;
            this.blue = b;
        }

        /**
         * Get the selected color object for this Enum.
         * @return The color description as a Color object.
         */
        public Color getColor()
        {
            // WANT TO RETURN A COLOR BASED ON currentScheme
            return new Color(red, green, blue);
        }
    }
}
