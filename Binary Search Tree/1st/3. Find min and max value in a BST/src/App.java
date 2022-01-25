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
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        findMinMax(root);
    }

    private static void findMinMax(Node root) {
        System.err.println("Minimum value: " + min(root));
        System.out.println("Maximum value: " + max(root));
    }

    private static int max(Node root) {
        if(root.right != null)
            return max(root.right);
        return root.data;
    }

    private static int min(Node root) {
        if(root.left != null)
            return min(root.left);
        return root.data;
    }
}
