import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.util.Collection;


/**
 * The type Draw panel.
 */
public class DrawPanel extends JPanel{
   /**
    * The Circles.
    */
   ArrayList<ColorCircle> circles;

   /**
    * Instantiates a new Draw panel.
    */
   public DrawPanel(){
       circles = new ArrayList<ColorCircle>();
   }

   /**
    * Create.
    *
    * @param x the x
    * @param y the y
    * @param r the r
    */
   public void create(double x, double y, double r){
      circles.add(new ColorCircle(x,y,r));
      // call repaint from the JPanel
      repaint();
   }


   public void paintComponent(Graphics g)
   {  
      // Important call super.paintComponent(g) first in this case
      // Be careful not to fall in recursion
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;

      for(ColorCircle c : circles){
         c.fill(g2);
         c.draw(g2);
      }

   }

   /**
    * Sort circles in descending order.
    */
   public void sort() {
      // sorts the objects
      for(int i=0; i<circles.size(); i++){
         circles.sort(circles.get(i));
      }
      repaint();
   }

   /**
    * Move or Co-Centre the circles.
    */
   public void move() {
      for (ColorCircle c: circles){
         c.move(getHeight()/2+100, getWidth()/2-100);
      }
      repaint();
   }

   /**
    * Reset all circles.
    */
   public void reset() {
      // resets the ArrayList
      circles.removeAll(circles);
      repaint();
   }

}