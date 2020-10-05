public class NumberAdder {
  public static void main(String[] args) {
    numberAdder(5);
  }
  public static int numberAdder (int n) {
    System.out.println(Integer.toString(n));
    if (n == 1) {
      return n;
    } else {
      return numberAdder(n - 1);
    }
  }
}
