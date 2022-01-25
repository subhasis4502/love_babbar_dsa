import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {2, 4, 3};
        if(isBstPreorder(arr))
            System.out.println("This is a preorder traversal");
        else
            System.out.println("This is not a preorder traversal");
    }

    private static boolean isBstPreorder(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MIN_VALUE;
        
        for(int i = 0; i<arr.length; i++){
            //Checking BST condition
            if(arr[i] < root)
                return false;
            //For the new root
            while(!stack.isEmpty() && stack.peek() < arr[i])
                root = stack.pop();
            stack.push(arr[i]);
        }
        return true;
    }
}
