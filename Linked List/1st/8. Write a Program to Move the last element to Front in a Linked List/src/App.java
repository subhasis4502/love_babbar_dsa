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

        traverse(head);
        head = lastToFirst(head);
        System.out.println();
        traverse(head);
    }

    private static Node lastToFirst(Node node) {
        Node prev = null;
        Node last = node;

        while(last.next != null){
            prev = last;
            last = last.next;
        }

        prev.next = null;
        last.next = node;

        return last;
    }

    private static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
