/* Ref: https://www.youtube.com/watch?v=ZdIrKO7gqok */

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
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println("Maximum sum: " + getMaxSum(root));
    }

    static HashMap<Node, Integer> hash = new HashMap<>();

    static int getMaxSum(Node root) {
        if (root == null)
            return 0;

        // Checking if already calculated
        if (hash.containsKey(root))
            return hash.get(root);

        // Calculating the included sum
        int inc = root.data;

        if (root.left != null) {
            inc += getMaxSum(root.left.left);
            inc += getMaxSum(root.left.right);
        }

        if (root.right != null) {
            inc += getMaxSum(root.right.left);
            inc += getMaxSum(root.right.right);
        }

        // Calculating the excluded sum
        int exc = getMaxSum(root.left) + getMaxSum(root.right);

        hash.put(root, Math.max(inc, exc));

        return hash.get(root);
    }

}
