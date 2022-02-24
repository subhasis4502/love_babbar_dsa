import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        insertEnd(stack, 9);
        display(stack);
    }

    private static void display(Stack<Integer> stack) {
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    private static void insertEnd(Stack<Integer> stack, int val) {
        if (stack.isEmpty()) {
            stack.push(val);
            return;
        }
        int x = stack.pop();
        insertEnd(stack, val);
        stack.push(x);
    }
}
