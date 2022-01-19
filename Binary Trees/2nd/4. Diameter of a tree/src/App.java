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
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        diameter(root);
    }

    private static void diameter(Node root) {
        length(root);
        System.out.println("The diameter is: " + ans);
    }

    private static int length(Node root) {
        if (root == null)
            return 0;

        int l = length(root.left);
        int r = length(root.right);

        ans = Math.max(ans, l + r + 1);
        return (Math.min(l, r) + 1);
    }

}
