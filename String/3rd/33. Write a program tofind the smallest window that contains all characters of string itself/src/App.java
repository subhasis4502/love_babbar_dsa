import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        findSubString(str);
        sc.close();
    }

    public static void findSubString(String str) {
        Set<Character> unique = new HashSet<>();
        int len = Integer.MAX_VALUE;

        for (char c : str.toCharArray())
            unique.add(c);

        int i = -1;
        int j = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        String res = "";

        while (true) {
            boolean f1 = false;
            boolean f2 = false;

            while (i < str.length() - 1 && map.size() < unique.size()) {
                i++;
                char ch = str.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
                f1 = true;
            }

            while (j < i && map.size() == unique.size()) {
                int plen = i - j;
                if (plen < len) {
                    len = plen;
                    res = str.substring(j + 1, i + 1);
                }

                j++;
                char ch = str.charAt(j);
                if (map.get(ch) == 1)
                    map.remove(ch);
                else
                    map.put(ch, map.get(ch) - 1);

                f2 = true;
            }

            if (f1 == false && f2 == false)
                break;
        }
        System.out.println("Smallest window: " + res);
    }
}
