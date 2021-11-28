/* Ref: https://www.youtube.com/watch?v=UQiZmkVwARg */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        longestRepeatingSubsequence(str);
        sc.close();
    }

    private static void longestRepeatingSubsequence(String str) {
        int n = str.length();
        int[][] dp = new int[n+1][n+1];
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=n; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(str.charAt(i-1) == str.charAt(j-1) && i != j)
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println("Longest Repeating subsequence: " + dp[n][n]);
    }
}
