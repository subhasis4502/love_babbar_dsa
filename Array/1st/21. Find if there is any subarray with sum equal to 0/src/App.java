import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            zeroSum(arr);
        }
        sc.close();
    }

    private static void zeroSum(int[] arr) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i : arr) {
            sum += i;
            if(set.contains(sum))
                count++;
            else
                set.add(sum);
        }

        System.out.println("Number of zero sum subarray: " + count);
    }
}
