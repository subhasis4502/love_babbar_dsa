/* Ref: https://www.youtube.com/watch?v=DZXb4UGl-v4 */

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
        head = quickSort(head);
        System.out.println();
        traverse(head);
    }

    private static Node quickSort(Node head) {
        Node start = head;
        Node end = head;

        while (end.next != null)
            end = end.next;

        return quickSortHelper(start, end);
    }

    private static Node quickSortHelper(Node start, Node end) {
        if (start == end)
            return start;

        Node pivot = partition(start, end);
        if (pivot != null && start != null)
            quickSortHelper(start, pivot);

        if (pivot != null && pivot.next != null)
            quickSortHelper(pivot.next, end);

        return start;
    }

    private static Node partition(Node start, Node end) {
        Node front = start;
        Node pivot = start;
        int temp = 0;

        while (front != null && front != end) {
            if (front.data < end.data) {
                // Swapping
                pivot = start;
                temp = start.data;
                start.data = front.data;
                front.data = temp;
                start = start.next;
            }
            front = front.next;
        }

        temp = start.data;
        start.data = end.data;
        end.data = temp;
        return pivot;
    }

    private static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
