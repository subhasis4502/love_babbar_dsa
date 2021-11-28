import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();
            int student = sc.nextInt();

            findMinDiff(arr, student);
        }
        sc.close();
    }

    private static void findMinDiff(int[] arr, int m) {
        Arrays.sort(arr);
        // 1 3 4 7 9 9 12 56
        // 0 1 2 3 4 5 6 7
        int i = 0;
        int j = m - 1;
        int minDiff = Integer.MAX_VALUE;

        while (j < arr.length) {
            minDiff = Math.min(minDiff, arr[(int) j] - arr[(int) i]);
            i++;
            j++;
        }
        System.out.println("Minimun difference: " + minDiff);
    }
}
