/* Ref: https://www.youtube.com/watch?v=0ca1nvR0be4 */

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

        boundry(root);
    }

    private static void boundry(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
	    if(!isLeaf(root))
	        res.add(root.data);
	    addLeftBoundary(root, res);
	    addLeaves(root, res);
	    addRightBoundary(root, res);
	    
        for(int i : res)
            System.out.print(i + " ");
    }

    static void addLeftBoundary(Node root, ArrayList<Integer> res){
	    Node cur = root.left;
	    while(cur != null){
	        if(!isLeaf(cur))
	            res.add(cur.data);
	        if(cur.left != null)
	            cur = cur.left;
	        else
	            cur = cur.right;
	    }
	}
	
	static void addLeaves(Node root, ArrayList<Integer> res){
	    if(isLeaf(root)){
	        res.add(root.data);
	        return;
	    }
	    if(root.left != null)
	        addLeaves(root.left, res);
	    
	    if(root.right != null)
	        addLeaves(root.right, res);
	}
	
	static void addRightBoundary(Node root, ArrayList<Integer> res){
	    Node cur = root.right;
	    Stack<Integer> tmp = new Stack<>();
	    while(cur != null){
	        if(!isLeaf(cur))
	            tmp.push(cur.data);
	        if(cur.right != null)
	            cur = cur.right;
	        else
	            cur = cur.left;
	    }
	    
	    while(!tmp.isEmpty())
	        res.add(tmp.pop());
	}
	
	static boolean isLeaf(Node node){
	    if(node.left == null && node.right == null)
	        return true;
	    return false;
	}
}
