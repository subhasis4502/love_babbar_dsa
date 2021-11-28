import java.util.*;

public class App {
    public static void minimizeHeight(int[] arr, int k) {

        Arrays.sort(arr);
        int n = arr.length;
        int ans = arr[n - 1] - arr[0];
        int smallest = arr[0] + k;
        int largest = arr[n - 1] - k;
        int mi, mx;

        for (int i = 0; i < n - 1; i++) {
            mi = Math.min(smallest, arr[i + 1] - k);
            mx = Math.max(largest, arr[i] + k);
            if (mi >= 0)
                ans = Math.min(ans, mx - mi);
        }

        System.out.print("Minimized height: " + ans);
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            minimizeHeight(arr, k);
        }
        sc.close();
    }
}
