import javax.swing.*;

import java.awt.*;


import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Triangles {
  public static void mainDraw(Graphics graphics) {
    /*General approach - to draw each triangle individually (more difficult approach):
    1. definition of generic multi-Array object for storing of triangle coordinates to be drawn:
       - Integer[][] individualTriangle = {{xa, ya}, {xb, yb}, {xc, yc}, {xa, ya}};
    2. defining generic function for drawing the individual triangle (based on the object defined in point 1)
    3. creating outer loop (for rows/lines containing triangles) - No.of rows is related to defined variable numOfRowsWithTriangles
    4. creating inner loop:   - for getting a number of individual triangles in particular row (this correlates with row index)
                              - for getting coordinates a,b,c for each triangle (difficult part is identification of
                              dependency of individual coordinates to outer and inner loop indexes.)
                              - for filling of Integer[][] individualTriangle with particular coordinates
                              - for launching a drawing function "drawIndividualTriangle" - this is done every single iteration,
                                so each triangle is drawn individually.
    */


    int numOfRowsWithTriangles = 20;

    // rows represent rows (lines with triangles) in canvas
    for (int row = 0; row < numOfRowsWithTriangles; row++) {

      //triangleIndex represents each triangle in row. We thus specify how many baseTriangles will be drawn in the row
      for (int triangleIndex = 0; triangleIndex < row + 1; triangleIndex++) {

        // a = top corner, b= bottom right corner, c = bottom left corner
        //  firstly moving xa to its 1st position in line
        int xa = WIDTH / 2 - (row * WIDTH / 2) / (numOfRowsWithTriangles) +
            //then adding a constant which is same for all triangles
            (triangleIndex * WIDTH) / numOfRowsWithTriangles;
        int ya = (row * HEIGHT) / numOfRowsWithTriangles;

        // xb (bottom right corner) was tricky part. However then I realized, that it is basically just slightly shifted xa corner (i need to add WIDTH/(2*numOfRowsWithTriangles)
        int xb = WIDTH / 2 - (row * WIDTH / 2) / (numOfRowsWithTriangles) +
            ((triangleIndex) * WIDTH) / numOfRowsWithTriangles +
            WIDTH / (2 * numOfRowsWithTriangles);

        int yb = ((row + 1) * HEIGHT) / numOfRowsWithTriangles;

        int xc = WIDTH / 2 - (row + 1) * (WIDTH / 2) / numOfRowsWithTriangles +
            (triangleIndex * WIDTH) / numOfRowsWithTriangles;
        int yc = yb;

        //Every iteration I get new coordinates of triangle abc, which are put into the multiarray bellow.
        //Then I call the function which draws an individual triangle
        Integer[][] individualTriangle = {{xa, ya}, {xb, yb}, {xc, yc}, {xa, ya}};

        drawIndividualTriangle (individualTriangle, graphics);
      }
    }
  }

  public static void drawIndividualTriangle (Integer[][] individualTriangle, Graphics graphics) {

    //i represents an index of line to be drawn (here we draw 3 lines to compose the individualTriangle

    for (int i = 0; i < individualTriangle.length - 1; i++) {

      int startingX = individualTriangle[i][0];
      int startingY = individualTriangle[i][1];
      int followingX = individualTriangle[i + 1][0];
      int followingY = individualTriangle[i + 1][1];

      graphics.drawLine(startingX, startingY, followingX, followingY);
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