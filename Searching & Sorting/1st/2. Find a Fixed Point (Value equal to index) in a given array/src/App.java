/* 
Input:
5
15 2 45 12 7

Output:
Values equal to index: 2 
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
        valueEqualToIndex(arr, arr.length);
        sc.close();
    }

    static void valueEqualToIndex(int arr[], int n) {
        System.out.print("Values equal to index: ");
        for(int i = 0; i<n; i++)
            if(arr[i] == i+1)
                System.out.print(arr[i] + " ");
        
    }
}
