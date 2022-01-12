/* Ref: https://www.youtube.com/watch?v=EXPY4SNCbhQ */

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

        traverse(head);
        head = mergeSort(head);
        System.out.println();
        traverse(head);
    }

    private static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        // Breaking the list
        Node middle = getMiddle(head);
        Node nextMiddle = middle.next;
        middle.next = null;

        // Applying merge sort
        Node left = mergeSort(head);
        Node right = mergeSort(nextMiddle);
        Node sortedNode = merge(left, right);
        return sortedNode;
    }

    private static Node merge(Node left, Node right) {
        if (left == null)
            return right;
        if (right == null)
            return left;
        Node res = null;
        if (left.data <= right.data) {
            res = left;
            res.next = merge(left.next, right);
        } else {
            res = right;
            res.next = merge(left, right.next);
        }
        return res;
    }

    private static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
