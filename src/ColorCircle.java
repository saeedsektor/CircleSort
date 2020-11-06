import java.awt.*;
import java.util.Random;

/**
 * The type Color circle.
 */
public class ColorCircle extends Circle{

    private Color color;

    /**
     * Instantiates a new Color circle.
     *
     * @param x the x
     * @param y the y
     * @param r the r
     */
    public ColorCircle(double x, double y, double r){
        super(x, y, r);
        Random rand = new Random();
        int red,blue,green;
        red = rand.nextInt(255);
        blue = rand.nextInt(255);
        green = rand.nextInt(255);
        this.color = new Color(red,blue,green);

    }

    /**
     * Fill.
     *
     * @param g2 the g 2
     */
    public void fill(Graphics2D g2){
        g2.setColor(this.color);

    }
}
