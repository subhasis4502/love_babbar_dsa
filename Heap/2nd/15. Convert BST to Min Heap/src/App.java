/* Ref: https://www.youtube.com/watch?v=Y9Pu7nHpeFc */

import java.util.ArrayList;

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
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(7);

        printTree(root);
        toMinHeap(root);
        System.out.println();
        printTree(root);
    }

    private static void toMinHeap(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        preOrder(root, arr);
    }

    private static void preOrder(Node root, ArrayList<Integer> arr) {
        if(root == null)
            return;
        root.data = arr.remove(0);
        preOrder(root.left, arr);
        preOrder(root.right, arr);
    }

    private static void inOrder(Node root, ArrayList<Integer> arr) {
        if(root == null)
            return;
        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }

    private static void printTree(Node root) {
        if (root == null)
            return;
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }
}
