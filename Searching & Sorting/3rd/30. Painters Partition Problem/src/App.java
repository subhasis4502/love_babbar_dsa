/* Ref: Same as book alocation problem */

/* 
Input:
5
5 10 30 20 15
3

Output:
Job will completed at: 35
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] boards = new int[size];
        for (int i = 0; i < size; i++) {
            boards[i] = sc.nextInt();
        }
        int painters = sc.nextInt();
        minTime(boards, painters);
        sc.close();
    }

    private static void minTime(int[] boards, int painters) {
        int sum = 0;
        int max = 0;

        for (int val : boards) {
            sum += val;
            max = Math.max(max, val);
        }

        int lo = max;
        int hi = sum;
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isPossible(boards, mid, painters)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println("Job will completed at: " + ans);
    }

    private static boolean isPossible(int[] boards, int mid, int painters) {
        int st = 1;
        int sum = 0;

        for (int i = 0; i < boards.length; i++) {
            sum += boards[i];

            if (sum > mid) {
                st++;
                sum = boards[i];
            }
        }

        return st <= painters;
    }
}