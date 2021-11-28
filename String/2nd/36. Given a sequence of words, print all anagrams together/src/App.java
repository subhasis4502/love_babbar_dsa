/* Ref: https://www.youtube.com/watch?v=NNBQik4phMI */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        String[] words = new String[size];
        for (int i = 0; i < size; i++) {
            words[i] = sc.next();
        }
        anagrams(words);
        sc.close();
    }

    public static void anagrams(String[] string_list) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> hash = new HashMap<>();

        for (String s : string_list) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray())
                map.put(c, map.getOrDefault(c, 0) + 1);

            if (hash.containsKey(map)) {
                ArrayList<String> arr = hash.get(map);
                arr.add(s);
                hash.put(map, arr);
            } else {
                ArrayList<String> arr = new ArrayList<>();
                arr.add(s);
                hash.put(map, arr);
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (HashMap<Character, Integer> h : hash.keySet()){
            hash.get(h).forEach((s)->{
                System.out.print(s + " ");
            });
            System.out.println();
        }
    }
}
