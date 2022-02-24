import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        String s = "231*+9-";
        evaluatePostFix(s);
    }

    private static void evaluatePostFix(String s) {
        Stack<Integer> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(c >= '0' && c<= '9')
                stack.push(c - '0');
            else{
                int b = stack.pop();
                int a = stack.pop();
                if(c == '+')
                    stack.push(a+b);
                else if(c == '-')
                    stack.push(a-b);
                else if(c == '*')
                    stack.push(a*b);
                else if(c == '/')
                    stack.push(a/b);
                else if(c == '^')
                    stack.push((int)Math.pow(a, b));
            }
        }

        System.out.println(s + " = " + stack.pop());
    }
}
