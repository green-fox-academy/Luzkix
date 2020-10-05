import java.util.Arrays;
import java.util.List;

public class Ex02 {
  public static void main(String[] args) {
    //Write a Stream Expression to get the squared value of the positive numbers from the following list:

    List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);
    int squareValue = numbers.stream()
        .filter(n -> n > 0)
        .map(n -> n*n)
        .peek(System.out::println)
        .reduce(0,Integer::sum);
    System.out.println(squareValue);

  }
}
