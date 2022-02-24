import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "GeeksforGeeks";
        reverse(s);
    }

    private static void reverse(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            st.push(c);
        }
        String res = "";
        while(!st.isEmpty()){
            res += st.pop();
        }
        System.out.println(res);
    }
}
