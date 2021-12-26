/* Ref:  */

/* 
Test:
I/P - 
4 3
16 28 60 64 
22 41 63 91 
27 50 87 93 
36 78 87 94

O/P - 
The kth element in matrix is 27
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int k = sc.nextInt();
        int[][] mat = new int[row][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        kthElement(mat, row, k);
        sc.close();
    }

    private static void kthElement(int[][] mat, int n, int k) {
        int low = mat[0][0];
        int hi = mat[n - 1][n - 1];
        while (low <= hi) {
            int x = 0;
            int mid = low + (hi - low) / 2;
            for (int i = 0; i < n; i++)
                x += binarySearch(mat[i], mid);

            if (x >= k)
                hi = mid - 1;
            else
                low = mid + 1;
        }
        System.out.println("The kth element in matrix is " + low);
    }

    static int binarySearch(int arr[], int num) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (l < arr.length && arr[l] <= num) {
            return l + 1;
        }
        return l;
    }
}
