/* Ref: https://www.youtube.com/watch?v=UZG3-vZlFM4 */

import java.util.Scanner;
import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            trappingWater(arr);
        }
        sc.close();
    }

    private static void trappingWater(int[] arr) {
        int left[] = new int[arr.length];
        int right[] = new int[arr.length];

        left[0] = arr[0];
        right[arr.length - 1] = arr[arr.length - 1];

        for (int i = 1; i < arr.length; i++)
            left[i] = Math.max(left[i - 1], arr[i]);

        for (int i = arr.length - 2; i >= 0; i--)
            right[i] = Math.max(right[i + 1], arr[i]);

        int water = 0;

        for (int i = 0; i < arr.length; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }

        System.out.println("Total rain water stored: " + water);
    }
}
