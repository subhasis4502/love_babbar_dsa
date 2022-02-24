import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "{([])}";
        if (isValid(s))
            System.out.println("Parenthesis valid");
        else
            System.out.println("Parenthesis is invalid");
    }

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(')
                    return false;
                else
                    stack.pop();
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{')
                    return false;
                else
                    stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[')
                    return false;
                else
                    stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
