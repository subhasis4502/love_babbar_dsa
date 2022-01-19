class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class App {
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(1);
        root.right.left = new Node(2);
        root.right.right = new Node(3);
        root.left.right.left = new Node(6);

        System.out.println("Max sum: " + sumOfLongRootToLeafPath(root));
    }

    public static int sumOfLongRootToLeafPath(Node root) {
        if (root == null)
            return 0;

        int sum = height(root.left) > height(root.right) ? sumOfLongRootToLeafPath(root.left)
                : sumOfLongRootToLeafPath(root.right);
        return root.data + sum;
    }

    static int height(Node root) {
        if (root == null)
            return 0;
        return (Math.max(height(root.left), height(root.right)) + 1);
    }

}
