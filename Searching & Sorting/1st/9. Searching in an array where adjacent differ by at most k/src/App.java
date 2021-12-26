/* Ref: https://www.youtube.com/watch?v=KtrAWsfyBaA */

/* 
Input:
6
2 4 5 7 7 6
2 6

Output:
6 present on index 5
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
        int k = sc.nextInt();
        int x = sc.nextInt();
        search(arr, k, x);
        sc.close();
    }

    private static void search(int[] arr, int k, int x) {
        int step = Math.abs(arr[0] - x) / k;
        int count = 0;
        for (int i = step; i < arr.length; i++) {
            if (arr[i] == x) {
                System.out.println(x + " present on index " + i);
                count++;
                break;
            }
        }
        if (count == 0)
            System.out.println(x + " is not present on this array");
    }
}
