/* Ref: https://www.youtube.com/watch?v=okP-e2VpI_g */

/* 
Input:
4
12 34 67 90
2

Output:
Minimum number of pages: 113
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int students = sc.nextInt();
        findPages(arr, students);
        sc.close();
    }

    private static void findPages(int[] arr, int students) {
        int sum = 0;
        int max = 0;

        for (int val : arr) {
            sum += val;
            max = Math.max(max, val);
        }

        int lo = max;
        int hi = sum;
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (isPossible(arr, mid, students)) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println("Minimum number of pages: " + ans);
    }

    private static boolean isPossible(int[] arr, int mid, int students) {
        int st = 1;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum > mid) {
                st++;
                sum = arr[i];
            }
        }

        return st <= students;
    }
}
