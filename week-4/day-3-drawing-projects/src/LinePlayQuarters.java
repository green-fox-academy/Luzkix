import javax.swing.*;

import java.awt.*;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class LinePlayQuarters {
  public static void mainDraw(Graphics graphics) {
    //a "few" variables for begenning :-)
    int divisionParameter = 2;
    WIDTH = (int) (WIDTH/divisionParameter);
    HEIGHT = (int) (HEIGHT/divisionParameter);
    int numberOfLines = 15;
    int startingX = 0;
    float endingX = WIDTH - (float) 1/12*WIDTH; //float necessary because of rounding - otherwise 1/12 is considered to be 0.
    float startingY = (float) 1/5*HEIGHT;
    int endingXint = (int) endingX; //transformed back to int for drawing function
    int startingYint = (int) startingY;
    int endingY = HEIGHT;
    int constantX = (int)(endingX - startingX)/numberOfLines; //changed back to int so it does not create problems during drawings
    int constantY = (int)(endingY - startingY)/numberOfLines;

    //Following are created necessary forloop functions

    for (int numberOfRows = 0; numberOfRows <divisionParameter*divisionParameter; numberOfRows++) {
      for (int numberOfRepeats = 0; numberOfRepeats <divisionParameter*divisionParameter; numberOfRepeats++) {

        int toBeSubstractedFromEndingX = endingXint - constantX;
        int toBeAddedToStartingY = 0;

        for (int lineIndex = 0; lineIndex < numberOfLines; lineIndex++) {
          //GREEN part
          graphics.setColor(Color.GREEN);
          graphics.drawLine(startingX + WIDTH*numberOfRepeats, (startingYint + toBeAddedToStartingY) + HEIGHT*numberOfRows,(endingXint - toBeSubstractedFromEndingX) + WIDTH*numberOfRepeats, endingY + HEIGHT*numberOfRows);

          //MAGNETA part - just reversed x and y coordinates from the drawLine function above
          graphics.setColor(Color.MAGENTA);
          graphics.drawLine((startingYint + toBeAddedToStartingY) + HEIGHT*numberOfRows, startingX + WIDTH*numberOfRepeats, endingY + HEIGHT*numberOfRows, (endingXint - toBeSubstractedFromEndingX) + WIDTH*numberOfRepeats);

          toBeSubstractedFromEndingX -= constantX;
          toBeAddedToStartingY += constantY;

      }
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