import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a number please:");
        int number = scanner.nextInt();

        for (int i=1; i <= number; i++) {
            System.out.println(i*number);
        }

    }
}