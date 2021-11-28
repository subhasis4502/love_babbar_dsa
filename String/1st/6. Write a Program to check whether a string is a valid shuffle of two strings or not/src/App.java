import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        if (shuffleCheck(str, s1, s2))
            System.out.println(str + " is a valid shuffle of " + s1 + " and " + s2);
        else
            System.out.println(str + " is not a valid shuffle of " + s1 + " and " + s2);
        sc.close();
    }

    private static boolean shuffleCheck(String str, String s1, String s2) {
        if (str.length() != s1.length() + s2.length())
            return false;
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : str.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (char c : s1.toCharArray()) {
            if (hash.containsKey(c)) {
                if (hash.get(c) > 1)
                    hash.put(c, hash.get(c) - 1);
                else
                    hash.remove(c);
            }
            else
                return false;
        }

        for (char c : s2.toCharArray()) {
            if (hash.containsKey(c)) {
                if (hash.get(c) > 1)
                    hash.put(c, hash.get(c) - 1);
                else
                    hash.remove(c);
            }
            else
                return false;
        }

        if (hash.isEmpty())
            return true;
        return false;
    }
}
