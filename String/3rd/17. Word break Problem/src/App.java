/* Ref: https://www.youtube.com/watch?v=2NaaM_z_Jig&t=204s */

/* 
Test:
I/P - 12
      i like sam sung samsung mobile ice cream icecream man go mango
      ilike  
O/P - 1
*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        ArrayList<String> dict = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            dict.add(sc.next());
        }
        String str = sc.next();
        System.out.println("Word breaks: " + wordBreak(str, dict));
        sc.close();
    }

    public static int wordBreak(String A, ArrayList<String> dict) {
        int[] dp = new int[A.length()];
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j <= i; j++) {
                String word2Check = A.substring(j, i + 1);
                if (dict.contains(word2Check)) {
                    if (j > 0)
                        dp[i] += dp[j - 1];
                    else
                        dp[i] += 1;
                }
            }
        }

        return (dp[A.length() - 1]);
    }
}
