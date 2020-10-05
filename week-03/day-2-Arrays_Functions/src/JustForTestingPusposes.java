
import java.util.Arrays;
import java.util.Iterator;
import java.util.Arrays;

import java.util.Scanner;
import javax.swing.*;
import java.lang.reflect.Array;



public class JustForTestingPusposes {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(subInt(0, new int[]{1, 11, 34, 0, 52, 61})));
  }
Scanner
  public static int[] subInt(int testNumber, int[] testArray) {
    int[] validValue = new int[testArray.length];
    int[] resultArray = new int[testArray.length];
    int counter = 0;
    for (int i = 0; i < testArray.length; i++) {
      while (testNumber <= testArray[i]) {
        if (testArray[i] % 10 == testNumber) {
          resultArray[i] = i;
          validValue[i] = 1;
          counter++;
          break;
        } else {
          testArray[i] /= 10;
        }
      }
    }
    int[] finalArray = new int[counter];
    int lengthOfFinalArray = -1;
    for (int i = 0; i < validValue.length; i++) {
      if (validValue[i] == 1) {
        lengthOfFinalArray++;
        finalArray[lengthOfFinalArray] = resultArray[i];
      }
    }
    return finalArray;
  }
}