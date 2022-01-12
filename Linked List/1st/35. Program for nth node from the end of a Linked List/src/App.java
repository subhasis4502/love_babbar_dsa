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
        head.next.next = new Node(3, null);
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = new Node(5, null);
        head.next.next.next.next.next = new Node(6, null);
        head.next.next.next.next.next.next = new Node(7, null);

        traverse(head);
        System.out.println("\n5th node from end: " + nthNode(head, 5));
    }

    private static int nthNode(Node head, int n) {
        int length = 0;
        Node n1 = head;
        while (n1 != null) {
            n1 = n1.next;
            length++;
        }

        int count = 0;
        while (count != length - n && head != null) {
            head = head.next;
            count++;
        }
        if (head != null)
            return head.data;
        return -1;
    }

    private static void traverse(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("NULL");
    }
}
