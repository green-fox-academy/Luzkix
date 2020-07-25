import java.util.Scanner;
public class OddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write a number - I will tell you, whether it is odd or even number:");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println("Your number is even!");
        } else {
            System.out.println("Your number is odd!");
        }

    }
}
