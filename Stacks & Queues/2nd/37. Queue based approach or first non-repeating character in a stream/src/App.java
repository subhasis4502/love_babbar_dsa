import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        String str = "aabc";
        firstNonRepeating(str);
    }

    private static void firstNonRepeating(String str) {
        int[] isRepeat = new int[26];
        Queue<Character> dq = new LinkedList<>();
        String res = "";

        for (char c : str.toCharArray()) {
            if (isRepeat[c - 'a'] == 0)
                dq.add(c);
            isRepeat[c - 'a']++;

            while(!dq.isEmpty() && isRepeat[dq.peek()-'a'] != 1)
                dq.remove();
            res += (dq.isEmpty() ? "#" : dq.peek());
        }
        System.out.println(res);
    }
}
