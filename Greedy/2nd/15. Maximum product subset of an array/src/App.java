/* Ref: https://www.youtube.com/watch?v=QLUg9v5NJc0 */

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { -1, -1, -2, 4, 3 };
        System.out.println("Maximum product: " + maxProductSubset(arr));
    }

    private static int maxProductSubset(int[] arr) {
        int zero = 0;
        int negative = 0;
        int product = 1;
        int maxNeg = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i == 0) {
                zero++;
                continue;
            } else if (i < 0) {
                negative++;
                maxNeg = Math.max(maxNeg, i);
            }
            product *= i;
        }

        if (zero == arr.length)
            return 0;
        else if (negative == 1 && zero + negative == arr.length)
            return 0;
        else if (negative % 2 == 1)
            product /= maxNeg;
        return product;
    }
}
