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
        root.left = new Node(-2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(-6);
        root.right.right = new Node(2);

        System.out.println("Maximum largest sum: " + subtreeSum(root));
    }

    static int max = 0;

    private static int subtreeSum(Node root) {
        if (root == null)
            return 0;

        int l = subtreeSum(root.left);
        int r = subtreeSum(root.right);

        max = Math.max(max, l + r + root.data);
        return l + r + root.data;
    }

}
