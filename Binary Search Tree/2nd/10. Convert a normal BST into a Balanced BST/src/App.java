/* Ref: https://www.youtube.com/watch?v=ceGBg3g18js */

import java.util.ArrayList;

class Node {
    int data;
    Node left, right, next;

    Node(int data) {
        this.data = data;
        left = right = next = null;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node root = new Node(7);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(4);
        root.left.left.left.left = new Node(3);
        root.left.left.left.left.left = new Node(2);
        root.left.left.left.left.left.left = new Node(1);

        traverse(root);
        System.out.println();
        root = balanceBst(root);
        traverse(root);
    }

    static ArrayList<Node> arr = new ArrayList<>();

    private static Node balanceBst(Node root) {
        inorder(root);
        return insert(0, arr.size()-1);
    }

    private static Node insert(int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node n = arr.get(mid);
        n.left = insert(start, mid - 1);
        n.right = insert(mid + 1, end);
        return n;
    }

    private static void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.left);
        arr.add(root);
        inorder(root.right);
    }

    private static void traverse(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        traverse(root.left);
        traverse(root.right);
    }
}
