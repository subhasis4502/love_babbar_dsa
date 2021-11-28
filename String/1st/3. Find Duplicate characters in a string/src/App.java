import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        duplicateChar(str);
        sc.close();
    }

    private static void duplicateChar(String str) {
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : str.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        System.out.print("Duplicate characters: ");
        for (char c : hash.keySet()) {
            if (hash.get(c) > 1)
                System.out.print(c + " ");
        }
    }
}
