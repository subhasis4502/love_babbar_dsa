import java.util.*;

class Pair{
    int val, ind;
    
    Pair(int a, int b){
        val = a;
        ind = b;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        maxSubarray(arr, arr.length, k);
    }

    private static void maxSubarray(int[] arr, int n, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> b.val-a.val);
        
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i<n; i++){
            pq.add(new Pair(arr[i], i));
            if(i >= k-1){
                // Removing the out-bound elements
                while(!pq.isEmpty() && pq.peek().ind <= i-k)
                    pq.poll();
                res.add(pq.peek().val);
            }
        }
        
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
