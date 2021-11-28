/* Ref: https://www.youtube.com/watch?v=wuzTpONbd-0 */

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

            maxProfit(arr);
        }
        sc.close();
    }

    private static void maxProfit(int[] arr) {

        int pist = 0; // Profit if sold today
        int leastsf = arr[0]; // Least so far
        int[] dpl = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            leastsf = Math.min(arr[i], leastsf);
            pist = arr[i] - leastsf;
            
            dpl[i] = (pist > dpl[i-1]) ? pist : dpl[i-1];
        }

        int pibt = 0; // Profit if bought today
        int maxat = arr[arr.length - 1]; // Max price til now
        int[] dpr = new int[arr.length];

        for (int i = arr.length - 2; i >= 0; i--) {
            maxat = Math.max(maxat, arr[i]);
            pibt = maxat - arr[i];

            dpr[i] = (pibt > dpr[i+1]) ? pibt : dpr[i+1];
        }

        int res = 0;
        for (int i = 0; i < dpr.length; i++) {
            res = Math.max(res, dpl[i] + dpr[i]);
        }

        System.out.println("Maximum profit is " + res);
    }
}
