/* 
Test:
I/P - 
5
1 2 -1 -4 -20
-8 -3 4 2 1
3 8 6 1 3
-4 -1 1 7 -6
0 -4 10 -5 1

O/P - 
Maximum value is 18
*/


import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int[][] mat = new int[row][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        findMaxValue(mat, row);
        sc.close();
    }

    private static void findMaxValue(int[][] mat, int n) {
        // stores maximum value
        int maxValue = Integer.MIN_VALUE;

        // maxArr[i][j] stores max of elements in matrix
        // from (i, j) to (n-1, n-1)
        int maxArr[][] = new int[n][n];

        // last element of maxArr will be same's as of
        // the input matrix
        maxArr[n - 1][n - 1] = mat[n - 1][n - 1];

        // preprocess last row
        int maxv = mat[n - 1][n - 1]; // Initialize max
        for (int j = n - 2; j >= 0; j--) {
            if (mat[n - 1][j] > maxv)
                maxv = mat[n - 1][j];
            maxArr[n - 1][j] = maxv;
        }

        // preprocess last column
        maxv = mat[n - 1][n - 1]; // Initialize max
        for (int i = n - 2; i >= 0; i--) {
            if (mat[i][n - 1] > maxv)
                maxv = mat[i][n - 1];
            maxArr[i][n - 1] = maxv;
        }

        // preprocess rest of the matrix from bottom
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // Update maxValue
                if (maxArr[i + 1][j + 1] - mat[i][j] > maxValue)
                    maxValue = maxArr[i + 1][j + 1] - mat[i][j];

                // set maxArr (i, j)
                maxArr[i][j] = Math.max(mat[i][j], Math.max(maxArr[i][j + 1], maxArr[i + 1][j]));
            }
        }

        System.out.println("Maximum value is " + maxValue);
    }
}
