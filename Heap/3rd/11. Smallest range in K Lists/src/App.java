/* Ref: https://www.youtube.com/watch?v=aH-2Sig2H2Q */

import java.util.*;

class Pair {
    int val, index, list;

    Pair(int a, int b, int c) {
        val = a; // Stores the element
        index = b; // Stores the index of the element
        list = c; // Stores the list no. of that element
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int[][] kSortedArr = { { 1, 3, 5, 7, 9 }, { 0, 2, 4, 6, 8 }, { 2, 3, 5, 7, 11 } };

        findSmallestRange(kSortedArr);
    }

    private static void findSmallestRange(int[][] kSortedArr) {
        int[] res = { 0, Integer.MAX_VALUE };
        int max = Integer.MIN_VALUE; // Storing the max in the heap
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair a, Pair b) -> a.val - b.val);

        for (int i = 0; i < kSortedArr.length; i++) {
            int mol = kSortedArr[i][0];
            pq.add(new Pair(mol, 0, i));
            max = Math.max(max, mol);
        }

        while (true) {
            Pair min = pq.remove(); // Taking the smallone out
            // Updating if range is smaller
            if (res[1] - res[0] > max - min.val) {
                res[0] = min.val;
                res[1] = max;
            }
            min.index++; // Taking the next element
            if (min.index == kSortedArr[0].length) // If it come to the end of the list
                break;
            else {
                min.val = kSortedArr[min.list][min.index];
                max = Math.max(max, min.val);
                pq.add(min);
            }
        }

        System.out.println("Range: " + res[0] + ", " + res[1]);
    }
}
