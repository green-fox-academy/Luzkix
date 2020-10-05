import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Test {
  public static void mainDraw(Graphics graphics) {
    int h = (int) ((Math.sqrt(3)/2)*320);
    graphics.setColor(Color.BLUE);
    graphics.drawLine(0,1,320,1);
    graphics.drawLine(0,1,160,h);
    graphics.drawLine(320,1,160,h);
  }
  public static void drawTriangle (Graphics graphics,int x, int y, int size){
    int h = (int) ((Math.sqrt(3)/2)*size);
    graphics.setColor(Color.BLUE);
    graphics.drawLine(x,y,x - (size/2),y+h);  //left side
    graphics.setColor(Color.RED);
    graphics.drawLine(x,y,x+ (size/2),y+h);           //right side
    graphics.setColor(Color.GREEN);
    graphics.drawLine(x-(size/2),y+h,x+(size/2),y+h);//bottom
    if (size>=10) {
      drawTriangle(graphics, (x - size/2), y, size / 2);
      drawTriangle(graphics, (x + size/2), y, size/2);
      drawTriangle(graphics, x,y+h, size/2);
    }
  }



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
      drawTriangle(graphics, 160, 1, 160);
    }
  }
}