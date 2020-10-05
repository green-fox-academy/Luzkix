import java.util.Scanner;

public class Summing {
  public static void main(String[] args) {
    System.out.println("Define the threshold to be summed:");
    Scanner scanner = new Scanner(System.in);
    int keyNumber = scanner.nextInt();

    //print result based on Var1
    System.out.println("Sum of all the numbers bellow stated threshold using variant 1 is: " + sumFunction(keyNumber));

    //print result based on Var2
    System.out.println("Sum of all the numbers bellow stated threshold using variant 2 is: " + sumFunction2(keyNumber));

  }

  //Var1: using loop and for loop
  public static int sumFunction (int definingNumber) {

    //first I will create an array of numbers to be summed with for loop
    int[] arrayOfNumbersToBeSummed = new int[definingNumber];

    //later helping variable called "sum" will be be used within foreach loop, to sum the numbers from the newly created array.
    int sum = 0;

    for (int numberToBeSummed=0; numberToBeSummed < definingNumber; numberToBeSummed++) {
      arrayOfNumbersToBeSummed[numberToBeSummed] = numberToBeSummed + 1;
    }

    for (int rawOfNumbeers : arrayOfNumbersToBeSummed) {
      sum += rawOfNumbeers;
    }

    return sum;
  }

  //Var2: using a loop for creation of array of numbers and then specific formula
  public static int sumFunction2 (int definingNumber) {
    int[] arrayOfNumbersToBeSummed = new int[definingNumber];

    for (int numberToBeSummed = 0; numberToBeSummed < definingNumber; numberToBeSummed++) {
      arrayOfNumbersToBeSummed[numberToBeSummed] = numberToBeSummed + 1;
    }

    int arraySum = java.util.Arrays.stream(arrayOfNumbersToBeSummed).sum();
    return arraySum;
  }

}
