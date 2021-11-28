/* Ref: https://www.youtube.com/watch?v=Ke8TPhHdHMw */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        findsubsequences(str, "");
        sc.close();
    }

    private static void findsubsequences(String str, String string) {
        if (str.length() == 0) {
            if (string.length() != 0)
                System.out.print(string + " ");
            return;
        }

        char ch = str.charAt(0);
        String roq = str.substring(1);

        findsubsequences(roq, string + "");
        findsubsequences(roq, string + ch);
    }
}
