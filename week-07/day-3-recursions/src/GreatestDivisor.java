public class GreatestDivisor {
 public static void main(String[] args) {
    //Find the greatest common divisor of two numbers using recursion.
   System.out.println(divisor(8, 12));
   System.out.println(greatestDivisorMARMIELL(8, 12));
  }

  //Trochu upravené řešení od Marmiell - já bych na tu logiku nikdy nepřišel
  private static int divisor(int num1, int num2) {
    if (num2 == 0) {
      return num1;
    } else return divisor(num2, num1%num2);
  }

  public static int greatestDivisorMARMIELL(int number1, int number2) {
    if (number2 != 0) {
      return greatestDivisorMARMIELL(number2,number1%number2);
    }
    else return number1;
  }

}
