/* Ref: https://www.youtube.com/watch?v=Eb1A6nm_Nic */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 4, 2, 7, 6, 9 };
        minCost(arr);
    }

    private static void minCost(int[] arr) {
        int cost = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i : arr) {
            heap.add(i);
        }

        while (heap.size() > 1) {
            int rope = heap.remove() + heap.remove();
            heap.add(rope);
            cost += rope;
        }

        System.out.println("Minimum cost: " + cost);
    }
}
