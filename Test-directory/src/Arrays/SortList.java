package Arrays;

import java.util.Arrays;

public class SortList {
  public static void main(String[] args) {
      int [] testArray = new int[] {34, 12, 24, 9, 5};
      bubble(testArray);
      advancedBubble(testArray, true);
  }

  private static void advancedBubble(int[] testArray, boolean b) {
    if (b == true) {
      for (int j = 0; j < testArray.length; j++) {
        for (int i = 0; i < testArray.length; i++) {
          while (i+1 < testArray.length)
            if (testArray[i] > testArray[i+1]) {
              i++;
            } else {
              int temp = testArray[i];
              testArray[i] = testArray[i+1];
              testArray[i+1] = temp;
              i++;
            }
        }
      }
      System.out.println(Arrays.toString(testArray));
    } else {
      for (int j = 0; j < testArray.length; j++) {
        for (int i = 0; i < testArray.length; i++) {
          while (i+1 < testArray.length)
            if (testArray[i] < testArray[i+1]) {
              i++;
            } else {
              int temp = testArray[i];
              testArray[i] = testArray[i+1];
              testArray[i+1] = temp;
              i++;
            }
        }
      }
      System.out.println(Arrays.toString(testArray));
    }

  }

  private static void bubble(int[] testArray) {
    for (int j = 0; j < testArray.length; j++) {
      for (int i = 0; i < testArray.length; i++) {
        while (i+1 < testArray.length)
          if (testArray[i] < testArray[i+1]) {
            i++;
          } else {
            int temp = testArray[i];
            testArray[i] = testArray[i+1];
            testArray[i+1] = temp;
            i++;
          }
      }
    }
    System.out.println(Arrays.toString(testArray));
  }
}
