/* Ref: https://www.youtube.com/watch?v=XGrXiVi7Ces */

/* 
Input:
6 78
5 20 3 2 5 80

Output:
2 & 80 have difference of 78
*/

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        findPair(arr, n);
        sc.close();
    }

    private static void findPair(int[] arr, int n) {
        Arrays.sort(arr);
        int i = 0, j = 1;
        int count = 0;
        while (j < arr.length) {
            if (arr[j] - arr[i] < n)
                j++;
            else if (arr[j] - arr[i] > n)
                i++;
            else {
                System.out.println(arr[i] + " & " + arr[j] + " have difference of " + n);
                count++;
                break;
            }
        }
        if (count == 0)
            System.out.println("There is no pair with difference of " + n);
    }
}
