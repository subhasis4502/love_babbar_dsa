/* Ref: https://www.youtube.com/watch?v=ajWCEu1razQ */

import java.util.HashMap;
import java.util.Map;
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

        commonElements(mat, row, col);
        sc.close();
    }

    private static void commonElements(int[][] mat, int row, int col) {
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < col; i++) {
            hash.put(mat[0][i], 1);
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(hash.containsKey(mat[i][j]) && hash.get(mat[i][j]) < i)
                    hash.put(mat[i][j], hash.get(mat[i][j])+1);
            }
        }

        System.out.print("Common elements are: ");
        for (int i : hash.keySet()) {
            if(hash.get(i) == row-1)
                System.out.print(i + " ");
        }
    }
}
