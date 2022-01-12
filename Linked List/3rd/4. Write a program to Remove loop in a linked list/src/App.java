/* Ref: https://www.youtube.com/watch?v=jcZtMh_jov0 */

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

        detectLoop(head);
        removeLoop(head);
        detectLoop(head);
    }

    private static void removeLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Detecting the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        // If last node loop with the head node
        if (fast == head) {
            while (fast.next != slow)
                fast = fast.next;
            fast.next = null;

            // Other than head node
        } else if (fast == slow) {
            slow = head;
            while (fast.next != slow.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    public static void detectLoop(Node head) {
        if (head == null || head.next == null) {
            System.out.println("No loop");
            return;
        }

        Node fast = head;
        Node slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                System.out.println("Loop existed");
                return;
            }
        }
        System.out.println("No loop");
    }
}
