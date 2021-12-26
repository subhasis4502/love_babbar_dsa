/* Ref: https://www.youtube.com/watch?v=SoxrXQbhCPI */

/* 
Test:
I/P - 3 3
      1 2 3 
      4 5 6
      7 8 9 
O/P - 7 4 1 
      8 5 2
      9 6 3
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] mat = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        rotate90Clockwise(mat, row, col);
        sc.close();
    }

    private static void rotate90Clockwise(int[][] mat, int row, int col) {
        // Transpose
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                swap(mat, i, j);
            }
        }

        // Swapping
        for (int i = 0; i < row; i++) {
            int j = 0;
            int k = col - 1;
            while (j < k) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][k];
                mat[i][k] = temp;

                j++;
                k--;
            }
        }

        System.out.println("\nRotated matrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void swap(int[][] mat, int i, int j) {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }
}
