import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FunctionToCenter {
  public static void mainDraw(Graphics graphics) {
    // Create a function that draws a single line and takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a line from that point to the center of the canvas.
    // Fill the canvas with lines from the edges, every 20 px, to the center.

    goToTheCenter(25, 35, Color.GREEN, graphics);

    int topEdgeX = 0;
    int bottomEdgeX = 0;
    int leftEdgeY = 0;
    int rightEdgeY = 0;

    for (int topEdge = 0; topEdge < WIDTH / 20; topEdge++) {
        goToTheCenter(topEdgeX, 0, Color.RED, graphics);
        topEdgeX += 20;
      }

    for (int bottomEdge = 0; bottomEdge < WIDTH / 20; bottomEdge++) {
      goToTheCenter(bottomEdgeX, HEIGHT, Color.RED, graphics);
      bottomEdgeX += 20;
    }

    for (int leftEdge = 0; leftEdge < HEIGHT / 20; leftEdge++) {
      goToTheCenter(0, leftEdgeY, Color.BLACK, graphics);
      leftEdgeY += 20;
    }

    for (int rightEdge = 0; rightEdge <= HEIGHT / 20; rightEdge++) {
      goToTheCenter(WIDTH, rightEdgeY, Color.BLACK, graphics);
      rightEdgeY += 20;
    }

  }

  public static void goToTheCenter(int xCord, int yCord, Color myColor, Graphics graphics) {
    Graphics2D g2d = (Graphics2D) graphics;
    g2d.setStroke(new BasicStroke(2));
    graphics.setColor(myColor);
    int centerWidth = WIDTH / 2;
    int centerHeight = HEIGHT / 2;
    graphics.drawLine(xCord, yCord, centerWidth, centerHeight);
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