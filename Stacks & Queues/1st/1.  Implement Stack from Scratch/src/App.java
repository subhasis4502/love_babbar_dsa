class Stack {
    private int maxSize;
    private int[] stArr;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stArr = new int[maxSize];
        top = -1;
    }

    public void push(int data) {
        if (!isFull())
            stArr[++top] = data;
        return;
    }

    public int pop() {
        if (!isEmpty())
            return stArr[top--];
        return -1;
    }

    public int peek() {
        if (!isEmpty())
            return stArr[top];
        return -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return maxSize == top+1;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Stack st = new Stack(5);
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(6);
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.peek());
    }
}
