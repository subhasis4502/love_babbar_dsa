/* Ref: https://www.youtube.com/watch?v=4YjEHmw1MX0 */

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int size = sc.nextInt();
            int[] prices = new int[size];
            for (int i = 0; i < size; i++)
                prices[i] = sc.nextInt();

            maxProfit(prices);
        }
        sc.close();
    }

    private static void maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int finalProfit = 0;
        int profit = 0;

        for(int i : prices){
            minPrice = Math.min(minPrice, i);
            profit = i - minPrice;
            finalProfit = Math.max(finalProfit, profit);
        }

        System.out.println("Maximum profit: " + finalProfit);
    }
}
