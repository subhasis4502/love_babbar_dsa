/* Ref: https://www.youtube.com/watch?v=lr5uTrdUQhM */

import java.util.*;

class Pair{
    int price, count;

    public Pair(int price, int count) {
        this.price = price;
        this.count = count;
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        int[] prices = { 10, 7, 19 };
        int balance = 45;

        maxStock(prices, balance);
    }

    private static void maxStock(int[] prices, int balance) {
        int count = 0;
        ArrayList<Pair> arr = new ArrayList<>();
        for (int i = 0; i < prices.length; i++) {
            arr.add(new Pair(prices[i], i+1));
        }
        Collections.sort(arr, (Pair a, Pair b) -> a.price-b.price);
        int cost = 0;
        for (int i = 0; i < arr.size(); i++) {
            int price = arr.get(i).price;
            int stock = arr.get(i).count;
            if(price*stock <= balance){
                count += stock;
                balance -= (price*stock);
            } else {
                count += (balance/price);
                balance -= balance;
            }
        }
        System.out.println(count);
    }
}
