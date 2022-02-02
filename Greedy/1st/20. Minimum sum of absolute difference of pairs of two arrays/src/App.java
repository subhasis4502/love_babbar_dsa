import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int a[] = { 4, 1, 8, 7 };
        int b[] = { 2, 3, 6, 5 };

        findMinSum(a, b);
    }

    private static void findMinSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        long sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.abs(a[i] - b[i]);
        }
        System.out.println("Minimum sum difference: " + sum);
    }
}
