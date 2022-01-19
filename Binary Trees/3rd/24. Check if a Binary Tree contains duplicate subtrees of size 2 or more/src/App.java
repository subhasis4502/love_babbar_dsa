/* Ref: https://www.youtube.com/watch?v=_j7yb_nWFO8 */

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
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(2);
        root.right.right.left = new Node(4);
        root.right.right.right = new Node(5);

        if(dupSub(root))
            System.out.println("Duplicate subtree present");
        else
            System.out.println("No Duplicate subtree present");
    }

    static Map<String, Integer> m = new HashMap<>();
    static boolean dupSub(Node root) {
        solve(root);
        for(String s : m.keySet())
            if(m.get(s) > 1)
                return true;
        return false;
    }
    
    static String solve(Node root){
        if(root == null) return "$";
        String s = "";
        if(root.right == null && root.left == null){
            return Integer.toString(root.data);
        }
        
        s += Integer.toString(root.data);
        s += solve(root.left);
        s += solve(root.right);
        
        m.put(s, m.getOrDefault(s, 0)+1);
        
        return s;
    }
}
