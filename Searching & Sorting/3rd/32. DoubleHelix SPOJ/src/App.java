/* Ref: https://www.youtube.com/watch?v=w-6YHcGmSxM */

/* 
Input:
13 11
3 5 7 9 20 25 30 40 55 56 57 60 62
1 4 7 11 14 25 44 47 55 57 100

Output:
Maximum sum: 450
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size1 = sc.nextInt();
        int size2 = sc.nextInt();
        int[] arr1 = new int[size1];
        int[] arr2 = new int[size2];
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }
        maxSum(arr1, arr2);
        sc.close();
    }

    private static void maxSum(int[] arr1, int[] arr2) {
        int s1 = 0, s2 = 0;
        int i = 0, j = 0;
        int ans = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j])
                s1 += arr1[i++];
            else if (arr2[j] < arr1[i])
                s2 += arr2[j++];
            else {
                ans += Math.max(s1, s2) + arr1[i];
                s1 = s2 = 0;
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            s1 += arr1[i++];
        }

        while (j < arr2.length) {
            s2 += arr2[j++];
        }

        ans += Math.max(s1, s2);
        System.out.println("Maximum sum: " + ans);
    }
}
