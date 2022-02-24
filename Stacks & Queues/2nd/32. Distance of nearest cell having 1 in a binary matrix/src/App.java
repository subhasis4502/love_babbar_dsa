/* Ref: https://www.youtube.com/watch?v=7AhF1h1fGnk */

import java.util.*;

class Pair{
    int row, col;
    Pair(int a, int b){
        row = a;
        col = b;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int[][] grid = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };
        nearest(grid);
    }

    private static void nearest(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] res = new int[r][c];
        Queue<Pair> q = new LinkedList<>();

        for (int[] arr : res) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        // Finding the location with value '1'
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    res[i][j] = 0; // Putting their distance 0
                    q.add(new Pair(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            int i = q.peek().row;
            int j = q.peek().col;

            // Left
            if ((i - 1) >= 0 && res[i][j] + 1 < res[i - 1][j]) {
                res[i - 1][j] = res[i][j] + 1;
                q.add(new Pair(i - 1, j));
            }

            // Up
            if ((j - 1) >= 0 && res[i][j] + 1 < res[i][j - 1]) {
                res[i][j - 1] = res[i][j] + 1;
                q.add(new Pair(i, j - 1));
            }

            // Right
            if ((i + 1) < r && res[i][j] + 1 < res[i + 1][j]) {
                res[i + 1][j] = res[i][j] + 1;
                q.add(new Pair(i + 1, j));
            }

            // Down
            if ((j + 1) < c && res[i][j] + 1 < res[i][j + 1]) {
                res[i][j + 1] = res[i][j] + 1;
                q.add(new Pair(i, j + 1));
            }

            q.remove();
        }

        for(int[] arr : res){
            for(int i : arr){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
