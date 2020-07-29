public class DoubleItems {
    public static void main(String[] args) {
        int[] numList = {3, 4, 5, 6, 7};

        //použil jsem forEach - zde nepoužívám [] a ve funkci ani název matice
        for (int row : numList) {
            row = row*2;
            System.out.print(row + " ");
        }

    }
}
