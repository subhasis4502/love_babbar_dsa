/* Ref: https://www.youtube.com/watch?v=LmHWIsBQBU4 */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        String[] dict = {"cats", "cat", "and", "sand", "dog"};
        String s = "catsanddog";
        wordBreak(dict, s);
    }

    private static void wordBreak(String[] dict, String sentence) {
        HashSet<String> dictionary = new HashSet<>();
        for(String s : dict){
            dictionary.add(s);
        }
        solve(sentence, "", dictionary);
    }
    private static void solve(String sen, String ans, HashSet<String> dict) {
        if(sen.length() == 0){
            System.out.println(ans);
            return;
        }
        
        for(int i = 0; i<sen.length(); i++){
            String left = sen.substring(0, i+1);
            if(dict.contains(left)){
                String right = sen.substring(i+1);
                solve(right, ans + left + " ", dict);
            }
        }
    }
}
