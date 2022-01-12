/* Ref: https://www.youtube.com/watch?v=tkoucfh10SI */

/* 
Input:
5
4 42 42 26 46
20

Output:
Minimum saw length: 36
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
        int wood = sc.nextInt();
        minLength(arr, wood);
        sc.close();
    }

    private static void minLength(int[] arr, int wood) {
        int lb = 0;
        int ub = 0;
        for(int i : arr)
            ub = Math.max(i, ub);

        int ans = 0;
        while(lb <= ub){
            int mid = (lb+ub)/2;
            if(solve(arr, wood, mid)){
                ans = mid;
                lb = mid+1;
            } else {
                ub = mid-1;
            }
        }
        System.out.println("Minimum saw length: " + ans);
    }

    private static boolean solve(int[] arr, int wood, int mid) {
        int sum = 0;
        for(int i : arr)
            if(i > mid) 
                sum += i-mid;

        return sum >= wood;
    }
}
