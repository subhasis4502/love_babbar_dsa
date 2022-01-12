/* Ref: https://www.youtube.com/watch?v=w_6L5OcFJEo */

/* 
Input:
6

Output:
First Number with 6 trailing zero: 25
*/

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        findNum(n);
        sc.close();
    }

    private static void findNum(int n) {
        if (n == 1)
            System.out.println("First Number with 1 trailing zero: " + 5);

        int low = 0;
        int high = 5 * n;

        while (low < high) {
            int mid = (low + high) / 2;
            // Checking mid value is consist of n trailing zeroes or not
            if (check(mid, n))
                high = mid;
            else
                low = mid + 1;
        }
        System.out.println("First Number with " + n + " trailing zero: " + low);
    }

    private static boolean check(int mid, int n) {
        int count = 0, f = 5;
        while(f <= mid){
            count += mid/f;
            f *= 5;
        }
        return count>=n;
    }
}
