import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;
        printFirstNegativeInteger(arr, k);
    }

    private static void printFirstNegativeInteger(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>(); // Stores the negative numbers
        int[] res = new int[arr.length-k+1];
        
        for(int i = 0; i<k; i++){
            if(arr[i] < 0) q.add(arr[i]);
        }

        int ind = 0;
        for(int i = k; i<arr.length; i++){
            if(!q.isEmpty()){
                res[ind] = q.peek();
                if(q.peek() == arr[i-k]) q.remove();
            }
            if(arr[i] < 0) q.add(arr[i]);
            ind++;
        }

        if(!q.isEmpty())
            res[ind] = q.peek();
        
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
