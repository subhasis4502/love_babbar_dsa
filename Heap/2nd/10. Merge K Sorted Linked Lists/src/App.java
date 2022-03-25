import java.util.PriorityQueue;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);

        Node h2 = new Node(4);
        h2.next = new Node(5);

        Node h3 = new Node(5);
        h3.next = new Node(6);

        Node h4 = new Node(7);
        h4.next = new Node(8);

        Node[] arr = { h1, h2, h3, h4 };
        mergeKList(arr, arr.length);
    }

    private static void mergeKList(Node[] arr, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((Node a, Node b) -> a.data - b.data);

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        Node headRes = null;
        Node res = null;

        while (!pq.isEmpty()) {
            Node temp = pq.remove();

            if (res == null) {
                res = new Node(temp.data);
                headRes = res;
            } else {
                res.next = new Node(temp.data);
                res = res.next;
            }

            if (temp.next != null) {
                temp = temp.next;
                pq.add(temp);
            }
        }

        while (headRes != null) {
            System.out.print(headRes.data + " -> ");
            headRes = headRes.next;
        }
    }
}
