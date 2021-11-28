/* Ref: https://www.youtube.com/watch?v=5Du2iSRrbEw */

import java.util.*;

public class App {
    public static void minJump(int[] arr) {
        int maxRechable = arr[0];
        int jumps = 1;
        int stepsPossible = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1)
                System.out.println("Jumps require: " + jumps);

            maxRechable = Math.max(maxRechable, i + arr[i]);
            stepsPossible--;
            if (stepsPossible == 0) {
                jumps++;
                if (i >= maxRechable) {
                    System.out.println("Not possible");
                    break;
                }
                stepsPossible = maxRechable - i;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++)
                arr[i] = sc.nextInt();

            minJump(arr);
        }
        sc.close();
    }
}
