/* Ref: https://www.youtube.com/watch?v=5_AZcOOc-kM */

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

        traverse(root);
        root = delete(root, 3);
        System.out.println();
        traverse(root);
    }

    private static void traverse(Node root) {
        if (root == null)
            return;

        traverse(root.left);
        System.out.print(root.data + " ");
        traverse(root.right);
    }
    
    public static Node delete(Node root, int key) {
        if(root == null)
            return null;
        
        if(root.data > key)
            root.left = delete(root.left, key);
        
        else if(root.data < key)
            root.right = delete(root.right, key);
        
        else {
            if(root.left != null && root.right != null){
                int lmax = max(root.left);
                root.data = lmax;
                root.left = delete(root.left, lmax);
                return root;
            } else if(root.left != null) {
                return root.left;
            } else if(root.right != null) {
                return root.right;
            } else {
                return null;
            }
        }
        return root;
    }
    
    public static int max(Node node){
        if(node.right != null)
            return max(node.right);
        else
            return node.data;
    }
}
