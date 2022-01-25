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
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        findMedian(root);
    }

    static int count;
    static Node prev = null;
    static Node curr = null;

    public static void countNodes(Node root) {
        if (root == null)
            return;
        countNodes(root.left);
        count++;
        countNodes(root.right);
    }

    public static void findMedian(Node root) {
        // code here.
        count = 0;
        countNodes(root);
        int c = 1;
        int f = 0;
        int median = (count / 2) + 1;
        helper(root, c, median, f);
        if (count % 2 == 0)
            System.out.println((prev.data + curr.data) / 2.0);
        else
            System.out.println(curr.data);
    }

    public static void helper(Node root, int c, int mid, int f) {
        if (root == null)
            return;

        helper(root.left, c, mid, f);

        if (prev == null) {
            prev = root;
            c++;
        } else if (c == count) {
            curr = root;
            c++;
            f = 1;
            return;
        } else if (f == 0) {
            prev = root;
            c++;
        }

        helper(root.right, c, mid, f);

    }
}