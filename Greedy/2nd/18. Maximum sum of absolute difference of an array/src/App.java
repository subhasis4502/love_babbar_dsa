import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 1, 2, 4, 8 };
        maxSumDiff(arr);
    }

    private static void maxSumDiff(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        List<Integer> finalSequence = new ArrayList<Integer>();
        for (int i = 0; i < n / 2; i++) {
            finalSequence.add(arr[i]);
            finalSequence.add(arr[n - i - 1]);
        }

        // For the middle element at the end.
        if (n % 2 != 0)
            finalSequence.add(arr[n / 2]);

        int maximumSum = 0;

        for (int i = 0; i < n - 1; i++) {
            maximumSum += Math.abs(finalSequence.get(i) - finalSequence.get(i + 1));
        }

        System.out.println("Maximum sum difference: " + maximumSum);
    }
}
