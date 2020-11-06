import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Random;

/**
 * The type Main panel.
 */
public class MainPanel extends JPanel{
   /**
    * The Data panel.
    */
   JPanel dataPanel;
   /**
    * The Button panel.
    */
   JPanel buttonPanel;
   /**
    * The Draw panel.
    */
   DrawPanel drawPanel;
   /**
    * The Rand.
    */
   Random rand;
   /**
    * The Number of circles t.
    */
   JTextField numberOfCirclesT;
   /**
    * The Radius min t.
    */
   JTextField radiusMinT;
   /**
    * The Radius max t.
    */
   JTextField radiusMaxT;

   /**
    * Instantiates a new Main panel.
    */
   public MainPanel(){
      rand = new Random();
      setLayout(new BorderLayout());
      buttonPanel = new JPanel();
      dataPanel = new JPanel();

      JButton createBtn = addButton("Create");
      createBtn.setPreferredSize(new Dimension(100, 510/4));

      JButton sortBtn = sortButton("Sort");
      sortBtn.setPreferredSize(new Dimension(100, 510/4));

      JButton coCentreBtn = coCenterButton("Co-Centre");
      coCentreBtn.setPreferredSize(new Dimension(100, 510/4));

      JButton resetBtn = resButton("Reset");
      resetBtn.setPreferredSize(new Dimension(100, 510/4));



      final int FIELD_WIDTH = 10;
      JLabel numberOfCircles = new JLabel("Number of Circles: ");
      this.numberOfCirclesT = new JTextField("5",FIELD_WIDTH);
      JLabel radiusMin = new JLabel("Radius of smallest circle: ");
      this.radiusMinT = new JTextField("10",FIELD_WIDTH);
      JLabel radiusMax = new JLabel("Radius of largest circle: ");
      this.radiusMaxT = new JTextField("50",FIELD_WIDTH);


      // labels and inputs
      dataPanel.add(numberOfCircles);
      dataPanel.add(numberOfCirclesT);
      dataPanel.add(radiusMin);
      dataPanel.add(radiusMinT);
      dataPanel.add(radiusMax);
      dataPanel.add(radiusMaxT);
      // buttons
      buttonPanel.add(createBtn);
      buttonPanel.add(sortBtn);
      buttonPanel.add(coCentreBtn);
      buttonPanel.add(resetBtn);

      // add to panels
      add(dataPanel, BorderLayout.NORTH);
      add(buttonPanel, BorderLayout.WEST);
      buttonPanel.setPreferredSize(new Dimension(100,550));
      
      drawPanel = new DrawPanel();
      add(drawPanel, BorderLayout.CENTER); 
   }

   private JButton addButton(String title){
      class CreateListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            int w = getWidth()+100;
            int h = getHeight();
            int numOfC = Integer.parseInt(numberOfCirclesT.getText());
            int min = Integer.parseInt(radiusMinT.getText());
            int max = Integer.parseInt(radiusMaxT.getText());
            for (int i=0; i<numOfC; i++){
               drawPanel.create(rand.nextInt(w),rand.nextInt(h),rand.nextInt(max)+min);
            }
         }            
      }
      JButton button = new JButton(title);
      button.addActionListener(new CreateListener());
      return button;
   }

   private JButton sortButton(String title){
      class CreateListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            drawPanel.sort();
         }
      }
      JButton button = new JButton(title);
      button.addActionListener(new CreateListener());
      return button;
   }

   private JButton coCenterButton(String title){
      class CreateListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            drawPanel.move();
         }
      }
      JButton button = new JButton(title);
      button.addActionListener(new CreateListener());
      return button;
   }

   private JButton resButton(String title){
      class DeleteListener implements ActionListener
      {
         public void actionPerformed(ActionEvent event)
         {
            drawPanel.reset();
            // Call repaint from outside.
            // Its effect is the same as call it from drawPanel
            drawPanel.repaint();
         } 

      }
      JButton button = new JButton(title);
      button.addActionListener(new DeleteListener());
      return button;
   }

}