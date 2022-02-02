import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 5, 3, 2, 4, 1 };
        maximize(arr);
    }

    private static void maximize(int[] arr) {
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += (long) arr[i] * i;
        System.out.println("Maximum sum: " + (int) (sum % 1000000007));
    }
}
