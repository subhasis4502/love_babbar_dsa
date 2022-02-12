/* Ref: https://www.youtube.com/watch?v=05y82cP3bJo */

import java.util.ArrayList;

public class App {
    static ArrayList<ArrayList<Integer>> res;

    public static void main(String[] args) throws Exception {
        int n = 10;
        res = new ArrayList<>();
        int[][] chess = new int[n][n];
        printQueens(chess, "", 0);
        for (ArrayList<Integer> a : res) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void printQueens(int[][] chess, String s, int row) {
        ArrayList<Integer> a = new ArrayList<>();
        if (row == chess.length) {
            String[] str= s.split(" ");
            for (String c : str) {
                a.add(Integer.parseInt(c));
            }
            res.add(a);
            return;
        }

        for (int col = 0; col < chess.length; col++) {
            if (isQueenSafe(chess, row, col)) {
                chess[row][col] = 1;
                printQueens(chess, s + (col + 1)+" ", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    private static boolean isQueenSafe(int[][] chess, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1)
                return false;
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1)
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1)
                return false;
        }

        return true;
    }
}
