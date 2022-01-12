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
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        node2.prev = head;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;
        node7.prev = node6;

        traverse(head);
        System.out.println();
        head = rotateByK(head, 5);
        traverse(head);
    }

    private static Node rotateByK(Node head, int k) {
        int len = 1;
        Node n = head;
        while(n.next != null){
            len++;
            n = n.next;
        }
        k = k%len;

        // Making a circular list
        n.next = head;
        head.prev = n;

        int loop = len-k-1;
        while(loop-->0){
            head = head.next;
        }
        // Disconnect the circular path
        Node newHead = head.next;
        head.next = null;
        newHead.prev = null;

        return newHead;
    }

    private static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data + " <-> ");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
