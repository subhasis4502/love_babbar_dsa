// Ref: https://www.youtube.com/watch?v=kV37sZV9pgk

import java.util.*;

public class App {
    public static int findDuplicate(int[] arr) {
        int n = arr.length;
        // Increment the value        
        for (int i = 0; i < n; i++)
            arr[arr[i] % n] += n;
        // Searching the duplicate
        for (int i = 0; i < n; i++)
            if (arr[i] / n > 1)
                return i;

        return -1;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            System.out.println(findDuplicate(arr));
        }
        sc.close();
    }
}
