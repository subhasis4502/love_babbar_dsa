/* Ref: https://www.youtube.com/watch?v=KsIeZfmvuVQ */

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        int[] push = { 7, 2, 9, 4, 5 };
        int[] pop = { 4, 5, 9, 2, 7 };

        if (isPermutation(push, pop))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean isPermutation(int[] push, int[] pop) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int i : push) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == pop[j]) {
                stack.pop();
                j++;
            }
        }

        return j == pop.length;
    }
}
