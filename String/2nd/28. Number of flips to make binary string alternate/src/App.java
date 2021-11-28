/* Ref: https://www.youtube.com/watch?v=F0E7k6X_kt8 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        minFlips(str);
        sc.close();
    }

    public static void minFlips(String S) {
        // Code here
        int c1 = 0, c2 = 0;
        for (int i = 0; i < S.length(); i++) {
            if (i % 2 == 0) {
                if (S.charAt(i) == '1')
                    c1++;
                else
                    c2++;
            } else {
                if (S.charAt(i) == '0')
                    c1++;
                else
                    c2++;
            }
        }
        System.out.println("Min flips require: " + Math.min(c1, c2));
    }
}
