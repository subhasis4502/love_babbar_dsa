import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node head1 = new Node(10, null);
        head1.next = new Node(20, null);
        head1.next.next = new Node(40, null);
        head1.next.next.next = new Node(50, null);

        Node head2 = new Node(15, null);
        head2.next = new Node(40, null);

        Node res = intersection(head1, head2);
        traverse(res);
    }

    private static Node intersection(Node head1, Node head2) {
        Map<Integer, Integer> hash = new HashMap<>();
        while (head1 != null) {
            hash.put(head1.data, hash.getOrDefault(head1.data, 0) + 1);
            head1 = head1.next;
        }
        Node head = null;
        Node n = null;
        while (head2 != null) {
            if (hash.containsKey(head2.data)) {
                if (head == null) {
                    n = new Node(head2.data, null);
                    head = n;
                } else {
                    n.next = new Node(head2.data, null);
                    n = n.next;
                }

                if (hash.get(head2.data) == 1)
                    hash.remove(head2.data);
                else
                    hash.put(head2.data, hash.get(head2.data) - 1);
            }

            head2 = head2.next;
        }
        return head;
    }

    private static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data);
            node = node.next;
        }
    }
}
