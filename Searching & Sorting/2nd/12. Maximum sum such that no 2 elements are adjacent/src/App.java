/* Ref: https://www.youtube.com/watch?v=FAxkaf_iDlc */

/* 
Input:
6
5 5 10 100 10 5 

Output:
Maximum sum: 110
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
        findMaxSum(arr);
        sc.close();
    }

    public static void findMaxSum(int arr[]) {
        int n = arr.length;
        if (n == 1)
            System.out.println("Maximum sum: " + arr[0]);

        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1], arr[0]);

        for (int i = 2; i < n; i++)
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);

        System.out.println("Maximum sum: " + dp[n - 1]);
    }
}
