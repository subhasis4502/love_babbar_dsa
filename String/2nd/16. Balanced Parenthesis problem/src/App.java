/* Ref: https://www.youtube.com/watch?v=uuE2pEjLiEI */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(isPar(str))
            System.out.println("Balanced");
        else
            System.out.println("Not balanced");
        sc.close();
    }

    private static boolean isPar(String str) {
        Stack<Character> st = new Stack<>();
        for(char c : str.toCharArray()){
            if(c == '(' || c == '{' || c == '[')
                st.push(c);
            else if(c == ')'){
                if(st.isEmpty() || st.peek() != '(')
                    return false;
                else
                    st.pop();
            }
            else if(c == '}'){
                if(st.isEmpty() || st.peek() != '{')
                    return false;
                else
                    st.pop();
            }
            else if(c == ']'){
                if(st.isEmpty() || st.peek() != '[')
                    return false;
                else
                    st.pop();
            }
        }
        
        if(st.isEmpty())
            return true;
        return false;
    }
}
