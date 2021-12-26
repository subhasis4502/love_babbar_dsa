/* 
Test:
I/P - ABC O/P - ABC ACB BAC BCA CBA CAB
*/

import java.util.*;

public class App {
    static List<String> res = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        find_permutation(str);
        sc.close();
    }

    private static void find_permutation(String str) {
        String asf = "";
        helper(str, asf);
        Collections.sort(res);

        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

    private static void helper(String s, String asf) {
        if (s.length() == 0) {
            res.add(asf);
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            helper(left + right, asf + c);
        }
    }
}
