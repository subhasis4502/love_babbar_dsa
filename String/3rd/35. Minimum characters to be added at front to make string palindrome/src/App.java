/* Ref: https://www.youtube.com/watch?v=IP4iqrh0mQk, https://www.youtube.com/watch?v=RiNzHfoA2Lo */

/* 
Test:
I/P - abbcabda
O/P - We have to add 3 number to make it palindrome
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        getMinCharToAddedToMakeStringPalin(str);
        sc.close();
    }

    private static void getMinCharToAddedToMakeStringPalin(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];

        for (int gap = 0; gap < dp.length; gap++) {
            for (int si = 0, ei = gap; ei < dp.length; si++, ei++) {
                if (gap == 0)
                    dp[si][ei] = 1;
                else {
                    if (str.charAt(si) == str.charAt(ei))
                        dp[si][ei] = dp[si + 1][ei - 1] + 2;
                    else
                        dp[si][ei] = Math.max(dp[si + 1][ei], dp[si][ei - 1]); // Max of suffix and prefix
                }
            }
        }

        int ans = n - dp[0][dp.length - 1]; // string.lenght() - longestPalindromicSubsequence
        System.out.println("We have to add " + ans + " number to make it palindrome");
    }
}
