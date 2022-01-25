/* Ref: https://www.youtube.com/watch?v=W25l6evkk_U */

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
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(12);
        root.left.left = new Node(3);

        populateNext(root);
        traverse(root);
    }

    static Node prev = null;

    private static void populateNext(Node root) {
        if (root == null)
            return;

        populateNext(root.left);

        if (prev != null)
            prev.next = root;
        prev = root;

        populateNext(root.right);
    }

    private static void traverse(Node root) {
        if (root == null)
            return;

        traverse(root.left);
        if (root.next != null)
            System.out.println(root.data + " -> " + root.next.data);
        else
            System.out.println(root.data + " -> -1");

        traverse(root.right);
    }
}
