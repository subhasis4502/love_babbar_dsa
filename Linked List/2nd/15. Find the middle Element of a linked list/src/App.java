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
        Node head = new Node(3, null);
        head.next = new Node(5, null);
        head.next.next = new Node(2, null);
        head.next.next.next = new Node(4, null);
        head.next.next.next.next = new Node(1, null);

        Node mid = findMid(head);
        System.out.println("Middle element: " + mid.data);
    }

    private static Node findMid(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
