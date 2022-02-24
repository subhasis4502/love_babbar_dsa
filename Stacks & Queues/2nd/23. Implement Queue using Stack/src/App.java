import java.util.Stack;

class StackQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void push(int val) {
        while (!s1.isEmpty())
            s2.push(s1.pop());

        s2.push(val);

        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    int pop() {
        if (s1.isEmpty())
            return -1;
        return s1.pop();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        StackQueue sq = new StackQueue();
        sq.push(2);
        sq.push(3);
        System.out.println(sq.pop());
        sq.push(4);
        System.out.println(sq.pop());
    }
}
