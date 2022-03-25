class Node {
    int data;
    Node left, right;

    public Node(int data) {
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

        if (isHeap(root))
            System.out.println("This is a heap");
        else
            System.out.println("This is not a heap");
    }

    private static boolean isHeap(Node root) {
        if (root == null)
            return true;
        if (root.left == null && root.right != null)
            return false;
        if (root.left == null && root.right == null)
            return true;
        if (root.right != null && root.right.left != null && root.right.right != null)
            return false;
        if (root.right != null)
            return root.data > root.left.data && root.data > root.right.data;

        return isHeap(root.left) && isHeap(root.right) && root.data > root.left.data;
    }
}
