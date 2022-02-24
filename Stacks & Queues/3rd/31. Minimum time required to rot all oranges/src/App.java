/* Ref: https://www.youtube.com/watch?v=H-p_MaL0g-A */

import java.util.*;

class Pair {
    int row, col;

    Pair(int a, int b) {
        row = a;
        col = b;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int[][] grid = {
                { 0, 1, 2 },
                { 0, 1, 2 },
                { 2, 1, 1 },
        };

        System.out.println("Time required: " + orangesRotting(grid));
    }

    private static int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q.add(new Pair(i, j));
            }
        }

        int count = 0;
        q.add(new Pair(-1, -1));
        while (!q.isEmpty()) {
            int i = q.peek().row;
            int j = q.peek().col;

            if (i == -1 && j == -1 && q.size() == 1) {
                q.remove();
                break;
            }

            else if (i == -1 && j == -1 && q.size() > 1) {
                count++;
                q.remove();
                q.add(new Pair(-1, -1));
            }

            else {
                if ((i - 1) >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    q.add(new Pair(i - 1, j));
                }
                if ((j - 1) >= 0 && grid[i][j-1] == 1) {
                    grid[i][j - 1] = 2;
                    q.add(new Pair(i, j - 1));
                }
                if ((i + 1) < grid.length && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    q.add(new Pair(i + 1, j));
                }
                if ((j + 1) < grid[0].length && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    q.add(new Pair(i, j + 1));
                }
                q.remove();
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return count;
    }
}
