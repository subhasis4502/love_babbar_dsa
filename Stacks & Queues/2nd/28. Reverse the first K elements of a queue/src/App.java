import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        int k = 3;
        Queue<Integer> queue = modifyQueue(q, k);
        while(!queue.isEmpty()){
            System.out.print(queue.remove() + " ");
        }
    }

    private static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++)
            stack.push(q.remove());

        while (!stack.isEmpty())
            queue.add(stack.pop());

        while (!q.isEmpty())
            queue.add(q.remove());

        return queue;
    }
}
