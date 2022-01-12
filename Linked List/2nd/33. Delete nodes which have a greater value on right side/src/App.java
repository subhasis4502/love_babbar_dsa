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
        Node head = new Node(12, null);
        head.next = new Node(15, null);
        head.next.next = new Node(10, null);
        head.next.next.next = new Node(11, null);
        head.next.next.next.next = new Node(5, null);
        head.next.next.next.next.next = new Node(6, null);
        head.next.next.next.next.next.next = new Node(2, null);
        head.next.next.next.next.next.next.next = new Node(3, null);

        traverse(head);
        System.out.println();
        head = compute(head);
        traverse(head);
    }

    private static Node compute(Node head) {
        // For the last node
        if (head == null || head.next == null)
            return head;

        // Coming to the last node
        Node ans = compute(head.next);

        if (ans.data > head.data) {
            return ans;
        } else {
            head.next = ans;
            return head;
        }
    }

    private static void traverse(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("NULL");
    }
}
