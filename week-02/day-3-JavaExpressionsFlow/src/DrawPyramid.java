import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter any whole number:");
        int numberOfLines = scanner.nextInt();

        //1. začnu počtem řádků - ty se v maximu rovnají zadání (numberOfLines)
        for (int lineNumber = 1; lineNumber <= numberOfLines; lineNumber++) {
            System.out.println();

            //3. přidám prázdné mezery zleva - zažnu maximem (počet řádků minus aktuální řádek) a snižuju.
            for (int spaceNumber = (numberOfLines - lineNumber); spaceNumber > 0 ; spaceNumber--) {
                System.out.print(" ");
            }

            //2. přidám počet X, které se tisknou DO ŘÁDKU (bez ln), v každém kroku o 2 x navíc
            for (int starNumber = 1; starNumber <= lineNumber * 2 - 1; starNumber++) {
                System.out.print("X");
            }

        }
    }
}
