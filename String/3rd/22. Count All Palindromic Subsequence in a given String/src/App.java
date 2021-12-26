/* Ref: https://www.youtube.com/watch?v=YHSjvswCXC8 */

/* 
Test:
I/P - abccbc O/P - 16
I/P - aab O/P - 4
*/


import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        countPS(str);
        sc.close();
    }

    private static void countPS(String str) {
        int n = str.length();
        long mod = 1000000007;
        long[][] dp = new long[n][n];
        for (int g = 0; g < n; g++) {
            // Corner traversal
            for (int i = 0, j = g; j < n; i++, j++) {
                // First corner
                if (g == 0)
                    dp[i][j] = 1;
                // Second corner
                else if (g == 1)
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
                else {
                    // If palindrom found
                    if (str.charAt(i) == str.charAt(j))
                        dp[i][j] = (dp[i][j - 1] + dp[i + 1][j] + 1) % mod;
                    else
                        dp[i][j] = (((dp[i][j - 1] + dp[i + 1][j]) % mod - dp[i + 1][j - 1]) % mod + mod) % mod;
                }
            }
        }
        System.out.println("Number of Palindromic Subsequences: " + dp[0][n - 1]);
    }
}
