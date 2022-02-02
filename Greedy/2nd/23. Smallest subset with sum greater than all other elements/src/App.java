/* Ref: https://www.youtube.com/watch?v=YrdVt9TC6gA */

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {2, 1, 2};
        minSubset(arr);
    }

    private static void minSubset(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        int subsetSum = 0;

        for (int i : arr) {
            sum += i;
        }

        for (int i = arr.length-1; i >= 0; i--) {
            sum -= arr[i];
            subsetSum += arr[i];

            if(subsetSum > sum){
                System.out.println(arr.length-i);
                break;
            }
        }
    }
}
