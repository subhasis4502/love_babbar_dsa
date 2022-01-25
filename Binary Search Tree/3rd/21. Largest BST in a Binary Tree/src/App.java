/* Ref: https://www.youtube.com/watch?v=X0oXMdtUDwo */

class Node {
    int data;
    Node left, right, next;

    Node(int data) {
        this.data = data;
        left = right = next = null;
    }
}

class NodeValue {
    public int maxNode, minNode, maxSize;

    NodeValue(int min, int max, int size) {
        maxNode = max;
        minNode = min;
        maxSize = size;
    }
}

public class App {

    public static void main(String[] args) throws Exception {
        Node root = new Node(6);
        root.left = new Node(6);
        root.right = new Node(3);
        root.left.right = new Node(2);
        root.left.right.right = new Node(8);
        root.right.left = new Node(9);
        root.right.right = new Node(3);
        root.right.left.left = new Node(8);
        root.right.left.right = new Node(2);
        
        largestBst(root);
    }

    private static void largestBst(Node root) {
        System.out.println("The size of the largest BST is: " + largestBstHelper(root).maxSize);
    }

    static NodeValue largestBstHelper(Node root){
        if(root == null)
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            
        NodeValue left = largestBstHelper(root.left);
        NodeValue right = largestBstHelper(root.right);
        
        if(left.maxNode < root.data && root.data < right.minNode){
            int min = Math.min(root.data, left.minNode);
            int max = Math.max(root.data, right.maxNode);
            return new NodeValue(min, max, left.maxSize+right.maxSize+1);
        }
        
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }
}