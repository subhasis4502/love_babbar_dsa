/* Ref: https://www.youtube.com/watch?v=XNAv8NrAwng */

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Stack<Integer> stack = new Stack<>();
        stack.push(11);
        stack.push(2);
        stack.push(32);
        stack.push(3);
        stack.push(41);

        sort(stack);
    }

    private static void sort(Stack<Integer> stack) {
        reverse(stack);
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    private static void reverse(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            reverse(stack);
            sortedInsert(stack, temp);
        }
    }

    private static void sortedInsert(Stack<Integer> stack, int temp) {
        if (stack.isEmpty() || temp > stack.peek()) {
            stack.push(temp);
            return;
        }

        int x = stack.pop();
        sortedInsert(stack, temp);
        stack.push(x);
    }
}
