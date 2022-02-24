import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Stack<Character> stack = new Stack<>();
        stack.push('a');
        stack.push('b');
        stack.push('c');
        stack.push('d');
        stack.push('e');

        reverse(stack);
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    private static void reverse(Stack<Character> stack) {
        if (stack.isEmpty())
            return;
        char x = stack.pop();
        reverse(stack);
        insertBottom(stack, x);
    }

    private static void insertBottom(Stack<Character> stack, char x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        char temp = stack.pop();
        insertBottom(stack, x);
        stack.push(temp);
    }
}
