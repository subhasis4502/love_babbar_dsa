/* Ref: https://www.youtube.com/watch?v=1YUqtoT9YoE */

/* 
Test:
I/P - 5 O/P - 111221
I/P - 2 O/P - 11
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countAndSay(n));
        sc.close();
    }

    private static String countAndSay(int n) {
        if (n == 1)
            return "1";
        if (n == 2)
            return "11";
        String s = "11";
        for (int i = 3; i <= n; i++) {
            String ans = "";
            s += "&";
            int count = 1;
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(j - 1)) {
                    ans += Integer.toString(count) + s.charAt(j - 1);
                    count = 1;
                } else
                    count++;
            }
            s = ans;
        }
        return s;
    }
}
