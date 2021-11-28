/* Ref: https://www.youtube.com/watch?v=wiDLcGxhh80 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            minOperation(arr);
        }
        sc.close();
    }

    private static void minOperation(int[] arr) {
        int i = 0, j = arr.length - 1;
        int ans = 0;

        while (i <= j) {
            if (arr[i] < arr[j]) {
                i++;
                arr[i] += arr[i - 1];
                ans++;
            } else if (arr[i] > arr[j]) {
                j--;
                arr[j] += arr[j + 1];
                ans++;
            } else {
                i++;
                j--;
            }
        }

        System.out.println("No. of merge operation require is " + ans);
    }
}
