/* Ref: https://www.youtube.com/watch?v=8GDHYgbxTN4 */

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 5, -2, 5, -4, 5, -12, 5, 5, 5, 20 };
        int k = 5;

        maximizeSum(arr, k);
    }

    private static void maximizeSum(int[] arr, int k) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0 && k > 0) {
                arr[i] *= -1;
                k--;
            }
        }
        long sum = 0;
        for (long i : arr)
            sum += i;

        long min = Long.MAX_VALUE;
        for (long i : arr)
            min = Math.min(min, i);

        if (k % 2 == 1)
            sum -= 2 * min;

        System.out.println("Maximum sum: " + sum);
    }
}
