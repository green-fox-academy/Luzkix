import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MiddleLines {
  public static void mainDraw(Graphics graphics){
    // draw a red horizontal line to the canvas' middle.
    // draw a green vertical line to the canvas' middle.
  graphics.setColor(Color.RED);
  int horizontalPositionOfLine = HEIGHT/2;
  int verticalPositionOfLine = WIDTH/2;
  graphics.drawLine(0,horizontalPositionOfLine,WIDTH,horizontalPositionOfLine);

  graphics.setColor(Color.GREEN);
  graphics.drawLine(verticalPositionOfLine,0,verticalPositionOfLine,HEIGHT);

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