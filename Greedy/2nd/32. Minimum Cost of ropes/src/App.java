/* Ref: https://www.youtube.com/watch?v=2pH6E9th0EY */

import java.util.PriorityQueue;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {4, 3, 2, 6};
        minCost(arr);
    }

    private static void minCost(int[] arr) {
        int cost = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : arr)
            pq.add(i);

        while(pq.size()>1){
            int rope = pq.poll()+pq.poll();
            pq.add(rope);
            cost += rope;
        }

        System.out.println("Minimum cost to join the ropes: "+ cost);
    }
}
