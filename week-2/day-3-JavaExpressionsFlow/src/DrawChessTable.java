public class DrawChessTable {
    public static void main(String[] args) {

        for (int lineNumber = 1; lineNumber <= 8; lineNumber++) {
            System.out.println();

            if (lineNumber%2 != 0) {
                for (int chessFieldNumber = 1; chessFieldNumber <= 4; chessFieldNumber++) {
                    System.out.print("% ");
                }
            } else {
                for (int chessFieldNumber = 1; chessFieldNumber <= 4; chessFieldNumber++) {
                    System.out.print(" %");
                }
            }
        }
    }
}
