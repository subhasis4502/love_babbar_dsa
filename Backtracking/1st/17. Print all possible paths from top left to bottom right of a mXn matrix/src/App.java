public class App {
    public static void main(String[] args) throws Exception {
        int mat[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        allPath(mat, 0, 0, "");
    }

    private static void allPath(int[][] mat, int x, int y, String string) {
        if (x >= mat.length || y >= mat[0].length)
            return;
        if (x == mat.length - 1 && y == mat[0].length - 1)
            System.out.println(string + mat[x][y]);

        allPath(mat, x, y + 1, string + mat[x][y] + " -> ");
        allPath(mat, x + 1, y, string + mat[x][y] + " -> ");
    }
}
