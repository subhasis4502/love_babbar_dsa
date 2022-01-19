/* Ref: https://www.youtube.com/watch?v=aZNaLrVebKQ */

import java.util.*;

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
        int[] inOrder = {3, 1, 4, 0, 5, 2};
        int[] preOrder = {0, 1, 3, 4, 2, 5};

        Node root = constructTree(inOrder, preOrder, inOrder.length);
        traversal(root);
    }

    private static Node constructTree(int[] inOrder, int[] preOrder, int length) {
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            inMap.put(inOrder[i], i);
        }

        Node root = buildTree(preOrder, 0, length-1, inOrder, 0, length-1, inMap);
        return root;
    }

    private static Node buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd,
            Map<Integer, Integer> inMap) {
        if(preStart > preEnd || inStart > inEnd)
                return null;

        Node root = new Node(preOrder[preStart]); // Making the first element as root
        int inRoot = inMap.get(root.data); // Finding the index of root in inorder
        int numsLeft = inRoot-inStart; // Calculating the size of the left tree

        root.left = buildTree(preOrder, preStart+1, preStart+numsLeft, inOrder, inStart, inRoot-1, inMap);
        root.right = buildTree(preOrder, preStart+numsLeft+1, preEnd, inOrder, inRoot+1, inEnd, inMap);
        return root;
    }

    private static void traversal(Node root) {
        if (root == null)
            return;

        traversal(root.left);
        System.out.print(root.data + " ");
        traversal(root.right);
    }
}
