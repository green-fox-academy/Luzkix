import java.util.ArrayList;
import java.util.List;

public class MaximumFinder {
  public static void main(String[] args) {
    //Write a function that finds the largest element of an array using recursion.

    int[] numbers = {3, 5, 2, 8, 10};

    System.out.println(findMax(numbers, 0, 0));

  }

  private static int findMax(int[] numbers, int maxNum, int index) {
    if (index == numbers.length) {
      return maxNum;
    }
    else if (numbers[index] > maxNum) {
      maxNum = numbers[index];
    }
    return findMax(numbers, maxNum, index+=1);
  }
}
