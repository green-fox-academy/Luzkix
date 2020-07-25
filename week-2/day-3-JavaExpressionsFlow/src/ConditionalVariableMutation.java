import java.util.Scanner;
public class ConditionalVariableMutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = 24;
        int out = 0;
        if (a % 2 == 0) {
            System.out.println(out + 1);
        }


        int b = 13;
        String out2 = "";
        if ((b >= 10) && (b <= 20)) {
            out2 = "Sweet!";
        } if (b < 10) {
            out2 = "Less!";
        } if (b > 20) {
            out2 = "More!";
        }
        System.out.println(out2);

        int c= 123;
        int credits = 100;
        boolean isBonus = false;
        if ((credits >= 50) && (isBonus == false)) {
            System.out.println(c - 2);
        } if ((credits < 50) && (isBonus == false)) {
            System.out.println(c - 1);
        } if (isBonus == true) {
            System.out.println(c);
        }

        int d = 8;
        int time = 120;
        String out3 = "";
        if ((d % 4 == 0) && (time <= 200)) {
            System.out.println(out3 = "check");
        } if (time > 200) {
            System.out.println(out3 = "Time out");
        } else {
            System.out.println(out3 = "Run Forest Run!");
        }




    }
}
