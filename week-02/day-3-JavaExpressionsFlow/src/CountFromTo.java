import java.util.Scanner;
public class CountFromTo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give me the first number:");
        int firstNum = scanner.nextInt();

        System.out.println("Please give me second number:");
        int secondNum = scanner.nextInt();

        if (firstNum >= secondNum) {
            System.out.println("The second number should be bigger! Please define second number again:");
            secondNum = scanner.nextInt();
        }

        if (secondNum > firstNum) {
            for (int i = firstNum; i <= secondNum; i++) {
                System.out.println(i);
            }
        }




    }
}
