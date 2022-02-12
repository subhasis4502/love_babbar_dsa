/* Ref: https://www.youtube.com/watch?v=SP880DBRJ_8 */

public class App {
    public static void main(String[] args) throws Exception {
        int n = 8;
        int[][] chess = new int[n][n];
        printKnightTour(chess, 0, 0, 1);
    }

    private static void printKnightTour(int[][] chess, int row, int col, int move) {

        if (row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0) {
            return;
        } else if (move == chess.length * chess.length) {
            chess[row][col] = move;
            displayChess(chess);
            chess[row][col] = 0;
            return;
        }

        chess[row][col] = move;
        printKnightTour(chess, row - 2, col + 1, move + 1);
        printKnightTour(chess, row - 1, col + 2, move + 1);
        printKnightTour(chess, row + 1, col + 2, move + 1);
        printKnightTour(chess, row + 2, col + 1, move + 1);
        printKnightTour(chess, row + 2, col - 1, move + 1);
        printKnightTour(chess, row + 1, col - 2, move + 1);
        printKnightTour(chess, row - 1, col - 2, move + 1);
        printKnightTour(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;
    }

    private static void displayChess(int[][] chess) {
        for (int[] r : chess) {
            for (int i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
