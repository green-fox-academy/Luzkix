import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;
public class PartyIndicator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many girls come to the party?");
        int girls = scanner.nextInt();

        System.out.println("How many boys come to the party?");
        int boys = scanner.nextInt();

        if ((girls == boys) && ((girls+boys) >= 20)) {
            System.out.println("The party is excelent!");
        } if ((girls != boys) && ((girls+boys) >= 20) && (girls != 0)) {
            System.out.println("Quite cool party!");
        } if ((girls+boys) < 20) {
            System.out.println("Average party...");
        } if (girls == 0) {
            System.out.println("Sausage party :-(");
        }

    }
}
