/* Ref: https://www.youtube.com/watch?v=dshWERdcAdg */

import java.util.*;

public class App {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        int[] arr = { 5, 15, 1, 3 };
        findMedian(arr);
    }

    private static void findMedian(int[] arr) {
        for (int i : arr) {
            insertHeap(i);
            System.out.print(getMedian() + " ");
        }

    }

    private static double getMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2;
        else if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else
            return minHeap.peek();
    }

    private static void balanceHeaps() {
        if (maxHeap.size() > minHeap.size() + 1)
            minHeap.add(maxHeap.poll());
        else if (maxHeap.size() + 1 < minHeap.size())
            maxHeap.add(minHeap.poll());
    }

    private static void insertHeap(int x) {
        if (maxHeap.isEmpty() || maxHeap.peek() > x)
            maxHeap.add(x);
        else
            minHeap.add(x);

        balanceHeaps();
    }
}
