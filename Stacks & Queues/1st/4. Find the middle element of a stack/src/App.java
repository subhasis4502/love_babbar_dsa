import java.util.ArrayList;

class Stack {
    private int maxSize;
    private ArrayList<Integer> stArr;
    private int top;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stArr = new ArrayList<>(maxSize);
        top = -1;
    }

    public void push(int data) {
        if (!isFull()){
            stArr.add(data);
            top++;
        }
        return;
    }

    public int pop() {
        if (!isEmpty()){
            top--;
            return stArr.remove(stArr.size()-1);
        }
        return -1;
    }

    public int peek() {
        if (!isEmpty())
            return stArr.get(top);
        return -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return maxSize == top + 1;
    }

    public int mid() {
        if(!isEmpty())
            return stArr.get(stArr.size()/2);
        return -1;
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

        System.out.println(st.mid());
        st.pop();
        st.pop();
        System.out.println(st.mid());
    }
}
