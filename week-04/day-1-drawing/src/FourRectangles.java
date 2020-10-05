import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FourRectangles {

  public static void mainDraw(Graphics graphics){
    // draw four different size and color rectangles.
    // avoid code duplication.

    //Solution using random color and random sizes including random positions - everything random :-)
    Graphics2D g2d = (Graphics2D) graphics;
    g2d.setStroke(new BasicStroke(3));

    for (int i = 0; i < 4; i++ ) {
      //defining random color
      int r = (int) (Math.random() * 255);
      int g = (int) (Math.random() * 255);
      int b = (int) (Math.random() * 255);
      Color randomcolor = new Color(r, g, b);
      //defining random sizes
      int randomX = (int) (Math.random() * WIDTH / 2);
      int randomY = (int) (Math.random() * HEIGHT / 2);
      int randomWidth = (int) (Math.random() * WIDTH / 2);
      int randomHeight = (int) (Math.random() * HEIGHT / 2);

      graphics.setColor(randomcolor);
      graphics.drawRect(randomX, randomY, randomWidth, randomHeight);
    }


  }

  // Don't touch the code below
  static int WIDTH = 320;
  static int HEIGHT = 320;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Drawing");
    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    ImagePanel panel = new ImagePanel();
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
    jFrame.add(panel);
    jFrame.setLocationRelativeTo(null);
    jFrame.setVisible(true);
    jFrame.pack();
  }

  static class ImagePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics graphics) {
      super.paintComponent(graphics);
      mainDraw(graphics);
    }
  }
}