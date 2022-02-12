/* Ref: https://www.youtube.com/watch?v=obhWqDfzwQQ */

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 1, 5, 11, 5 };
        if (equalPartition(arr))
            System.out.println("Yes possible");
        else
            System.out.println("Not possible");

    }

    private static boolean equalPartition(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (sum % 2 == 1)
            return false;

        return isSubsetSum(arr, 0, sum / 2);
    }

    private static boolean isSubsetSum(int[] arr, int pos, int sum) {
        boolean dp[][] = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[arr.length][sum];
    }
}
