package Arrays;

import java.util.Arrays;
import java.util.Collections;

public class Reverse {
  public static void main(String[] args) {
    Integer[] numbers = {3, 4, 5, 6, 7, 4};
    /*int[] temp = new int[numbers.length];
    for (int i = numbers.length-1; i >= 0; i--) {
      temp[numbers.length - i - 1] = numbers[i];
    }
    numbers = temp;
    System.out.println(Arrays.toString(numbers));*/
    Arrays.sort(numbers, Collections.reverseOrder());
    System.out.println(Arrays.toString(numbers));
  }

}
