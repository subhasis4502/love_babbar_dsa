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
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(2, null);
        head.next.next.next = new Node(2, null);
        head.next.next.next.next = new Node(3, null);
        head.next.next.next.next.next = new Node(3, null);

        traverse(head);
        head = removeDuplicate(head);
        System.out.println();
        traverse(head);
    }

    private static Node removeDuplicate(Node head) {
        Node n = head;
        Node m = null;

        while (n != null && n.next != null) {
            m = n.next;
            while (m != null && n.data == m.data)
                m = m.next;
            n.next = m;
            n = n.next;
        }

        return head;
    }

    private static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
