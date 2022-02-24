/* Ref: https://www.youtube.com/watch?v=CiiXBvrX-5A */

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        int[][] arr = { { 0, 1, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };
        celebrity(arr);
    }

    private static void celebrity(int[][] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(i);
        }

        while(stack.size() >= 2){
            int i = stack.pop();
            int j = stack.pop();

            // If i knows j -> i is not a celebrity
            if(arr[i][j] == 1){
                stack.push(j);
            // If j knows i -> i may be a celebrity
            } else {
                stack.push(i);
            }
        }

        int pot = stack.pop();
        for (int i = 0; i < arr.length; i++) {
            if(i != pot){
                if(arr[i][pot] == 0 || arr[pot][i] == 1){
                    System.out.println("No celebrities");
                    break;
                }
            }
        }

        System.out.println(pot + " is the celebrity.");
    }
}
