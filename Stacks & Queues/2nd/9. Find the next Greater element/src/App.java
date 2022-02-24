import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 6, 8, 0, 1, 3 };
        nextLargerElement(arr);
    }

    private static void nextLargerElement(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i])
                stack.pop();
            if (!stack.isEmpty() && stack.peek() > arr[i])
                res[i] = stack.peek();
            else
                res[i] = -1;
            stack.push(arr[i]);
        }
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
