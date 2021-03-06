/* 
Input:
Enter the line co-ordinates:
1 -1 -3 
How many points?
5       
-3 -2
-1 0
-1 2
1 2
3 4

Output:
Optimal Distance: 20.787127583509818
*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int k = sc.nextInt();
        int[] words = new int[size];

        for (int i = 0; i < size; i++) {
            words[i] = sc.nextInt();
        }
        int val = solveWordWrap(words, k);
        System.out.println("Total cost: " + val);

        sc.close();
    }

    public static int solveWordWrap(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return wordWrap(nums, 0, dp, k);
    }

    public static int wordWrap(int[] nums, int index, int[] dp, int k) {
        if (index >= nums.length - 1)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int min = Integer.MAX_VALUE;
        int oneline = 0;
        for (int i = index; i < nums.length; i++) {
            oneline += nums[i];
            if (oneline <= k) {
                int result = (k - oneline) * (k - oneline) + wordWrap(nums, i + 1, dp, k);
                if (i == nums.length - 1)
                    return 0;
                oneline += 1;
                min = Math.min(min, result);
            } else
                break;
        }
        dp[index] = min;
        return min;
    }
}
