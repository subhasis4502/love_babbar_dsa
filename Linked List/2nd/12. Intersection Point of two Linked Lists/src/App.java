class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node head = new Node(3);
        Node a = new Node(6);
        Node b = new Node(9);
        Node c = new Node(10);
        Node d = new Node(15);
        Node e = new Node(30);

        head.next = a;
        a.next = b;
        b.next = d;
        d.next = e;
        c.next = d;

        Node in = intersectingPoint(head, c);
        System.out.println("Insertion point: " + in.data);
    }

    private static Node intersectingPoint(Node head1, Node head2) {
        int len1 = 0, len2 = 0;
        Node n1 = head1, n2 = head2;

        // calculating the lengths
        while (n1 != null) {
            len1++;
            n1 = n1.next;
        }

        while (n2 != null) {
            len2++;
            n2 = n2.next;
        }

        // Take two nodes to the same level
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            if (len1 > len2)
                head1 = head1.next;
            else
                head2 = head2.next;
        }

        while (head1.next != head2.next) {
            head1 = head1.next;
            head2 = head2.next;
        }

        return head1.next;
    }
}
