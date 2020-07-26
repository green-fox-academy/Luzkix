import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Define an odd number:");
        int setPyramideHeight = scanner.nextInt();

        //vytvořím fakticky 2 nezávislé pyramidy, pro které si připravím variables:
        int pyramideHeight1 = setPyramideHeight / 2 + 1;
        int pyramideHeight2 = setPyramideHeight / 2;

        //Pyramida 1:
        for (int lineNumber = 1; lineNumber <= pyramideHeight1; lineNumber++) {
            System.out.println();

            for (int spaceNumber = pyramideHeight1 - lineNumber; spaceNumber > 0; spaceNumber--) {
                System.out.print(" ");
            }

            for (int starNumber = 1; starNumber <= lineNumber * 2 - 1; starNumber++) {
                    System.out.print("X");
            }
        }

        //Pyramida 2 - obrácená pyramida. Nejtěžší bylo vymyslet vzorec pro X, což se mi povedlo náhodou (zkopušel jsem, co to dělá, až mi to došlo):
        for (int lineNumber = 1; lineNumber <= pyramideHeight2; lineNumber++) {
            System.out.println();

            for (int spaceNumber = 1; spaceNumber <= lineNumber; spaceNumber++) {
                System.out.print(" ");
            }

            for (int starNumber = (pyramideHeight2 * 2 - lineNumber * 2) + 1; starNumber > 0; starNumber--) {
                System.out.print("X");
            }
        }

    }
}
