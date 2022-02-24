import java.util.Deque;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        int arr[] = { 2, 5, -1, 7, -3, -1, -2 };
        int k = 3;
        sumOfKsubArray(arr, k);
    }

    private static void sumOfKsubArray(int[] arr, int k) {
        int sum = 0;
        Deque<Integer> inc = new LinkedList<>();
        Deque<Integer> dec = new LinkedList<>();

        // Calculating for the initial window
        for (int i = 0; i < k; i++) {
            // Remove all previous greater elements
            while (!inc.isEmpty() && arr[inc.peekLast()] >= arr[i])
                inc.removeLast();

            // Remove all previous smaller elements
            while (!dec.isEmpty() && arr[dec.peekLast()] <= arr[i])
                dec.removeLast();

            // Add current element at rear
            inc.addLast(i);
            dec.addLast(i);
        }

        for (int i = k; i < arr.length; i++) {
            sum += arr[inc.peekFirst()] + arr[dec.peekFirst()];

            // Remove all elements which are out of this window
            while (!inc.isEmpty() && inc.peekFirst() <= i - k)
                inc.removeFirst();

            while (!dec.isEmpty() && dec.peekFirst() <= i - k)
                dec.removeFirst();

            // Remove all previous greater elements
            while (!inc.isEmpty() && arr[inc.peekLast()] >= arr[i])
                inc.removeLast();

            // Remove all previous smaller elements
            while (!dec.isEmpty() && arr[dec.peekLast()] <= arr[i])
                dec.removeLast();

            // Add current element at rear
            inc.addLast(i);
            dec.addLast(i);
        }

        sum += arr[inc.peekFirst()] + arr[dec.peekFirst()];

        System.out.println("Sum of sub-array: " + sum);
    }
}
