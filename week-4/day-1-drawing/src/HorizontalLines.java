import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class HorizontalLines {
  public static void mainDraw(Graphics graphics) {
    // Create a function that draws a single line and takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a 50 long horizontal line from that point.
    // Draw at least 3 lines with that function using a loop.

    createHorizontalLines(45, 80, graphics);
  }

  public static void createHorizontalLines (int inputX, int inputY, Graphics graphics) {
    Graphics2D g2d = (Graphics2D) graphics;
    g2d.setStroke(new BasicStroke(2));

    int lineLength = 50;
    int minDistanceX = 60;
    int minDistanceY = 20;
    for (int x = inputX; (x > 0) && (x < (WIDTH - lineLength)); x += (minDistanceX+Math.random()*100)) {
      for (int y = inputY; (y > 0) && (y < HEIGHT); y += (minDistanceY + Math.random()*100)) {
        graphics.drawLine(x, y, x + lineLength, y);
      }
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