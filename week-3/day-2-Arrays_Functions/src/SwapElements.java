import java.util.Arrays;

public class SwapElements {
    public static void main(String[] args) {
        String[] orders = {"first", "second", "third"};
        String temp = orders[0];
        orders[0] = orders[2];
        orders[2] = temp;
        System.out.println(Arrays.toString(orders));
    }
}
