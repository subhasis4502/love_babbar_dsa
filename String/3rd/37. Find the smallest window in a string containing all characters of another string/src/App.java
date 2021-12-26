/* Ref: https://www.youtube.com/watch?v=e1HlptlipB0 */

/* 
Test:
I/P - 
dbaecbbabdcaafbddcabgba
abbcdc

O/P - Smallest window: cbbabdc
*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(smallestWindow(str1, str2));
        sc.close();
    }

    public static String smallestWindow(String s, String p) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : p.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        int count = 0;
        int mcount = p.length();
        int start = 0;
        int end = s.length() - 1;

        int i = -1;
        int j = -1;
        HashMap<Character, Integer> hash = new HashMap<>();
        while (true) {
            boolean f1 = false;
            boolean f2 = false;
            // Acquaring
            while (i < s.length() - 1 && count < mcount) {
                i++;
                char c = s.charAt(i);
                hash.put(c, hash.getOrDefault(c, 0) + 1);
                if (hash.getOrDefault(c, 0) <= freq.getOrDefault(c, 0))
                    count++;
                f1 = true;
            }
            // Releasing
            while (j < i && count == mcount) {
                // Storing the answer
                if (end - start > i - j) {
                    start = j + 1;
                    end = i + 1;
                }
                j++;
                char c = s.charAt(j);
                // Removing from hash
                if (hash.get(c) == 1)
                    hash.remove(c);
                else
                    hash.put(c, hash.get(c) - 1);

                if (hash.getOrDefault(c, 0) < freq.getOrDefault(c, 0))
                    count--;
                f2 = true;
            }

            if (!f1 && !f2)
                break;
        }
        if (start == 0 && end == s.length() - 1)
            return "No small window available";
        return ("Smallest window: " + s.substring(start, end));
    }
}
