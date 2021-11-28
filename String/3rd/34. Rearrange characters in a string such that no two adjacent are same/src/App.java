import java.util.*;

class CharFr {
    char c;
    int f;

    CharFr(char c, int f) {
        this.c = c;
        this.f = f;
    }
}

class Ncomp implements Comparator<CharFr> {
    public int compare(CharFr c1, CharFr c2) {
        if (c1.f < c2.f)
            return 1;
        else if (c1.f > c2.f)
            return -1;
        return 0;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        rearrangeCharacters(str);
        sc.close();
    }

    public static void rearrangeCharacters(String str) {
        // code here
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<CharFr> pq = new PriorityQueue<CharFr>(new Ncomp());

        for (char c : map.keySet())
            pq.add(new CharFr(c, map.get(c)));
            
        CharFr temp = new CharFr('#', -1);
        String s = new String();
        while (!pq.isEmpty()) {
            CharFr obj = pq.poll();
            s = s + Character.toString(obj.c);
            obj.f--;
            if (temp.f > 0) {
                pq.add(temp);
            }
            temp = obj;
        }
        if (s.length() != str.length())
            System.out.println("Update not possible");
        else
            System.out.println("Updated string: " + s);
    }
}
