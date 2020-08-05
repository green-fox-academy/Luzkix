import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ConnectTheDots {
  public static void mainDraw(Graphics graphics) {
    // Create a function that takes 2 parameters:
    // An array of {x, y} points and graphics
    // and connects them with green lines.
    // Connect these to get a box: {{10, 10}, {290,  10}, {290, 290}, {10, 290}}
    // Connect these: {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70},
    // {120, 100}, {85, 130}, {50, 100}}

    Integer[][] coordinates1 = {{10, 10}, {290, 10}, {290, 290}, {10, 290}};
    Integer[][] coordinates2 =
        {{50, 100}, {70, 70}, {80, 90}, {90, 90}, {100, 70}, {120, 100}, {85, 130}, {50, 100}};

    drawObject(coordinates1, (Graphics2D) graphics, Color.GREEN);
    drawObject(coordinates2, (Graphics2D) graphics, Color.RED);
  }

  public static void drawObject(Integer[][] coordinates, Graphics2D g, Color color) {
    g.setStroke(new BasicStroke(10));
    int startingX = 0;
    int startingY = 0;
    int targetX = 0;
    int targetY = 0;

    for (int i = 0; i < coordinates.length - 1; i++) {
      startingX = coordinates[i][0];
      startingY = coordinates[i][1];
      targetX = coordinates[i + 1][0];
      targetY = coordinates[i + 1][1];
      g.setColor(color);
      g.drawLine(startingX, startingY, targetX, targetY);
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