public class SumDigits {
  public static void main(String[] args) {
    System.out.println(sumOfDigits(12345678));
  }

  public static int sumOfDigits(int number) {
    if (number % 10 == number) {
      return number;
    }
    return number % 10 + sumOfDigits(number / 10);
  }
}

