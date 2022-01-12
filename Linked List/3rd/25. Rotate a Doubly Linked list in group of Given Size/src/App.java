import java.nio.file.NotLinkException;

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
        Node node8 = new Node(8);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        node2.prev = head;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;
        node7.prev = node6;
        node8.prev = node7;

        traverse(head);
        System.out.println();
        head = reverseInGroup(head, 3);
        traverse(head);
    }

    private static Node reverseInGroup(Node head, int k) {
        Node n = head;
        while(n != null){
            // Placing two pointers
            Node i = n;
            int count = k;
            Node j = n;
            while(count --> 1 && j.next != null){
                j = j.next;
            }
            Node nex = j;
            int loop = k/2;
            
            // Reversing the group
            while(loop --> 0 && i != null && j != null){
                int temp = i.data;
                i.data = j.data;
                j.data = temp;

                i = i.next;
                j = j.prev;
            }
            n = nex.next;
        }
        return head;
    }

    private static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data + " <-> ");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
