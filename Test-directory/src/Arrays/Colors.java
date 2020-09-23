package arrays;
import static arrays.A.staticNumber;
import arrays.A;
import java.util.Arrays;

public class Colors {
  public static void main(String[] args) {
    String [][] colors = {{"lime", "forest green", "olive", "pale green", "spring green"}, {"orange red", "red", "tomato"}, {"orchid", "violet", "pink", "hot pink"}};
    for (int i = 0; i < colors.length; i++) {
      for (int j = 0; j < colors[i].length; j++) {
        System.out.print(" '" + colors[i][j] + "' ");
      }
      System.out.println();
    }

    A a = new A();
    int b = 3 * staticNumber;
    System.out.println(b);


  }

}
