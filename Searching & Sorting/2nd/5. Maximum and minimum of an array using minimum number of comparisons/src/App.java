/* 
Input:
6
2 5 1 6 3 4

Output:
Minimum element: 1
Maximum element: 6
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
        getMinMax(arr);
        sc.close();
    }

    private static void getMinMax(int[] arr) {
        int n = arr.length;
        int max, min, i;
        if (n % 2 == 0) {
            if (arr[0] < arr[1]) {
                min = arr[0];
                max = arr[1];
            } else {
                min = arr[1];
                max = arr[0];
            }
            i = 2;
        } else {
            min = arr[0];
            max = arr[0];
            i = 1;
        }

        while (i < n - 1) {
            if (arr[i] > arr[i + 1]) {
                max = Math.max(arr[i], max);
                min = Math.min(arr[i + 1], min);
            } else {
                max = Math.max(arr[i + 1], max);
                min = Math.min(arr[i], min);
            }
            i += 2;
        }
        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);
    }
}
