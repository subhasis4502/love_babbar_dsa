import java.util.*;

class Pair {
    char val;
    int count;

    Pair(char a, int b) {
        val = a;
        count = b;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        String s = "aaab";
        System.out.println(reorganizeString(s));
    }

    private static String reorganizeString(String s) {
        // Counting characters
        HashMap<Character, Integer> hash = new HashMap<>();
        for (char c : s.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
        // Putting into max-heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> b.count - a.count);
        for (char key : hash.keySet()) {
            pq.add(new Pair(key, hash.get(key)));
        }

        String res = "";
        Pair block = null;
        while (!pq.isEmpty()) {
            Pair temp = pq.remove();

            res += temp.val;
            temp.count--;

            if (block != null && block.count != 0)
                pq.add(block);
            block = temp;
        }

        if (res.length() == s.length())
            return res;
        return "Not possible";
    }
}
