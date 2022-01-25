/* Ref: https://www.youtube.com/watch?v=Bexswo4pqZQ */

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
        int[] pre = { 10, 5, 1, 7, 40, 50 };
        Node root = makeTree(pre);
        traverse(root);
    }

    private static Node makeTree(int[] pre) {
        int lr = Integer.MIN_VALUE;
        int rr = Integer.MAX_VALUE;
        return makeTree(pre, lr, rr);
    }

    static int index = 0;

    private static Node makeTree(int[] pre, int lr, int rr) {
        if (index >= pre.length || pre[index] < lr || pre[index] > rr)
            return null;

        Node node = new Node(pre[index++]);
        node.left = makeTree(pre, lr, node.data);
        node.right = makeTree(pre, node.data, rr);

        return node;
    }

    private static void traverse(Node root) {
        if (root == null)
            return;

        traverse(root.left);
        System.out.print(root.data + " ");
        traverse(root.right);
    }
}
