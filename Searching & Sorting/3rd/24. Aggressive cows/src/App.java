/* Ref: https://www.youtube.com/watch?v=wSOfYesTBRk */

/* 
Input:
5
1 2 4 8 9
3

Output:
The largest minimum distance: 3
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
        int cows = sc.nextInt();
        largestMinDistance(arr, cows);
        sc.close();
    }

    private static void largestMinDistance(int[] arr, int cows) {
        int low = 1, high = arr[arr.length-1]-arr[0];
        int res = 0;
        while(low <= high){
            int mid = (low+high)/2;
            if(canPlaceCows(arr, cows, mid)){
                res = mid;
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        System.out.println("The largest minimum distance: " + res );
    }

    private static boolean canPlaceCows(int[] arr, int cows, int dist) {
        int coOrd = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - coOrd >= dist){
                count++;
                coOrd = arr[i];

                if(count == cows)
                    return true;
            }
        }
        return false;
    }
}
