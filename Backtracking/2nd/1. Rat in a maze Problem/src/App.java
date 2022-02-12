/* Ref: https://www.youtube.com/watch?v=bLGZhJlt4y0 */

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] m = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 1, 1, 0, 0 },
                { 0, 1, 1, 1 } };

        findPath(m);
    }

    private static void findPath(int[][] m) {
        int n = m.length;
        ArrayList<String> res = new ArrayList<>();
        int[][] visited = new int[n][n];
        if (m[0][0] == 1)
            solve(0, 0, m, n, res, "", visited);
        for (String s : res) {
            System.out.println(s);
        }
    }

    private static void solve(int i, int j, int[][] m, int n, ArrayList<String> res, String path, int[][] visited) {
        if (i == n - 1 && j == n - 1) {
            res.add(path);
            return;
        }

        // Downward
        if (i + 1 < n && visited[i + 1][j] == 0 && m[i + 1][j] == 1) {
            visited[i][j] = 1;
            solve(i + 1, j, m, n, res, path + 'D', visited);
            visited[i][j] = 0;
        }

        // Left
        if (j - 1 >= 0 && visited[i][j - 1] == 0 && m[i][j - 1] == 1) {
            visited[i][j] = 1;
            solve(i, j - 1, m, n, res, path + "L", visited);
            visited[i][j] = 0;
        }

        // Right
        if (j + 1 < n && visited[i][j + 1] == 0 && m[i][j + 1] == 1) {
            visited[i][j] = 1;
            solve(i, j + 1, m, n, res, path + "R", visited);
            visited[i][j] = 0;
        }

        // Up
        if (i - 1 >= 0 && visited[i - 1][j] == 0 && m[i - 1][j] == 1) {
            visited[i][j] = 1;
            solve(i - 1, j, m, n, res, path + "U", visited);
            visited[i][j] = 0;
        }
    }
}
