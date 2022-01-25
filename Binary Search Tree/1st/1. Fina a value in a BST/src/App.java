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
        Node root = new Node(2);
        root.left = new Node(1);
        root.right = new Node(3);
        root.right.right = new Node(6);

        traverse(root);
        root = insert(root, 4);
        System.out.println();
        traverse(root);
    }

    private static void traverse(Node root) {
        if (root == null)
            return;

        traverse(root.left);
        System.out.print(root.data + " ");
        traverse(root.right);
    }

    private static Node insert(Node node, int n) {
        if (node == null)
            return (new Node(n));

        if (node.data > n)
            node.left = insert(node.left, n);

        if (node.data < n)
            node.right = insert(node.right, n);

        return node;
    }
}
