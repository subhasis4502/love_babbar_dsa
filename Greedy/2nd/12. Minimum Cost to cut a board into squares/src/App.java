/* Ref: https://www.youtube.com/watch?v=9DckVBRzuQU */

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Integer[] x = { 2, 1, 3, 1, 4 };
        Integer[] y = { 4, 1, 2 };

        minimumCostOfBreaking(x, y);
    }

    private static void minimumCostOfBreaking(Integer[] x, Integer[] y) {
        Arrays.sort(x, Collections.reverseOrder());
        Arrays.sort(y, Collections.reverseOrder());

        int hor = 1;
        int ver = 1;
        int res = 0;
        int i = 0, j = 0;
        while (i < x.length && j < y.length) {
            if (x[i] >= y[j]) {
                res += x[i] * ver;
                i++;
                hor++;
            } else {
                res += y[j] * hor;
                j++;
                ver++;
            }
        }

        while (i < x.length) {
            res += x[i] * ver;
            i++;
        }

        while (j < y.length) {
            res += y[j] * hor;
            j++;
        }

        System.out.println("Minimum cost of breaking: " + res);
    }
}
