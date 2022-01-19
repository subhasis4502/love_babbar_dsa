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

        traversal(root);
        System.out.println();
        mirrior(root);
        traversal(root);
    }

    private static void mirrior(Node root) {
        if (root == null)
            return;

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrior(root.left);
        mirrior(root.right);
    }

    private static void traversal(Node root) {
        if (root == null)
            return;

        traversal(root.left);
        System.out.print(root.data + " ");
        traversal(root.right);
    }

}
