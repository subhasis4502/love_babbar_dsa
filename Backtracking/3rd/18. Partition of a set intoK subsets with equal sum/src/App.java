/* Ref: https://www.youtube.com/watch?v=3qN3bonkCG4 */

public class App {
    public static void main(String[] args) throws Exception {
        int[] a = { 2, 1, 4, 5, 6 };
        int k = 3;
        if (isKPartitionPossible(a, k))
            System.out.println("Yes Possible");
        else
            System.out.println("Not possible");
    }

    private static boolean isKPartitionPossible(int[] a, int k) {
        int total = 0;
        for (int i : a) {
            total += i;
        }
        if (total % k != 0)
            return false;
        int sum = total / k;
        boolean[] marked = new boolean[a.length];
        return solve(a, sum, marked, sum);
    }

    private static boolean solve(int[] a, int curSum, boolean[] marked, int target) {
        if (curSum == 0)
            return solve(a, target, marked, target);

        if (curSum < 0)
            return false;
        boolean flag = true;
        for (int i = 0; i < a.length; i++) {
            if (!marked[i]) {
                flag = false;
                marked[i] = true;
                if (solve(a, curSum - a[i], marked, target)) {
                    return true;
                } else {
                    marked[i] = false;
                }
            }
        }
        return flag;
    }
}
