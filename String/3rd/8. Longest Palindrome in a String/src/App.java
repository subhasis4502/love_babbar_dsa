/* Ref: https://www.youtube.com/watch?v=jCOJk4UyO8w */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        longestPalin(str);
        sc.close();
    }

    private static void longestPalin(String s) {
        int l, h;

        int start = 0, end = 1;

        for (int i = 1; i < s.length(); i++) {
            // Even substring
            l = i - 1;
            h = i;

            while (l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {
                if (h - l + 1 > end) {
                    start = l;
                    end = h - l + 1;
                }

                l--;
                h++;
            }

            // Odd part
            l = i - 1;
            h = i + 1;

            while (l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)) {
                if (h - l + 1 > end) {
                    start = l;
                    end = h - l + 1;
                }
                l--;
                h++;
            }
        }
        System.out.println(s.substring(start, start + end));
    }
}
