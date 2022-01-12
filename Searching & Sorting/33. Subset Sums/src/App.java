import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int lb = sc.nextInt();
        int ub = sc.nextInt();
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        subsetSum(arr, lb, ub);
        sc.close();
    }

    private static void subsetSum(int[] arr, int lb, int ub) {
        int n = arr.length;
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();

        solve(arr, 0, (n/2)-1, a1);
        solve(arr, n/2, n-1, a2);
        Collections.sort(a2);
        int count = 0;
        for (int i = 0; i < a1.size(); i++) {
            int low = 
            int high =
            count += high-low;
        }
        System.out.println("Count is: " + count);
    }

    private static void solve(int[] arr, int st, int end, ArrayList<Integer> a) {
        int s = 0;
        int n = end-st+1;
        for (int i = 0; i < (1<<n); i++) {
            s = 0;
            int j = st;
            int x = i;
            while(x == 1){
                int l = x&1;
                if(l == 1)
                    s += arr[j];
                j++;
                x = x>>1;
            }
            a.add(s);
        }
    }
}
