import java.io.IOException;
import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class DivideByZero {
  public static void main(String[] args) {
    System.out.println("Give me a number:");
    Scanner scanner = new Scanner(System.in);
    int definedNumber = scanner.nextInt();
    try {
      int result =  10/definedNumber;
      System.out.println("A number 10 divided by your number is: " + result);
    } catch (ArithmeticException e) {
      System.out.println("You can not provide us with 0! Please repeate.");
    }


  }
}
