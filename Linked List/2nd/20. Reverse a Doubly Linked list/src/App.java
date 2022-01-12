class Node {
    int data;
    Node prev, next;

    public Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        node2.prev = head;
        node3.prev = node2;
        node4.prev = node3;

        traverse(head);
        head = reverse(head);
        System.out.println();
        traverse(head);
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
