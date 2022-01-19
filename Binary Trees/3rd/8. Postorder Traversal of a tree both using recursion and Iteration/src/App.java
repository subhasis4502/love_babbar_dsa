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

        postorderRecur(root);
        System.out.println();
        postorderIter(root);
    }

    private static void postorderIter(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Stack<Integer> out = new Stack<>();
        
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            out.push(curr.data);

            if(curr.left != null)
                stack.push(curr.left);
            
            if(curr.right != null)
                stack.push(curr.right);
        }

        while(!out.isEmpty())
            System.out.print(out.pop() + " ");
    }

    private static void postorderRecur(Node root) {
        if (root == null)
            return;
        postorderRecur(root.left);
        postorderRecur(root.right);
        System.out.print(root.data + " ");
    }
}
