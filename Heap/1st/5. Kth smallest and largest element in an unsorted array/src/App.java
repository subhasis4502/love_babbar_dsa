import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        int k = 3;
        kthSmallest(arr, k);
    }

    private static void kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if (pq.peek() > arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        System.out.println(k + "th smallest element: " + pq.peek());
    }
}
