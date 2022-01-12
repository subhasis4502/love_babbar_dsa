/* Ref: https://www.youtube.com/watch?v=vF7gk4iaklA */

/* 
Input:5
40 50 10 20 30

Output:
Pivot element: 10
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
        System.out.println("Pivot element: " + pivotElement(arr));
        sc.close();
    }

    private static int pivotElement(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] < arr[high])
                high = mid;
            else
                low = mid+1;
        }
        return arr[low];
    }
}
