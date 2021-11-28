import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void kthMinmax(int[] arr, int k){
        Arrays.sort(arr);
        System.out.println("Kth min: " + arr[k-1]);
        System.out.println("Kth max: " + arr[arr.length - k]);
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
            kthMinmax(arr, k);
        }
        sc.close();
    }
}
