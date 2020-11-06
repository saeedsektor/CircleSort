import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Comparator;


/**
 * The Circle class describes a class defined by its centre and radius.
 */
public class Circle implements Comparator<Circle>
{
   /**
    * The constant PI.
    */
   public static final double PI = 3.14;
   private Point2D centre;
   private double radius;

   /**
    * Constructs a Circle.
    */
   public Circle()
   {
      centre = new Point2D();
      radius=1;

   }

   /**
    * Constructs a Circle and initialize
    *
    * @param x coordinate of the centre
    * @param y coordinate of the centre
    * @param r radius of the cirlce
    */
   public Circle(double x, double y, double r)
   {
      centre = new Point2D(x,y);
      radius = r;
   }

   /**
    * set the radius of the cirlce
    *
    * @param r radius of the circle
    */
   public void set(double r)
   {
      radius = r;
   }

   /**
    * returns the radius of the circle
    *
    * @return radius of the circle
    */
   public double getRadius()
   {
      return radius;
   }

   /**
    * move circle to the new coordinates
    *
    * @param x new coordinate of the centre
    * @param y new coordinate of the centre
    */
   public void move(double x, double y)
   {
      centre.move(x,y);
   }

   /**
    * Calculates and returns the area of the circle
    *
    * @return double area
    */
   public double getArea()
   {
      return radius*radius*PI;
   }

   /**
    * Calculates and returns the circumference of the circle
    *
    * @return double circumference
    */
   public double getCircumference ()
   {
      return 2*radius*PI;
   }
   /**
    override toString() method of the class
    */
   public String toString()
   {
      return "["+ centre.toString() +", r= " +radius+"]";
   }

   /**
    * draw circle using Graphics2D g2
    *
    * @param g2 the g 2
    */
   public void draw(Graphics2D g2)
   {
      Ellipse2D.Double c= new Ellipse2D.Double(centre.getX()-radius,centre.getY()-radius,2*radius,2*radius);
      g2.draw(c);
      g2.fill(c);
   }


   @Override
   public int compare(Circle o1, Circle o2) {

      if (o1.getRadius() > o2.getRadius())
         return -1;
      if (o1.getRadius() == o2.getRadius())
         return 0;

      return 1;
   }
}
