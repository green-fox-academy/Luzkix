package Arrays;

import java.util.Arrays;

public class DiagonalMatrix {
  public static void main(String[] args) {
    int[][] matrix = new int[10000][10000];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j <matrix[i].length; j++) {
        if (i==j) {
          matrix[i][j] = 1;
          System.out.print(matrix[i][j]);
        } else {
          matrix[i][j]= i*j;
          System.out.print(matrix[i][j]+" ");
        }
      }
      System.out.println();
    }
    System.out.println(matrix [1][1]);

    System.out.println(isSymetric(matrix));
  }

  private static boolean isSymetric(int[][] matrix) {
    int temp = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if (matrix[i][j] == matrix[j][i]) {
        } else temp +=1;
      }
    }
    if (temp == 0) {
      System.out.println("The matrix is symetric!");
      return true;
    } else return false;
  }
}
