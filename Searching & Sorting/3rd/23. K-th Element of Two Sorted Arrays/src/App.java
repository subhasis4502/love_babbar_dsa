/* Ref: Median of two sorted array */

/* 
Input:
6 4
1 3 4 7 10 12
2 3 6 15
5

Output:
5th element in two sorted array: 4
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
        int k = sc.nextInt();
        System.out.println(k + "th element in two sorted array: " + findTwoElement(arr1, arr2, size1, size2, k));
        sc.close();
    }

    private static int findTwoElement(int[] arr1, int[] arr2, int n, int m, int k) {
        if (arr1.length > arr2.length)
            return findTwoElement(arr2, arr1, m, n, k);

        int lo = Math.max(0, k - m);
        int hi = Math.min(k, n);

        while (lo <= hi) {

            int aleft = lo + (hi - lo) / 2;
            int bleft = k - aleft;

            int alm1 = (aleft == 0) ? Integer.MIN_VALUE : arr1[aleft - 1];
            int al = (aleft == arr1.length) ? Integer.MAX_VALUE : arr1[aleft];
            int blm1 = (bleft == 0) ? Integer.MIN_VALUE : arr2[bleft - 1];
            int bl = (bleft == arr2.length) ? Integer.MAX_VALUE : arr2[bleft];

            if (alm1 > bl) {
                hi = aleft - 1;
            } else if (al < blm1) {
                lo = aleft + 1;
            }

            else {
                int ans = Math.max(alm1, blm1);
                return ans;

            }
        }

        return 0;
    }
}
