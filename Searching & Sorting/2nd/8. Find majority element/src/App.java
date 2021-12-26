/* Ref: https://www.youtube.com/watch?v=3tbjwaGC-ng */

/* 
Input:
5
3 1 3 3 2

Output:
Majority element: 3
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
        majorityElement(arr);
        sc.close();
    }

    private static void majorityElement(int[] arr) {
        int val = arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (val == arr[i]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                val = arr[i];
                count = 1;
            }
        }

        count = 0;
        for (int i : arr)
            if (i == val)
                count++;

        if (count > arr.length / 2)
            System.out.println("Majority element: " + val);
        else
            System.out.println("No Majority element present");
    }
}
