/* Ref: https://www.youtube.com/watch?v=0Ql40Llp09E */

/* 
Test:
I/P - abcd aebd
O/P - Length of longest common sequence: 3
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        lcs(str1, str2);
        sc.close();
    }

    static void lcs(String s1, String s2) {
        int x= s1.length();
        int y= s2.length();
        int[][] dp = new int[x+1][y+1];
        
        for (int i = x-1; i >= 0; i--) {
            for (int j = y-1; j >= 0; j--) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if(c1 == c2)
                    dp[i][j] = 1 + dp[i+1][j+1];
                else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
            }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        /* int x = s1.length();
        int y = s2.length();
        int[][] dp = new int[x + 1][y + 1];
        for (int i = x - 1; i >= 0; i--) {
            for (int j = y - 1; j >= 0; j--) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if (c1 == c2) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        } */

        System.out.println("Length of longest common sequence: " + dp[0][0]);
    }
}
