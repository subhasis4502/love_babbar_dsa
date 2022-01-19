/* Ref: https://www.youtube.com/watch?v=_j7yb_nWFO8 */

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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.right = new Node(4);
        root.right.left.left = new Node(4);

        dupSub(root);
    }

    static Map<String, Integer> m = new HashMap<>();
    static List<Node> dup = new ArrayList<>();

    static void dupSub(Node root) {
        solve(root);
        for (Node n : dup) {
            preOrder(n);
            System.out.println();
        }
    }

    private static void preOrder(Node n) {
        if (n == null)
            return;
        System.out.print(n.data + " ");
        preOrder(n.left);
        preOrder(n.right);
    }

    static String solve(Node root) {
        if (root == null)
            return "";

        String s = "(";
        s += solve(root.left);
        s += Integer.toString(root.data);
        s += solve(root.right);
        s += ")";

        if (m.get(s) != null && m.get(s) == 1)
            dup.add(root);

        m.put(s, m.getOrDefault(s, 0) + 1);

        return s;
    }
}
