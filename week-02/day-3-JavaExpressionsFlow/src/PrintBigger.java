import java.util.Scanner;
public class PrintBigger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a number 1");
        int number1 = scanner.nextInt();

        System.out.println("Give me a number 2");
        int number2 = scanner.nextInt();

        if (number1 > number2) {
            System.out.println(number1 + " is bigger number!");
        } if (number2 > number1) {
            System.out.println(number2 + " is bigger number!");
        } else {
            System.out.println("You tried to fool me! The same numbers :-)");
        }


    }
}
