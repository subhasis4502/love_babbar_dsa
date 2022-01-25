/* Ref: https://www.youtube.com/watch?v=eZMCRBrMznA */

import java.util.*;

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
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        if (isDeadEnd(root))
            System.out.println("There is a deadend");
        else
            System.out.println("There is a no deadend");
    }

    private static boolean isDeadEnd(Node root) {
        Set<Integer> tree = new HashSet<>();
        ArrayList<Integer> leaf = new ArrayList<>();

        inorder(root, tree, leaf);
        for (int i : leaf) {
            if (tree.contains(i - 1) && tree.contains(i + 1))
                return true;
        }
        return false;
    }

    private static void inorder(Node root, Set<Integer> tree, ArrayList<Integer> leaf) {
        if (root == null)
            return;
        inorder(root.left, tree, leaf);
        if (root.left == null && root.right == null)
            leaf.add(root.data);
        tree.add(root.data);
        inorder(root.right, tree, leaf);
    }

}