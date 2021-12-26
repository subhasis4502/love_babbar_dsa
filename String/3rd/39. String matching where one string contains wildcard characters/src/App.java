/* Ref: https://www.youtube.com/watch?v=NbgUZAoIz3g */

/* 
Test:
I/P - 
baaabab
ba*a?

O/P - Matched
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String pattern = sc.nextLine();
        match(str, pattern);
        sc.close();
    }

    private static void match(String str, String pattern) {
        boolean[][] dp = new boolean[pattern.length() + 1][str.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = true;
                } else if (i == dp.length - 1) {
                    dp[i][j] = false;
                } else if (j == dp[0].length - 1) {
                    if (pattern.charAt(i) == '*')
                        dp[i][j] = dp[i + 1][j];
                    else
                        dp[i][j] = false;
                } else {
                    if (pattern.charAt(i) == '?')
                        dp[i][j] = dp[i + 1][j + 1];
                    else if (pattern.charAt(i) == '*')
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    else if (pattern.charAt(i) == str.charAt(j))
                        dp[i][j] = dp[i + 1][j + 1];
                    else
                        dp[i][j] = false;
                }
            }
        }

        if (dp[0][0])
            System.out.println("Mathched");
        else
            System.out.println("Not Mathched");
    }
}
