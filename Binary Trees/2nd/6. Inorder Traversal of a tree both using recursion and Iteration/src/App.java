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

        inorderRecur(root);
        System.out.println();
        inorderIter(root);
    }

    private static void inorderIter(Node root) {
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if(root != null){
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                System.out.print(root.data + " ");
                root = root.right;
            }
        }
    }

    private static void inorderRecur(Node root) {
        if (root == null)
            return;
        inorderRecur(root.left);
        System.out.print(root.data + " ");
        inorderRecur(root.right);
    }
}
