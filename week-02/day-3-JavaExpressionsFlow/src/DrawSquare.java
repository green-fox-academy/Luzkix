import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give me a number:");
        int predefinedSize = scanner.nextInt();

        //V podstatě vytvářím 3 lopy: pro první řádek, pro prostředek a pro poslední řádek

       for (int percentageNumber = 1; percentageNumber <= predefinedSize; percentageNumber++) {
           System.out.print("%");
       }

        for (int rowNumber = 1; rowNumber <= predefinedSize-2; rowNumber++) {
            System.out.println();
            System.out.print("%");

            for (int percentageNumber = 1; percentageNumber <= predefinedSize-2; percentageNumber++ ) {
                System.out.print(" ");
            };

            System.out.print("%");
        }

        System.out.println(); //tím vložím prázdný řádek, defacto zalomím tu předchozí funkci

        for (int percentageNumber = 1; percentageNumber <= predefinedSize; percentageNumber++) {
            System.out.print("%");
        }
    }
}
