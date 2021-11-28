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
        int target = sc.nextInt();

        if (searchMatrix(mat, target))
            System.out.println(target + " is found");
        else
            System.out.println(target + " is not found");
        sc.close();
    }

    private static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] <= target && matrix[i][col - 1] >= target) {
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == target)
                        return true;
                }
            }
        }
        return false;
    }
}
