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
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(6);
        root.left.left = new Node(3);
        root.right.right = new Node(7);

        Node n = lca(root, 3, 7);
        System.out.println("Lowest common ancestor: " + n.data);
    }

    private static Node lca(Node root, int n1, int n2) {
        if (root == null)
            return null;

        if (root.data == n1 || root.data == n2)
            return root;

        Node l = lca(root.left, n1, n2);
        Node r = lca(root.right, n1, n2);

        if (l != null && r != null)
            return root;
        else if (l != null)
            return root.left;
        else
            return root.right;
    }
}