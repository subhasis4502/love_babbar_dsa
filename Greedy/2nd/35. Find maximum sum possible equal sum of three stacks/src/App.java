/* Ref: https://www.youtube.com/watch?v=hfA7y4XEAkw */

public class App {
    public static void main(String[] args) throws Exception {
        int[] s1 = { 3, 2, 1, 1, 1 };
        int[] s2 = { 4, 3, 2 };
        int[] s3 = { 1, 1, 4, 1 };

        maxEqualSum(s1, s2, s3);
    }

    private static void maxEqualSum(int[] s1, int[] s2, int[] s3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;
        for (int i : s1)
            sum1 += i;
        for (int i : s2)
            sum2 += i;
        for (int i : s3)
            sum3 += i;

        int top1 = 0, top2 = 0, top3 = 0;
        int ans = 0;
        while (true) {
            if (top1 == s1.length || top2 == s2.length || top3 == s3.length) {
                ans = 0;
                break;
            }

            if (sum1 == sum2 && sum2 == sum3) {
                ans = sum1;
                break;
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1[top1++];
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2[top2++];
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= s3[top3++];
            }
        }

        System.out.println(ans);
    }
}
