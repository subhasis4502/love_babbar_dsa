import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Pair {
    int level;
    Node node;

    Pair(int level, Node node) {
        this.level = level;
        this.node = node;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        if (isBalanced(root))
            System.out.println("The tree is balanced");
        else
            System.out.println("The tree is not balanced");
    }

    private static boolean isBalanced(Node root) {
        if (root == null)
            return true;

        int l = height(root.left);
        int r = height(root.right);

        if (Math.abs(l - r) < 2 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    private static int height(Node root) {
        if (root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);

        return (Math.max(left, right) + 1);
    }

}
