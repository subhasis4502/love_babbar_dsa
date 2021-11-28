/* Ref: https://www.youtube.com/watch?v=Ylz6mwghDrU */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        minimumNumberOfSwaps(str);
        sc.close();
    }

    static void minimumNumberOfSwaps(String S) {

        if (S.length() % 2 == 1)
            return;

        int count = 0;
        int open = 0;
        int close = 0;
        int fault = 0;

        for (char c : S.toCharArray()) {
            if (c == ']') {
                close++;
                fault = close - open;
            } else {
                open++;
                if (fault > 0) {
                    count += fault;
                    fault--;
                }
            }
        }
        System.out.println("Minimum number of swaps: " + count);
    }
}
