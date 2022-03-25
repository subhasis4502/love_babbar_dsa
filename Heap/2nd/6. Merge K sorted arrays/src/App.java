import java.util.*;

class Pair {
    int arrNo, valInd;

    Pair(int a, int b) {
        arrNo = a;
        valInd = b;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int k = 3;
        mergeKArrays(arr, k);
    }

    private static void mergeKArrays(int[][] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (Pair a, Pair b) -> arr[a.arrNo][a.valInd] - arr[b.arrNo][b.valInd]);
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(i, 0));
        }

        while (!pq.isEmpty()) {
            Pair temp = pq.remove();
            res.add(arr[temp.arrNo][temp.valInd]);
            temp.valInd++;
            if (temp.valInd < arr[0].length)
                pq.add(new Pair(temp.arrNo, temp.valInd));
        }

        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
