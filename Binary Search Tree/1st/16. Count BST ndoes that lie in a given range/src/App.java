class Node {
    int data;
    Node left, right, next;

    Node(int data) {
        this.data = data;
        left = right = next = null;
    }
}

public class App {
    static int ind;
    static int ans;

    public static void main(String[] args) throws Exception {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        int l = 2;
        int h = 5;
        System.out.println("No. of nodes in the given range: " + getCount(root, l, h));
    }

    static int count = 0;

    private static int getCount(Node root, int l, int h) {
        if (root == null)
            return 0;

        getCount(root.left, l, h);
        if (root.data >= l && root.data <= h)
            count++;
        getCount(root.right, l, h);

        return count;
    }

}