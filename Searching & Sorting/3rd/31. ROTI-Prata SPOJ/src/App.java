/* Ref: https://www.youtube.com/watch?v=-Nx1h54KzUQ */

/* 
Input:
10
4
1 2 3 4

Output:
Time required: 12
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int paratha = sc.nextInt();
        int cooks = sc.nextInt();

        int[] arr = new int[cooks];
        for (int i = 0; i < cooks; i++) {
            arr[i] = sc.nextInt();
        }

        timeRequired(arr, paratha);
        sc.close();
    }

    private static void timeRequired(int[] arr, int paratha) {
        int lb = 0;
        int ub = Integer.MAX_VALUE;
        int ans = 0;

        while (lb <= ub) {
            int mid = (lb + ub) / 2;
            if (isParathaPrepared(arr, paratha, mid)) {
                ans = mid;
                ub = mid - 1;
            } else {
                lb = mid + 1;
            }
        }
        System.out.println("Time required: " + ans);
    }

    private static boolean isParathaPrepared(int[] arr, int paratha, int mid) {
        int time = 0;
        int readyParatha = 0;
        for (int i = 0; i < arr.length; i++) {
            time = arr[i];
            int j = 2;
            while (time <= mid) {
                readyParatha++;
                time += (arr[i] * j);
                j++;
            }
            if (readyParatha >= paratha)
                return true;
        }
        return false;
    }
}
