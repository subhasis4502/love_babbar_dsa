/* Ref: https://www.youtube.com/watch?v=hgcKeJiBCc8 */

import java.util.PriorityQueue;

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
        Node head = new Node(3);
        Node node2 = new Node(6);
        Node node3 = new Node(2);
        Node node4 = new Node(12);
        Node node5 = new Node(56);
        Node node6 = new Node(8);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        node2.prev = head;
        node3.prev = node2;
        node4.prev = node3;
        node5.prev = node4;
        node6.prev = node5;

        traverse(head);
        head = sort(head, 2);
        System.out.println();
        traverse(head);
    }

    private static Node sort(Node head, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = k + 1;
        while (count-- > 0) {
            pq.add(head.data);
            head = head.next;
        }

        Node res = null;
        Node resHead = null;
        while (head != null) {
            // Removing from heap and add to result
            if (res == null) {
                res = new Node(pq.poll());
                resHead = res;
            } else {
                res.next = new Node(pq.poll());
                res = res.next;
            }

            // Adding the next elements
            pq.add(head.data);
            head = head.next;
        }

        // Adding the remaining element
        while (!pq.isEmpty()) {
            res.next = new Node(pq.poll());
            res = res.next;
        }

        return resHead;
    }

    private static void traverse(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
