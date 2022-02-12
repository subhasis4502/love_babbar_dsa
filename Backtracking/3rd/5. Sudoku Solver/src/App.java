/* Ref: https://www.youtube.com/watch?v=uyetDh-DyDg */

class App {
    public static void main(String[] args) {
        int[][] board = {
                { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 },
        };
        solveSudoku(board, 0, 0);
    }

    private static void solveSudoku(int[][] board, int i, int j) {
        int ni = 0;
        int nj = 0;

        // when all cells are filled
        if (i == board.length) {
            display(board);
            return;
        }

        // When reach at the last column
        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] != 0) {
            solveSudoku(board, ni, nj);
        } else {
            for (int po = 1; po <= 9; po++) {
                if (isValid(board, i, j, po)) {
                    board[i][j] = po;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0; // Backtracking
                }
            }
        }
    }

    private static boolean isValid(int[][] board, int x, int y, int val) {
        // Checking the row
        for (int j = 0; j < board[0].length; j++) {
            if (board[x][j] == val)
                return false;
        }

        // Checking the column
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == val)
                return false;
        }

        // // Checking the sub-matrix
        int rs = x / 3 * 3;
        int cs = y / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rs + i][cs + j] == val)
                    return false;
            }
        }
        return true;
    }

    private static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}