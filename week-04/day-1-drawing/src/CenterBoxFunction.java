import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CenterBoxFunction {

  public static void mainDraw(Graphics graphics){
    // create a function that draws one square and takes 2 parameters:
    // the square size and the graphics
    // and draws a square of that size to the center of the canvas.
    // draw 3 squares with that function.
    // avoid code duplication.

  centerSquares(50, graphics);
  }

  public static void centerSquares (int size, Graphics graphics) {
    Graphics2D g2d = (Graphics2D) graphics;
    g2d.setStroke(new BasicStroke(20));

    int xCor = WIDTH/2 - size/2;
    int yCor = HEIGHT/2 - size/2;
    int numberOfSquares = 3;
    int xSquareDistances = (WIDTH-xCor)/numberOfSquares;
    int ySquareDistances = (HEIGHT-yCor)/numberOfSquares;

    for(int i=0; i < numberOfSquares; i++) {
      graphics.setColor(new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)));
      graphics.drawRect(xCor + i*xSquareDistances, yCor + i*ySquareDistances, size, size );
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