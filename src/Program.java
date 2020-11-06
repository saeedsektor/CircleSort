import javax.swing.JFrame;

/**
 * This program displays the growth of an investment.
 */
public class Program
{
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args)
  {  
    JFrame frame = new JFrame();
    frame.add(new MainPanel());

    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
  private static final int FRAME_WIDTH = 800;
  private static final int FRAME_HEIGHT = 600;
}
   