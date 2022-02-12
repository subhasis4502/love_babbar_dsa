/* Ref: https://www.youtube.com/watch?v=wvaYrOp94k0 */

import java.util.*;

public class App {
    static ArrayList<ArrayList<String>> res;

    public static void main(String[] args) throws Exception {
        String str = "abaaba";
        allPalindromicPerms(str);
        for (ArrayList<String> a : res) {
            for (String s : a) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }

    private static void allPalindromicPerms(String str) {
        res = new ArrayList<>();
        ArrayList<String> a = new ArrayList<>();
        solve(str, a);
        return;
    }

    private static void solve(String str, ArrayList<String> asf) {
        if (str.length() == 0) {
            ArrayList<String> a = new ArrayList<>();
            a.addAll(asf);
            res.add(a);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String prefix = str.substring(0, i + 1);
            String ros = str.substring(i + 1);
            if (isPalindrome(prefix)) {
                asf.add(prefix);
                solve(ros, asf);
                asf.remove(asf.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
