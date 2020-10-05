import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class PositionSquare {

  public static void mainDraw(Graphics graphics) {
    // create a function that draws one square and takes 3 parameters:
    // the x and y coordinates of the square's top left corner and the graphics
    // and draws a 50x50 square from that point.
    // draw 3 squares with that function.
    // avoid code duplication.

    drawSquare(20, 20, graphics);

  }

  public static void drawSquare(int xCor, int yCor, Graphics graphics) {
    Graphics2D g2d = (Graphics2D) graphics;
    g2d.setStroke(new BasicStroke(20));


    int boxesDistance = 100;
    int boxSize = 50;
    for (int i = 0; i < 4; i++) {
      graphics.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255),
          (int) (Math.random() * 255)));
      graphics.drawRect(xCor + i * boxesDistance, yCor + i * boxesDistance, boxSize, boxSize);
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