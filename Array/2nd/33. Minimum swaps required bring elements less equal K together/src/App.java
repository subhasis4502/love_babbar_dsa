/* Ref: https://www.youtube.com/watch?v=PLu6uvp9l1k&t=539s */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            var k = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            minSwap(arr, k);
        }
        sc.close();
    }

    private static void minSwap(int[] arr, int k) {
        int good = 0;
        int bad = 0;
        
        for(int i : arr)
            if(i <= k)
                good++;
        
        for(int i = 0; i<good; i++)
            if(arr[i] > k)
                bad++;
        
        int i = 0;
        int j = good;
        int swap = bad;
        
        while(j < arr.length){
            if(arr[i] > k)
                bad--;
            if(arr[j] > k)
                bad++;
            
            swap = Math.min(swap, bad);
            i++;
            j++;
        }

        System.out.println("Minimum number of swap require is " + swap);
    }
}
