/* Ref: https://www.youtube.com/watch?v=8AnntMKIWlQ */

import java.util.*;

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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);

        print(root);
        System.out.println();
        binaryTreeToBST(root);
        print(root);
    }

    static ArrayList<Integer> arr = new ArrayList<>();
    static int i = 0;

    private static void binaryTreeToBST(Node root) {
        traverse(root);
        Collections.sort(arr);
        put(root);
    }

    private static void put(Node root) {
        if (i >= arr.size() || root == null)
            return;
        put(root.left);
        root.data = arr.get(i++);
        put(root.right);
    }

    private static void traverse(Node root) {
        if (root == null)
            return;
        traverse(root.left);
        arr.add(root.data);
        traverse(root.right);
    }

    private static void print(Node root) {
        if (root == null)
            return;

        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }
}