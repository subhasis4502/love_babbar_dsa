/* Ref: https://www.youtube.com/watch?v=DfIoVCQ2Lvg */

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

        ans = -1;
        ind = 1;
        kthLargest(root, 3);
        System.out.println("kth largest element: " + ans);
    }

    private static void kthLargest(Node root, int k) {
        if (root == null)
            return;

        kthLargest(root.right, k);
        if (k == ind) {
            ans = root.data;
        }
        ind++;
        kthLargest(root.left, k);
    }

}