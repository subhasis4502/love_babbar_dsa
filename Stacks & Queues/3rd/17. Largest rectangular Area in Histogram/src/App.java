/* Ref: https://www.youtube.com/watch?v=0do2734xhnU */

import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        int arr[] = { 7, 2, 8, 9, 1, 3, 6, 5 };
        getMaxArea(arr, arr.length);
    }

    private static void getMaxArea(int[] hist, int n) {
        int maxArea = Integer.MIN_VALUE;

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : hist[i]);

            if (s.isEmpty() || h >= hist[s.peek()]) {
                s.push(i);
            } else {
                int tp = s.pop();
                int width = (s.isEmpty() ? i : i - s.peek() - 1);
                maxArea = Math.max(maxArea, hist[tp] * width);
                i--;
            }
        }
        System.out.println("Maximum area of histogram: " + maxArea);
    }
}
