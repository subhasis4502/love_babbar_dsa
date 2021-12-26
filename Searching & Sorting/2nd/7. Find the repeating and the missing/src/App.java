/* Ref: https://www.youtube.com/watch?v=MvklwzVz654 */

/* 
Input:
7                                                                                                                        java App }
3 6 2 5 1 2 7

Output:
Missing number: 4
Repeated number: 2
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
        findTwoElement(arr);
        sc.close();
    }

    private static void findTwoElement(int[] arr) {
        int xor = 0;
        for (int i : arr) {
            xor ^= i;
        }

        for (int i = 1; i <= arr.length; i++) {
            xor ^= i;
        }

        int rsb = xor & -xor;

        int x = 0;
        int y = 0;

        for (int val : arr) {
            if ((val & rsb) == 0)
                x = x ^ val;
            else
                y = y ^ val;
        }

        for (int i = 1; i <= arr.length; i++) {
            if ((i & rsb) == 0)
                x = x ^ i;
            else
                y = y ^ i;
        }

        for (int val : arr) {
            if (val == x) {
                System.out.println("Missing number: " + y);
                System.out.println("Repeated number: " + x);
                break;
            } else if (val == y) {
                System.out.println("Missing number: " + x);
                System.out.println("Repeated number: " + y);
                break;
            }
        }
    }
}
