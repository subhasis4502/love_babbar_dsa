/* Ref: https://www.youtube.com/watch?v=6DraIPN_0no */

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

        distance(root, 30, 60);
    }

    private static void distance(Node root, int a, int b) {
        Node n = lca(root, a, b);
        int l = height(n, a, 0);
        int r = height(n, b, 0);
        System.out.println("Maximum distance: " + (l + r));
    }

    private static int height(Node root, int target, int depth) {
        if (root.data == target)
            return depth;

        int left = 0;
        int right = 0;
        if (root.left != null)
            left = height(root.left, target, depth + 1);
        if (root.right != null)
            right = height(root.right, target, depth + 1);

        return Math.max(left, right);
    }

    private static Node lca(Node node, int a, int b) {
        if (node == null || node.data == a || node.data == b)
            return node;

        Node left = lca(node.left, a, b);
        Node right = lca(node.right, a, b);

        if (left != null && right != null)
            return node;
        else if (left != null)
            return left;
        else if (right != null)
            return right;
        else
            return null;
    }

}
