import java.util.Scanner;
public class AverageOfInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write 5 numbers and see what will be calculated :-)");
        int number1 = scanner.nextInt();
        int number2 = scanner.nextInt();
        int number3 = scanner.nextInt();
        int number4 = scanner.nextInt();
        int number5 = scanner.nextInt();
        float average = (number1 + number2 + number3 + number4 + number5)/5;
        System.out.println("Based on your input, the average number is: " + average + "!!!");

    }
}
