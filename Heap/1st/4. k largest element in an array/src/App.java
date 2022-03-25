import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {12, 5, 787, 1, 23};
        int k = 2;
        kLargest(arr, k);
    }

    private static void kLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i : arr)    
            pq.add(i);
            
        int[] res = new int[k];
        for(int i = 0; i<k; i++)
            res[i] = pq.remove();
        
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
