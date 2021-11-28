import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static ArrayList<String> res = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        solve(str, 0, str.length() - 1, 1, "");
        res.forEach((s)->{
            System.out.println(s);
        });
        sc.close();
    }

    private static void solve(String str, int i, int j, int level, String temp) {
        if (i == j + 1 && level == 5)
            res.add(temp.substring(1));

        // Digits of a number ranging 0-255 can lie only between
        // 0-3
        for (int k = i; k < i + 3 && k <= j; k++) {
            String ad = str.substring(i, k + 1);

            // Return if sting starting with '0' or it is
            // greater than 255.
            if (str.charAt(i) == '0' || Integer.valueOf(ad) > 255)
                return ;

            // Recursively call for another level.
            String s = temp + "." + ad;
            solve(str, k + 1, j, level + 1, s);
        }
    }
}
