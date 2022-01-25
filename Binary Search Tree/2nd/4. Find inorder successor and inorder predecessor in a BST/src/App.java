class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class App {
    static int pre;
    static int suc;
    public static void main(String[] args) throws Exception {
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        int k = 3;
        findPredSucc(root, k);
        System.out.println("Predecessor of " + k + " : " + pre);
        System.out.println("Successor of " + k + " : " + suc);
    }

    private static void findPredSucc(Node root, int k) {
        if(root == null)
            return;

        findPredSucc(root.left, k);

        if(root.data > k)
            suc = root.data;
        if(root.data < k)
            pre = root.data;

        findPredSucc(root.right, k);
    }

}
