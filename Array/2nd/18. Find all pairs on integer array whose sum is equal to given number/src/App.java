/* Ref: https://www.youtube.com/watch?v=5L9Jrehvoew */

import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            countSum(arr, k);
        }
        sc.close();
    }

    private static void countSum(int[] arr, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int count = 0;
        for (int i : arr){
            if(hash.containsKey(k-i))
                count += hash.get(k-i);
            
            hash.put(i, hash.getOrDefault(i, 0)+1);
        }

        System.out.println("Number of counts: " + count);
    }
}
