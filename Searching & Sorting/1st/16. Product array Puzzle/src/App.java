/* 
Input:
5
10 3 5 6 2

Output:
180 600 360 300 900
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        productExceptSelf(arr);
        sc.close();
    }

    private static void productExceptSelf(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] product = new int[n];

        left[0] = 1;
        right[n - 1] = 1;

        for (int i = 1; i < n; i++)
            left[i] = left[i - 1] * arr[i - 1];

        for (int i = n - 2; i >= 0; i--)
            right[i] = right[i + 1] * arr[i + 1];

        for (int i = 0; i < n; i++)
            product[i] = left[i] * right[i];

        for (int i = 0; i < n; i++) {
            System.out.print(product[i] + " ");
        }
    }
}
