/* Ref: https://www.youtube.com/watch?v=Wq4Sn20dHr8 */

public class App {
    public static void main(String[] args) throws Exception {
        int days = 12;
        int maxFoodBuy = 28;
        int surviveFood = 20;

        minimummaxFoodBuy(days, maxFoodBuy, surviveFood);
    }

    private static void minimummaxFoodBuy(int days, int maxFoodBuy, int surviveFood) {
        if (maxFoodBuy < surviveFood) {
            System.out.println("Died");
            return;
        }

        int sunday = days / 7;
        int food = days * surviveFood;
        int buyDay = days - sunday;
        int buy = (int) Math.ceil(food / (double) maxFoodBuy);
        if (buy <= buyDay)
            System.out.println("Survived Food buying maxFoodBuy: " + buy);
        else {
            System.out.println("Died");
        }
    }
}
