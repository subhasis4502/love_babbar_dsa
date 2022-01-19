/* Ref: https://www.youtube.com/watch?v=XpeA8w44xeo */

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
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        traversal(root);
        System.out.println();
        sumTree(root);
        traversal(root);
    }

    private static void sumTree(Node root) {
        helper(root);
    }

    private static int helper(Node root) {
        if(root == null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);
        int x = root.data;
        root.data = l+r;

        return l+r+x;
    }

    private static void traversal(Node root) {
        if (root == null)
            return;

        traversal(root.left);
        System.out.print(root.data + " ");
        traversal(root.right);
    }
    
}
