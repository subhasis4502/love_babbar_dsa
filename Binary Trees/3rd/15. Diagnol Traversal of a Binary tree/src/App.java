/* Ref: https://www.youtube.com/watch?v=cvK3Sb6zJ1k */

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.left = new Node(80);
        root.right.right = new Node(90);

        diagonalTraversal(root);
    }

    private static void diagonalTraversal(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            // Traversing each component of that diagonal
            while (size-- > 0) {
                Node temp = q.poll();
                // Traversing a componenet
                while (temp != null) {
                    System.out.print(temp.data + " ");
                    if (temp.left != null)
                        q.add(temp.left);
                    temp = temp.right;
                }
            }
        }
    }

}
