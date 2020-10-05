import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {

        int[][] matrix = new int[4][4];

        for (int outerIndex = 0; outerIndex < matrix.length; outerIndex++) {
            for (int innerIndex = 0; innerIndex < matrix[outerIndex].length; innerIndex++) {
                //do vnitřní fce for doplním podmínky, jakou hodnotu mají mít jednotlivé elementy. Pokud se indexy shodují = 1 (diagonála)
                if (innerIndex == outerIndex) {
                    matrix[outerIndex][innerIndex] = 1;
                } else {
                    matrix[outerIndex][innerIndex] = 0;
                }
                //zde postupně vytisknu jednotlivé hodnoty každého elementu + mezeru (pro lepší přehlednost)
                System.out.print(matrix[outerIndex][innerIndex] + " ");
            }
            //po každém jednom vytištění vnitřní Array zalomit řádek a pak tisknu další Array
            System.out.println();
        }


    }

}

