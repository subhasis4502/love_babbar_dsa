import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (areIsomorphic(str1, str2))
            System.out.println("Isomorphic");
        else
            System.out.println("Not isomorphic");
        sc.close();
    }

    private static boolean areIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length())
            return false;

        Map<Character, Character> hash1 = new HashMap<>();
        Map<Character, Character> hash2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (!hash1.containsKey(c1) && !hash2.containsKey(c2)) {
                hash1.put(c1, c2);
                hash2.put(c2, c1);
            } else if (hash1.containsKey(c1) && hash1.get(c1) != c2)
                return false;
            else if (hash2.containsKey(c2) && hash2.get(c2) != c1)
                return false;
        }
        return true;
    }
}
