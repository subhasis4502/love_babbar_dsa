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
        head.next = new Node(9, null);
        head.next.next = new Node(9, null);
        head.next.next.next = new Node(9, null);

        traverse(head);
        head = addOne(head);
        System.out.println();
        traverse(head);
    }

    private static Node addOne(Node head) {
        if (head.next == null) {
            head.data += 1;
            return head;
        }

        Node n = addOne(head.next);

        if (n.data >= 9) {
            head.data += n.data / 10;
            n.data %= 10;

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
