import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] a = {10, 5, 6, 2};
        int[] b = {12, 7, 9};
        mergeHeaps(a, b);
    }

    private static void mergeHeaps(int[] a, int[] b) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : a)
            pq.add(i);
        for(int j : b)
            pq.add(j);
            
        while(!pq.isEmpty())
            System.out.print(pq.remove() + " ");
    }
}
