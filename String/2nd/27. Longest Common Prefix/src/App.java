import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] str = new String[size];
        for (int i = 0; i < size; i++) {
            str[i] = sc.nextLine();
        }
        String res = longestCommonPrefix(str);
        System.out.println("Longest prefix: " + res);
        sc.close();
    }

    private static String longestCommonPrefix(String[] str) {
        if (str.length == 1)
            return str[0];

        Arrays.sort(str); // Taking the smallest word first
        String ans = "";

        if (str[0].length() == 0)
            return ans;

        for (int j = 0; j < str[0].length(); j++) {
            for (int i = 0; i < str.length - 1; i++) {
                if (str[i].charAt(j) != str[i + 1].charAt(j))
                    return ans;
            }
            ans += str[0].charAt(j);
        }
        return ans;

    }
}
