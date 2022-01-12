/* Ref: https://www.youtube.com/watch?v=3zImAyVQlTQ */

/* 
Input:
7
1 2 3 4 5 6 7
3
3
10
2

Output:
Round 1: Soldier defeat: 3, Power gained: 6
Round 2: Soldier defeat: 7, Power gained: 28
Round 3: Soldier defeat: 2, Power gained: 3
*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int rounds = sc.nextInt();
        int[] power = new int[rounds];
        for (int i = 0; i < rounds; i++) {
            power[i] = sc.nextInt();
        }
        winning(arr, size, power);
        sc.close();
    }

    private static void winning(int[] arr, int size, int[] power) {
        Arrays.sort(arr);
        int[] sum = new int[size];
        sum[0] = arr[0];
        for (int i = 1; i < size; i++) {
            sum[i] = arr[i] + sum[i - 1];
        }
        for (int p = 0; p < power.length; p++) {
            int ind = upbound(arr, 0, size, power[p]);
            System.out.println("Round " + (p+1) + ": Soldier defeat: " + ind + ", Power gained: " + sum[ind - 1]);
        }
    }

    private static int upbound(int[] arr, int l, int h, int p) {
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (arr[mid] <= p)
                l = mid + 1;
            else
                h = mid;
        }
        return l;
    }
}
