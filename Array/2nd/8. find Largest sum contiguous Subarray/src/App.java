import java.util.*;

public class App {
    public static void largestSum(int[] arr) {
        int best = 0;
        int allBest = 0;

        for (int i : arr) {
            best = (best + i > best) ? best+i : best;

            allBest = Math.max(allBest, best);
        }
        
        System.out.println(allBest);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            largestSum(arr);
        }
        sc.close();
    }
}
