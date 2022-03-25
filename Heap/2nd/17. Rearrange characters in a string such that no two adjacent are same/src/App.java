/* Ref: https://www.youtube.com/watch?v=69u_bfwoHm0 */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "geeksforgeeks";
        Map<Character, Integer> hash = new HashMap<>();
        int max = 0;

        for (char c : s.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
            if (hash.get(c) > max)
                max = hash.get(c);
        }

        if (max <= s.length() - max + 1)
            System.out.println("Possible");
        else
            System.out.println("Not possible");
    }
}
