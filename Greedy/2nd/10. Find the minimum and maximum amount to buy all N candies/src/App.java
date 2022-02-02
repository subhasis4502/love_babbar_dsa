/* Ref: https://www.youtube.com/watch?v=2Sj6-5JFaAo */

import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] candies = {3, 2, 1, 4, 5};
        int k = 4;
        candyStore(candies, k);
    }

    private static void candyStore(int[] candies, int k) {
        Arrays.sort(candies);
        int i = 0, j = candies.length-1;
        int min = 0;
        while(i <= j){
            min += candies[i];
            i++;
            j -= k;
        }
        int max = 0;
        i = candies.length-1;
        j = 0;
        while(j <= i){
            max += candies[i];
            i--;
            j += k;
        }
        System.out.println("Minimum price to buy all candies: " + min);
        System.out.println("Minimum price to buy all candies: " + max);
    }
}
