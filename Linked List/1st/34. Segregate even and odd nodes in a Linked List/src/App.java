class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(9);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(6);

        traverse(head);
        head = segregate(head);
        System.out.println();
        traverse(head);
    }

    private static Node segregate(Node head) {
        Node odd = new Node(-1);
        Node oddHead = odd;
        Node even = new Node(-1);
        Node evenHead = even;

        while (head != null) {
            if (head.data % 2 == 0) {
                even.next = new Node(head.data);
                even = even.next;
            } else {
                odd.next = new Node(head.data);
                odd = odd.next;
            }
            head = head.next;
        }

        even.next = oddHead.next;
        return evenHead.next;
    }

    private static void traverse(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("NULL");
    }
}
