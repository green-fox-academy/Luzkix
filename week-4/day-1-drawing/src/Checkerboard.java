import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Checkerboard {
  public static void mainDraw(Graphics graphics) {
    // Fill the canvas with a checkerboard pattern.

    int numberOfSquares = 8;
    int boxsize = WIDTH / numberOfSquares;

    for (int j = 0; j < numberOfSquares; j++) {
      for (int i = 0; i < numberOfSquares; i++) {
        if (j % 2 == 0) {
          if (i % 2 != 0) {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(i * boxsize, j * boxsize, boxsize, boxsize);
          }
        }
        if (j % 2 != 0) {
          if (i % 2 == 0) {
            graphics.setColor(Color.BLACK);
            graphics.fillRect(i * boxsize, j * boxsize, boxsize, boxsize);
          }
        }
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