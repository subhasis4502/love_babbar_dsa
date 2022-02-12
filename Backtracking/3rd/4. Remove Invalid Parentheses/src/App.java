/* Ref: https://www.youtube.com/watch?v=Cbbf5qe5stw */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "()())()";
        removeInvalidParentheses(s);
    }

    private static void removeInvalidParentheses(String s) {
        int minRemove = getMin(s);
        solve(s, minRemove, new HashSet<>());
    }

    private static void solve(String str, int minRemove, HashSet<String> ans) {
        if (str.length() == 0)
            return;
            
        if (minRemove == 0) {
            if (getMin(str) == 0 && !ans.contains(str)) {
                System.out.println(str);
                ans.add(str);
            }
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i + 1);
            solve(left + right, minRemove - 1, ans);
        }
    }

    private static int getMin(String str) {
        Stack<Character> st = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                if (st.size() == 0) {
                    st.push(c);
                }else if(st.peek() == ')'){
                    st.push(c);
                } else if (st.peek() == '(') {
                    st.pop();
                }
            }
        }
        return st.size();
    }
}
