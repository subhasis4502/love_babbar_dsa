class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class App {
    static Node newList1, newList2;

    public static void main(String[] args) throws Exception {
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = head;
        // head.next.next.next.next = new Node(5, null);
        // head.next.next.next.next.next = head;

        splitList(head);
        traverse(newList1);
        System.out.println();
        traverse(newList2);
    }

    private static void splitList(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (true) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == head || fast.next == head)
                break;
        }

        newList2 = slow.next;
        newList1 = head;
        Node head2 = newList2;
        slow.next = newList1;

        while (head2.next != head)
            head2 = head2.next;

        if (fast != head)
            fast.next = newList2;
        else
            head2.next = newList2;
    }

    private static void traverse(Node node) {
        System.out.print(node.data + " -> ");
        Node n = node.next;
        while (n != node) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.print("NULL");
    }
}
