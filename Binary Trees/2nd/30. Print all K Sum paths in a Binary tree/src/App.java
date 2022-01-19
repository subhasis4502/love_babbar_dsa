/* Ref: https://www.youtube.com/watch?v=_Ng486jJu80 */

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
    static ArrayList<Integer> path = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(-1);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.right.left = new Node(1);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right.right = new Node(6);

        kSumPath(root, 5);
    }

    private static void kSumPath(Node root, int k) {
        // Base case
        if (root == null)
            return;

        path.add(root.data);
        // Recursion
        kSumPath(root.left, k);
        kSumPath(root.right, k);

        int sum = 0;
        // Calculating the sum for every ends
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) {
                // Printing the path
                System.out.println();
                for (int j = i; j < path.size(); j++) {
                    System.out.print(path.get(j) + " -> ");
                }
                System.out.print("Null");
            }
        }
        path.remove(path.size() - 1);
    }
}