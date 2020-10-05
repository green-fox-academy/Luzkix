import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenteredSquare {

  public static void mainDraw(Graphics graphics) {
    // Draw a green 10x10 square to the canvas' center.
    Graphics2D g2d = (Graphics2D) graphics;
    g2d.setStroke(new BasicStroke(3));

    int squareSize = 10;
    int positionX = (WIDTH - squareSize) / 2;
    int positionY = (HEIGHT - squareSize) / 2;
    graphics.setColor(Color.GREEN);

    graphics.drawRect(positionX, positionY, squareSize, squareSize);

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