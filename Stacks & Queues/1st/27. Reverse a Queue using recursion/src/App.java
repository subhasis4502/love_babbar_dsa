import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        q = reverse(q);

        while (!q.isEmpty())
            System.out.print(q.remove() + " ");
    }

    private static Queue<Integer> reverse(Queue<Integer> q) {
        if (!q.isEmpty()) {
            int temp = q.remove();
            reverse(q);
            q.add(temp);
        }
        return q;
    }
}
