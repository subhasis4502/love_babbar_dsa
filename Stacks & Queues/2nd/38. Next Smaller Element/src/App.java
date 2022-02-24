import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 3, 8, 5, 2, 25 };
        nextSmaller(arr);
    }

    private static void nextSmaller(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
	    Stack<Integer> stack = new Stack<>();
	    
	    for(int i = n-1; i>=0; i--){
	        while(!stack.isEmpty() && stack.peek() >= arr[i])
	            stack.pop();
	        res[i] = (stack.isEmpty() ? -1 : stack.peek());
	        stack.push(arr[i]);
	    }

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
