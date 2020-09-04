import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Test {

  public static void mainDraw(Graphics graphics){

    Color rColor = Color.orange;//new Color (255,0,0);
    graphics.setColor(rColor);
    graphics.fillRect(0,0,WIDTH,HEIGHT);

    Color cc = Color.BLACK;
    graphics.setColor(cc);
    int startX = 10;
    int startY = 10;
    int len = 500;
    int height = 500;
    //graphics.drawOval(startX, startY, len, height); //generic circle - to be used later

    drawCirclesFunction(graphics, startX, startY, len, height, 2);
  }
  public static void drawCirclesFunction(Graphics graphics, int startX, int startY, int len, int height, int level) {
    if (level == 0) {
      return;
    } else {
      graphics.drawOval(startX, startY, len, height);
      drawCirclesFunction(graphics, startX+len/4, startY, len/2, height/2, level-1);
      drawCirclesFunction(graphics, startX, startY+height/3, len/2, height/2, level-1);
      drawCirclesFunction(graphics, startX+len/2, startY+height/3, len/2, height/2, level-1);
    }
  }

  // Don't touch the code below
  static int WIDTH = 520;
  static int HEIGHT = 520;
  static int HALF = WIDTH/2;
  static int ONETHIRD = WIDTH/3;
  static int TWOTHIRD = WIDTH/3*2;

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
