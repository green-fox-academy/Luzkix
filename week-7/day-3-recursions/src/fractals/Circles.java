package fractals;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Circles {

  public static void mainDraw(Graphics graphics){
    Color lightGreen = new Color(144,238,144);
    graphics.setColor(lightGreen);
    graphics.fillRect(0,0,WIDTH,HEIGHT);

    graphics.setColor(Color.black);
    double x = 0;
    double y= 0;
    double width = 500;
    double height = 500;

    //graphics.drawOval((int)x, (int)y, (int)width, (int)height); //not necessary now

    drawFractalOvals(graphics, (int)x, (int)y, (int)width, (int)height, 5);

  }

  public static void drawFractalOvals(Graphics graphics, double x, double y, double width, double height, int level) {
    if (level == 0) {
      return;
    } else {
      graphics.drawOval((int)x, (int)y, (int)width, (int)height); //initial circle
      drawFractalOvals(graphics, x + width/4, y, width/2, height/2, level -1);//top circle
      drawFractalOvals(graphics, x + width/32, y + height/3 + height/32, width/2, height/2, level -1);//left circle
      drawFractalOvals(graphics, x + width/2 - width/32, y + height/3 + height/32, width/2, height/2, level -1);//right circle

    }

  }

  // Don't touch the code below
  static int WIDTH = 500;
  static int HEIGHT = 500;
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
