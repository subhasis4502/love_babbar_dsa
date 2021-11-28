/* Ref: https://www.youtube.com/watch?v=gNDIOqdAJiw */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String txt = sc.nextLine();
        String pattern = sc.nextLine();
        searchOccur(txt, pattern);
        sc.close();
    }

    private static void searchOccur(String txt, String pattern) {
        long p = 31;
        long pow = p;
        long mod = 1000000007;
        long dhv = pattern.charAt(0) - 'A' + 1;

        for (int i = 1; i < pattern.length(); i++) {
            dhv = (dhv + (pattern.charAt(i) - 'A' + 1) * pow) % mod;
            pow = (pow * p) % mod;
        }

        // Rabin Karp
        long[] dp = new long[txt.length()];
        long[] pa = new long[txt.length()];

        dp[0] = txt.charAt(0) - 'A' + 1;
        pa[0] = 1;
        pow = p;
        for (int i = 1; i < txt.length(); i++) {
            dp[i] = ((dp[i - 1] + (txt.charAt(i) - 'A' + 1) * pow)) % mod;
            pa[i] = pow;
            pow = (pow * p) % mod;
        }

        int sp = 0, ep = pattern.length() - 1;
        ArrayList<Integer> ans = new ArrayList<>();

        while (ep < txt.length()) {
            long win = dp[ep];
            if (sp > 0)
                win = (win - dp[sp - 1] + mod) % mod;
            if (win == (dhv * pa[sp]) % mod)
                ans.add(sp + 1);
            sp++;
            ep++;
        }

        if (ans.size() == 0) {
            System.out.println("Not found");
            System.out.println();
            return;
        }

        System.out.println("No. of occurances: " + ans.size());
        System.out.print("Located on index: ");
        for (int x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
