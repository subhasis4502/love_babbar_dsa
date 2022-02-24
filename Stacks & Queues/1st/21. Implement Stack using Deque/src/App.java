import java.util.LinkedList;

class DoubleQueue {
    LinkedList<Integer> list = new LinkedList<>();

    boolean isEmpty() {
        return list.isEmpty();
    }

    void addFront(int val) {
        list.add(0, val);
    }

    void addEnd(int val) {
        list.add(val);
    }

    int removeFront() {
        if (isEmpty())
            return -1;
        return list.removeFirst();
    }

    int removeBack() {
        if (isEmpty())
            return -1;
        return list.removeLast();
    }
}

class MyStack {
    DoubleQueue dq = new DoubleQueue();

    boolean isEmpty() {
        return dq.isEmpty();
    }

    void push(int val) {
        dq.addFront(val);
    }

    int pop() {
        if (dq.isEmpty())
            return -1;
        return dq.removeFront();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
    }
}
