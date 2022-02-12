/* Ref: GFG Article */

public class App {
    public static void main(String[] args) throws Exception {
        int[][] mat = {
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1, 1, 1, 1, 1, 1 } };

        findShortestPath(mat);
    }

    static int rowNum[] = { -1, 0, 0, 1 };
    static int colNum[] = { 0, -1, 1, 0 };
    static int minDis;

    private static void findShortestPath(int[][] mat) {
        minDis = Integer.MAX_VALUE;
        int[][] visited = new int[mat.length][mat[0].length];
        markUnsafe(mat);
        for (int i = 0; i < mat.length; i++) {
            if (mat[i][0] == 1) {
                findShortestPathUtil(mat, visited, i, 0, 0);

                // If min distance is already found
                if (minDis == mat[0].length - 1)
                    break;
            }
        }

        if (minDis != Integer.MAX_VALUE)
            System.out.println("Length of shortest safe route is " + minDis);
        else
            System.out.println("Destination not reachable from given source");
    }

    private static void findShortestPathUtil(int[][] mat, int[][] visited, int i, int j, int dist) {
        if (j == mat[0].length - 1) {
            // Update shortest path found so far
            minDis = Math.min(dist, minDis);
            return;
        }

        // If current path cost exceeds minimum so far
        if (dist > minDis)
            return;

        // include (i, j) in current path
        visited[i][j] = 1;
        for (int k = 0; k < 4; k++) {
            if (isValid(i + rowNum[k], j + colNum[k], mat) && isSafe(mat, visited, i + rowNum[k], j + colNum[k])) {
                findShortestPathUtil(mat, visited, i + rowNum[k], j + colNum[k], dist + 1);
            }
        }
        visited[i][j] = 0;
    }

    private static boolean isSafe(int[][] mat, int[][] visited, int x, int y) {
        if (mat[x][y] == 0 || visited[x][y] == 1)
            return false;
        return true;
    }

    private static void markUnsafe(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    for (int k = 0; k < 4; k++)
                        if (isValid(i + rowNum[k], j + colNum[k], mat))
                            mat[i + rowNum[k]][j + colNum[k]] = -1;
                }
            }
        }

        // Mark all found adjacent cells as unsafe
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == -1)
                    mat[i][j] = 0;
            }
        }
    }

    private static boolean isValid(int r, int c, int[][] mat) {
        if (r < mat.length && c < mat[0].length && r >= 0 && c >= 0)
            return true;
        return false;
    }
}
