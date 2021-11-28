import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            findOcuuranceNK(arr, arr.length, k);
        }
        sc.close();
    }

    private static void findOcuuranceNK(int[] arr, int n, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int i : arr) {
            hash.put(i, hash.getOrDefault(i, 0)+1);
        }

        System.out.print("The number occurs n/k time: ");
        for (int i : hash.keySet()) {
            if(hash.get(i) > n/k)
                System.out.print(i + " ");
        }
    }
}
