/* Ref: https://www.youtube.com/watch?v=PJdOUDWYstY */

import java.util.ArrayList;

class Pair {
    int val, ind;

    public Pair(int val, int ind) {
        this.val = val;
        this.ind = ind;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = { 5, -4, 1, -3, 1 };
        wineTrading(arr);
    }

    private static void wineTrading(int[] arr) {
        ArrayList<Pair> buy = new ArrayList<>();
        ArrayList<Pair> sell = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                buy.add(new Pair(arr[i], i));
            else
                sell.add(new Pair(arr[i], i));
        }

        int ans = 0;
        int i = 0, j = 0;
        while (i < buy.size() && j < sell.size()) {
            int x = Math.min(buy.get(i).val, -sell.get(j).val);
            buy.get(i).val -= x;
            sell.get(j).val += x;
            int diff = Math.abs(buy.get(i).ind - sell.get(j).ind);
            ans += x * diff;
            if (buy.get(i).val == 0)
                i++;
            if (sell.get(j).val == 0)
                j++;
        }

        System.out.println("Minimum amount of work: " + ans);
    }
}
