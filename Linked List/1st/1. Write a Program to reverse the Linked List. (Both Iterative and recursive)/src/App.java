/* 
Output: 
Iterative Traversal:
1 -> 2 -> 3 -> 4 -> NULL
Recursive Traversal:
1 -> 2 -> 3 -> 4 -> NULL
*/

import java.util.Scanner;

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

        System.out.println("Iterative Traversal:");
        iterativeTraverse(head);
        System.out.println();
        System.out.println("Recursive Traversal:");
        recursiveTraverse(head);
    }

    private static void recursiveTraverse(Node node) {
        if (node == null) {
            System.out.print("NULL");
            return;
        }
        System.out.print(node.data + " -> ");
        recursiveTraverse(node.next);
    }

    private static void iterativeTraverse(Node node) {
        while (node != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("NULL");
    }
}
