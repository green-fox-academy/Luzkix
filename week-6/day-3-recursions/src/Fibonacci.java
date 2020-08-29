import java.time.Duration;
import java.time.LocalDateTime;

public class Fibonacci {
  public static void main(String[] args) {

    LocalDateTime start = LocalDateTime.now();
    System.out.println(fib(45));
    LocalDateTime end = LocalDateTime.now();
    System.out.println(Duration.between(start, end).toMillis());
  }

  public static long fib (int n) {
    if (n < 1) {
      return 0;
    }
    if (n < 3) {
      return 1;
    }
    return fib(n-1) + fib(n-2);
  }
}
