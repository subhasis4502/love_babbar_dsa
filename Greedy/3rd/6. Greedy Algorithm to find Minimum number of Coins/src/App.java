/* Ref: https://www.youtube.com/watch?v=NhnsINajZRA */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "ccba";
        chooseAndSwap(s);
    }

    private static void chooseAndSwap(String s) {
        Set<Character> set = new TreeSet<>();
        int n = s.length();
        char[] a = s.toCharArray();
        
        for(char c : a)
            set.add(c);
        for(int i = 0; i<n; i++){
            char c = set.iterator().next();
            set.remove(s.charAt(i));
            if (set.isEmpty()) 
                break;
                
            if(c<s.charAt(i)){
                char c2 = s.charAt(i);

                for (int j = 0; j<n; j++){
                    if (a[j]==c2) a[j] = c;
                    else if (a[j]==c) a[j] = c2;
                }
                break;
            }
        }
        System.out.println(String.valueOf(a));
    }
}
