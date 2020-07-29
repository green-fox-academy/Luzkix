import java.util.Arrays;

public class Colors {
    public static void main(String[] args) {
        String[][] colors = {
                {"lime", "forest green", "olive", "pale green", "spring green"},
                {"orange red", "red", "tomato"},
                {"orchid", "violet", "pink", "hot pink"}
        };

        for (int outerIndex = 0; outerIndex < colors.length; outerIndex++) {
            for (int innerIndex = 0; innerIndex < colors[outerIndex].length; innerIndex++) {
                System.out.print(colors[outerIndex][innerIndex] + " | ");
            }
            System.out.println();
        }


    }
}
