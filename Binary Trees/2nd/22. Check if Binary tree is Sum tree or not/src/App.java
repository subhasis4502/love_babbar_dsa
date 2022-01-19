/* Ref: https://www.youtube.com/watch?v=zqA8FwxXSdU */

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class App {
    static boolean f = true;

    public static void main(String[] args) throws Exception {
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        if (isSumTree(root))
            System.out.println("This is a sum tree");
        else
            System.out.println("This is not a sum tree");
    }

    private static boolean isSumTree(Node root) {
        f = true;
        solve(root);
        return f;
    }

    private static int solve(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return root.data;

        if (!f)
            return 0;

        int a = solve(root.left);
        int b = solve(root.right);
        if (a + b != root.data)
            f = false;
        return a + b + root.data;
    }

}
