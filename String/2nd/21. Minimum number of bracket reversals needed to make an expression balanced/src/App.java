import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        countRev(str);
        sc.close();
    }

    static void countRev(String s) {
        if (s.length() % 2 == 0) {
            int open = 0;
            int close = 0;
            for (char c : s.toCharArray()) {
                if (c == '{') open++;
                else if (open != 0) open--;
                else close++;
            }
            int res = (int) (Math.ceil(open / 2.0) + Math.ceil(close / 2.0));
            System.out.println("Minimum reversal reuired: " + res);
        } else
            System.out.println("Not Possible");
    }
}
