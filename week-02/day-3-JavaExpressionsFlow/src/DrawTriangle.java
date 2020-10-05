import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me a number:");
        int numberOfLines = scanner.nextInt();

        for (int linenumber = 1; linenumber <= numberOfLines; linenumber++) {
            System.out.println();
            for (int numberOfStar = 1; numberOfStar <= linenumber; numberOfStar++) {
                System.out.print("*");
            }
        }

    }
}
