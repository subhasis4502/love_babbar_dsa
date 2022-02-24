/* Ref: https://www.youtube.com/watch?v=QMlDCR9xyd8 */

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Stack<Integer> s = new Stack<>();
        s.push(18);
        s.push(19);
        s.push(29);
        s.push(15);
        s.push(16);

        System.out.println(mid(s));
    }

    static int mid = Integer.MAX_VALUE;

    public void push(int a, Stack<Integer> s) {
        if (a < mid)
            mid = a;

        s.push(a);
    }

    public int pop(Stack<Integer> s) {
        return s.pop();
    }

    static public int mid(Stack<Integer> s) {
        return mid;
    }

    public boolean isFull(Stack<Integer> s, int n) {
        return s.size() == n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        return s.isEmpty();
    }
}
