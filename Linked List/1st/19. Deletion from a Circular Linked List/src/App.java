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
        head.next.next.next.next.next = head;

        traverse(head);
        Node n = deleteNode(head, 5);
        System.out.println();
        traverse(n);
    }

    private static Node deleteNode(Node head, int val) {
        // For head node
        if (head.data == val) {
            Node newHead = head.next;
            Node n = head;
            while (n.next != head)
                n = n.next;
            n.next = newHead;
            return newHead;
        } else {
            Node prev = head;
            Node curr = head.next;

            while(curr.next != head && curr.data != val){
                prev = curr;
                curr = curr.next;
            }

            prev.next = curr.next;
            return head;
        }
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
