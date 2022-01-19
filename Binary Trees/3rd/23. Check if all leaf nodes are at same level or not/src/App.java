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
        root.right.left = new Node(70);
        root.right.right = new Node(80);

        if(leafSameLevel(root))
            System.out.println("All leaves are in same level");
        else
            System.out.println("All leaves are not in same level");
    }

    private static boolean leafSameLevel(Node root) {
        checkheight(root,height);
	    return f;
    }

    static int height=0;
    static boolean f=true;
    static void checkheight(Node node,int h){
        if(node==null) 
            return;
        
        if(node.left!=null) 
            checkheight(node.left,h+1);
            
        if(node.right!=null)
            checkheight(node.right,h+1);
        
        if(node.left==null && node.right==null){
            if(height==0){
                height=h;
            }
            else{
                if(height!=h){
                    f=false;
                }
            }
        }
        return;
    }
}
