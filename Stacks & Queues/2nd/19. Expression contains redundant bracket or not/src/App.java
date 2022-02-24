/* Ref: https://www.youtube.com/watch?v=aMPXhEdpXFA */

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        String exp = "((a+(b)/c))";
        if (checkRedundancy(exp))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean checkRedundancy(String exp) {
        Stack<Character> stack = new Stack<>();

        for (char c : exp.toCharArray()) {
            if (c == ')') {
                if (stack.peek() == '(')
                    return true;
                else {
                    while (stack.peek() != '(')
                        stack.pop();
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        return false;
    }
}
