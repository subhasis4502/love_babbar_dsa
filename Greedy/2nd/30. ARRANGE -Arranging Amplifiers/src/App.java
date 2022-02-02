/* Ref: https://www.youtube.com/watch?v=j4AAeH5CPmk */

import java.util.Arrays;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {
        Integer[] arr = { 3, 1, 4, 4, 1, 2 };
        maxAmplifier(arr);
    }

    private static void maxAmplifier(Integer[] arr) {
        int one = 0;
        for (int i : arr) {
            if (i == 1)
                one++;
        }

        Arrays.sort(arr, Collections.reverseOrder());
        for (int i = 0; i < one; i++) {
            System.out.print(1 + " ");
        }

        if ((arr.length - one) == 2 && arr[0] == 3 && arr[1] == 2) {
            System.out.print(2 + " " + 3);
        } else {
            for (int i = 0; i < arr.length - one; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
