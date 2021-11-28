import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (areRotations(str1, str2))
            System.out.println("Yes a rotaion");
        else
            System.out.println("Not a rotaion");
        sc.close();
    }

    private static boolean areRotations(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (l1 != l2)
            return false;

        else {
            String s = str1 + str1;
            for (int i = 0; i < s.length() - l2; i++) {
                if (s.substring(i, i + l2).compareTo(str2) == 0) {
                    return true;
                }
            }
            return false;
        }

    }
}
