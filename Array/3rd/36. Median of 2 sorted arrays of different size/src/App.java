/* Ref: https://www.youtube.com/watch?v=jDJuW7tSxio */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size1 = sc.nextInt();
            int size2 = sc.nextInt();
            int[] arr1 = new int[size1];
            for (int i = 0; i < size1; i++)
                arr1[i] = sc.nextInt();

            int[] arr2 = new int[size2];
            for (int i = 0; i < size2; i++)
                arr2[i] = sc.nextInt();

            findMedian(arr1, arr2);
        }
        sc.close();
    }

    private static void findMedian(int[] arr1, int[] arr2) {

        // 1st array is always smaller than 2nd array
        if (arr1.length > arr2.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        int lo = 0;
        int high = arr1.length;
        int total = arr1.length + arr2.length;

        while (lo <= high) {

            int aleft = (lo + high) / 2;
            int bleft = (total + 1) / 2 - aleft;

            int alml = (aleft == 0) ? Integer.MIN_VALUE : arr1[aleft - 1]; // If aleft is zero treat it as negative infinite
            int al = (aleft == arr1.length) ? Integer.MAX_VALUE : arr1[aleft];
            int blml = (bleft == 0) ? Integer.MIN_VALUE : arr2[bleft - 1];
            int bl = (bleft == arr2.length) ? Integer.MAX_VALUE : arr2[bleft]; // If bleft is arr2.length treat it as positive infinite

            // Valid segregation
            if (alml <= bl && blml <= al) {
                double median = 0.0;
                if (total % 2 == 0) {
                    int lmax = Math.max(alml, blml);
                    int rmin = Math.min(al, bl);

                    median = (lmax + rmin) / 2.0;
                } else {
                    int lmax = Math.max(alml, blml);
                    median = lmax;
                }
                System.out.println("The median is " + median);
                break;
            } else if (alml > bl) {
                // There are more elements to be picked in left part from 'arr2' array
                high = aleft - 1;

            } else if (blml > al) {
                // There are more elements to be picked in left part from 'arr1' array
                lo = aleft + 1;
            }
        }
    }
}
