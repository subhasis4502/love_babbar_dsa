import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 6, 5, 7, 1, 8, 2, 9, 9, 7, 7, 9 };
        Arrays.sort(arr);
        int target = 6;
        combinationSum(arr, 0, "", target);
    }

    private static void combinationSum(int[] arr, int ind, String set, int target) {
        if (target == 0) {
            System.out.println(set);
            return;
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1])
                continue;
            if (arr[i] <= target) {
                combinationSum(arr, i, set + arr[i] + " ", target - arr[i]);
            }
        }
    }
}
