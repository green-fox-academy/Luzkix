import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ColoredBox {
  public static void mainDraw(Graphics graphics) {
    // Draw a box that has different colored lines on each edge.
    Graphics2D g2d = (Graphics2D) graphics;
    g2d.setStroke(new BasicStroke(100));

  int sizeOfBox = 150;
    graphics.setColor(Color.GREEN);
    graphics.drawLine(0,0, sizeOfBox,0);
    graphics.setColor(Color.RED);
    graphics.drawLine(sizeOfBox,0, sizeOfBox, sizeOfBox);
    graphics.setColor(Color.YELLOW);
    graphics.drawLine(sizeOfBox, sizeOfBox, 0, sizeOfBox);
    graphics.setColor(Color.BLUE);
    graphics.drawLine(0, sizeOfBox, 0,0);

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