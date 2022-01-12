/* 
Input:
9
9 8 6 1 11 7 3 3 10

Output:
11 7 9 6 3 3 10 8 1
*/

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        sortBySetBitCount(arr);
        for (Integer i : arr) {
            System.out.print(i + " ");
        }
        sc.close();
    }

    private static void sortBySetBitCount(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int x = a;
                int y = b;
                return Integer.bitCount(y) - Integer.bitCount(x);
            }
        });
    }
}
