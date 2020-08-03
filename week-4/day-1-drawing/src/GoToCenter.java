import java.util.HashMap;
import java.util.Scanner;
import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GoToCenter {
  public static void mainDraw(Graphics graphics) {
    // Create a function that draws a single line and takes 3 parameters:
    // The x and y coordinates of the line's starting point and the graphics
    // and draws a line from that point to the center of the canvas.
    // Draw at least 3 lines with that function using a loop.

    goToTheCenter(25, 35, Color.GREEN, graphics);
  }

  public static void goToTheCenter (int xCord, int yCord, Color myColor, Graphics graphics) {
    int centerWidth = WIDTH/2;
    int centerHeight = HEIGHT/2;
    graphics.setColor(myColor);

    for (int x = xCord; x < WIDTH; x += 50 + Math.random()*100) {
      for (int y = yCord; y < HEIGHT; y += 50 + Math.random()*100) {
        graphics.drawLine(x, y, centerWidth, centerHeight);
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