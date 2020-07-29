public class AppendA {
    public static void main(String[] args) {
        String[] animals = {"koal", "pand", "zebr"};
        for (String row : animals) {
            row = row + "a";
            System.out.println(row);
        }
    }
}
