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
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        if(isBst(root))
            System.out.println("This tree is a BST");
        else
            System.out.println("This tree is not a BST");
    }

    static Node prev = null;
    private static boolean isBst(Node root) {
        if(root == null)
            return true;
        
        if(!isBst(root.left))
            return false;
            
        if(prev != null && root.data <= prev.data)
            return false;
        prev = root;
        
        if(!isBst(root.right))
            return false;
        return true;
    }
}
