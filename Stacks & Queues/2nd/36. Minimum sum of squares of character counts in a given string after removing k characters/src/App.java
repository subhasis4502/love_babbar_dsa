import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "aabcbcbcabcc";
        int k = 3;
        minValue(s, k);
    }

    private static void minValue(String s, int k) {
        HashMap<Character, Integer> hash = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            hash.put(s.charAt(i), hash.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (char c : hash.keySet())
            pq.add(hash.get(c));

        while (k != 0) {
            int x = pq.remove();
            x--;
            pq.add(x);
            k--;
        }

        int sum = 0;
        while (!pq.isEmpty()) {
            sum += Math.pow(pq.remove(), 2);
        }
        System.out.println("The value is: " + sum);
    }
}
