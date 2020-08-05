import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class _ForTestingPurposes {
  public static void mainDraw(Graphics graphics) {

    int numberOfSquares = 15;
    int startingXPosition = 10;
    int startingYPosition = 15;
    int initialSquareSize = 35;
    int squareSizeJump = 5;

    for (int i = 0; i < numberOfSquares; i++) {
      drawSingleSquare(startingXPosition, startingYPosition, initialSquareSize, graphics);
      startingXPosition += initialSquareSize;
      startingYPosition += initialSquareSize;
      initialSquareSize += squareSizeJump;
    }
  }

  private static void drawSingleSquare(int startingXPosition, int startingYPosition, int size, Graphics graphics) {
    graphics.setColor(Color.MAGENTA);
    graphics.fill3DRect(startingXPosition, startingYPosition, size, size, true);
  }

  // Don't touch the code below
  static int WIDTH = 720;
  static int HEIGHT = 720;

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