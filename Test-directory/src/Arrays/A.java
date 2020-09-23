package arrays;

import java.util.Arrays;

public class A {
  static int staticNumber = 2;

  public static void main(String[] args) {
    int[][] testRay = {
        {1,2,3},
        {3,4,5},
        {7,8,9,10}
    };

    int[][] test2 = Arrays.copyOf(testRay, 2);

    int position = Arrays.binarySearch(testRay[1], 3);
    System.out.println(position);

    System.out.println();
    for (int i = 0; i < test2.length;i++ ) {
      for (int j = 0; j < test2[i].length; j++) {
        System.out.print(test2[i][j]);
      }
      System.out.println("");
      System.out.println(Arrays.toString(test2[i]));
    }

    for (int i = 0; i < testRay.length;i++ ) {
      for (int j = 0; j < testRay[i].length; j++) {
        System.out.print(testRay[i][j]);
      }
      System.out.println("");
      System.out.println(Arrays.toString(testRay[i]));
    }
  }
}
