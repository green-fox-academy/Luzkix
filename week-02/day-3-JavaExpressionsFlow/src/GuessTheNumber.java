import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tell mi the number! Zadej číslo!");
        int definedNumber = scanner.nextInt();

        System.out.println("Guess the number! / Hádej číslo!:");
        int guessedNumber = scanner.nextInt();

        //toto if jsem vložil až nakonec, protože když by se číslo rovnou uhádlo, program skončí a nevypíše žádnou větu.
/*        if (guessedNumber == definedNumber) {
            System.out.println("You found the number: / Správně! Číslo je: " + definedNumber);
        }*/

        while (guessedNumber != definedNumber) {
            if (guessedNumber < definedNumber) {
                System.out.println("The stored number is higher / Hádej vyšší číslo!");
                guessedNumber = scanner.nextInt();
            }
            if (guessedNumber > definedNumber) {
                System.out.println("The stored number is lower / Hádej menší číslo!");
                guessedNumber = scanner.nextInt();
            }
            if (guessedNumber == definedNumber) {
                System.out.println("You found the number: / Správně! Číslo je: " + definedNumber);
            }
        }


    }
}
