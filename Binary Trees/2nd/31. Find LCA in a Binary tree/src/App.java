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
        Node root = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);

        System.out.println("Lowest common ancestor is: " + lca(root, 3, 4).data);
    }

    private static Node lca(Node root, int n1, int n2) {
        if (root == null)
            return null;

        else if (root.data == n1 || root.data == n2)
            return root;

        else {
            Node left = lca(root.left, n1, n2);
            Node right = lca(root.right, n1, n2);

            if (left != null && right != null)
                return root;
            else if (left != null)
                return left;
            else
                return right;
        }
    }
}
