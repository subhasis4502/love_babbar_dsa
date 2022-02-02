/* Ref: https://www.youtube.com/watch?v=dxVcMDI7vyI */

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

        minPlatform(arr, dep);
    }

    private static void minPlatform(int[] arr, int[] dep) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat = 1, res = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                plat++;
                i++;
            } else {
                plat--;
                j++;
            }
            res = Math.max(res, plat);
        }

        System.out.println("Minimum platform required: " + res);
    }
}
