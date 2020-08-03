import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class _ForTestingPurposes {

  public static void mainDraw(Graphics graphics){
    Color mainColor = new Color(0, 255, 0, 100);
    Color diagonalColor = new Color(0, 9, 255, 100);

    int size = 50;
    int circleWidth = 100;
    int margin = 5;
    int columnCount = (WIDTH + margin) / (size + margin);
    int rowCount = (HEIGHT + margin) / (size + margin);

    graphics.setColor(diagonalColor);
    graphics.drawLine(0, size / 2, WIDTH, size / 2);
    graphics.fillOval((WIDTH - circleWidth) / 2, (HEIGHT - circleWidth) / 2, circleWidth, circleWidth);

    for (int j = 0; j < rowCount; j++) {
      for (int i = 0; i < columnCount; i++) {
        if (i == j || i == columnCount - j - 1) {
          graphics.setColor(diagonalColor);
        } else {
          graphics.setColor(mainColor);
        }
        graphics.fillRect(i * (size + margin), j * (size + margin), size, size);
      }
    }

  }

  // Don't touch the code below
  static int WIDTH = 600;
  static int HEIGHT = 600;

  public static void main(String[] args) {
    JFrame jFrame = new JFrame("Material Review");
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