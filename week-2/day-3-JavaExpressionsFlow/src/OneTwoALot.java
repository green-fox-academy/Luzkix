import java.util.Scanner;
public class OneTwoALot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please write a whole number - it can be also negative number or zero, but it should be a whole number:");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Not enought!");
        } if (number == 1) {
            System.out.println("One!");
        } if (number == 2) {
            System.out.println("Two!");
        } if (number > 2){
            System.out.println("A lot!");
        }
    }
}
