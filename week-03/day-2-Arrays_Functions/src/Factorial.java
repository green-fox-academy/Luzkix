import java.util.Scanner;

public class Factorial {
  public static void main(String[] args) {
    System.out
        .println("Please input a number which will be used as a base for factorial function:");
    Scanner scanner = new Scanner(System.in);
    int inputVariable = scanner.nextInt();

    System.out.println("Factorial for your number is: " + factorio(inputVariable));
  }

  public static long factorio(int definedNumber) {
    int[] factorialNumbers = new int[definedNumber];
    // long - factorial output can be too long, therefore long. This variable is used later in forEach loop.
    long factorial = 1;

    //creating of Array of numbers to be factored
    for (int indexNumber = 0; indexNumber < definedNumber; indexNumber++) {
      factorialNumbers[indexNumber] = indexNumber + 1;
    }
    //factoring of the numbers from factorialNumbers Array
    for (int row : factorialNumbers) {
      factorial *= row;
    }

    return factorial;
  }

}

