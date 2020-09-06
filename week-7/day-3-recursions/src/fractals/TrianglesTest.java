package fractals;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class TrianglesTest {

  public static void mainDraw(Graphics graphics){
    Color lightGreen = new Color(144,238,144);
    graphics.setColor(lightGreen);
    graphics.fillRect(0,0,WIDTH,HEIGHT);

    graphics.setColor(Color.black);

    int x1 = 0; //top left x
    int y1 = 0; //top left y
    int x2 = WIDTH; //top right x
    int y2 = 0; //top right y
    int x3 = WIDTH/2; //bottom x
    int y3 = HEIGHT; //bottom y

    /* test triangles - for setting and verification of corectness of coordinates:
    Polygon outerTriangle = new Polygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
    Polygon triangleLeft = new Polygon(new int[] {x1, x2/2, x3/2}, new int[] {y1, y2, y3/2}, 3);
    Polygon triangleRight = new Polygon(new int[] {x1+x2/2, x2, x3 + x3/2}, new int[] {y1, y2, y3/2}, 3);
    Polygon triangleBottom = new Polygon(new int[] {x1 + x2/4, x2 - x2/4, x3}, new int[] {y1 + y3/2, y2 + y3/2, y3}, 3);
    graphics.drawPolygon(outerTriangle);
    graphics.drawPolygon(triangleLeft);
    graphics.drawPolygon(triangleRight);
    graphics.drawPolygon(triangleBottom);
    */

    drawTriangles(graphics, x1, x2, x3, y1, y2, y3, 3);

    // !!!Unfortinatelly not working correctly - if level > 2, its mess

  }

  public static void drawTriangles (Graphics graphics, int x1, int x2, int x3, int y1, int y2, int y3, int level) {

    if (level == 0) {
      return;
    } else {
      Polygon baseTriangle = new Polygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3);
      graphics.drawPolygon(baseTriangle);

      drawTriangles(graphics,x1, x2/2, x3/2,y1, y2, y3/2,level - 1); //left triangle
      drawTriangles(graphics,x1+x2/2, x2, x3 + x3/2,y1, y2, y3/2,level - 1); //right triangle
      drawTriangles(graphics,x1 + x2/4, x2 - x2/4, x3,y1 + y3/2, y2 + y3/2, y3, level - 1); //bottom triangle

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
