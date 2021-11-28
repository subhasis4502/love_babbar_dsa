import java.util.Scanner;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            longestSubSequence(arr);
        }
        sc.close();
    }

    private static void longestSubSequence(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        int count = 0;
        int maxCount = 0;
        int prev = arr[0];

        for (int i : arr) {
            set.add(i);
        }

        for(int i : set){
            if(i - prev < 2)
                count++;
            else{
                maxCount = Math.max(maxCount, count);
                count = 1;
            }
        }

        maxCount = Math.max(maxCount, count);
        System.out.println("Longest subsequence length: " + maxCount);
    }
}
