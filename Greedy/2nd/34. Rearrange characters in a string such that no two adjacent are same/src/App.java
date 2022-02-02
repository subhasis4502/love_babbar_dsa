/* Ref: https://www.youtube.com/watch?v=sSDAN_WwNwU */

import java.util.*;

class Pair {
    char c;
    int f;

    Pair(char c, int f) {
        this.c = c;
        this.f = f;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        String str = "geeksforgeeks";
        rearrangeCharacters(str);
    }

    private static void rearrangeCharacters(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((Pair a, Pair b) -> b.f-a.f);

        for (char c : map.keySet())
            pq.add(new Pair(c, map.get(c)));

        Pair temp = new Pair('#', -1);
        String s = "";
        while (!pq.isEmpty()) {
            Pair obj = pq.poll();
            s += Character.toString(obj.c);
            obj.f--;
            if (temp.f > 0)
                pq.add(temp);

            temp = obj;
        }
        if (s.length() != str.length())
            System.out.println("Not possible");
        else
            System.out.println(s);
    }
}
