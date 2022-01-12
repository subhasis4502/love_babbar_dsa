/* Ref: https://www.youtube.com/watch?v=gbASJJAvAGk */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        firstNonRepeating("aabc");
    }

    private static void firstNonRepeating(String string) {
        String ans = "";
        int isRepeated[] = new int[26];
        Deque<Character> queue = new ArrayDeque<>();
        for (char ch : string.toCharArray()) {
            if (isRepeated[ch - 'a'] == 0)
                queue.add(ch);

            isRepeated[ch - 'a']++;
            while (!queue.isEmpty() && isRepeated[queue.peek() - 'a'] != 1)
                queue.poll();
            ans += (queue.isEmpty() ? '#' : queue.peek());

        }
        System.out.println("Non-repeating char: " + ans);
    }
}
