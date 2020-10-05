public class SumAll {
  public static void main(String[] args) {
    int[] numbers = {3,4,5,6,7};
    int sum = 0;

    //součet elementů pomocí forEach
    for (int row : numbers) {
      sum += row;
    }
    System.out.println(sum);

    //součet elementů pomocí funkce
    int sum2 = java.util.Arrays.stream(numbers).sum();
    System.out.println(sum2);

  }
}
