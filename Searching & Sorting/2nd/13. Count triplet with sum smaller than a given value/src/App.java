/* Ref: https://www.youtube.com/watch?v=9455buJlb_k */

/* 
Input:
4 2
-2 0 1 3

Output:
Total no. of triplets: 2
*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        countTriplets(arr, sum);
        sc.close();
    }

    static void countTriplets(int arr[], int sum)
    {
        int n = arr.length;
        int count = 0;
        Arrays.sort(arr);
        for(int i = 0; i<n; i++){
            int left = i+1;
            int right = n-1;
            while(left < right){
                int s = arr[i]+arr[left]+arr[right];
                if(s<sum){
                    count += right-left;
                    left++;
                }
                else
                    right--;
            }
        }
        System.out.println("Total no. of triplets: " + count);
    }
}
