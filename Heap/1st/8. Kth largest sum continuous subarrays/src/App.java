public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 10, -10, 20, -40 };
        int k = 6;
        System.out.println("Largest sum: " + kthLargestSum(arr, k));
    }

    private static int kthLargestSum(int[] arr, int k) {
        int sum = 0;
        if (k >= arr.length) {
            for (int i : arr)
                sum += i;
            return sum;
        } else {
            for (int i = 0; i < k; i++) {
                sum += arr[i];
            }
            int maxSum = sum;
            for (int i = k; i < arr.length; i++) {
                sum += arr[i];
                sum -= arr[i - k];
                maxSum = Math.max(sum, maxSum);
            }
            return maxSum;
        }
    }
}
