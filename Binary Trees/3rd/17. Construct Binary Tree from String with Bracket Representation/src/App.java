/* Ref: https://www.youtube.com/watch?v=BH_btihSwVM */

class Node{
    int data;
    Node left, right;

    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        String s = "4(2(3)(1))(6(5))";
        Node root = makeBinaryTree(s, 0);
        traversal(root);
    }

    private static int start = 0;
    private static Node makeBinaryTree(String s, int index) {
        if(s == null || s.length() == 0)
            return null;
        
        return helper(s);
    }

    private static Node helper(String s) {
        if(start >= s.length())
            return null;

        boolean neg = false;
        if(s.charAt(start) == '-'){
            neg = true;
            start++;
        }
        int num = 0;
        while(start < s.length() && Character.isDigit(s.charAt(start))) {
            int digit = Character.getNumericValue(s.charAt(start));
            num = num*10+digit;
            start++;
        }

        if(neg)
            num = -num;
        Node root = new Node(num);

        if(start >= s.length())
            return root;

        if(start < s.length() && s.charAt(start) == '(') {
            start++;
            root.left = helper(s);
        }

        if(start < s.length() && s.charAt(start) == ')'){
            start++;
            return root;
        }

        if(start < s.length() && s.charAt(start) == '('){
            start++;
            root.right = helper(s);
        }

        if(start < s.length() && s.charAt(start) == ')'){
            start++;
            return root;
        }

        return root;
    }

    private static void traversal(Node root) {
        if(root == null)
            return;
        
        traversal(root.left);
        System.out.print(root.data + " ");
        traversal(root.right);
    }
}
