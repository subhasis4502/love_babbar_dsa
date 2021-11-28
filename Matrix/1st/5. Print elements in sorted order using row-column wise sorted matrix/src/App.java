import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        sortedMatrix(mat, n);
        sc.close();
    }

    private static void sortedMatrix(int[][] mat, int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                arr.add(mat[i][j]);
            }
        }
        Collections.sort(arr);
        int ind = 0;
        System.out.println();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                System.out.print(arr.get(ind++) + " ");
            }
            System.out.println();
        }
    }
}
