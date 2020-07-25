import java.util.Scanner;
public class MileToKmConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many miles did you travel today? e.g. 3,85");
        double milesTraveled = scanner.nextDouble();
        double milesToKm = milesTraveled * 1.609344;
        System.out.println("You traveled " + milesToKm +" Kms!!!");
    }
}
