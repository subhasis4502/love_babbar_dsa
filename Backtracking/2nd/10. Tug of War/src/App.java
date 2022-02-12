/* Ref: https://www.youtube.com/watch?v=Q1fLW_zQr3M */

import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        int arr[] = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
        ArrayList<Integer> set1 = new ArrayList<>();
        ArrayList<Integer> set2 = new ArrayList<>();
        tugOfWar(arr, 0, set1, set2, 0, 0);
        System.out.println(res);
    }

    static int minDiff = Integer.MAX_VALUE;
    static String res = "";
    private static void tugOfWar(int[] arr, int i, ArrayList<Integer> set1, ArrayList<Integer> set2, int sum1,
            int sum2) {

        if(i == arr.length){
            int diff = Math.abs(sum1-sum2);
            if(diff < minDiff){
                minDiff = diff;
                res = set1 + " " + set2;
            }
            return;
        }

        if (set1.size() < (arr.length + 1) / 2) {
            set1.add(arr[i]);
            tugOfWar(arr, i + 1, set1, set2, sum1 + arr[i], sum2);
            set1.remove(set1.size() - 1);
        }

        if (set2.size() < (arr.length + 1) / 2) {
            set2.add(arr[i]);
            tugOfWar(arr, i + 1, set1, set2, sum1, sum2 + arr[i]);
            set2.remove(set2.size() - 1);
        }
    }
}
