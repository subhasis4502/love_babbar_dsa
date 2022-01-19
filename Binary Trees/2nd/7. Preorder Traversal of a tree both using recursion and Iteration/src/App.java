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
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);

        preorderRecur(root);
        System.out.println();
        preorderIter(root);
    }

    private static void preorderIter(Node root) {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                System.out.print(root.data + " ");
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    private static void preorderRecur(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preorderRecur(root.left);
        preorderRecur(root.right);
    }
}
