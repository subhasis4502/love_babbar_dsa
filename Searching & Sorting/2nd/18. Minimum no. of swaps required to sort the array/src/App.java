/* Ref: https://www.youtube.com/watch?v=1BxbBgNSwHo */

/* 
Input:
5       
10 19 6 3 5

Output:
Swaps required: 2
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
        minSwaps(arr);
        sc.close();
    }

    private static void minSwaps(int[] arr) {
        int ans = 0;
        int N = arr.length;
        int[] temp = Arrays.copyOfRange(arr, 0, N);
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
 
        Arrays.sort(temp);
        for (int i = 0; i < N; i++)
            hash.put(arr[i], i);
        
        for (int i = 0; i < N; i++)
            if (arr[i] != temp[i]){
                ans++;
                int init = arr[i];
                swap(arr, i, hash.get(temp[i]));
                hash.put(init, hash.get(temp[i]));
                hash.put(temp[i], i);
            }
        
        System.out.println("Swaps required: " + ans);
    }
    
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
