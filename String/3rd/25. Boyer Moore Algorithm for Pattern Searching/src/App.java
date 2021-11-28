/* Ref: https://www.youtube.com/watch?v=4Oj_ESzSNCk */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String pattern = sc.nextLine();
        ArrayList<Integer> res = boyerMooreAlgorithm(sentence, pattern);
        res.forEach((n) -> {
            if(n == -1)
                System.out.println("The pattern doesn't present");
            System.out.println("The pattern present at: " + n);
        });
        sc.close();
    }

    private static ArrayList<Integer> boyerMooreAlgorithm(String sentence, String pattern) {
        Map<Character, Integer> badMatchTable = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        int n = sentence.length();
        int m = pattern.length();

        // Creating the bad match table
        for (int i = 0; i < pattern.length(); i++)
            badMatchTable.put(pattern.charAt(i), m - i - 1);
        int star = m;
        badMatchTable.put(pattern.charAt(m - 1), star);

        // Implementing algorithm
        int i = 0;
        int j = i + m - 1;
        int k = m - 1;
        while (i <= n - m && j < n) {
            if (sentence.charAt(j) == pattern.charAt(k)) {
                j--;
                k--;
            } else {
                if (!badMatchTable.containsKey(sentence.charAt(j)))
                    i += star;
                else
                    i += badMatchTable.get(sentence.charAt(j));
                j = i + m-1;
                k = m - 1;
            }

            // When match found
            if (i == j){
                res.add(i + 1);
                i++;
                j = i+m-1;
                k = m-1;
            }
        }
        if (res.isEmpty())
            res.add(-1);
        return res;
    }
}
