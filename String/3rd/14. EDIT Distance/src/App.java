/* Ref: https://www.youtube.com/watch?v=tooMn-xfYCU */

/* 
Test:
I/P - geek gesek O/P - 1
I/P - gfg gfg O/P - 0
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        editDistance(s, t);
        sc.close();
    }

    private static void editDistance(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                if(i == 0){
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else {
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        int f1 = 1 + dp[i-1][j-1]; // Replace
                        int f2 = 1 + dp[i-1][j]; // Delete
                        int f3 = 1 + dp[i][j-1]; // Insert
                        dp[i][j] = Math.min(f3, Math.min(f1, f2));
                    }
                }
            }
        }
        System.out.println("Minimum operation required: " + dp[dp.length - 1][dp[0].length-1]);
    }
}
