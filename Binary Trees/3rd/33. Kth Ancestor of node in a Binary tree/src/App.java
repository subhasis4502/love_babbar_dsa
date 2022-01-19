/* Ref: GFG */

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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        k = 2;
        Node n = kthAncestor(root, 5);
        if (n != null)
            System.out.println("Not possible");
    }

    static Node temp = null;
    static int k;

    private static Node kthAncestor(Node root, int node) {
        if (root == null)
            return null;

        if (root.data == node || (temp = kthAncestor(root.left, node)) != null
                || (temp = kthAncestor(root.right, node)) != null) {
            if (k > 0)
                k--;
            else if (k == 0) {
                System.out.println("Kth ancestor: " + root.data);
                return null;
            }
            return root;
        }
        return null;
    }

}