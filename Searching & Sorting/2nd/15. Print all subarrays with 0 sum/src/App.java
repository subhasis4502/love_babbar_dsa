/* Ref: https://www.youtube.com/watch?v=C9-n_H7dsvU */

/* 
Input:
6
0 0 5 5 0 0

Output:
Total zero sum subarrays: 6
*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        findSubarray(arr);
        sc.close();
    }

    public static void findSubarray(int[] arr) 
    {
        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(0, 1);
        int sum = 0;
        int count = 0;
        for(long i : arr){
            sum += i;
            
            if(hash.containsKey(sum)){
                count += hash.get(sum);
                hash.put(sum, hash.get(sum)+1);
            }
            else
                hash.put(sum, 1);
        }
        System.out.println("Total zero sum subarrays: " + count);
    }
}
