import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class StarryNight {
  public static void mainDraw(Graphics graphics) {
    // Draw the night sky:
    //  - The background should be black
    //  - The stars can be small squares
    //  - The stars should have random positions on the canvas
    //  - The stars should have random color (some shade of grey)

    //some variables which can be changed:
    int maximumNumberOfStars = 150;
    int minimumNumberOfStars = 50;
    int numberOfStars = (minimumNumberOfStars + (int) (Math.random()*(maximumNumberOfStars-minimumNumberOfStars)));
    int maxSizeOfStar = 20;

    //black sky
    graphics.setColor(Color.black);
    graphics.fillRect(0,0,WIDTH,HEIGHT);

    //random stars
    for (int starNumber = 0; starNumber < numberOfStars; starNumber++) {
      int randomStarSize = (int) (Math.random()*maxSizeOfStar);

      int randomGreyCoef = (int) (Math.random()*255);
      Color randomGrey = new Color(randomGreyCoef, randomGreyCoef, randomGreyCoef);
      graphics.setColor(randomGrey);

      int randomX = (int) (Math.random()*WIDTH);
      int randomY = (int) (Math.random()*HEIGHT);

      graphics.fillRect(randomX, randomY, randomStarSize, randomStarSize);
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