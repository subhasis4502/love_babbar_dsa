public class App {
    static int maxLen = 0;
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        int mat[][] = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

        visited = new int[mat.length][mat[0].length];
        findLongestPath(mat, 0, 0, 1, 7, 0);
        System.out.println("Longest path : " + maxLen);
    }

    private static void findLongestPath(int[][] mat, int sx, int sy, int dx, int dy, int len) {
        if (sx < 0 || sy < 0 || sx >= mat.length || sy >= mat[0].length || visited[sx][sy] == 1 || mat[sx][sy] == 0)
            return;

        if (sx == dx && sy == dy)
            maxLen = Math.max(maxLen, len);

        visited[sx][sy] = 1;
        findLongestPath(mat, sx - 1, sy, dx, dy, len + 1);
        findLongestPath(mat, sx, sy + 1, dx, dy, len + 1);
        findLongestPath(mat, sx + 1, sy, dx, dy, len + 1);
        findLongestPath(mat, sx, sy - 1, dx, dy, len + 1);
        visited[sx][sy] = 0;
    }
}
