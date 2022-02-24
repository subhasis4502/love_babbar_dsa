import java.util.LinkedList;
import java.util.Queue;

class Queues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int val) {
        q2.add(val); // Adding the new element to q2

        // Adding all the elements of q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swapping q1 & q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public void pop() {
        if (q1.isEmpty())
            System.out.println("Nothing to pop");
        else
            System.out.println(q1.remove());
    }

}

public class App {
    public static void main(String[] args) throws Exception {
        Queues q = new Queues();
        q.push(2);
        q.push(3);
        q.pop();
        q.push(4);
        q.pop();
    }
}
