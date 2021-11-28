/* Ref: https://www.youtube.com/watch?v=QtpTDMBJqH0 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            threeWayPartition(arr, a, b);
        }
        sc.close();
    }

    private static void threeWayPartition(int[] arr, int a, int b) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;
        
        for(int i = 0; i<=r; i++){
            if(arr[i] < a){
                swap(arr, l, i);
                l++;
            }
            else if(arr[i] > b){
                swap(arr, r, i);
                r--;
                i--;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    } 
}
