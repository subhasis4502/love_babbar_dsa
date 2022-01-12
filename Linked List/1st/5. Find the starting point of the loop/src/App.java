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
        head.next.next.next.next = head.next;

        detectFirstNode(head);
    }

    private static void detectFirstNode(Node head) {
        Node meet = detectLoop(head);
        Node start = head;

        while(meet != start){
            start = start.next;
            meet = meet.next;
        }

        System.out.println("Loop start at: " + start.data);
    }

    private static Node detectLoop(Node head) {
        Node slow = head;
        Node fast= head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return slow;
        }
        
        return null;
    }
}
