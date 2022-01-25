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
    static Set<Integer> hash = new HashSet<>();
    static int count;

    public static void main(String[] args) throws Exception {
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(7);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.right = new Node(15);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        int x = 16;

        countPairs(root1, root2, x);
    }

    private static void countPairs(Node root1, Node root2, int x) {
        inorder(root1);
        find(root2, x);
        System.out.println("Total number of pairs: " + count);
    }

    private static void find(Node root, int x) {
        if(root == null)
	        return;
	       
	    find(root.left, x);
	    if(hash.contains(x - root.data))
	        count++;
	    find(root.right, x);
    }

    private static void inorder(Node root) {
        if(root == null)
	        return;
	       
	    inorder(root.left);
	    hash.add(root.data);
	    inorder(root.right);
    }
}