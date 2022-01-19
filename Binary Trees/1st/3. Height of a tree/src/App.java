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

        System.out.println("Height of the tree: " + height(root));
    }

    private static int height(Node root) {
        if (root == null)
            return 0;

        int l = height(root.left);
        int r = height(root.right);

        return (Math.max(l, r)+1);
    }

}
